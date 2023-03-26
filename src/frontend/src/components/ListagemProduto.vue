<template>
  <div class="lista-geral">
    <h2>Produtos</h2>
    <button id="btnCadastrar">Cadastrar</button>
  <div>
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
      <tr v-for="(produto, index) in produtos" v-bind:key="index">
        <td>{{produto.id}}</td>
        <td>{{produto.nome}}</td>
        <td>{{produto.quantidade}}</td>
        <td>{{produto.preco}}</td>
        <td>{{produto.status}}</td>
      </tr>
      </tbody>
    </table>
    </div>
  </div>
  </div>


</template>

<script>
import {defineComponent} from "vue";
import axios from "axios";
export default defineComponent ({
  name: 'Listagem-produto',

  data (){
    return{
      produtos: []

    }
  },

  beforeMount() {
    this.listarProdutos(this.produtos)

  },

  methods: {
      listarProdutos(produtos) {
      axios ({
        method: 'get',
        url: 'http://localhost:8081/produtos/listar'

      })
          .then(function (response) {
            for (let i = 0; i < response.data.length; i++){
              produtos.push(response.data[i]);
            }

          })
          .catch(function (error) {
            alert("Não foi possível realizar o login.");
            console.log(error);
          });
    }
  },
});


</script>

<style>
.listaProdutos{
  background-color: rgba(217, 217, 217, 1);
  text-align: center;
  justify-content: center;
  margin-top: 50px;
  margin-left: 30px;
  width: 75%;
  height:75%;


}

th, td{
  border: 1px solid #222222;
  padding: 5px;
}
.lista-geral{
  position: absolute;
  top: 20%;
  left: 30%;
  width: 50%;
  height: 70%;
  background-color: aqua;

}
.lista-geral h2{
  margin: 10px;
  width: 75%;
  display: inline;
  align-items: center;
  justify-content: center;
}

.lista-geral button{
  margin-left: 0;
  width: 50%;
}

#btnCadastrar{
  border: 1px solid #222222;
  padding: 5px;
  width: auto;
  margin-left:70%;
  background: rgba(217, 217, 217, 1);
  border-right: 2px solid #111;
  border-radius: 5px;
}

#btnCadastrar:hover{
   color: gold;
   font-weight: bold;
   background-color: red;
   border-radius: 5px;

 }


</style>