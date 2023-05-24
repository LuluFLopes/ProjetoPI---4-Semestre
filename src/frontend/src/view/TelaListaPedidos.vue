<template>
  <v-card>
    <h1>Histórico dos Pedidos:</h1>
    <table class="tabela-principal">
      <thead>
      <tr>
        <th>Número do Pedido</th>
        <th>Data da Compra</th>
        <th>Valor Total</th>
        <th>Status do Pedido</th>
        <th>Valor do Frete</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(pedido,index) in this.pedidos" :key="index">
        <td>{{ pedido.id }}</td>
        <td>{{ pedido.dataCompra }}</td>
        <td>{{ pedido.valorTotal }}</td>
        <td>{{ pedido.statusPedido }}</td>
        <td>{{ pedido.frete }}</td>
        <td>
          <v-btn @click="redirecionarParaATelaDetalhes(pedido.id)">
            &#9998;
          </v-btn>
        </td>
      </tr>
      </tbody>
    </table>
  </v-card>
</template>

<script>
import {defineComponent} from "vue";
import axios from "axios";
import router from "@/router";
import {mapMutations} from "vuex";

export default defineComponent({
  name: "TelaListaPedidos",
  data() {
    return {
      pedidos: [],
    }
  },
  methods: {
    async listarPedidos() {
      const response = await axios.get('http://localhost:8081/pedidos/listar');
      this.pedidos = response.data;
    },
    redirecionarParaATelaDetalhes(id) {
      this.setPedidoPesquisado(id);
      router.push('/visualizarDetalhePedido');
    },
    ...mapMutations([
      'setPedidoPesquisado'
    ]),
  },
  mounted() {
    this.listarPedidos();
  }
});
</script>

<style scoped>
.tabela-principal {
  text-align: center;
  justify-content: center;
  margin-top: 2%;
  padding-bottom: 2%;
  margin-left: 15%;
  width: 75%;
  height: 75%;
}
</style>