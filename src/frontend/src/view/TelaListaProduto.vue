<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral />
    </div>

    <div class="frame">
      <h1>Produtos</h1>

      <router-link to="/cadastrarProduto" custom v-slot="{ navigate }"><button id="btnCadastrar" @click="navigate" role="link">Cadastrar</button></router-link>

      <div>
        <div class="inp-pesquisar">
          <v-text-field
              variant="underlined"
              label="Pesquisar"
          ></v-text-field>
        </div>

          <table class="listaProdutos">
            <thead>
            <tr>
              <th>Código</th>
              <th>Nome Produto</th>
              <th>Qtd Estoque</th>
              <th>Valor</th>
              <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(produto,index) in produtos" v-bind:key="index">
              <td>{{produto.id}}</td>
              <td>{{produto.nome}}</td>
              <td>{{produto.quantidade}}</td>
              <td>{{produto.preco}}</td>
              <td>{{produto.status}}</td>
              <v-checkbox
                  v-model="produto.checkbox" @onChange="mandarStatus(produto.id, produto.status)"
              ></v-checkbox>
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
export default defineComponent( {
  name: "TelaListaProdutos",
  components:{
    MenuLateral
  },
  data (){
    return{
      produtos: [],
      pagina: 0,
      totalPaginas: 0
    }
  },

  beforeMount() {
    this.listarProdutos(this.produtos),
    this.validaCheckbox();
  },
  methods: {

    listarProdutos(produtos) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/produtos/listar?size=10&page=' + this.pagina

      })
          .then(function (response) {
            for (let i = 0; i< response.data.content.length;i++){
              produtos.push(response.data.content[i])
            }
          })
          .catch(function (error) {
            alert("Não foi possível listar.");
            console.log(error);
          });
    },
    mandarStatus(identificação, checkbox) {
      axios({
        method: 'post',
        url: 'http://localhost:8081/alterarStatus',
        data: {
          id: identificação,
          status: checkbox
        }

      })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    validaCheckbox() {
      for (const produto of this.produtos) {
        if (produto.status === "ATIVO") {
          produto.checkbox = true;
        } else {
          produto.checkbox = false;
        }  
      }
    },

    }

});
</script>

<style>

.fundo{
  position: relative;
  height: 100%;
  background: rgba(45, 46, 50);
}
.frame{
  position: absolute;
  top: 5%;
  left: 25%;
  width: 65%;
  height: 90%;
  background: rgba(217, 217, 217, 1);
  color: #111111;
}


.frame h1{
  margin: 15px;
  width: 75%;
  display: inline;
}
.frame button{
  margin-left: 0;
  width: 50%;
}

.menuLateral1{
  position: relative;
  height: 100%;
}

.listaProdutos{
  background-color: rgba(217, 217, 217);
  text-align: center;
  justify-content: center;
  margin-top: 2%;
  margin-left: 15%;
  width: 75%;
  height:75%;


}

th, td{
  border: 1px solid #222222;
  padding: 5px;
}

.inp-pesquisar{
  width: 600px;
  margin: 1% 20%;
  margin-bottom: 1px;
}


</style>