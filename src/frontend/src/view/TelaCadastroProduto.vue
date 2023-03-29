<template>
  <main>
    <div>
      <h1>Cadastro de Produto</h1>
      <form role="form" class="formulario">
        <fieldset>

          <div class="itens-formulario">
            <label for="userLogin">Nome:</label>
            <input class="itens-entrada" id="userLogin" type="text" aria-label="Nome" placeholder="Nome" v-model="nome">
          </div>

          <div class="itens-formulario">
            <label >Descrição:</label>
            <input class="itens-entrada" id="userLogin" type="text" aria-label="Detalhes" placeholder="Detalhes" v-model="detalhes">
          </div>

          <div class="avaliacao">
            <label >Avaliação:</label>
            <div class="left">
              <v-rating
                  v-model="avaliacao"
                  hover
                  half-increments
              ></v-rating>
            </div>
          </div>

          <div class="itens-formulario">
            <label>Imagens:</label>
            <input class="itens-entrada" id="Imagens" type="Imagens" aria-label="Imagens" placeholder="Imagens"  >
          </div>

          <div class="ItensVlrEstq">
            <label for="userLogin">Valor:</label>
            <input class="itens-entrada" id="VleEstq" type="text" aria-label="Valor" placeholder="Valor" v-model="preco" >

            <div class="ItensVlrEstq">
              <label for="userLogin" class="text-no-wrap">Quatidade em Estoque:</label>
              <input class="itens-entrada " id="VleEstq" type="text" aria-label="Quatidade em Estoque" placeholder="Quatidade em Estoque" v-model="quantidade">
            </div>

          </div>



          <input type="submit" class="btnAcao green" value="Cadastrar"
                 @click="mandarInformacoes(nome, detalhes ,urlImg, preco, quantidade, avaliacao)">

          <router-link to="/WlistaProduto" custom v-slot="{ navigate }">
            <button class="btnAcao red" @click="navigate" role="link">Fechar</button></router-link>

        </fieldset>
      </form>
    </div>
  </main>
</template>


<script>
import { defineComponent } from 'vue';
import axios from 'axios';

export default defineComponent({
  data() {
    return {
      nome: "",
      detalhes: "",
      urlImg: [],
      preco: "",
      quantidade: "",
      avaliacao: 0
    }
  },
  methods: {
    mandarInformacoes(nome, detalhes ,urlImg, preco, quantidade, avaliacao) {

        axios({
          method: 'post',
          url: 'http://localhost:8081/produtos/cadastrar',
          data: {
            nome: nome,
            detalhes: detalhes,
            preco: preco,
            quantidade: quantidade,
            avaliacao: avaliacao
    }
        })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
      }
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
  font-size: 3dvw;
  margin-top: 2%;
}
label, input, select {
  padding: 0.5dvw;
  align-items: left;
  justify-content: left;
  text-align: left;
  font-weight: bold;

}
fieldset{
  margin-top: -5%;
  background-color: aliceblue;
  opacity: 0.90;
  border-radius: 40px;
  border-color: rgb(35, 75, 110);
  height: 180%;

}

.btnAcao{
  border: solid;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  padding: 5px;
  margin: -1% 10%;
}

.itens-formulario{
  text-align: left;
  margin: 2%;
}

.itens-entrada {
  border: 1px solid #222222;
  border-radius: 5px;
  margin-left: 2%;
}

.formulario{
  background: rgba(45, 46, 50);
  height: 250px;
  width: 50%;
  margin: 3% 25%;
}

.avaliacao{
  display: flex;
  text-align: left;
  margin-left: 2%;

}

#Imagens{
  height: 150px;
  width: 480px;
}

#userLogin{
  margin: 0% 4%;
  width: 480px;
}

.ItensVlrEstq{
  margin: 2%;
  width: 10px;
  display: flex;

}

#VleEstq{
  width: 90px;
  height: 50px;

}

</style>