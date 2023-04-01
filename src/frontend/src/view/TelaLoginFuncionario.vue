<script>
  import { defineComponent } from 'vue';
  import axios from 'axios';
  import CryptoJS from "crypto-js";
  import router from "@/router";

  export default defineComponent({
      data() {
        return {
          usuario: "",
          senha: ""
        }
      },
      methods: {
        mandarInformacoes(usuario, senha) {
          senha = this.encrypt(senha);
          axios ({
            method: 'post',
            url: 'http://localhost:8081/login',
            data: {
              usuario: usuario,
              senha: senha
            }
          })
              .then(function (response) {
                alert("Login realizado com sucesso!");
                console.log(response);
                sessionStorage.setItem("usuario",usuario);
                router.push('/logado')
              })
              .catch(function (error) {
                alert("Não foi possível realizar o login.");
                console.log(error);
              });
        },
        encrypt (senha) {
          return CryptoJS.SHA512(senha).toString()
        }
      }
    });

  
</script>

<template>
  <main>
    <div>
      <h1>Iniciar Sessão</h1>
        <form role="form">
          <fieldset>

            <div>
              <label for="userLogin">Usuário:</label>
              <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="usuario">
            </div>

            <div>
              <label for="userPassword">Senha:</label>
              <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="senha">
            </div>

            <input type="submit" value="Entrar" @click="mandarInformacoes( usuario , senha )">

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
    font-size: 3dvw;
  }
  label, input {
    padding: 0.5dvw;
    margin: 2dvh;
    align-items: left;
    justify-content: left;
    text-align: left;

  }
  fieldset{
    background-color: aliceblue;
    border-radius: 10px;
    border-color: rgb(35, 75, 110);
    align-items: center;
  }
</style>