import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    user: {
      id: 0,
      nome: "",
      cpf: "",
      usuario: "",
      senha: "",
      status: "",
      grupo: ""
    },
    alteracaoUsuario: {
      id: "",
      nome: "",
      cpf: "",
      usuario: "",
      senha: "",
      status: "",
      grupo: ""
    },
    alteracaoProduto: {
      id: "",
      nome: "",
      detalhes: "",
      avaliacao: "",
      preco: "",
      quantidade: "",
      urlImg: []
    },
    produto: {
      avaliacao: "",
      detalhes: "",
      id: "",
      nome: "",
      preco: "",
      quantidade: "",
      status: "",
      urlImg: []
    },
    carrinho: [],
    valorTotal: 0,
    usuarioLogado: false,
    numeroDoPedido: 0,
  },
  mutations: {
    setUserInfo(state, payload) {
      state.user = payload;
      state.usuarioLogado = state.user.id !== 0;
    },
    setProdutoInfo(state, payload) {
      state.produto = payload;
    },
    setCarrinhoInfo(state, payload) {
      state.carrinho.push(payload);
    },
    calculaTotalCarrinho(state, payload) {
      state.valorTotal = 0;
      state.carrinho.forEach(el => {
        let valorCalculadoPorElemento = 0;
        valorCalculadoPorElemento = parseInt(el.preco * el.quantidade) + payload;
        state.valorTotal += valorCalculadoPorElemento;
      })
    },
    adicionaFreteNoTotal(state, payload){
      state.valorTotal = payload;
    },
    atualizarUsuario(state, payload) {
      state.alteracaoUsuario = payload;
    },
    atualizarProduto(state, payload) {
      state.alteracaoProduto = payload;
    },
    adicionaNoCarrinho(state, payload){
      state.carrinho.forEach(e => {
        if (e.id === payload.id){
          parseInt(e.quantidade++);
        }
      });
    },
    removeDoCarrinho(state, payload){
      for (let i = 0; i < state.carrinho.length; i++) {
        if(state.carrinho[i].id === payload.id){
          state.carrinho[i].quantidade = parseInt(state.carrinho[i].quantidade - 1);
          if (state.carrinho[i].quantidade === 0) {
            if (i === 0) {
              state.carrinho.shift();
            } else {
              state.carrinho.splice(i);
            }
          }
        }
      }
    },
    removeProdutoCarrinho(state, payload){
      for (let i = 0; i < state.carrinho.length; i++) {
        if(state.carrinho[i].id === payload.id){
            if (i === 0) {
              state.carrinho.shift();
            } else {
              state.carrinho.splice(i);
            }
        }
      }
    },
    salvaNumeroPedido(state, payload){
      state.numeroDoPedido = payload;
    },
    limpaCarrinho(state) {
      state.valorTotal = 0;
      state.carrinho = [];
    }
  },
  actions: {
    getUserInfos({commit}, payload) {
      commit('setUserInfo', payload);
    },
    getProdutoInfos({commit}, payload) {
      commit('setProdutoInfo', payload);
    },
    getCarrinhoInfos({commit}, payload) {
      commit('setCarrinhoInfo', payload);
    },
    alteraValorTotalCarrinho({commit}, payload) {
      commit('calculaTotalCarrinho', payload);
    }
  },
});

export default store;
