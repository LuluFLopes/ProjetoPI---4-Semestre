import import Vue from 'vue'


<template>

  <div class="hello">
    <div id="prd">
      <img class="imagem-principal" src="../assets/bazinga.png">


      <h1>Lista de Jogos</h1>
      <div class="products" v-for="produto in detalhesProdutos" :key="produto.id">
        <v-card
            class="prod"
            variant="tonal"
            width="400px"
        >
          <v-card-title>
            {{ produto.nome }}
          </v-card-title>
          <v-card-subtitle id="cartao">
            R$ {{ produto.preco }}
          </v-card-subtitle>
          <v-img width="100%"
                 :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                 height="200"
          />
          <v-card-actions>
            <v-btn v-on:click="abreTelaDetalhes(produto.id)">Detalhes</v-btn>
          </v-card-actions>
        </v-card>

      </div>
    </div>
  </div>
</template>


<script>
import {defineComponent} from 'vue';
import axios from "axios";
import router from "@/router";
import {mapActions} from "vuex";

export default defineComponent({

  name: 'TelaInicial',

  data() {
    return {
      detalhesProdutos: [],
      selecionado: 0,
    }
  },

  methods: {
    async listaProduto() {
      try {
        const request = await axios.get('http://localhost:8081/produtos/listar')
        this.detalhesProdutos = request.data.content;
      } catch (ex) {
        console.log(ex.message);
      }
    },
    abreTelaDetalhes(id) {
      this.getProdutoInfos(this.detalhesProdutos[id]);
      router.push('/DetalheProduto');
    },
    ...mapActions ([
      'getProdutoInfos'
    ])
  },
  mounted() {
    this.listaProduto();
  },

});

</script>


<style>

.hello {
  background: rgba(45, 46, 50);
  height: 100%;
}


.imagem-principal {
  width: auto;
  margin-left: 370px;
  translate: 60px;
  margin-top: 30px;
  opacity: 0.3;
  position: absolute;
}

.prod {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 20px;
  width: 30%;
  margin: 10px 10px;
}

.products {
  display: inline-flex;
  position: relative;
  padding: 50px;
  margin: auto;
  width: 33.3%;


}

#cartao {
  font-weight: bold;
  color: black;
}

h1 {
  padding: 10px;
  text-align: center;
  font-size: 56px;
}

#prd {
  padding: 0;
}


</style>
