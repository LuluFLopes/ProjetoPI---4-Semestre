<template>
  <header class="cabecalho">
    <v-toolbar color="rgba(217, 217, 217, 1)" density="confortable">
      <v-toolbar-title>
        <router-link to="/" style="text-decoration: none; color: inherit;"><h1>Bazinga Games</h1></router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon class="login" v-show="!usuarioLogado">
        <router-link to="login">
          <v-icon>mdi-login</v-icon>
        </router-link>
      </v-btn>
      <label class="usuario" v-show="usuarioLogado">
        Olá, {{ this.user.nome }}!
      </label>
      <v-btn icon class="login" v-show="usuarioLogado" @click="deslogar()">
        Sair
      </v-btn>
    </v-toolbar>
  </header>
</template>

<script>
import {defineComponent} from "vue";
import {mapState} from "vuex";
import router from "@/router";

export default defineComponent({
  components: {},
  data() {
    return {
      usuarioLogado: false
    }
  },
  methods: {
    verificaUsuarioLogado(obj) {
      return obj && obj !== 'null' && obj !== 'undefined';
    },
    deslogar() {
      this.user = {};
      this.usuarioLogado = false;
      router.push('/');
    },
    mounted() {
      if (this.verificaUsuarioLogado(this.user)) {
        this.usuarioLogado = true;
      }
      this.usuarioLogado = false;
    }
  },
  computed: {
    ...mapState([
      'user'
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
</style>


