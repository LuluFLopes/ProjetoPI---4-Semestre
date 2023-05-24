<template>
  <main>
    <div id="app">
      <h1>Alterar Cliente</h1>
      <form v-on:submit.prevent role="form" class="formulario">
        <fieldset>

          <div class="subMenu">
            <button class="subMenu-itens" @click="dados_P = true , Enderecos_P = false">Dados Pessoais</button>
            <button class="subMenu-itens" @click="Enderecos_P = true, dados_P = false">Endereços</button>
          </div>

          <div v-show="dados_P === true">
            <div class="itens-formulario">
              <label class="textLabel" for="userLogin">Usuário:</label>
              <input class="itens-entrada usuario" name="user" type="text" aria-label="Usuário" placeholder="Usuário"
                     v-model="nome"
              >
            </div>

            <div class="itens-formulario">
              <label class="textLabelCS" for="ncompeto">Nome Completo:</label>
              <input class="itens-entrada inputGrande" name="nome-completo" type="text" aria-label="Nome Completo"
                     placeholder="Nome Completo"
                     v-model="ncompleto">
            </div>

            <div class="itens-formulario">
              <label class="textLabel" for="E-Mail">E-Mail:</label>
              <input class="itens-entrada e-mail" name="email" type="email" aria-label="Email" placeholder="Email"
                     v-model="usuario"
              >
            </div>

            <div class="grid">
              <div class="itens-formulario">
                <label class="textLabel" for="CPF">CPF:</label>
                <input class="itens-entrada" name="cpf" v-mask="'###.###.###-##'" type="text" aria-label="CPF"
                       placeholder="CPF"
                       v-model="cpf">
              </div>

              <div class="itens-formulario">
                <v-dialog
                    ref="dialog"
                    v-model="modal"
                    :return-value.sync="dtnasc"
                    persistent
                    width="290px"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="dtnasc"
                        label="Data Nascimento:"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                      v-model="dtnasc"
                      scrollable
                  >
                    <v-spacer></v-spacer>
                    <v-btn
                        text
                        color="primary"
                        @click="modal = false"
                    >
                      Cancel
                    </v-btn>
                    <v-btn
                        text
                        color="primary"
                        @click="$refs.dialog.save(dtnasc)"
                    >OK
                    </v-btn>
                  </v-date-picker>
                </v-dialog>
              </div>

              <div class="itens-formulario">
                <label class="textLabelCS" for="genero">Gênero:</label>
                <select class="itens-entrada inputSelect" aria-label="Genero" name="genero" v-model="genero">
                  <option value="">Selecione...</option>
                  <option value="Masculino">Masculino</option>
                  <option value="Feminino">Feminino</option>
                </select>
              </div>

            </div>
            <div class="grid">
              <div class="itens-formulario">
                <label class="textLabel" for="userPassword">Senha:</label>
                <input class="itens-entrada" type="password" aria-label="Senha" name="senha" placeholder="Senha"
                       v-model="senha"
                >
              </div>

              <div class="itens-formulario">
                <label class="textLabelCS" for="userPasswordConf">Confirmar Senha:</label>
                <input class="itens-entrada" type="password" aria-label="Confirmar Senha" name="confirma-senha"
                       placeholder="Confirmar Senha"
                       v-model="confirmaSenha">
              </div>
            </div>
          </div>

          <div v-show="Enderecos_P === true">

            <div class="grid2">
              <div class="itens-formulario">
                <label class="textLabel" for="cep">CEP:</label>
                <input class="itens-entrada" v-mask="'#####-###'" value="" @blur="GetAdress(endereco.cep,1)"
                       maxlength="9" type="text" aria-label="cep" placeholder="CEP" v-model="endereco.cep"
                >
              </div>

              <div class="itens-formulario">
                <label class="textLabelCS" for="genero">Tipo de Endereço:</label>
                <select class="itens-entrada inputSelect" aria-label="Genero" name="Genero"
                        v-model="endereco.tipoEnd">
                  <option value="">Selecione...</option>
                  <option value="EF">Entrega/Faturamento</option>
                  <option value="E">Entrega</option>
                  <option value="F">Faturamento</option>
                </select>

                <v-checkbox v-if="endereco.tipoEnd !== 'F'"
                            v-model="isChecked"
                            label="Endereço Principal"
                            class="font-weight-bold"
                            id="endereco-principal"
                            @click="preencheTipoDeEndereco()"
                ></v-checkbox>
              </div>
            </div>


            <div class="grid">
              <div class="itens-formulario">
                <label class="textLabel" for="logradouro">Logradouro:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Logradouro"
                       placeholder="Logradouro" v-model="endereco.logradouro">
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="num">Número:</label>
                <input class="itens-entrada" type="text" aria-label="Número" placeholder="Número"
                       v-model="endereco.numero">
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="compl">Complemento:</label>
                <input class="itens-entrada" type="text" aria-label="Complemento" placeholder="Complemento"
                       v-model="endereco.complemento">
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="bairro">Bairro:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Bairro" placeholder="Bairro"
                       v-model="endereco.bairro">
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="cidade">Cidade:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Cidade" placeholder="Cidade"
                       v-model="endereco.cidade">
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="UF">UF:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="UF" placeholder="UF"
                       v-model="endereco.uf">
              </div>
            </div>
            <button class="BtnCadEnd" @click="adicionarEndereco()">+ Adicionar</button>

            <div class="container-lista-enderecos">
              <h2>Endereços de Entrega:</h2>
              <table class="listaEndereco">
                <thead>
                <tr>
                  <th>CEP</th>
                  <th>Logradouro</th>
                  <th>Número</th>
                  <th>Complemento</th>
                  <th>Bairro</th>
                  <th>Cidade</th>
                  <th>UF</th>
                  <th>Tipo</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(endereco,index) in enderecos" :key="index">
                  <td>{{ endereco.cep }}</td>
                  <td>{{ endereco.logradouro }}</td>
                  <td>{{ endereco.numero }}</td>
                  <td>{{ endereco.complemento }}</td>
                  <td>{{ endereco.bairro }}</td>
                  <td>{{ endereco.cidade }}</td>
                  <td>{{ endereco.uf }}</td>
                  <td>{{ endereco.tipoEndereco }}</td>
                  <td>
                    <v-btn @click="removerEndereco(index)">
                      &#8722;
                    </v-btn>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>

            <div class="container-lista-faturamento">
              <h2>Endereço de Faturamento:</h2>
              <table class="listaEndereco">
                <thead>
                <tr>
                  <th>CEP</th>
                  <th>Logradouro</th>
                  <th>Número</th>
                  <th>Complemento</th>
                  <th>Bairro</th>
                  <th>Cidade</th>
                  <th>UF</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>{{ enderecoFaturamento.cep }}</td>
                  <td>{{ enderecoFaturamento.logradouro }}</td>
                  <td>{{ enderecoFaturamento.numero }}</td>
                  <td>{{ enderecoFaturamento.complemento }}</td>
                  <td>{{ enderecoFaturamento.bairro }}</td>
                  <td>{{ enderecoFaturamento.cidade }}</td>
                  <td>{{ enderecoFaturamento.uf }}</td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
          <input type="button" class="btnAcao green" value="Alterar"
                 @click="mandarInformacoes(nome, cpf, dtnasc, genero, usuario, senha, endereco, confirmaSenha)">

          <router-link to="/" custom v-slot="{ navigate }">
            <button class="btnAcao red" @click="navigate" role="link">Fechar</button>
          </router-link>
        </fieldset>
      </form>
    </div>
  </main>
