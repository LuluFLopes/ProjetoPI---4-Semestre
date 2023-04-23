<template>
  <!--
<div class="hello">

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
      </div>


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
-->

      <section class="home">
        <div class="home-img">
          <img :src="imagemDetalhes" class="one">
        </div>

        <div class="home-text">
        <h1>Jogo Online</h1>
        <h5>Resident Evil</h5>
        <h3>R$ 200,00</h3>
        <a href="#" class="btn">Compre Aqui</a>
        </div>


  <div class="main">
    <div class="row1" v-for="(row, index)  of detalhesImg" :key="'linha-'+index">
      <li><img :src="row.imagem" class="one"  @click="slider(row.imagem)"></li>
    </div>
  </div>

      </section>

</template>


<script>
import { defineComponent } from "vue";

export default defineComponent({
  data() {
    return {
      detalhesImg:[
        {
          imagem:'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp',
        },
        {
         imagem:'https://s2.glbimg.com/9K5eFTG7MONGExnCW-5G7yDFpq4=/0x250:1892x1264/984x0/smart/filters:strip_icc()/s.glbimg.com/po/tt2/f/original/2018/04/10/free_fire.png'
        },
        {
          imagem:'https://leiturinha.com.br/blog/wp-content/uploads/2019/08/jogo-LOL.jpg'
        },
      ],
      imagemAtual:"",
    }
  },
  methods:{
    slider(imagem){
      return this.imagemAtual = imagem
    }
  },
  computed:{
    imagemDetalhes(){
      return this.imagemAtual ? this.imagemAtual : this.detalhesImg[0].imagem
    }
  }

});


</script>

<style>
/*
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
*/

.home {
  position: relative;
  height: 100vh;
  width: 100%;
  display: grid;
  grid-template-columns: 2fr 1fr;
  align-items: center;
  gap: 2rem;
  background: rgba(45, 46, 50);
}
  .home-text h1{
    font-size: 4rem;
    line-height: 1.2;
    margin-bottom: 2px;

  }

.home-text h5{
  color: #ffffff99;
  font-size: 14px;
  font-weight: 400;
  margin-bottom: 60px;
}

.home-text h3{
  font-size: 40px;
  font-weight: 700;
  letter-spacing: 2px;
  margin-bottom: 35px;
}

.home-img img{
  max-width: 100%;
  width: 28rem;
  height: auto;
  margin-left: 25%;
}

.btn{
  display: inline-block;
  padding: 15px 70px;
  font-size: 16px;
  font-weight: 500;
  background: transparent;
  border: solid 2px #ffffff;
  transition: all ease-out;
  color:#ffffff;
}

.btn:hover{
  background: white;
  border: 2px solid #ffffff;
  color: #111111;
}

.main{
  position: absolute;
  top: 50%;
  left: 3%;
  transform: translateY(-50%);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  list-style:none;
}

.main li img{
  width: 120px;
  height: auto;
  max-width: 100%;
}

.row1{
  justify-content: center;
  transition: all ease-out;
  cursor: pointer;
  display: inline-flex;
}

.row1:hover{
  transform: translateY(-8px);
}

.row2{
  justify-content: center;
  transition: all ease-out;
  cursor: pointer;
  display: inline-flex;
}

.row2:hover{
  transform: translateY(-8px);
}


.row3{
  justify-content: center;
  transition: all ease-out;
  cursor: pointer;
  display: inline-flex;
}

.row3:hover{
  transform: translateY(-8px);
}



</style>
