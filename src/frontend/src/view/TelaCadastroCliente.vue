<template>
  <main>
    <div id="app">
      <h1>Cadastro de Cliente</h1>
      <form v-on:submit.prevent role="form" class="formulario">
        <fieldset>

          <div class="subMenu">
            <button class="subMenu-itens" @click="dados_P = true , Enderecos_P = false">Dados Pessoais</button>
            <button class="subMenu-itens" @click="Enderecos_P = true, dados_P = false">Endereços</button>
          </div>

          <div v-show="dados_P === true">
            <div class="itens-formulario">
              <label class="textLabel" for="userLogin">Usuário:</label>
              <input class="itens-entrada usuario" type="text" aria-label="Usuário" placeholder="Usuário" v-model="nome"
                     required>
            </div>

            <div class="itens-formulario">
              <label class="textLabelCS" for="ncompeto">Nome Completo:</label>
              <input class="itens-entrada inputGrande" type="text" aria-label="Nome Completo"
                     placeholder="Nome Completo"
                     v-model="ncompleto" required>
            </div>

            <div class="itens-formulario">
              <label class="textLabel" for="E-Mail">E-Mail:</label>
              <input class="itens-entrada e-mail" type="email" aria-label="Email" placeholder="Email" v-model="usuario"
                     required>
            </div>

            <div class="grid">
              <div class="itens-formulario">
                <label class="textLabel" for="CPF">CPF:</label>
                <input class="itens-entrada" type="text" aria-label="CPF" placeholder="CPF"
                       v-model="cpf" required>
              </div>

              <div class="itens-formulario">

                <v-dialog
                    ref="dialog"
                    v-model="modal"
                    :return-value.sync="dtnasc"
                    persistent
                    width="290px"
                    required
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="dtnasc"
                        label="Data Nascimento:"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                        required
                    ></v-text-field>
                  </template>
                  <v-date-picker
                      v-model="dtnasc"
                      scrollable
                      required
                  >
                    <v-spacer></v-spacer>
                    <v-btn
                        text
                        color="primary"
                        @click="modal = false"
                        required
                    >
                      Cancel
                    </v-btn>
                    <v-btn
                        text
                        color="primary"
                        @click="$refs.dialog.save(dtnasc)"
                        required
                    >OK
                    </v-btn>
                  </v-date-picker>
                </v-dialog>
              </div>

              <div class="itens-formulario">
                <label class="textLabelCS" for="genero">Gênero:</label>
                <select class="itens-entrada inputSelect" aria-label="Genero" name="Genero" v-model="genero" required>
                  <option value="">Selecione...</option>
                  <option value="Masculino">Masculino</option>
                  <option value="Feminino">Feminino</option>
                </select>
              </div>

            </div>
            <div class="grid">
              <div class="itens-formulario">
                <label class="textLabel" for="userPassword">Senha:</label>
                <input class="itens-entrada" type="password" aria-label="Senha" placeholder="Senha" v-model="senha"
                       required>
              </div>

              <div class="itens-formulario">
                <label class="textLabelCS" for="userPasswordConf">Confirmar Senha:</label>
                <input class="itens-entrada" type="password" aria-label="Confirmar Senha" placeholder="Confirmar Senha"
                       v-model="confirmaSenha" required>
              </div>
            </div>
          </div>

          <div v-show="Enderecos_P === true">

            <div class="grid2">

              <div class="itens-formulario">
                <label class="textLabel" for="cep">CEP:</label>
                <input class="itens-entrada" v-mask="'#####-###'" value="" @blur="GetAdress(enderecoEntrega.CEP,1)"
                       maxlength="9" type="text" aria-label="cep" placeholder="CEP" v-model="enderecoEntrega.CEP"
                       required>

              </div>

              <div class="itens-formulario">

                <label class="textLabelCS" for="genero">Tipo de Endereço:</label>
                <select class="itens-entrada inputSelect" aria-label="Genero" name="Genero"
                        v-model="enderecoEntrega.tipoEnd" required>
                  <option value="">Selecione...</option>
                  <option value="EF">Entrega/Faturamento</option>
                  <option value="E">Entrega</option>
                  <option value="F">Faturamento</option>
                </select>

                <v-checkbox v-if="enderecoEntrega.tipoEnd !== 'F'" v-model="enderecoEntrega.tipoEndereco"
                            :label="'Endereço Principal'"
                            class="font-weight-bold"
                            required
                ></v-checkbox>

              </div>


            </div>


            <div class="grid">

              <div class="itens-formulario">
                <label class="textLabel" for="logradouro">Logradouro:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Logradouro"
                       placeholder="Logradouro" v-model="enderecoEntrega.logradouro" required>
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="num">Número:</label>
                <input class="itens-entrada" type="text" aria-label="Número" placeholder="Número"
                       v-model="enderecoEntrega.num" required>
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="compl">Complemento:</label>
                <input class="itens-entrada" type="text" aria-label="Complemento" placeholder="Complemento"
                       v-model="enderecoEntrega.compl" required>
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="bairro">Bairro:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Bairro" placeholder="Bairro"
                       v-model="enderecoEntrega.bairro" required>
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="cidade">Cidade:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="Cidade" placeholder="Cidade"
                       v-model="enderecoEntrega.localidade" required>
              </div>

              <div class="itens-formulario">
                <label class="textLabel" for="UF">UF:</label>
                <input class="itens-entrada" readonly="readonly" type="text" aria-label="UF" placeholder="UF"
                       v-model="enderecoEntrega.uf" required>
              </div>
            </div>

            <button class="BtnCadEnd" @click="AddEnd(enderecoEntrega)">+ Adicionar</button>

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
              <tr v-for="(endereco,index) in enderecos" v-bind:key="index">
                <td>{{ endereco.CEP }}</td>
                <td>{{ endereco.logradouro }}</td>
                <td>{{ endereco.num }}</td>
                <td>{{ endereco.compl }}</td>
                <td>{{ endereco.bairro }}</td>
                <td>{{ endereco.localidade }}</td>
                <td>{{ endereco.uf }}</td>
              </tr>
              </tbody>
            </table>
          </div>

          <input type="submit" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, cpf, dtnasc, genero, usuario, senha, enderecoEntrega, confirmaSenha)">

          <router-link to="/WlistaUsuario" custom v-slot="{ navigate }">
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
      enderecoEntrega: {
        CEP: "",
        logradouro: "",
        num: "",
        compl: "",
        bairro: "",
        localidade: "",
        uf: "",
        tipoEnd: "",
        tipoEndereco: ""
      },
      enderecoFaturamento: {
        CEP: "",
        logradouro: "",
        num: "",
        compl: "",
        bairro: "",
        localidade: "",
        uf: ""

      },
      enderecos: [],
      pagina: 1,
      data: {
        nome: "",
        cpf: "",
        dataNascimento: "",
        genero: "",
        usuario: "",
        senha: "",
        endEntrega: {
          CEP: "",
          logradouro: "",
          num: "",
          compl: "",
          bairro: "",
          localidade: "",
          uf: "",
          tipoEnd: "",
        },
        endFaturamento: {
          CEP: "",
          logradouro: "",
          num: "",
          compl: "",
          bairro: "",
          localidade: "",
          uf: "",
          tipoEnd: "",
        }
      }
    }
  },

  computed: {
    ...mapState([
      'carrinho'
    ])
  },

  beforeMount() {
    this.listarEnderecosFat(this.enderecos)
    this.listarEnderecosEntg(this.enderecos)
  }
  ,
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

      if (enderecoEntrega.tipoEndereco === true) {
        enderecoEntrega.tipoEndereco = 'PRINCIPAL'
      } else {
        enderecoEntrega.tipoEndereco = 'SECUNDARIO'
      }

      let cpfFormatado = cpf.replaceAll('.', '');
      cpfFormatado = cpfFormatado.replace('-', '');
      var cpfValido = this.TestaCPF(cpfFormatado)

      if (cpfValido === true && cErro === 0) {

        senha = this.encrypt(senha);


        try {
          this.data.senha = senha
          this.data.nome = nome;
          this.data.cpf = cpf;
          this.data.dataNascimento = dtnasc;
          this.data.genero = genero;
          this.data.usuario = usuario;
          this.data.senha = senha;
          this.data.enderecoEntrega = this.endEntrega;
          this.data.enderecoEntrega = parseInt(this.data.enderecoEntrega);
          this.data.enderecoFaturamento = this.endFaturamento;
          this.data.enderecoFaturamento = parseInt(this.data.enderecoFaturamento);

          //console.log(enderecoEntrega)
          //console.log(enderecoFaturamento)

          const response = await axios.post('http://localhost:8081/clientes/cadastrar', this.data)


          if (this.carrinho.length === 0) {
            console.log(response);
            alert("Cadastrado com Sucesso!");
            await router.push('/');

          } else {
            console.log(response);
            alert("Cadastrado com Sucesso!");
            await router.push('/loginCliente')
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
      if (cpf == "00000000000") return false

      for (i = 1; i <= 9; i++) Soma = Soma + parseInt(cpf.substring(i - 1, i)) * (11 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11)) Resto = 0
      if (Resto != parseInt(cpf.substring(9, 10))) return false

      Soma = 0
      for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpf.substring(i - 1, i)) * (12 - i)
      Resto = (Soma * 10) % 11

      if ((Resto === 10) || (Resto === 11)) Resto = 0
      if (Resto != parseInt(cpf.substring(10, 11))) return false
      return true
    },

    async GetAdress(CEP, tipo) {
      var CEPTrat = CEP.replace(/\D/g, '');
      var url2 = 'https://viacep.com.br/ws/' + CEPTrat + '/json/'

      if (CEPTrat != "") {

        var validaCep = /^[0-9]{8}$/;

        if (validaCep.test(CEPTrat)) {

          try {
            axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

            const request = await axios.get(url2, this.formAdress)

            console.log(request)

            if (request.data.erro !== false) {
              if (tipo == 1) {
                this.enderecoEntrega.logradouro = request.data.logradouro;
                this.enderecoEntrega.bairro = request.data.bairro;
                this.enderecoEntrega.localidade = request.data.localidade;
                this.enderecoEntrega.uf = request.data.uf;
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

    listarEnderecosFat(enderecos) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/clientes/buscarEnderecoFaturamento/' + this.pagina

      })
          .then(function (response) {
            for (let i = 0; i < response.data.length; i++) {
              console.log(response.data[i])
              enderecos.push(response.data[i])
            }
          })
          .catch(function (error) {
            alert("Não foi possível listar.");
            console.log(error);
          });
    },

    listarEnderecosEntg(enderecos) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/clientes/buscarEnderecoEntrega/' + this.pagina

      })
          .then(function (response) {
            for (let i = 0; i < response.data.length; i++) {
              console.log(response.data[i])
              enderecos.push(response.data[i])
            }
          })
          .catch(function (error) {
            alert("Não foi possível listar.");
            console.log(error);
          });
    },

    AddEnd(endEntrega) {

      var endFaturamento = {}

      if (this.enderecoEntrega.tipoEnd === 'EF') {

        endEntrega.CEP = this.enderecoEntrega.CEP
        endEntrega.logradouro = this.enderecoEntrega.logradouro
        endEntrega.num = this.enderecoEntrega.num
        endEntrega.compl = this.enderecoEntrega.compl
        endEntrega.bairro = this.enderecoEntrega.bairro
        endEntrega.localidade = this.enderecoEntrega.localidade
        endEntrega.uf = this.enderecoEntrega.uf
        this.enderecos.push(endEntrega)

        console.log(endEntrega)

        endFaturamento.CEP = this.enderecoEntrega.CEP
        endFaturamento.logradouro = this.enderecoEntrega.logradouro
        endFaturamento.num = this.enderecoEntrega.num
        endFaturamento.compl = this.enderecoEntrega.compl
        endFaturamento.bairro = this.enderecoEntrega.bairro
        endFaturamento.localidade = this.enderecoEntrega.localidade
        endFaturamento.uf = this.enderecoEntrega.uf
        this.enderecos.push(endFaturamento)

        console.log(endFaturamento)

      }

      if (this.enderecoEntrega.tipoEnd === 'E') {

        endEntrega.CEP = this.enderecoEntrega.CEP
        endEntrega.logradouro = this.enderecoEntrega.logradouro
        endEntrega.num = this.enderecoEntrega.num
        endEntrega.compl = this.enderecoEntrega.compl
        endEntrega.bairro = this.enderecoEntrega.bairro
        endEntrega.localidade = this.enderecoEntrega.localidade
        endEntrega.uf = this.enderecoEntrega.uf

      }

      if (this.enderecoEntrega.tipoEnd === 'F') {

        endFaturamento.CEP = this.enderecoEntrega.CEP
        endFaturamento.logradouro = this.enderecoEntrega.logradouro
        endFaturamento.num = this.enderecoEntrega.num
        endFaturamento.compl = this.enderecoEntrega.compl
        endFaturamento.bairro = this.enderecoEntrega.bairro
        endFaturamento.localidade = this.enderecoEntrega.localidade
        endFaturamento.uf = this.enderecoEntrega.uf
      }

      //this.listarEnderecosEntg();
      //this.listarEnderecosFat();

    }

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
  height: 120 dvh;
  width: 50 dvw;
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

</style>