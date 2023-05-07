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
  },
  mutations: {
    setUserInfo(state, payload) {
      state.user = payload;
    },

    setProdutoInfo(state, payload) {
      state.produto = payload;
    }
  },
  actions: {
    getUserInfos({commit}, payload) {
      commit('setUserInfo', payload);
    },
    getProdutoInfos({commit}, payload) {
      commit('setProdutoInfo', payload);
    }
  },

});

export default store;
