<template>

  <div class="container">
    <div>
      <form>
        <div class="row">
          <div class="col">
            <h3 class="title">Dados Pessoais</h3>

            <div class="inputBox">
              <span>Nome Completo: {{ this.user.nome }}</span>
            </div>
            <div class="inputBox">
              <span>Usuário: {{ this.user.usuario }}</span>
            </div>
            <div class="inputBox">
              <span>Email: {{ this.user.cpf }}</span>
            </div>
            <div class="inputBox">
              <span>Endereço de Entrega: </span>
              <select v-model="pedido.enderecoEntrega">
                <option value="">Selecione...</option>
                <option v-for="(endereco, indexEnd) in enderecosEntrega" :key="indexEnd" :value="endereco">
                  {{ endereco.logradouro + ", " + endereco.numero + ", " + endereco.cep }}
                </option>
              </select>
            </div>
            <div class="inputBox">
              <span>Endereço de Faturamento: </span>
              <p> {{
                  enderecoFaturamento.logradouro + ", " + enderecoFaturamento.numero + ", " + enderecoFaturamento.cep
                }} </p>
            </div>
          </div>

          <div class="col">
            <h3 class="title">Forma de Pagamento</h3>
            <select v-model="pedido.formaDePagamento" required>
              <option value="">Selecione...</option>
              <option value="Cartão de Crédito">Cartão de Crédito</option>
              <option value="Dinheiro">Dinheiro</option>
              <option value="Pix">Pix</option>
              <option value="Cheque">Cheque</option>
            </select>
          </div>
        </div>
      </form>

      <v-card class="frete">
        <h3 class="title posicao-frete">Valor do Frete</h3>
        <select class="posicao-frete opcoes-frete" v-model="freteTransportadora" @change="calculaFrete" required>
          <option value="0">Selecione...</option>
          <option value="3">Correios</option>
          <option value="5">Rodonaves</option>
          <option value="6">Loggi</option>
          <option value="2">Carvalima</option>
        </select>
        <h3 class="posicao-frete">{{ frete }}</h3>
      </v-card>

      <v-card class="container-carrinho">
        <div class="listagemProdutosContainer col">
          <h2 class="elementos-cartao">Carrinho de Compras</h2>
          <table class="listaProdutos elementos-cartao">
            <thead>
            <tr>
              <th>Código</th>
              <th>Nome Produto</th>
              <th>Qtd Estoque</th>
              <th>Valor</th>
              <th>&nbsp;</th>
              <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(produto,index) in this.carrinho" v-bind:key="index">
              <td>{{ produto.nome }}</td>
              <td>{{ produto.detalhes }}</td>
              <td>{{ produto.quantidade }}</td>
              <td>{{ produto.preco }}</td>
              <td>
                <v-btn @click="adicionaItem(produto)">
                  &#43;
                </v-btn>
              </td>
              <td>
                <v-btn @click="removeItem(produto)">
                  &#8722;
                </v-btn>
              </td>
              <td>
                <v-btn @click="removeProduto(produto)">
                  &#128465;
                </v-btn>
              </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <strong>
                <td>Valor Total R$</td>
                <td>{{ this.valorTotal }}</td>
              </strong>
            </tr>
            </tfoot>
          </table>
          <v-btn class="botao-limpar" color="error" @click="limpar">
            Limpar Carrinho
          </v-btn>
          <input type="button" value="Finalizar Compra" class="submit-btn elementos-cartao"
                 @click="fecharPedidoDeCompra(indexEnd)">
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {mapState, mapMutations} from "vuex";
import axios from "axios";
import router from "@/router";

