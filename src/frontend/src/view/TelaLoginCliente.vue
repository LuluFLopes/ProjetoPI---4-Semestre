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
import {mapActions, mapState} from "vuex";

const url = 'http://localhost:8081/clientes/login';

export default defineComponent({
  emits: [
      'clicarBotaoEntrar'
  ],
  data() {
    return {
      formData: {
        usuario: "",
        senha: ""
      }
    }
  },
  computed: {
    ...mapState([
        'carrinho'
    ])
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
        if (this.carrinho.length === 0){
          await router.push('/');
        } else {
          //await router.push('/telaDetalheProduto');
        }
      } catch (ex) {
        console.log(ex.message);
      }
    },
    encrypt(senha) {
      return CryptoJS.SHA512(senha).toString()
    },
    ...mapActions([
      'getUserInfos'
    ])
  },
});

</script>

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
  padding: 10px;
}

h1 {
  color: aliceblue;
  font-size: 3dvw;
}

label, input {
  padding: 10px;
  margin: 2dvh;
  align-items: center;
  justify-content: left;
  text-align: left;
}

fieldset {
  background-color: aliceblue;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  align-items: center;
  height: 250px;
}

</style>