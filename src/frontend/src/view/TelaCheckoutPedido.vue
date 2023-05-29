<template>

  <div class="container">
    <div>
      <form>
        <h2 class="main-title">Confirme as informações antes de finalizar sua compra</h2>
        <div class="row">
          <div class="col">
            <h3 class="title">Dados Pessoais</h3>
            <div class="inputBox">
              <span>Nome Completo: {{ pedido.cliente.nome }}</span>
            </div>
            <div class="inputBox">
              <span>Usuário: {{ pedido.cliente.usuario }}</span>
            </div>
            <div class="inputBox">
              <span>CPF: {{ pedido.cliente.cpf }}</span>
            </div>
            <div class="inputBox">
              <span>Endereço de Entrega: </span>
              <p>{{
                  pedido.enderecoEntrega.logradouro + ", " + pedido.enderecoEntrega.numero + ", " + pedido.enderecoEntrega.cep
                }}</p>
            </div>
            <div class="inputBox">
              <span>Endereço de Faturamento: </span>
              <p> {{
                  pedido.enderecoFaturamento.logradouro + ", " + pedido.enderecoFaturamento.numero + ", " + pedido.enderecoFaturamento.cep
                }} </p>
            </div>
          </div>
          <div class="col">
            <h3 class="title">Forma de Pagamento</h3>
            <p>{{ pedido.formaDePagamento }}</p>
          </div>
        </div>
      </form>

      <v-card class="frete">
        <h3 class="title posicao-frete">Valor do Frete</h3>
        <h3 class="posicao-frete">{{ pedido.transportadora }}</h3>
        <h3 class="posicao-frete">{{ pedido.frete }}</h3>
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
            </tr>
            </thead>
            <tbody>
            <tr v-for="(produto,index) in pedido.produtos" :key="index">
              <td>{{ produto.nome }}</td>
              <td>{{ produto.detalhes }}</td>
              <td>{{ produto.quantidade }}</td>
              <td>{{ produto.preco }}</td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <strong>
                <td>Valor Total R$</td>
                <td>{{ pedido.valorTotal }}</td>
              </strong>
            </tr>
            </tfoot>
          </table>
          <input type="button" value="Finalizar Compra" class="submit-btn elementos-cartao"
                 @click="fecharPedidoDeCompra()">
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {mapMutations, mapState} from "vuex";
import axios from "axios";
import router from "@/router";

export default defineComponent({
  data() {
    return {
      pedido: {
        valorTotal: 0,
        enderecoEntrega: "",
        enderecoFaturamento: {},
        cliente: {},
        produtos: [],
        formaDePagamento: "",
        frete: 0,
        transportadora: "",
      },
    }
  },
  methods: {
    async fecharPedidoDeCompra() {
      try {
        const request = await axios.post('http://localhost:8081/pedidos/cadastrar', this.pedidoFechamento);
        this.salvaNumeroPedido(request.data.id);
        this.limpaCarrinho();
        await router.push('/compraConcluida')
      } catch (ex) {
        console.log(ex.message);
      }
    },
    async preencheCampos() {
      const request = await axios.get('http://localhost:8081/clientes/buscar/' + this.pedidoFechamento.idCliente);
      this.pedido.cliente = request.data;
      this.pedido.valorTotal = this.pedidoFechamento.valorTotal;
      this.pedido.enderecoEntrega = this.pedidoFechamento.enderecoEntrega;
      this.pedido.enderecoFaturamento = this.pedidoFechamento.enderecoFaturamento;
      this.pedido.produtos = this.pedidoFechamento.produtos;
      this.pedido.formaDePagamento = this.pedidoFechamento.formaDePagamento;
      this.pedido.frete = this.pedidoFechamento.frete;
      this.pedido.transportadora = this.pedidoFechamento.transportadora;
    },
    ...mapMutations([
      'salvaNumeroPedido',
      'limpaCarrinho'
    ]),
  },
  computed: {
    ...mapState([
      'pedidoId',
      'pedidoFechamento',
    ])
  },
  mounted() {
    this.preencheCampos();
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

.main-title {
  margin-bottom: 20px;
}
</style>