</template>

<script>
import {defineComponent} from 'vue';
import axios from 'axios';
import router from "@/router";
import {mapState} from "vuex";

const CryptoJS = require("crypto-js");

export default defineComponent({
  data: function () {
    return {
      dados_P: true,
      Enderecos_P: false,
      nome: "",
      usuario: "",
      cpf: "",
      ncompleto: "",
      dtnasc: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      genero: "",
      senha: "",
      confirmaSenha: "",
      grupo: "",
      modal: false,
      endereco: {
        cep: "",
        logradouro: "",
        numero: "",
        complemento: "",
        bairro: "",
        cidade: "",
        uf: "",
        tipoEnd: "",
        tipoEndereco: ""
      },
      enderecoFaturamento: {
        cep: "",
        logradouro: "",
        numero: "",
        complemento: "",
        bairro: "",
        cidade: "",
        uf: ""
      },
      enderecos: [],
      pagina: 1,
      data: {
        id: 0,
        nome: "",
        cpf: "",
        dataNascimento: "",
        genero: "",
        usuario: "",
        senha: "",
        enderecoEntrega: [],
        enderecoFaturamento: {}
      },
      isChecked: false,
    }
  },
  computed: {
    ...mapState([
      'carrinho',
      'user'
    ])
  },
  methods: {

    async mandarInformacoes(nome, cpf, dtnasc, genero, usuario, senha, enderecoEntrega, confirmaSenha) {
      var cErro = 0
      var cMsg = ''

      if (nome.length === 0) {
        cErro = 1
        cMsg = 'Campo Usuário não pode ser vazio'
      }

      if (usuario.length === 0) {
        if (cMsg.length === 0) {
          cErro = 1
          cMsg = 'Campo e-mail não pode ser vazio'
        } else {
          cMsg = cMsg + '\n' + 'Campo e-mail não pode ser vazio'
        }

      }

      if (senha === confirmaSenha && senha.length > 0) {
        cErro = 0
      } else {
        if (cMsg.length === 0) {
          cErro = 1
          cMsg = "As duas senhas precisam ser iguais!"
        } else {
          cMsg = cMsg + '\n' + "As duas senhas precisam ser iguais!"
        }
      }

      let cpfFormatado = cpf.replaceAll('.', '');
      cpfFormatado = cpfFormatado.replace('-', '');
      var cpfValido = this.TestaCPF(cpfFormatado)

      if (cpfValido === true && cErro === 0) {
        senha = this.encrypt(senha);

        try {
          this.data.id = this.id;
          this.data.senha = senha;
          this.data.nome = nome;
          this.data.cpf = cpf;
          this.data.dataNascimento = dtnasc;
          this.data.genero = genero;
          this.data.usuario = usuario;
          this.data.senha = senha;
          this.data.enderecoEntrega = this.enderecos;
          this.data.enderecoFaturamento = this.enderecoFaturamento;

          const response = await axios.put('http://localhost:8081/clientes/alterar', this.data)

          if (this.carrinho.length === 0) {
            console.log(response);
            alert("Cadastrado com Sucesso!");
            await router.push('/');
          } else {
            console.log(response);
            alert("Cadastrado com Sucesso!");
            await router.push('/detalhePedido')
          }
        } catch (ex) {
          console.log(ex.message);
        }
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

    encrypt(senha) {
      return CryptoJS.SHA512(senha).toString()
    },

    TestaCPF(cpf) {
      var Soma
      var Resto
      Soma = 0
      var i
      if (cpf === "00000000000") return false

      for (i = 1; i <= 9; i++) Soma = Soma + parseInt(cpf.substring(i - 1, i)) * (11 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11)) Resto = 0
      if (Resto !== parseInt(cpf.substring(9, 10))) return false

      Soma = 0
      for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpf.substring(i - 1, i)) * (12 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11)) Resto = 0
      if (Resto !== parseInt(cpf.substring(10, 11))) return false
      return true
    },

    async GetAdress(CEP, tipo) {
      var CEPTrat = CEP.replace(/\D/g, '');
      var url2 = 'https://viacep.com.br/ws/' + CEPTrat + '/json/'

      if (CEPTrat !== "") {

        var validaCep = /^[0-9]{8}$/;

        if (validaCep.test(CEPTrat)) {

          try {
            axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

            const request = await axios.get(url2, this.formAdress);

            if (request.data.erro !== false) {
              if (tipo === 1) {
                this.endereco.logradouro = request.data.logradouro;
                this.endereco.bairro = request.data.bairro;
                this.endereco.cidade = request.data.localidade;
                this.endereco.uf = request.data.uf;
              }

            }
            if (request.data.erro === true) {
              alert("CEP não encontrado.");
              console.log('CEP não encontrado.')
            }

          } catch (err) {
            console.log(err.message)
          }

        } else {
          alert("CEP Inválido.");
        }
      }
    },
    adicionarEndereco() {

      let enderecoAux = {
        cep: this.endereco.cep,
        logradouro: this.endereco.logradouro,
        numero: this.endereco.numero,
        complemento: this.endereco.complemento,
        bairro: this.endereco.bairro,
        cidade: this.endereco.cidade,
        uf: this.endereco.uf,
        tipoEndereco: this.endereco.tipoEndereco
      };

      if (enderecoAux.tipoEndereco === "PRINCIPAL") {
        for (const endereco of this.enderecos) {
          if (endereco.tipoEndereco === "PRINCIPAL") {
            endereco.tipoEndereco = "SECUNDARIO";
          }
        }
      } else {
        enderecoAux.tipoEndereco = "SECUNDARIO";
      }

      if (this.endereco.tipoEnd === 'EF') {
        this.enderecos.push(enderecoAux)
        this.preencheEnderecoFaturamento(enderecoAux);
      }
      if (this.endereco.tipoEnd === 'E') {
        this.enderecos.push(enderecoAux)
      }
      if (this.endereco.tipoEnd === 'F') {
        this.preencheEnderecoFaturamento(enderecoAux);
      }
      enderecoAux = {};
      this.endereco = {
        cep: "",
        logradouro: "",
        numero: "",
        complemento: "",
        bairro: "",
        cidade: "",
        uf: "",
        tipoEnd: "",
        tipoEndereco: ""
      }
      this.isChecked = false;
    },
    preencheTipoDeEndereco() {
      this.endereco.tipoEndereco = "PRINCIPAL";
    },
    removerEndereco(index) {
      this.enderecos.splice(index, 1);
    },
    preencheEnderecoFaturamento(enderecoAux) {
      this.enderecoFaturamento.cep = enderecoAux.cep;
      this.enderecoFaturamento.logradouro = enderecoAux.logradouro;
      this.enderecoFaturamento.numero = enderecoAux.numero;
      this.enderecoFaturamento.complemento = enderecoAux.complemento;
      this.enderecoFaturamento.bairro = enderecoAux.bairro;
      this.enderecoFaturamento.cidade = enderecoAux.cidade;
      this.enderecoFaturamento.uf = enderecoAux.uf;
    },
    async buscarCliente() {
      const response = await axios.get('http://localhost:8081/clientes/buscar/' + this.user.id);
      this.preencheCampos(response);
    },
    preencheCampos(response){
      this.id = this.user.id;
      this.nome = "";
      this.ncompleto = response.data.nome;
      this.usuario = response.data.usuario
      this.cpf = response.data.cpf;
      let date = new Date(response.data.dataNascimento);
      this.dtnasc = date.toISOString().split('T')[0];
      this.genero = response.data.genero;
      this.senha = response.data.senha;
      this.confirmaSenha = "";
      this.enderecoFaturamento = response.data.enderecoFaturamento;
      this.enderecos = response.data.enderecoEntrega;
    }
  },

  mounted() {
    this.buscarCliente();
  }
});

