<template>
  <main>
    <div>
      <h1>Cadastro de Produto</h1>
      <form role="form" class="formulario" @submit.prevent="selecionaImagem">
        <fieldset>
          <div class="itens-formulario">
            <label for="userLogin">Nome:</label>
            <input class="itens-entrada" id="userLogin" type="text" aria-label="Nome" placeholder="Nome" v-model="nome"
                   required>
          </div>

          <div class="itens-formulario">
            <label>Descrição:</label>
            <input class="itens-entrada" id="prod_desc" type="text" aria-label="Detalhes" placeholder="Detalhes"
                   v-model="detalhes" required>
          </div>

          <div class="avaliacao">
            <label>Avaliação:</label>
            <div class="left">
              <v-rating
                  v-model="avaliacao"
                  hover
                  half-increments
                  required
              ></v-rating>
            </div>
          </div>

          <div class="itens-formulario">
            <label id="label-img">Imagens:</label>
            <div v-for="(imagem, index) of this.listagemImg" :key="index">{{ imagem }}<label id="botao-retirar"
                                                                                             @click="removerImagem">X</label>
            </div>
          </div>

          <div id="entrada-img">
            <input type="file" id="capturar-img" @onchange="selecionaImagem">
            <button id="btn-img">Enviar</button>
          </div>

          <div class="ItensVlrEstq">
            <label for="userLogin">Valor:</label>
            <input class="itens-entrada" id="VleEstq" type="text" aria-label="Valor" placeholder="Valor" v-model="preco"
                   required>

            <div class="Qtd-Estq">
              <label for="userLogin" class="text-no-wrap">Quantidade em Estoque:</label>
              <input class="itens-entrada " id="VleEstq" type="text" aria-label="Quatidade em Estoque"
                     placeholder="Quatidade em Estoque" v-model="quantidade" required>
            </div>
          </div>

          <input type="submit" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, detalhes , preco, quantidade, avaliacao)">

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

export default defineComponent({
  data() {
    return {
      nome: "",
      detalhes: "",
      urlImg: new FormData(),
      preco: "",
      quantidade: "",
      avaliacao: 0,
      listagemImg: [],
    }
  },
  methods: {
    mandarInformacoes(nome, detalhes, preco, quantidade, avaliacao) {

      axios({
        method: 'post',
        url: 'http://localhost:8081/produtos/cadastrar',
        data: {
          nome: nome,
          detalhes: detalhes,
          preco: preco,
          quantidade: quantidade,
          avaliacao: avaliacao,
        }
      })
          .then(function (response) {
            console.log(response);
            alert("Cadastrado com Sucesso!");
            router.push('/WlistaProduto')
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    selecionaImagem() {
      const botao = document.getElementById('capturar-img');
      if (botao.value) {
        let separator = "C:\\fakepath\\";
        this.listagemImg.push(botao.value.split(separator)[1]);

        // this.urlImg.append("imagem", botao.value);
      }
    },
    removerImagem(index) {
      this.listagemImg.splice(index, 1);
    }
  }
});

</script>

<style scoped>

main {
  background: rgba(45, 46, 50);
  height: 105 dvh;
  width: 100%;
  display: inline-block;
  align-items: center;
  justify-content: center;
  text-align: center;
  height: 100%;
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
  margin: 2% 5%;
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
  height: 30px;

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

#botao-retirar {
  margin-left: 5px;
}

</style>