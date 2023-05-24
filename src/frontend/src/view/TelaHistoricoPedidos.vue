<template>

  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral/>
    </div>

    <div class="frame">
      <h1>Pedidos</h1>
      <div class="inp-pesquisar">
      </div>
      <div class="main-table">
        <table class="tabela-principal">
          <thead>
          <tr>
            <th>Número do Pedido</th>
            <th>Data da Compra</th>
            <th>Valor Total</th>
            <th>Status do Pedido</th>
            <th>Valor do Frete</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(pedido,index) in this.historicoPedidos" :key="index">
            <td>{{ pedido.id }}</td>
            <td>{{ pedido.dataCompra }}</td>
            <td>{{ pedido.valorTotal }}</td>
            <td>
              <select :disabled="!checkBoxHabilitada" v-model="pedido.statusPedido">
                <option value="AGUARDANDO PAGAMENTO">AGUARDANDO PAGAMENTO</option>
                <option value="PAGAMENTO REJEITADO">PAGAMENTO REJEITADO</option>
                <option value="PAGAMENTO COM SUCESSO">PAGAMENTO COM SUCESSO</option>
                <option value="AGUARDANDO RETIRADA">AGUARDANDO RETIRADA</option>
                <option value="EM TRANSITO">EM TRANSITO</option>
                <option value="ENTREGUE">ENTREGUE</option>
              </select>
            </td>
            <td>{{ pedido.frete }}</td>
            <td>
              <v-btn @click="acionaModoDeAlteracao(pedido)">
                &#9998;
              </v-btn>
            </td>
            <td>
              <v-btn v-show="modoDeAlteracao" class="success" @click="alteraStatusPedido(pedido)">
                &#10003;
              </v-btn>
            </td>
            <td>
              <v-btn v-show="modoDeAlteracao" class="error" @click="desativaModoDeAlteracao()">
                &#9940;
              </v-btn>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</template>

<script>
import {defineComponent} from "vue";
import axios from "axios";
import MenuLateral from "@/components/MenuLateral";

export default defineComponent({
  name: "TelaHistoricoPedidos",
  components: {
    MenuLateral
  },
  data() {
    return {
      historicoPedidos: [],
      modoDeAlteracao: false,
      checkBoxHabilitada: false,
      novoStatusPedido: "",
    }
  },
  methods: {
    async listarPedidosDeCompra() {
      const response = await axios.get('http://localhost:8081/pedidos/listar');
      this.historicoPedidos = response.data;
      this.formataStatus(response.data);
    },
    async alteraStatusPedido(pedido){
      let dataForm = {
        id: pedido.id,
        statusPedido: pedido.statusPedido.replaceAll(" ", "_"),
      }
      await axios.put('http://localhost:8081/pedidos/ajustarStatus', dataForm);
      this.modoDeAlteracao = false;
      this.checkBoxHabilitada = false;
    },
    acionaModoDeAlteracao(pedido) {
      if (pedido.statusPedido !== "ENTREGUE" && pedido.statusPedido !== "CANCELADO"){
        this.modoDeAlteracao = true;
        this.checkBoxHabilitada = true;
      } else {
        alert("Não é possível alterar um pedido " + pedido.statusPedido.toLowerCase() + "!");
      }
    },
    desativaModoDeAlteracao() {
      this.modoDeAlteracao = false;
      this.checkBoxHabilitada = false;
    },
    formataStatus(historicoPedidos){
      for (const pedido of historicoPedidos) {
        let tempStatus = pedido.statusPedido
         pedido.statusPedido = tempStatus.replaceAll("_", " ");
      }
    }
  },
  mounted() {
    this.listarPedidosDeCompra();
  }
});
</script>

<style scoped>

.tabela-principal {
  text-align: center;
  justify-content: center;
  margin: 2% auto;
  padding-bottom: 2%;
  width: 75%;
  height: 75%;
  overflow: auto;
}

</style>