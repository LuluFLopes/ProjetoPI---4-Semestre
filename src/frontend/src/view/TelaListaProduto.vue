<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral />
    </div>

    <div class="frame">
      <h1>Produtos</h1>
      <router-link to="/cadastrarProduto" custom v-slot="{ navigate }"><button id="btnCadastrar" @click="navigate" role="link">Cadastrar</button></router-link>
      <div>
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
    this.listarProdutos(this.produtos)
  },
  methods: {

    listarProdutos(produtos) {
      axios({
        method: 'get',
        url: 'http://localhost:8081/produtos/listar?size=10&page=' + this.pagina

      })
          .then(function (response) {
            for (let i = 0; i< response.data.content.length;i++){
              console.log(response.data.content[i])
              produtos.push(response.data.content[i])
            }
          })
          .catch(function (error) {
            alert("Não foi possível listar.");
            console.log(error);
          });
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
  top: 10%;
  left: 25%;
  width: 65%;
  height: 75%;
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

</style>