<template>
  <v-dialog
      v-model="dialog"
      persistent
      max-width="700px"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-btn
          class="btn-modal"
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          width="10px"
          height="20px"
      >
        +
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <span class="text-h5">Cadastrar Endereço</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col
                cols="6"
                sm="6"
                md="4"
            >
              <div class="itens-formulario">
                <label class="textLabel" for="cep">CEP:</label>
                <input class="itens-entrada" v-mask="'#####-###'" value="" @blur="getAdress(endereco.cep,1)"
                       maxlength="9" type="text" aria-label="cep" placeholder="CEP" v-model="endereco.cep"
                >
              </div>
            </v-col>
            <v-col
                cols="6"
                sm="6"
                md="4"
            >
              <div class="itens-formulario">
                <label class="textLabel" for="logradouro">Logradouro:</label>
                <input class="itens-entrada" type="text" aria-label="Logradouro"
                       placeholder="Logradouro" v-model="endereco.logradouro">
              </div>
            </v-col>
            <v-col cols="6">
              <div class="itens-formulario">
                <label class="textLabel" for="num">Número:</label>
                <input class="itens-entrada" type="text" aria-label="Número" placeholder="Número"
                       v-model="endereco.numero">
              </div>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="6">
              <div class="itens-formulario">
                <label class="textLabel" for="compl">Complemento:</label>
                <input class="itens-entrada" type="text" aria-label="Complemento" placeholder="Complemento"
                       v-model="endereco.complemento">
              </div>
            </v-col>
            <v-col
                cols="6"
                sm="6"
            >
              <div class="itens-formulario">
                <label class="textLabel" for="bairro">Bairro:</label>
                <input class="itens-entrada" type="text" aria-label="Bairro" placeholder="Bairro"
                       v-model="endereco.bairro">
              </div>
            </v-col>
            <v-col
                cols="6"
                sm="6"
            >
              <div class="itens-formulario">
                <label class="textLabel" for="UF">UF:</label>
                <input class="itens-entrada" type="text" aria-label="UF" placeholder="UF"
                       v-model="endereco.uf">
              </div>
            </v-col>
            <v-col>
              <select v-model="endereco.tipoEndereco">
                <option selected value="PRINCIPAL">Principal</option>
                <option value="SECUNDARIO">Secundário</option>
              </select>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
        >
          Cancelar
        </v-btn>
        <v-btn
            color="blue darken-1"
            text
            @click="cadastrarNovoEndereco"
        >
          Salvar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import {defineComponent} from "vue";
import {mapMutations, mapState} from "vuex";
import axios from "axios";

export default defineComponent({
  name: "ModalFormulario",
  data: () => ({
    dialog: false,
    endereco: {
      cep: "",
      logradouro: "",
      numero: "",
      complemento: "",
      bairro: "",
      cidade: "",
      uf: "",
      tipoEndereco: ""
    },
    enderecoAGravar: {},
  }),
  computed: {
    ...mapState([
      'pedidoFechamento',
    ])
  },
  methods: {
    async cadastrarNovoEndereco() {
      this.adicionarEndereco();
      const responseCliente = await axios.get(
          'http://localhost:8081/clientes/buscar/' + this.pedidoFechamento.idCliente,
          this.pedidoFechamento.cliente
      );

      let cliente = responseCliente.data;
      cliente.enderecoEntrega.push(this.enderecoAGravar);

      await axios.put(
          'http://localhost:8081/clientes/alterar',
          cliente
      );

      this.dialog = false
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

      this.enderecoAGravar = {
        cep: enderecoAux.cep,
        logradouro: enderecoAux.logradouro,
        numero: enderecoAux.numero,
        complemento: enderecoAux.complemento,
        bairro: enderecoAux.bairro,
        cidade: enderecoAux.cidade,
        uf: enderecoAux.uf,
        tipoEndereco: enderecoAux.tipoEndereco
      }

      console.log(this.enderecoAGravar);

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
    },
    preencheTipoDeEndereco() {
      this.endereco.tipoEndereco = "PRINCIPAL";
    },
    buscaEnderecosEntrega() {
      this.endereco = this.pedidoFechamento.enderecoEntrega;
    },
    async getAdress(CEP, tipo) {
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
    ...mapMutations([
      'setEnderecoEntrega'
    ])
  },
  mounted() {
    this.buscaEnderecosEntrega();
  }
});
</script>

<style scoped>
.btn-modal {
  margin-left: 10px;
}


</style>