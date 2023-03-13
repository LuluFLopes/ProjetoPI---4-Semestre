import Vue from 'vue'
import VueRouter from 'vue-router'
import TelaInicial from '@/components/TelaInicial.vue';





Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: TelaInicial
  }
]

const router = new VueRouter({
  routes
})

export default router

