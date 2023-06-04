<template>
  <header class="cabecalho">
    <v-toolbar color="rgba(217, 217, 217, 1)" density="confortable">
      <v-toolbar-title>
        <router-link to="/" style="text-decoration: none; color: inherit;"><h1>Bazinga Games</h1></router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <div class="main-carrinho">
        <v-btn class="btn-carrinho" @click="redirecionaParaDetalhePedido" v-show="verificaSePodeExibirBotaoCarrinho()">
          <img class="carrinho" src="../assets/shopping-cart.png">
          <p class="quantidade-carrinho"> {{ this.carrinho.length }} </p>
        </v-btn>
      </div>
      <modal-tipo-usuario
          v-on="this.modalAtivo"
          v-show="!this.usuarioLogado"
          class="tipo-usuario">
      </modal-tipo-usuario>
      <label class="usuario" v-show="this.usuarioLogado">
        Olá, {{ this.user.nome }}!
      </label>
      <v-btn class="secondary btn-historico" v-show="verificaSePodeExibirBotaoFuncionario()"
             @click="redirecionaParaTelaPrincipalFuncionario()">
        &#8962;
      </v-btn>
      <v-btn icon class="secondary btn-historico" v-show="verificaSePodeExibirBotao()"
             @click="redirecionaParaTelaHistirico()">
        &#128269;
      </v-btn>
      <v-btn icon class="secondary btn-historico" v-show="verificaSePodeExibirBotao()"
             @click="redirecionaParaTelaAlteraCliente()">
        &#9998;
      </v-btn>
      <v-btn icon class="login" v-show="this.usuarioLogado" @click="deslogar()">
        Sair
      </v-btn>
    </v-toolbar>
  </header>
</template>

<script>
import {defineComponent} from "vue";
import {mapActions, mapMutations, mapState} from "vuex";
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
      'usuarioLogado',
      'tipoDeLogin'
    ])
  },
  methods: {
    deslogar() {
      this.getUserInfos({
        id: 0,
      })
      this.setTipoDeLogin(0);
      router.push('/');
    },
    redirecionaParaDetalhePedido() {
      if (this.carrinho.length !== 0) {
        router.push('/detalhePedido');
      } else {
        alert("Selecione ao menos um produto!");
      }
    },
    redirecionaParaTelaHistirico() {
      router.push('/historicoCompra');
    },
    ...mapActions([
      'getUserInfos'
    ]),
    ...mapMutations([
      'setTipoDeLogin'
    ]),
    verificaSePodeExibirBotao() {
      return this.usuarioLogado && this.tipoDeLogin === 2;
    },
    verificaSePodeExibirBotaoFuncionario() {
      return this.usuarioLogado && this.tipoDeLogin === 1;
    },
    verificaSePodeExibirBotaoCarrinho() {
      return !this.usuarioLogado || this.tipoDeLogin === 2;
    },
    redirecionaParaTelaPrincipalFuncionario() {
      router.push('/logado');
    },
    redirecionaParaTelaAlteraCliente() {
      router.push('/alterarCliente');
    },
  },
});
</script>

<style scoped>
.login {
  margin: auto;
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

.btn-historico {
  margin-left: 10px;
}

@media (max-width: 450px) {
  h1 {
    font-size: 5vw;
    display: inline-block;
    padding-left: 0;
  }

  .main-carrinho {
    width: 15vw;
  }

  .btn-carrinho {
    margin: 0;
  }

  .carrinho {
    width: 4vw;
    margin-right: 0;
  }

  .quantidade-carrinho {
    font-size: 4vw;
  }

  .usuario {
    text-align: center;
    width: 5vw;
    margin-left: 3vw;
    margin-right: 3vw;
  }

  .btn-historico {
    width: 5vw;
    margin-left: 0;
    padding: 2vw;
  }

  .tipo-usuario {
    margin-left: 2vw;
  }
}

</style>


