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
    produto: {
      avaliacao: "",
      detalhes: "",
      id: "",
      nome: "",
      preco: "",
      quantidade: "",
      status: "",
      urlImg: ""
    },
    carrinho: []
  },
  mutations: {
    setUserInfo(state, payload) {
      state.user = payload;
    },
    setProdutoInfo(state, payload) {
      console.log(payload);
      state.produto = payload;
    },
    setCarrinhoInfo(state, payload) {
      state.carrinho.push(payload);
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
    }
  },

});

export default store;
