<template>
  <main>
    <div>
      <h1>Iniciar Sessão</h1>
      <form role="form" @submit.prevent="submitSignIn()">
        <fieldset>
          <div>
            <label for="userLogin">Usuário:</label>
            <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="formData.usuario">
          </div>

          <div>
            <label for="userPassword">Senha:</label>
            <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="formData.senha">
          </div>
          <button type="submit">Entrar</button>
        </fieldset>
      </form>
    </div>
  </main>
</template>

<script>
import {defineComponent} from "vue";
import axios from "axios";
import router from "@/router";
import CryptoJS from "crypto-js";
import {mapActions} from "vuex";

const url = 'http://localhost:8081/clientes/login';

export default defineComponent({
  data() {
    return {
      formData: {
        usuario: "",
        senha: ""
      }
    }
  },
  methods: {
    async submitSignIn() {
      try {
        this.formData.senha = this.encrypt(this.formData.senha)
        const request = await axios.post(url, this.formData)
        console.log(request)
        const date = new Date().getTime().toString();
        sessionStorage.setItem("token", date);
        this.getUserInfos(request.data);
        await router.push('/logado');
      } catch (ex) {
        console.log(ex.message);
      }
    },
    encrypt(senha) {
      return CryptoJS.SHA512(senha).toString()
    },
    resgatarInformacoes(usuario) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/listarFiltrando'
      })
          .then(function (response) {
            sessionStorage.setItem("grupo", usuario.push(response.data[4]));
          })
          .catch(function (error) {
            alert("Não foi possível encontrar o grupo do usuário!");
            console.log(error);
          });
    },
    ...mapActions([
      'getUserInfos'
    ])
  },
});
</script>

<style>

main {
  background-color: rgba(45, 46, 50);
  height: 70%;
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

label, p, a {
  color: rgb(6, 45, 78);
  padding: 10px;
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
}

label, input {
  padding: 2%;
  margin: 2%;
  align-items: left;
  justify-content: left;
  text-align: left;

}

fieldset {
  background-color: aliceblue;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  align-items: center;
  width: 30%;
  height: 220px;
  align-items: center;
  justify-content: center;
  position: relative;
  margin: 0 35%;
}


</style>