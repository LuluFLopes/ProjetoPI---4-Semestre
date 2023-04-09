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
      <div>
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
              ></v-checkbox>
            </td>
          </tr>
          </tbody>
        </table>
        <v-pagination :length="5"></v-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import MenuLateral from "@/components/MenuLateral.vue";
import axios from "axios";

export default defineComponent({
  name: "TelaListaUsuario",
  components: {
    MenuLateral
  },
  data() {
    return {
      usuarios: []
    }
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
    validaCheckbox() {
      for (const usuario of this.usuarios) {
        if (usuario.status === "ATIVO") {
          usuario.checkbox = true;
        } else {
          usuario.checkbox = false;
        }
      }
    },
  },
  beforeMount() {
    this.listarUsuarios(this.usuarios);
    this.validaCheckbox();
  }
});
</script>

<style>

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
  background: blue;
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