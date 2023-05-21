<template>
  <header class="cabecalho">
    <v-toolbar color="rgba(217, 217, 217, 1)" density="confortable">
      <v-toolbar-title>
        <router-link to="/" style="text-decoration: none; color: inherit;"><h1>Bazinga Games</h1></router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <div class="main-carrinho" @click="verificaUsuarioLogado()">
        <v-btn class="btn-carrinho" @click="verificaLoginAntesDeCheckout">
          <img class="carrinho" src="../assets/shopping-cart.png">
          <p class="quantidade-carrinho"> {{ this.carrinho.length }} </p>
        </v-btn>
      </div>

      <modal-tipo-usuario
          v-on="this.modalAtivo"
          v-show="!this.usuarioLogado"></modal-tipo-usuario>
      <label class="usuario" v-show="this.usuarioLogado">
        Olá, {{ this.user.nome }}!
      </label>
      <v-btn icon class="login" v-show="this.usuarioLogado" @click="deslogar()">
        Sair
      </v-btn>
    </v-toolbar>
  </header>
</template>

<script>
import {defineComponent} from "vue";
import {mapActions, mapState} from "vuex";
import router from "@/router";
import ModalTipoUsuario from "@/components/ModalTipoUsuario";

export default defineComponent({
  components: {
    ModalTipoUsuario
  },
  data() {
    return {}
  },
  computed: {
    ...mapState([
      'user',
      'carrinho',
      'usuarioLogado'
    ])
  },
  methods: {
    deslogar() {
      this.getUserInfos({
        id: 0,
      })
      router.push('/');
    },
    verificaLoginAntesDeCheckout() {
      if (this.user.usuario === "") {
        router.push('/loginCliente');
      } else {
        // router.push('/telaDetalhePedido');
      }
    },
    ...mapActions([
      'getUserInfos'
    ])
  },
});
</script>


<style>
.login {
  margin: auto;
  position: absolute;
  display: block;
}

.cabecalho {
  border-bottom: 2px solid #111;
}

.usuario {
  align-items: center;
}

.main-carrinho {
  display: flex;
}

.carrinho {
  width: 30%;
  height: 30%;
  margin-right: 15px;
}

.quantidade-carrinho {
  font-weight: bold;
  font-size: 20px;
  margin-top: 12px;
}

.btn-carrinho {
  margin-right: 20px;
  width: 10%;
}


</style>


