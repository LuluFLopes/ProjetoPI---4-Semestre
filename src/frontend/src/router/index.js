import Vue from 'vue'
import VueRouter from 'vue-router'
import TelaInicial from '@/view/TelaInicial.vue';
import TelaLoginFuncionario from "@/view/TelaLoginFuncionario.vue";
import TelaLogado from "@/view/TelaLogado.vue";
import ListagemProduto from "@/components/ListagemProduto.vue";
import ListagemUsuario from "@/components/ListagemUsuario.vue";
import TelaListaUsuario from "@/view/TelaListaUsuario";
import TelaListaProdutos from "@/view/TelaListaProduto";
import TelaCadastroUsuario from "@/view/TelaCadastroUsuario";
import TelaCadastroProduto from "@/view/TelaCadastroProduto";

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
    path: '/cadastrarUsuario',
    name: 'cadastrarUsuario',
    component: TelaCadastroUsuario
  },
  {
    path: '/logado',
    name: 'logado',
    component: TelaLogado
  },
  {
    path: '/listaUsuario',
    name: 'listaUsuario',
    component: ListagemUsuario
  },
  {
    path: '/listaProduto',
    name: 'listaProduto',
    component: ListagemProduto
  },
  {
    path: '/WlistaUsuario',
    name: 'WListaUsuario',
    component: TelaListaUsuario
  },
  {
    path: '/WlistaProduto',
    name: 'WListaProduto',
    component: TelaListaProdutos
  },
  {
    path: '/cadastrarProduto',
    name: 'cadastrarProduto',
    component: TelaCadastroProduto
  }
]

const router = new VueRouter({
  routes
})

export default router

