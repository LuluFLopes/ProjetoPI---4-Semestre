<template>
  <main>
    <div id="app">
      <h1>Cadastro de Cliente</h1>
      <form action="" v-on:submit.prevent="checkForm" role="form" class="formulario">
        <fieldset>

          <div class="itens-formulario">
            <label class="textLabel" for="userLogin">Usuário:</label>
            <input class="itens-entrada"  type="text" aria-label="Usuário" placeholder="Usuário" v-model="nome">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="E-Mail">E-Mail:</label>
            <input class="itens-entrada"  type="email" aria-label="Email" placeholder="Email" v-model="usuario">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="CPF">CPF:</label>
            <input class="itens-entrada" v-mask="'###.###.###-##'"  type="text" aria-label="CPF" placeholder="CPF" v-model="cpf">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="cep">CEP:</label>
            <input class="itens-entrada" v-mask="'#####-###'" value="" @blur="GetAdress(CEP)" maxlength="9" type="text" aria-label="cep" placeholder="CEP" v-model="CEP" >
          </div>

          <div class="grid">

          <div class="itens-formulario">
            <label class="textLabel" for="logradouro">Logradouro:</label>
            <input class="itens-entrada" readonly="readonly" type="text" aria-label="Logradouro" placeholder="Logradouro" v-model="formAdress.logradouro">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="num">Número:</label>
            <input class="itens-entrada"  type="text" aria-label="Número" placeholder="Número" v-model="formAdress.num">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="compl">Complemento:</label>
            <input class="itens-entrada"  type="text" aria-label="Complemento" placeholder="Complemento" v-model="formAdress.compl">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="bairro">Bairro:</label>
            <input class="itens-entrada" readonly="readonly"  type="text" aria-label="Bairro" placeholder="Bairro" v-model="formAdress.bairro">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="cidade">Cidade:</label>
            <input class="itens-entrada" readonly="readonly"  type="text" aria-label="Cidade" placeholder="Cidade" v-model="formAdress.localidade">
          </div>

          <div class="itens-formulario">
            <label class="textLabel" for="UF">UF:</label>
            <input class="itens-entrada" readonly="readonly" type="text" aria-label="UF" placeholder="UF" v-model="formAdress.uf">
          </div>
          </div>

          <div class="grid">
          <div class="itens-formulario">
            <label class="textLabel" for="userPassword">Senha:</label>
            <input class="itens-entrada"  type="password" aria-label="Senha" placeholder="Senha" v-model="senha">
          </div>

          <div class="itens-formulario">
            <label class="textLabelCS" for="userPasswordConf">Confirmar Senha:</label>
            <input class="itens-entrada"  type="password" aria-label="Confirmar Senha" placeholder="Confirmar Senha"
                   v-model="confirmaSenha">
          </div>
          </div>



          <input type="submit" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, cpf ,usuario, senha, 'cliente', confirmaSenha)">

          <router-link to="/WlistaUsuario" custom v-slot="{ navigate }">
            <button class="btnAcao red" @click="navigate" role="link">Fechar</button></router-link>
        </fieldset>
      </form>
    </div>
  </main>
</template>





<script>
import { defineComponent } from 'vue';
import axios from 'axios';
import router from "@/router";
const CryptoJS = require("crypto-js");



export default defineComponent({
  data() {
    return {
      nome: "",
      usuario: "",
      cpf: "",
      CEP:"",

      senha: "",
      confirmaSenha: "",
      grupo: "",

      formAdress: {
        logradouro:"",
        num:"",
        compl:"",
        bairro:"",
        localidade:"",
        uf:""

      }
    }
  },
  methods: {

    mandarInformacoes(nome, cpf, usuario, senha, grupo, confirmaSenha) {
      // eslint-disable-next-line
      debugger



      var cErro = 0
      var cMsg = ''

      grupo = grupo.toUpperCase();

      if (nome.length === 0){
        cErro = 1
        cMsg = 'Campo Usuário não pode ser vazio'
      }

      if (usuario.length === 0){
        if (cMsg.length === 0){
          cErro = 1
          cMsg = 'Campo e-mail não pode ser vazio'
        }else{
          cMsg = cMsg + '\n' + 'Campo e-mail não pode ser vazio'
        }

      }

      if (grupo === ''){
        if (cMsg.length === 0){
          cErro = 1
          cMsg = 'Selecione o grupo do usuário'
        }else{
          cMsg = cMsg + '\n' + 'Selecione o grupo do usuário'
        }
      }

      if (senha === confirmaSenha && senha.length > 0) {
        cErro = 0
      }else {
        if (cMsg.length === 0) {
          cErro = 1
          cMsg = "As duas senhas precisam ser iguais!"
        } else {
          cMsg = cMsg + '\n' + "As duas senhas precisam ser iguais!"
        }
      }


      var cpfValido = this.TestaCPF(cpf)
      if (cpfValido === true && cErro === 0) {

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
              alert("Cadastrado com Sucesso!");
              router.push('/WlistaUsuario')
            })
            .catch(function (error) {
              console.log(error);
            });
      } else {
        cErro = 1
        if (cMsg.length === 0) {
          cErro = 1
          cMsg = "O CPF é inválido"
        } else {
          cMsg = cMsg + '\n' + "O CPF é inválido !!!"
        }
      }


      if (cErro > 0) {

        alert(cMsg)
      }
    }
    ,

    encrypt (senha) {
      return CryptoJS.SHA512(senha).toString()
    },


    TestaCPF(cpf) {
      var Soma
      var Resto
      Soma = 0
      var i
      if (cpf == "00000000000") return false

      for (i=1; i<=9; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (11 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11))  Resto = 0
      if (Resto != parseInt(cpf.substring(9, 10)) ) return false

      Soma = 0
      for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (12 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11))  Resto = 0
      if (Resto != parseInt(cpf.substring(10, 11) ) ) return false
      return true
    },

    async GetAdress(CEP){
      var CEPTrat = CEP.replace(/\D/g, '');
      var url2 = 'https://viacep.com.br/ws/'+CEPTrat+'/json/'

      if (CEPTrat != ""){

        var validaCep = /^[0-9]{8}$/;

        if(validaCep.test(CEPTrat)) {

          try {
            axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

            const request = await axios.get(url2, this.formAdress)

            console.log(request)

            if (request.data.erro !==false){
              this.formAdress.logradouro = request.data.logradouro;
              this.formAdress.bairro = request.data.bairro;
              this.formAdress.localidade = request.data.localidade;
              this.formAdress.uf = request.data.uf;
            }
            if (request.data.erro === true) {
              alert("CEP não encontrado.");
              console.log('CEP não encontrado.')
            }

          } catch (err) {
            console.log(err.message)
          }

        }else {
          alert("CEP Inválido.");
        }
        }

      }


  }
});

</script>



<style scoped>
main {
  background: rgba(45, 46, 50);
  height: 150dvh;
  width: 100vw;
  display: flex;
  justify-content: center;
  text-align: center;
}

h1 {
  color: aliceblue;
  font-size: 3dvw;
  margin-top: 2%;
}
 input, select {
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
  height: 130dvh;
  width: 50dvw;

}


.itens-formulario{
  text-align: left;
  margin: 30px 10px;
}

.itens-entrada {
  border: 1px solid #222222;
  border-radius: 5px;
  margin-left: auto;

}

.btnAcao{
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  margin: -1% 10%;
}

.grid{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;

  justify-content: left;
  text-align: left;
}

.textLabel{
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  width: 80px;
}

.textLabelCS{
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  width: 140px;
}

</style>