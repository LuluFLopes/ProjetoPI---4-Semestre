import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    user: {
      id: "",
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
    valorTotal: 0
  },
  mutations: {
    setUserInfo(state, payload) {
      state.user = payload;
    },
    setProdutoInfo(state, payload) {
      state.produto = payload;
    },
    setCarrinhoInfo(state, payload) {
      state.carrinho.push(payload);
    },
    calculaTotalCarrinho(state){
      state.valorTotal = 0;
      state.carrinho.forEach(el => {
        let valorCalculadoPorElemento = 0;
        valorCalculadoPorElemento = parseInt(el.preco * el.quantidade);
        state.valorTotal += valorCalculadoPorElemento;
      })
    },
    atualizarUsuario(state, payload) {
        state.alteracaoUsuario = payload;
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
