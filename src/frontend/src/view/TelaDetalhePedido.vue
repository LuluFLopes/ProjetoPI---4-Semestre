<template>
  <div class="container">
    <div class="group">
      <v-card class="cartao">
        <h2>Detalhes do seu pedido</h2>
        <div class="row">
          <div class="col">
            <h3 class="title div-pagamentos">Forma de Pagamento</h3>
            <select class="div-pagamentos" v-model="pedido.formaDePagamento" required>
              <option value="">Selecione...</option>
              <option value="Cartão de Crédito">Cartão de Crédito</option>
              <option value="Dinheiro">Dinheiro</option>
              <option value="Pix">Pix</option>
              <option value="Cheque">Cheque</option>
            </select>
          </div>
        </div>
      </v-card>

      <v-card class="frete elemento-lista cartao">
        <h3 class="title posicao-frete">Valor do Frete</h3>
        <select class="posicao-frete" v-model="freteTransportadora" @change="calculaFrete" required>
          <option value="0">Selecione...</option>
          <option value="3">Correios</option>
          <option value="5">Rodonaves</option>
          <option value="6">Loggi</option>
          <option value="2">Carvalima</option>
        </select>
        <h3 class="posicao-frete">{{ frete }}</h3>
      </v-card>

      <v-card class="container-carrinho elemento-lista cartao">
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
          <input type="button" value="Ir Para A Tela De Checkout" class="submit-btn elementos-cartao"
                 @click="salvarAntesDeFecharCompra()">
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {mapState, mapMutations} from "vuex";
import router from "@/router";

export default defineComponent({
  data() {
    return {
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
    preencheCorpoDaRequisicao() {
      this.pedido.valorTotal = this.valorTotal;
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
    salvarAntesDeFecharCompra() {
      this.preencheCorpoDaRequisicao();
      this.setInformacoesPedidoFechamento(this.pedido);
      if (this.user.id === 0) {
        router.push("/loginCliente")
      } else {
        router.push("/telaFinalizarCompra");
      }
    },
    ...mapMutations([
      'adicionaFreteNoTotal',
      'adicionaNoCarrinho',
      'removeDoCarrinho',
      'calculaTotalCarrinho',
      'removeProdutoCarrinho',
      'salvaNumeroPedido',
      'limpaCarrinho',
      'setInformacoesPedidoFechamento'
    ]),
  },
  mounted() {
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

@media (max-width: 425px) {

  .container {
    width: 100%;
  }

  .listagemProdutosContainer {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }

  .elemento-lista {
    width: 100%;
  }

  .group {
    margin: 0 auto;
  }

  .div-pagamentos {
    display: flex;
    justify-content: center;
    margin: 0 auto;
  }

  .cartao {
    width: 100%;
  }
}

</style>
