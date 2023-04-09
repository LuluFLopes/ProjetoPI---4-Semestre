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
        }
    },
    mutations: {
        setUserInfo(state, payload) {
            state.user = payload;
        }
    },
    actions: {
        getUserInfos({commit}, payload) {
            commit('setUserInfo', payload);
        }
    },
});

export default store;
