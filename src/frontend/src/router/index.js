import Vue from 'vue'
import VueRouter from 'vue-router'
import TelaInicial from '@/view/TelaInicial.vue';
import TelaLoginFuncionario from "@/view/TelaLoginFuncionario.vue";
import TelaCadastro from "@/view/TelaCadastro.vue";
import TelaLogado from "@/view/TelaLogado.vue";
import TelaListaUsuario from "@/view/TelaListaUsuario.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: TelaInicial
  },
  {
    path: '/login',
    name: 'login',
    component: TelaLoginFuncionario
  },
  {
    path: '/cadastrar',
    name: 'cadastrar',
    component: TelaCadastro
  },
  {
    path: '/logado',
    name: 'logado',
    component: TelaLogado
  },

  {
    path: '/listaUsuario',
    name: 'listaUsuario',
    component: TelaListaUsuario
  }
]

const router = new VueRouter({
  routes
})

export default router

