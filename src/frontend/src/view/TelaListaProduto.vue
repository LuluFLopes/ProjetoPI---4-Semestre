<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral/>
    </div>

    <div class="frame">
      <h1>Produtos</h1>

      <router-link to="/cadastrarProduto" custom v-slot="{ navigate }">
        <button id="btnCadastrar" @click="navigate" role="link">Cadastrar</button>
      </router-link>

      <div class="inp-pesquisar">
        <v-text-field
            variant="underlined"
            label="Pesquisar"
        ></v-text-field>
      </div>

      <div class="main-table">

        <table class="listaProdutos">
          <thead>
          <tr>
            <th>Código</th>
            <th>Nome Produto</th>
            <th>Qtd Estoque</th>
            <th>Valor</th>
            <th>Status</th>
            <th>Ativar/Inativar</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(produto,index) in produtos" v-bind:key="index">
            <td>{{ produto.id }}</td>
            <td>{{ produto.nome }}</td>
            <td>{{ produto.quantidade }}</td>
            <td>{{ produto.preco }}</td>
            <td>{{ produto.status }}</td>
            <td id="alterarStatus">
              <v-checkbox
              ></v-checkbox>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <v-pagination :length="totalPaginas" v-model="pagina"></v-pagination>

    </div>
  </div>
</template>

<script>

import {defineComponent} from "vue";
import MenuLateral from "@/components/MenuLateral.vue";
import axios from "axios";

export default defineComponent({
  name: "TelaListaProdutos",
  components: {
    MenuLateral
  },
  data() {
    return {
      produtos: [],
      pagina: 0,
      totalPaginas: 0
    }
  },
  watch: {
    pagina(novaPagina) {
      this.pagina = novaPagina;
      this.produtos = [];
      this.listarProdutos();
    }
  },
  beforeMount() {
    this.listarProdutos(this.produtos),
        this.validaCheckbox();
  },
  methods: {
    async listarProdutos() {
      try {
        const response = await axios.get('http://localhost:8081/produtos/listar?size=5&page=' + (this.pagina - 1))
        console.log("Pagina atual" + this.pagina);
        for (let i = 0; i < response.data.content.length; i++) {
          this.produtos.push(response.data.content[i])
        }
        this.totalPaginas = response.data.totalPages;
      } catch (ex) {
        alert("Não foi possível listar.");
        console.log(ex.message);
      }
    },
    mandarStatus(identificacao, checkbox) {
      axios({
        method: 'post',
        url: 'http://localhost:8081/alterarStatus',
        data: {
          id: identificacao,
          status: checkbox
        }
      })
          .then(function (response) {
            this.produtos = [];
            this.pagina = 0;
            this.totalPaginas = 0;
            this.listarProdutos();
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    // validaCheckbox() {
    //   for (const produto of this.produtos) {
    //     if (produto.status === "ATIVO") {
    //       produto.checkbox = true;
    //     } else {
    //       produto.checkbox = false;
    //     }
    //
    //   }
    //   this.mandarStatus(produto.id, produto.checkbox);
    // }
  },
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
  top: 5%;
  left: 25%;
  width: 65%;
  height: 90%;
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
  background-color: rgba(217, 217, 217);
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

.inp-pesquisar {
  width: 600px;
  margin: 1% 20%;
  margin-bottom: 1px;
}

</style>