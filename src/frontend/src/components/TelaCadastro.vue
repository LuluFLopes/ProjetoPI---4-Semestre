<script>
import { defineComponent } from 'vue';
import axios from 'axios';

export default defineComponent({
  data() {
    return {
      userLogin: "",
      userCPF: "",
      userEmail:"",
      userPassword:"",
      userPasswordConf: "",
      userGrupo:""
    }
  },
  methods: {
    mandarInformacoes(userLogin, userCPF, userEmail, userPassword, userGrupo) {
      axios ({
        method: 'post',
        url: 'http://localhost:8081/Cadastrar',
        data: {
          usuario: userLogin,
          cpf: userCPF,
          email: userEmail,
          senha: userPassword,
          grupo: userGrupo
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
      <h1>Cadastro de Usuário</h1>
      <form role="form" class="formulario">
        <fieldset>

          <div>
            <label for="userLogin">Usuário:</label>
            <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="userLogin">
          </div>

          <div>
            <label for="CPF">CPF:</label>
            <input id="CPF" type="text" aria-label="CPF" placeholder="CPF" v-model="userCPF">
          </div>

          <div>
            <label for="E-Mail">E-Mail:</label>
            <input id="userPassword" type="email" aria-label="Email" placeholder="Email" v-model="userEmail">
          </div>

          <div>
            <label for="userPassword">Senha:</label>
            <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="userPassword">
          </div>

          <div>
            <label for="userPasswordConf">Confirmar Senha:</label>
            <input id="userPasswordConf" type="password" aria-label="Confirmar Senha" placeholder="Confirmar Senha" v-model="userPasswordConf">
          </div>

          <div>
            <label for="userGrupo">Grupo:</label>
            <input id="userGrupo" type="text" aria-label="Grupo" placeholder="Grupo" v-model="userGrupo">
          </div>



          <input type="submit" class="btnCadastrar" value="Cadastrar" @click="mandarInformacoes({ userLogin }, {userCPF },{userEmail},{userPassword}, {userGrupo}  )">

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
  color: rgb(0, 0, 0);
  font-weight: bold;
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

.btnCadastrar{
  border: solid;
  border-radius: 40px;
  border-color: rgb(35, 75, 110);
}

</style>