</script>

<style scoped>

main {
  background: rgba(45, 46, 50);
  height: 140 dvh;
  width: 100vw;
  display: flex;
  justify-content: center;
  text-align: center;
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
  margin-top: 1%;
}

input, select {
  padding: 0.5 dvw;
  align-items: left;
  justify-content: left;
  text-align: left;
  font-weight: bold;
}

fieldset {
  background-color: aliceblue;
  opacity: 0.90;
  border-radius: 40px;
  border-color: rgb(35, 75, 110);
  height: 150dvh;
  width: 50dvw;
}

.itens-formulario {
  text-align: left;
  margin: 30px 10px;
}

.itens-entrada {
  border: 1px solid #222222;
  border-radius: 5px;
  margin-left: auto;
}

.btnAcao {
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  margin: 32% 10%;
}

.grid {
  margin-top: -5%;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  justify-content: left;
  text-align: left;
}

.grid2 {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  justify-content: left;
  text-align: left;
}

.textLabel {
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  width: 80px;
}

.textLabelCS {
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  width: 140px;
}

.usuario {
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  margin-bottom: 2%;
  width: 500px;
}

.e-mail {
  margin-bottom: 2%;
  width: 500px;
}

.inputGrande {
  float: left;
  display: block;
  font-weight: bold;
  padding: 5px;
  margin-bottom: 2%;
  width: 440px;
}

.inputSelect {
  width: 200px;
}

.subMenu {
  height: 50px;
  margin-left: 6%;
  display: flex;
}

.subMenu-itens {
  margin: 0 3%;
}

.listaEndereco {
  text-align: center;
  justify-content: center;
  margin-top: 2%;
  margin-left: 15%;
  width: 75%;
  height: 75%;
}

.BtnCadEnd {
  margin-left: 80%;
  padding: 1%;
  border: solid;
  border-color: darkgreen;
  color: green;
}

.container-lista-faturamento {
  margin-top: 3%;
}

.container-lista-enderecos {
  margin-top: 3%;
}

</style>