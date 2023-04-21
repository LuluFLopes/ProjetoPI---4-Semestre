<template>

  <div class="hello">



        <!--
        <div id="produtos">
          <v-card
              class="prod"
              variant="tonal"
              width="95%"

          >
            <v-card-title>Resident Evil 4'</v-card-title>
            <v-card-subtitle id="cartao">R$15,00</v-card-subtitle>
            <v-img src="https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp"
                   width="100%"
                   height="200"
            />
            <v-card-actions>
              <v-btn>Detalhes</v-btn>
            </v-card-actions>
          </v-card>

          <div class="img1">
            <img src="https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp" id="img1">
          </div>
        </div>-->


        <div  id="frame">

          <h1>Jogo 1</h1>

        <div class="infos">
        <div class="fotos">
          <h3>Fotos</h3>

        </div>

          <div id="detalhes">

            <h3>Informações do jogo</h3>

          </div>

          <div class="botoes">

            <v-btn>Comprar</v-btn>

          </div>

        </div>


        </div>






  </div>

</template>


<script>
import { defineComponent } from "vue";

export default defineComponent({

  data: () => ({
    model: null,
  }),

});


</script>

<style>

.hello{
  background: rgba(45, 46, 50);
  height: 100%;
}

.imagem-principal{
  width: auto;
  margin-left: 370px;
  translate: 60px;
  margin-top: 30px;
  opacity: 0.3;
  position: absolute;
}

.prod{
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 20px;
  width: 30%;
  margin: 10px 10px;
}

#produtos {
  display: flex;
  align-items: center;
  justify-content: left;
  padding: 20% 0;
  height: 5dvh;
}
#cartao{
  font-weight: bold;
  color: black;
}

.img1{
  display: flex;
  align-items: center;
  justify-content: left;
  width: 10px;
  height: 5px;
  border: solid 2px black;
}


#frame{
  background: rgba(55, 76, 90);
  height: 900px;
  width: 80%;
  padding: 2%;
  margin-left: 10%;

}

.infos{
  height: 100%;
  width: 100%;
  display: flex;
}


.fotos{
  height: 50%;
  width: 55%;
  background: chartreuse;
}

#detalhes{
  background: gold;
  margin-left: 1%;
  height: 90%;
  width: 45%;
}

.botoes{
  position: absolute;
  margin-top: 35%;
}
</style>
