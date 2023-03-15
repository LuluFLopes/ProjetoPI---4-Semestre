<script>
import { defineComponent } from 'vue';
import axios from 'axios';

export default defineComponent({
  data() {
    return {
      nome: "",
      cpf: "",
      usuario: "",
      senha: "",
      confirmaSenha: "",
      grupo: ""
    }
  },
  methods: {
    mandarInformacoes(nome, cpf, usuario, senha, grupo, confirmaSenha) {

      grupo = grupo.toUpperCase();

      if (senha === confirmaSenha) {
        axios({
          method: 'post',
          url: 'http://localhost:8081/cadastrar',
          data: {
            nome: nome,
            cpf: cpf,
            usuario: usuario,
            senha: senha,
            grupo: grupo
          }
        })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });

      } else {
        alert("As duas senhas precisam ser iguais!")
      }
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
            <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="nome">
          </div>

          <div>
            <label for="CPF">CPF:</label>
            <input id="CPF" type="text" aria-label="CPF" placeholder="CPF" v-model="cpf">
          </div>

          <div>
            <label for="E-Mail">E-Mail:</label>
            <input id="userPassword" type="email" aria-label="Email" placeholder="Email" v-model="usuario">
          </div>

          <div>
            <label for="userPassword">Senha:</label>
            <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="senha">
          </div>

          <div>
            <label for="userPasswordConf">Confirmar Senha:</label>
            <input id="userPasswordConf" type="password" aria-label="Confirmar Senha" placeholder="Confirmar Senha"
                   v-model="confirmaSenha">
          </div>

          <div>
            <label for="userGrupo">Grupo:</label>
            <input id="userGrupo" type="text" aria-label="Grupo" placeholder="Grupo" v-model="grupo">
          </div>

          <input type="submit" class="btnCadastrar" value="Cadastrar"
                 @click="mandarInformacoes(nome, cpf ,usuario, senha, grupo, confirmaSenha)">

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