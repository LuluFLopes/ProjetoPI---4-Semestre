<template>
  <main>
    <div id="app">
      <h1>Cadastro de Usuário</h1>
      <form action="" v-on:submit.prevent="checkForm" role="form" class="formulario">
        <fieldset>

          <div class="itens-formulario">
            <label for="userLogin">Usuário:</label>
            <input class="itens-entrada" id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="nome">
          </div>

          <div class="itens-formulario">
            <label for="CPF">CPF:</label>
            <input class="itens-entrada" id="CPF" type="text" aria-label="CPF" placeholder="CPF" v-model="cpf">
          </div>

          <div class="itens-formulario">
            <label for="E-Mail">E-Mail:</label>
            <input class="itens-entrada" id="userPassword" type="email" aria-label="Email" placeholder="Email" v-model="usuario">
          </div>

          <div class="itens-formulario">
            <label for="userPassword">Senha:</label>
            <input class="itens-entrada" id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="senha">
          </div>

          <div class="itens-formulario">
            <label for="userPasswordConf">Confirmar Senha:</label>
            <input class="itens-entrada" id="userPasswordConf" type="password" aria-label="Confirmar Senha" placeholder="Confirmar Senha"
                   v-model="confirmaSenha">
          </div>

          <div class="itens-formulario">
            <label for="userGrupo">Grupo:</label>
            <select class="itens-entrada" name="userGrupo"  v-model="grupo">
              <option value="">Selecione...</option>
              <option value="ADMINISTRADOR">Administrador</option>
              <option value="ESTOQUISTA">Estoquista</option>
            </select>

          </div>

          <input type="submit" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, cpf ,usuario, senha, grupo, confirmaSenha)">

          <router-link to="/WlistaUsuario" custom v-slot="{ navigate }">
            <button class="btnAcao red" @click="navigate" role="link">Fechar</button></router-link>

          <ul>
            <li v-for="error in errors" :key="error.message">{{error}}</li>
          </ul>
        </fieldset>
      </form>
    </div>
  </main>
</template>





<script>
import { defineComponent } from 'vue';
import axios from 'axios';
const CryptoJS = require("crypto-js");



export default defineComponent({
  data() {
    return {
      nome: "",
      cpf: "",
      usuario: "",
      senha: "",
      confirmaSenha: "",
      grupo: "",
      erros:[]
    }
  },
  methods: {
    mandarInformacoes(nome, cpf, usuario, senha, grupo, confirmaSenha) {

      grupo = grupo.toUpperCase();

      if (senha === confirmaSenha && senha.length > 0) {

        var cpfValido = this.TestaCPF(cpf)
        if(cpfValido  == true){
          senha = this.encrypt(senha);

          axios({
            method: 'post',
            url: 'http://localhost:8081/cadastrar',
            data: {
              nome: nome,
              cpf: cpf,
              usuario: usuario,
              senha: senha,
              grupo: grupo,
            }
          })
              .then(function (response) {
                console.log(response);
              })
              .catch(function (error) {
                console.log(error);
              });
        }
        else{
          alert("CPF inválido !!!")
        }


      } else {
        alert("As duas senhas precisam ser iguais!")
      }
    },

    encrypt (senha) {
      return CryptoJS.SHA512(senha).toString()
    },

    decrypt (senha) {
      const bytes = CryptoJS.AES.decrypt(senha)
      const originalText = bytes.toString(CryptoJS.enc.Utf8)
      return originalText
    },

    TestaCPF(cpf) {
      var Soma
      var Resto
      Soma = 0
      var i
  if (cpf == "00000000000") return false

  for (i=1; i<=9; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (11 - i)
  Resto = (Soma * 10) % 11

  if ((Resto == 10) || (Resto == 11))  Resto = 0
  if (Resto != parseInt(cpf.substring(9, 10)) ) return false

  Soma = 0
  for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (12 - i)
  Resto = (Soma * 10) % 11

  if ((Resto == 10) || (Resto == 11))  Resto = 0
  if (Resto != parseInt(cpf.substring(10, 11) ) ) return false
  return true
  }

  },

  checkForm: function () {
    this.errors= [];

    if(!this.nome){
      this.errors.push('O nome deve ser preenchido')
    }

    if(!this.cpf){
      this.errors.push('O CPF deve ser preenchido')
    }
    else{
      this.TestaCPF(this.cpf)
      if(this.cpf === false){
        this.errors.push('O CPF inválido')
      }

    }

  }



});

</script>



<style scoped>
main {
  background: rgba(45, 46, 50);
  height: 100%;
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
  margin-top: 2%;
}
label, input, select {
  padding: 0.5dvw;
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
  height: 55dvh;

}


.itens-formulario{
  text-align: left;
  margin: 30px 10px;
}

.itens-entrada {
  border: 1px solid #222222;
  border-radius: 5px;
  float:right;
}

.btnAcao{
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  margin: -1% 10%;
}


</style>