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
import TelaDetalheProduto from "@/view/TelaDetalheProduto.vue";
import TelaCadastroCliente from "@/view/TelaCadastroCliente";
import TelaLoginCliente from "@/view/TelaLoginCliente.vue";
import TelaDetalhePedido from "@/view/TelaDetalhePedido.vue";
import TelaAlterarProduto from "@/view/TelaAlterarProduto";
import TelaAlterarUsuario from "@/view/TelaAlterarUsuario";
import TelaCompraConcluida from "@/view/TelaCompraConcluida";
import TelaListaPedidos from "@/view/TelaListaPedidos";
import TelaDetalheVisualizarPedido from "@/view/TelaDetalheVisualizarPedido";
import TelaHistoricoPedidos from "@/view/TelaHistoricoPedidos";
import TelaAlterarCliente from "@/view/TelaAlterarCliente";
import TelaCheckoutPedido from "@/view/TelaCheckoutPedido";

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
  },
  {
    path: '/alterarProduto',
    name: 'alterarProduto',
    component: TelaAlterarProduto
  },
  {
    path: '/alterarUsuario',
    name: 'alterarUsuario',
    component: TelaAlterarUsuario
  },
  {
    path: '/DetalheProduto',
    name: 'DetalheProduto',
    component: TelaDetalheProduto
  },
  {
    path: '/Cadastro',
    name: 'Cadastro',
    component: TelaCadastroCliente
  },
  {
    path: '/loginCliente',
    name: 'loginCliente',
    component: TelaLoginCliente
  },
  {
    path: '/detalhePedido',
    name: 'detalhePedido',
    component: TelaDetalhePedido
  },
  {
    path: '/compraConcluida',
    name: 'compraConcluida',
    component: TelaCompraConcluida
  },
  {
    path: '/historicoCompra',
    name: 'historicoCompra',
    component: TelaListaPedidos
  },
  {
    path: '/visualizarDetalhePedido',
    name: 'historicoCompra',
    component: TelaDetalheVisualizarPedido
  },
  {
    path: '/historicoPedido',
    name: 'historicoPedido',
    component: TelaHistoricoPedidos
  },
  {
    path: '/alterarCliente',
    name: 'alterarCliente',
    component: TelaAlterarCliente
  },
  {
    path: '/telaFinalizarCompra',
    name: 'telaFinalizarCompra',
    component: TelaCheckoutPedido
  },
]

const router = new VueRouter({
  mode: "history",
  routes
})

export default router

