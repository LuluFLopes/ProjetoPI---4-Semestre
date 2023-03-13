<script>
  import { defineComponent } from 'vue';
  import axios from 'axios';

  export default defineComponent({
      data() {
        return {
          userLogin: "",
          userPassword: ""
        }
      },
      methods: {
        mandarInformacoes(userLogin, userPassword) {
          axios ({
            method: 'post',
            url: 'http://localhost:8081/login',
            data: {
              usuario: userLogin,
              senha: userPassword
            }
          })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
        }
      },
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
              <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="userLogin">
            </div>
    
            <div>
              <label for="userPassword">Senha:</label>
              <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="userPassword">
            </div>
            
            <input type="submit" class="btnEntrar" value="Entrar" @click="mandarInformacoes({ userLogin }, { userPassword })">

          </fieldset>
        </form>
    </div>
  </main>
</template>

<style scoped>
  main {
    background: url("@/Images/RE4-2.jpg");
    height: 100vh;
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
    font-weight: bold;

  }
  fieldset{
    background-color: aliceblue;
    opacity: 0.90;
    border-radius: 40px;
    border-color: rgb(35, 75, 110);
    align-items: center;
  }

  .btnEntrar{
    border: solid;
    border-radius: 30px;
    border-color: rgb(35, 75, 110);
  }
</style>