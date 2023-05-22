<template>
  <v-card class="cartao-principal">
    <div class="main-content">
      <h1>Compra Concluída!</h1>
      <h2>A equipe da Bazinga Games agradeçe a sua compra!</h2>
      <h2>Após a confirmação do pagamento, seu pedido será despachado!</h2>
      <h2>O número do seu pedido é: {{ this.numeroDoPedido }}</h2>
      <v-btn color="primary" @click="voltarTelaInicial">
        Voltar á pagina inicial
      </v-btn>
    </div>
  </v-card>
</template>

<script>
import {defineComponent} from "vue";
import {mapState} from "vuex";
import router from "@/router";

export default defineComponent({
  name: "TelaCompraConcluda",
  computed: {
    ...mapState([
      'numeroDoPedido'
    ])
  },
  methods: {
    voltarTelaInicial() {
      router.push("/");
    }
  }
});
</script>

<style scoped>
.main-content {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
}

.cartao-principal {
  text-align: center;
  height: 50%;
  margin: 0 auto;
}
</style>