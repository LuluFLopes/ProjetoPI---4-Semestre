import Vue from 'vue'
import VueRouter from 'vue-router'
import TelaInicial from '@/components/TelaInicial.vue';
import TelaCadastro from "@/components/TelaCadastro";





Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: TelaInicial
  },
  {
    path: '/TelaCadastro',
    name: 'TelaCadastro',
    component: TelaCadastro
  }
]

const router = new VueRouter({
  routes
})

export default router

