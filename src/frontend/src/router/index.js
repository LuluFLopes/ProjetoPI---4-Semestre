import Vue from 'vue'
import VueRouter from 'vue-router'
import TelaInicial from '@/components/TelaInicial.vue';
import TelaLoginFuncionario from "@/components/TelaLoginFuncionario";
import TelaCadastro from "@/components/TelaCadastro";

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
    name: 'login',
    component: TelaCadastro
  }
]

const router = new VueRouter({
  routes
})

export default router

