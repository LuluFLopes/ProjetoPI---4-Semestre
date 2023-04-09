<script>
import {defineComponent} from 'vue';
import CryptoJS from "crypto-js";
import axios from 'axios';
import {mapActions} from 'vuex'
import router from "@/router";

const url = 'http://localhost:8081/login';

export default defineComponent({
  data() {
    return {
      formData: {
        usuario: "stevart@hotmail.com",
        senha: "irmãdosevart123"
      }
    }
  },
  methods: {
    async submitSignIn() {
      try {
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

<style scoped>
main {
  background-color: rgba(45, 46, 50);
  height: 100%;
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

label, p, a {
  color: rgb(6, 45, 78);
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
}

label, input {
  padding: 0.5 dvw;
  margin: 2 dvh;
  align-items: left;
  justify-content: left;
  text-align: left;

}

fieldset {
  background-color: aliceblue;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  align-items: center;
}
</style>