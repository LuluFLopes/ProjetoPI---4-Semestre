<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral/>
    </div>

    <div class="frame">
      <h1>Usuários</h1>
      <router-link to="/cadastrarUsuario" custom v-slot="{ navigate }">
        <button id="btnCadastrar" @click="navigate" role="link">Cadastrar</button>
      </router-link>
      <div class="main-table">
        <table class="listaProdutos">
          <thead>
          <tr>
            <th>Nome</th>
            <th>Usuário</th>
            <th>Grupo</th>
            <th>Status</th>
            <th>Ativar/Inativar</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(usuario,index) in usuarios" :key="index">
            <td>{{ usuario.nome }}</td>
            <td>{{ usuario.usuario }}</td>
            <td>{{ usuario.grupo }}</td>
            <td>{{ usuario.status }}</td>
            <td id="alterarStatus">
              <v-checkbox
                  v-model="usuario.checkbox"
                  @change="mandarStatus(usuario.id, usuario.status)"
              ></v-checkbox>
            </td>
            <td>
              <v-btn @click="redirecionaParaAlterar(index)">
                &#9998;
              </v-btn>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import MenuLateral from "@/components/MenuLateral.vue";
import axios from "axios";
import {mapActions, mapMutations, mapState} from "vuex";
import router from "@/router";

export default defineComponent({
  name: "TelaListaUsuario",
  components: {
    MenuLateral
  },
  data() {
    return {
      usuarios: [],
      id: "id",

    }
  },
  computed: {
    ...mapState([
      'user'
    ])
  },
  methods: {
    listarUsuarios(usuarios) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/listar'
      })
          .then(function (response) {
            for (let i = 0; i < response.data.length; i++) {
              usuarios.push(JSON.parse(JSON.stringify(response.data[i])));
            }
          })
          .catch(function (error) {
            alert("Não foi possível listar.");
            console.log(error);
          });
    },
    mandarStatus(identificacao, checkbox) {
      if (checkbox === "ATIVO") {
        checkbox = "INATIVO"
      } else {
        checkbox = "ATIVO"
      }
      axios({
        method: 'put',
        url: 'http://localhost:8081/alterarStatus',
        data: {
          id: identificacao,
          status: checkbox
        }
      })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      this.usuarios = [];
      this.listarUsuarios(this.usuarios);
    },
    redirecionaParaAlterar(index) {
      this.atualizarUsuario(this.usuarios[index]);
      if (this.user.id !== this.usuarios[index].id) {
        router.push("/alterarUsuario");
      } else {
        alert("Não é possível alterar seu próprio usuário!")
      }
    },
    ...mapActions([
      'getUserInfos'
    ]),
    ...mapMutations([
      'atualizarUsuario'
    ])
  },
  beforeMount() {
    this.listarUsuarios(this.usuarios);
  }
});
</script>

<style>

.main-table {
  height: 300px;
  overflow: auto;
}

.fundo {
  position: relative;
  height: 100%;
  background: rgba(45, 46, 50);
}

.frame {
  position: absolute;
  top: 10%;
  left: 25%;
  width: 65%;
  height: 75%;
  background: rgba(217, 217, 217, 1);
  color: #111111;
}


.frame h1 {
  margin: 15px;
  width: 75%;
  display: inline;
}

.frame button {
  margin-left: 0;
  width: 50%;
}

.menuLateral1 {
  position: relative;
  height: 100%;
}

.listaProdutos {
  background-color: rgba(217, 217, 217, 1);
  text-align: center;
  justify-content: center;
  margin-top: 2%;
  margin-left: 15%;
  width: 75%;
  height: 75%;
}

th, td {
  border: 1px solid #222222;
  padding: 5px;
}

#alterarStatus {
  display: flex;
  align-items: center;
  justify-content: center;
}

#btnCadastrar {
  border: 1px solid #222222;
  padding: 5px;
  width: auto;
  margin-left: 70%;
  background: rgba(217, 217, 217, 1);
  border-right: 2px solid #111;
  border-radius: 5px;
}

#btnCadastrar:hover {
  color: gold;
  font-weight: bold;
  background-color: red;
  border-radius: 5px;
}

</style>