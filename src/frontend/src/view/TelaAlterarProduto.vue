<template>
  <main>
    <div>
      <h1>Alteração de Produto</h1>
      <form role="form" class="formulario">
        <fieldset>

          <div class="itens-formulario">
            <label for="userLogin">Nome:</label>
            <input class="itens-entrada" id="userLogin" type="text" aria-label="Nome" placeholder="Nome" v-model="nome"
                   :disabled="usuarioEstoquista">
          </div>

          <div class="itens-formulario">
            <label>Descrição:</label>
            <input class="itens-entrada" id="prod_desc" type="text" aria-label="Detalhes" placeholder="Detalhes"
                   v-model="detalhes" :disabled="usuarioEstoquista">
          </div>

          <div class="avaliacao">
            <label>Avaliação:</label>
            <div class="left">
              <v-rating
                  v-model="avaliacao"
                  hover
                  half-increments
                  :readonly="usuarioEstoquista"
              ></v-rating>
            </div>
          </div>

          <div class="itens-formulario">
            <label id="label-img">Imagens:</label>
            <!--<input class="itens-entrada" id="Imagens" type="Imagens" aria-label="Imagens" placeholder="Imagens"  >-->
            <img src="https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp">
          </div>

          <div id="entrada-img">
            <v-file-input
                v-model="urlAtual"
                multiple
                label="File input"
                prepend-icon="mdi-camera"
            ></v-file-input>
            <button id="btn-img" @click="adicionaListaImagem(urlAtual)">Enviar</button>
          </div>

          <div class="ItensVlrEstq">
            <label for="userLogin">Valor:</label>
            <input class="itens-entrada" id="VleEstq" type="text" aria-label="Valor" placeholder="Valor"
                   v-model="preco" :disabled="usuarioEstoquista">

            <div class="Qtd-Estq">
              <label for="userLogin" class="text-no-wrap">Quantidade em Estoque:</label>
              <input class="itens-entrada " id="VleEstq" type="text" aria-label="Quatidade em Estoque"
                     placeholder="Quatidade em Estoque" v-model="quantidade">
            </div>

          </div>
          <input type="button" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, detalhes ,urlImg, preco, quantidade, avaliacao)">

          <router-link to="/WlistaProduto" custom v-slot="{ navigate }">
            <button class="btnAcao red" @click="navigate" role="link">Fechar</button>
          </router-link>

        </fieldset>
      </form>
    </div>
  </main>
</template>


<script>
import {defineComponent} from 'vue';
import axios from 'axios';
import router from "@/router";
import { mapMutations, mapState} from "vuex";

export default defineComponent({
  data() {
    return {
      nome: "",
      detalhes: "",
      urlImg: [],
      preco: "",
      quantidade: "",
      avaliacao: 0,
      data: {
        nome: "",
        detalhes: "",
        preco: "",
        quantidade: "",
        avaliacao: "",
        imgUrl: [],
      },
      usuarioEstoquista: false,
      urlAtual: "",
    }
  },
  computed: {
    ...mapState([
      'alteracaoProduto',
      'user',
    ])
  },
  methods: {
    async mandarInformacoes(nome, detalhes, urlImg, preco, quantidade, avaliacao) {

      this.data.id = this.alteracaoProduto.id;
      this.data.nome = nome;
      this.data.detalhes = detalhes;
      this.data.preco = preco;
      this.data.quantidade = quantidade;
      this.data.avaliacao = avaliacao;

      try {
        const request = await axios.post('http://localhost:8081/produtos/alterar', this.data);
        console.log(request);
        alert("Alterado com Sucesso!");
        await router.push('/WlistaProduto')
      } catch (ex) {
        console.log(ex.message);
      }
    },
    preencheCampos() {
      this.nome = this.alteracaoProduto.nome;
      this.detalhes = this.alteracaoProduto.detalhes;
      this.avaliacao = this.alteracaoProduto.avaliacao;
      this.preco = this.alteracaoProduto.preco;
      this.quantidade = this.alteracaoProduto.quantidade;
    },
    verificaTipoUsuario() {
      if (this.user.grupo === "ESTOQUISTA") {
        this.usuarioEstoquista = true;
      }
    },
    adicionaListaImagem(urlAtual) {
      this.urlImg.push(urlAtual);
      this.urlImg = "";
    },
    ...mapMutations([
      'atualizarProduto',
    ])
  },
  mounted() {
    this.preencheCampos();
    this.verificaTipoUsuario();
  }
});
</script>

<style scoped>
main {
  background: rgba(45, 46, 50);
  height: 100%;
  width: 100%;
  display: inline-block;
  align-items: center;
  justify-content: center;
  text-align: center;
}

label, p, a {
  color: rgb(0, 0, 0);
  font-weight: bold;
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
  margin-top: 2%;
}

label, input, select {
  padding: 0.5 dvw;
  align-items: left;
  justify-content: left;
  text-align: left;
  font-weight: bold;

}

fieldset {
  margin-top: -8%;
  background-color: aliceblue;
  opacity: 0.90;
  border-radius: 40px;
  border-color: rgb(35, 75, 110);
  height: 200%;
}

.btnAcao {
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  margin: -1% 10%;
  width: 90px;
}

.itens-formulario {
  text-align: left;
  margin: 2%;
}

.itens-entrada {
  border: 1px solid #222222;
  border-radius: 5px;
}

.formulario {
  background: rgba(45, 46, 50);
  height: 250px;
  width: 50%;
  margin: 3% 25%;
}

.avaliacao {
  display: flex;
  text-align: left;
  margin-left: 2%;

}

#Imagens {
  height: 150px;
  width: 480px;
}

#userLogin {
  width: 480px;
  margin-left: 4%;

}

#prod_desc {
  width: 480px;

}

.ItensVlrEstq {
  margin: 2% 2%;
  width: 10px;
  display: flex;

}

.Qtd-Estq {
  margin: 2% 15%;
  width: 10px;
  display: flex;
  padding-left: 180px;
}

#VleEstq {
  width: 90px;
  height: 50px;

}


#label-img {
  position: absolute;
}

img {
  margin-left: 15%;
  height: 40%;
  width: 30%;
}

#entrada-img {
  display: flex;
  margin: 2%;
  width: 70%;
}

#btn-img {
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  height: 10%;
  margin-top: 1%;
}


</style>