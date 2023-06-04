<template>

  <section class="home">
    <div class="home-img">
        <img :src="imagemDetalhes" class="one imagem">
    </div>

    <v-card class="cartao-principal">
      <div class="home-text ">
        <h1 class="elementos-internos">Jogo</h1>
        <h3 class="elementos-internos">{{ this.produto.nome }}</h3>
        <h3 class="elementos-internos">R$ {{ this.produto.preco }}</h3>
        <h3 class="elementos-internos"> {{ this.produto.detalhes }} </h3>
        <h3 class="elementos-internos"> Disponíveis: {{ this.produto.quantidade }} </h3>
        <label class="elementos-internos"> Selecione a quantidade: </label>
        <input class="elementos-internos" type="number" v-model="quantidadeSelecionada">
        <v-btn class="primary elementos-internos botao-adicionar" @click="adicionaNoCarrinho()">
          Adicionar no carrinho
        </v-btn>
        <v-alert color="error alerta" icon="$error" v-model="elementoDeAlertaAtivo"> {{ this.msgAlerta }}
        </v-alert>
      </div>
    </v-card>

    <div class="main">
      <div class="row1" v-for="(row, index)  of this.produto.urlImg" :key="'linha-'+index">
        <li><img :src="row.imagem" class="one" @click="slider(row.imagem)"></li>
      </div>
    </div>
  </section>

</template>

<script>
import {defineComponent} from "vue";
import {mapActions, mapState} from "vuex";
import router from "@/router";

export default defineComponent({
  data() {
    return {
      detalhesImg: [
        {
          imagem: 'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp',
        },
        {
          imagem: 'https://s2.glbimg.com/9K5eFTG7MONGExnCW-5G7yDFpq4=/0x250:1892x1264/984x0/smart/filters:strip_icc()/s.glbimg.com/po/tt2/f/original/2018/04/10/free_fire.png'
        },
        {
          imagem: 'https://leiturinha.com.br/blog/wp-content/uploads/2019/08/jogo-LOL.jpg'
        },
      ],
      jaAdicionado: false,
      elementoJaAdicionado: -1,
      quantidadeSelecionada: 1,
      elementoDeAlertaAtivo: false,
      msgAlerta: "",
    }
  },
  methods: {
    slider(imagem) {
      return this.imagemAtual = imagem
    },
    ...mapActions([
      'getCarrinhoInfos',
      'alteraValorTotalCarrinho'
    ]),
    adicionaNoCarrinho() {

      let quantidadeAtual = this.quantidadeSelecionada;

      for (const produto of this.carrinho) {
        if (produto.id === this.produto.id) {
          quantidadeAtual += this.produto.quantidade;
        }
      }

      if (quantidadeAtual <= this.produto.quantidade) {
        this.elementoDeAlertaAtivo = false;
        this.msgAlerta = "";

        this.carrinho.forEach((el, i) => {
          if (el.id === this.produto.id) {
            this.jaAdicionado = true;
            this.elementoJaAdicionado = i;
          }
        });

        this.produto.quantidade = this.quantidadeSelecionada;

        if (this.jaAdicionado) {
          let quantidadeAtual = parseInt(this.carrinho[this.elementoJaAdicionado].quantidade);
          quantidadeAtual += parseInt(this.quantidadeSelecionada);
          this.carrinho[this.elementoJaAdicionado].quantidade = quantidadeAtual;
          this.alteraValorTotalCarrinho();
        } else {
          this.getCarrinhoInfos(this.produto);
          this.alteraValorTotalCarrinho();
        }
        this.jaAdicionado = false;
        router.push("/");
      } else {
        this.elementoDeAlertaAtivo = true;
        this.msgAlerta = 'Não é possível selecionar uma quantidade maior do que o estoque!';
      }
    }
  },
  computed: {
    imagemDetalhes() {
      return this.imagemAtual ? this.imagemAtual : this.detalhesImg[0].imagem
    },
    ...mapState([
      'produto',
      'carrinho',
      'valorTotal'
    ]),
  },
});
</script>

<style>

.home {
  position: relative;
  height: 100%;
  width: 100%;
  display: grid;
  grid-template-columns: 2fr 1fr;
  align-items: center;
  gap: 2rem;
  background: rgba(45, 46, 50);
}

.home-text {
  text-align: center;
}

.home-text h1 {
  font-size: 4rem;
  line-height: 1.2;
  margin-bottom: 2px;

}

.home-text h5 {
  color: #ffffff99;
  font-size: 14px;
  font-weight: 400;
  margin-bottom: 60px;
}

.home-text h3 {
  font-size: 40px;
  font-weight: 700;
  letter-spacing: 2px;
}

.home-img img {
  max-width: 100%;
  width: 28rem;
  height: auto;
  margin-left: 25%;
}

.main {
  position: absolute;
  top: 50%;
  left: 3%;
  transform: translateY(-50%);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  list-style: none;
}

.main li img {
  width: 120px;
  height: auto;
  max-width: 100%;
}

.row1 {
  justify-content: center;
  transition: all ease-out;
  cursor: pointer;
  display: inline-flex;
}

.row1:hover {
  transform: translateY(-8px);
}

.elementos-internos {
  padding: 2vh;
}

.cartao-principal {
  margin-right: 3vw;
}

.botao-adicionar {
  margin-bottom: 3vh;
}

@media (max-width: 450px) {
  .home-img{
    max-width: 70vw;
  }

  .home {
    display: block;
  }
  .cartao-principal {
    margin: 0 auto;
  }

  .cartao-principal h3{
    font-size: 7vw;
  }
}

</style>