export default defineComponent({
  data() {
    return {
      enderecosEntrega: [],
      enderecoFaturamento: {},
      pedido: {
        valorTotal: 0,
        enderecoEntrega: "",
        enderecoFaturamento: {},
        idCliente: 0,
        produtos: [],
        formaDePagamento: "",
        frete: 0,
        transportadora: "",
      },
      indexEndereco: 0,
      freteTransportadora: "0",
      frete: 0,
    }
  },
  computed: {
    ...mapState([
      'carrinho',
      'valorTotal',
      'user'
    ])
  },
  methods: {
    async fecharPedidoDeCompra() {
      this.preencheCorpoDaRequisicao();
      try {
        const request = await axios.post('http://localhost:8081/pedidos/cadastrar', this.pedido);
        console.log(request.data);
        this.salvaNumeroPedido(request.data.id);
        this.limpaCarrinho();
        await router.push('/compraConcluida')
      } catch (ex) {
        console.log(ex.message);
      }
    },
    async buscaEnderecoFaturamento() {
      try {
        const request = await axios.get('http://localhost:8081/clientes/buscarEnderecoFaturamento/' + this.user.id);
        this.enderecoFaturamento = request.data;
      } catch (ex) {
        console.log(ex.message);
      }
    },
    async buscaEnderecosEntrega() {
      try {
        const request = await axios.get('http://localhost:8081/clientes/buscarEnderecoEntrega/' + this.user.id);
        this.enderecosEntrega = request.data;
      } catch (ex) {
        console.log(ex.message);
      }
    },
    preencheCorpoDaRequisicao() {
      this.pedido.valorTotal = this.valorTotal;
      this.pedido.enderecoFaturamento = this.enderecoFaturamento;
      this.pedido.idCliente = this.user.id;
      this.pedido.produtos = this.carrinho;
      this.pedido.frete = this.frete;
      this.preencheTransportadora();
    },
    preencheTransportadora() {
      if (this.freteTransportadora === "3") {
        this.pedido.transportadora = "Correios";
      } else if (this.freteTransportadora === "5") {
        this.pedido.transportadora = "Rodonaves";
      } else if (this.freteTransportadora === "6") {
        this.pedido.transportadora = "Loggi";
      } else if (this.freteTransportadora === "2") {
        this.pedido.transportadora = "Carvalima";
      }
    },
    calculaFrete() {
      if (this.freteTransportadora !== "0") {
        this.adicionaFreteNoTotal(this.valorTotal - this.frete);
        this.frete = 0;
        let qtdItens = 0;
        let valorBase = 15;
        for (const produto of this.carrinho) {
          qtdItens += produto.quantidade;
        }
        let valorSomado = parseInt(this.freteTransportadora) + valorBase;
        this.frete = qtdItens * valorSomado;
        this.adicionaFreteNoTotal(this.valorTotal + this.frete);
        this.calculaTotalCarrinho(this.frete);
      }
    },
    adicionaItem(produto) {
      produto.quantidade = parseInt(produto.quantidade++);
      this.adicionaNoCarrinho(produto);
      this.calculaTotalCarrinho(this.frete);
    },
    removeItem(produto) {
      produto.quantidade = parseInt(produto.quantidade--);
      this.removeDoCarrinho(produto);
      this.calculaTotalCarrinho(this.frete);
    },
    removeProduto(produto) {
      this.removeProdutoCarrinho(produto);
      this.calculaTotalCarrinho(this.frete);
    },
    limpar() {
      this.limpaCarrinho();
    },
    ...mapMutations([
      'adicionaFreteNoTotal',
      'adicionaNoCarrinho',
      'removeDoCarrinho',
      'calculaTotalCarrinho',
      'removeProdutoCarrinho',
      'salvaNumeroPedido',
      'limpaCarrinho',
    ]),
  },
  mounted() {
    this.buscaEnderecoFaturamento();
    this.buscaEnderecosEntrega();
    this.calculaTotalCarrinho(this.frete);
  }
});
</script>

<style scoped>
/* Incluindo a biblioteca Font Awesome */
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  outline: none;
  border: none;
  text-transform: capitalize;
  transition: all .2s linear;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 25px;
  min-height: 100vh;
  background: rgba(45, 46, 50);
  padding-bottom: 70px;
  overflow: auto;
  width: 100%;
}

.container form {
  padding: 20px;
  width: 100%;
  background: #ffffff;
  box-shadow: 0 5px 10px rgba(0, 0, 0, .1);
  border-radius: 5px;
}

form {
  display: inline-block;
}

.container .row {
  display: flex;
  flex-wrap: wrap;
  gap: 15px;
}

.container form .row .col {
  flex: 1 1 250px;
}

.container form .row .col .title {
  font-size: 20px;
  color: rgba(45, 46, 50);
  padding-bottom: 5px;
  text-transform: uppercase;
}

.container form .row .col .inputBox {
  margin: 15px 0;
}

.container form .row .col .inputBox span {
  display: block;
}

.container form .row .col .inputBox input {
  width: 100%;
  border: 1px solid #ccc;
  padding: 10px 15px;
  font-size: 15px;
  text-transform: none;
}

.container form .row .col .inputBox input:focus {
  border: 1px solid #000;
}

.container form .row .col .flex {
  display: flex;
  gap: 15px;
}

.container form .row .col .flex .inputBox {
  margin-top: 5px;
}

.container form .row .col .inputBox img {
  height: 34px;
  margin-top: 5px;
  filter: drop-shadow(0 0 1px #000000);
}

.submit-btn {
  width: 100%;
  padding: 12px;
  font-size: 30px;
  font-weight: bold;
  color: #ffffff;
  background: #222222;
  cursor: pointer;
  margin-top: 20px;
}

.submit-btn:hover {
  background: green;
}

.listagemProdutosContainer {
  display: inline-block;
}

table {
  width: 100%;
}

table, thead, th, td, tfooter {
  padding: 10px;
}

.container-carrinho {
  margin-top: 20px;
}

.elementos-cartao {
  padding: 20px;
}

h2 {
  text-align: center;
  font-size: 30px;
}

.posicao-frete {
  text-align: center;
  padding: 10px;
}

.frete {
  margin-top: 20px;
  text-align: center;
  text-align-last: center;
}

.botao-limpar {
  margin-top: 20px;
  float: right;
}

</style>
