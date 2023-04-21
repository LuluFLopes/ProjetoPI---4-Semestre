import import Vue from 'vue'


<template>

  <div class="hello">
      <div>
        <img class="imagem-principal" src="../assets/bazinga.png">

          <div id="products">

            <!--
            <v-carousel
                :cicle="true"
                :hide-delimiters="slider.length < 4"
                :show-arrows="slider.length > 4"
            >
              <template v-for="(item, index) of slider">
                <v-carousel-item v-if="(index + 1) % columns === 1 || columns === 1"
                                 :key="index"
                >
                  <v-row class="flex-nowrap" style="height:100%">
                    <template v-for="(n,i) in columns">
                      <template v-if="(+index + i) < slider.length">
                        <v-col :key="i">
                            <v-row
                              class="fill-height"
                              align="center"
                              justify="center"
                            >
                              <v-card
                                class="prod"
                                variant="tonal"
                                width="400px"
                              >
                                <v-card-title>
                                  {{slider[i].title}}
                                </v-card-title>
                                <v-card-subtitle id="cartao">
                                  {{slider[i].value}}
                                </v-card-subtitle>
                                <v-img width="100%"
                                   :src="slider[i].imageSrc"
                                  height="200"
                                />
                               <v-card-actions>
                                  <v-btn>Detalhes</v-btn>
                              </v-card-actions>
                              </v-card>
                            </v-row>
                        </v-col>
                      </template>
                    </template>
                  </v-row>
                </v-carousel-item>
              </template>

            </v-carousel>
            -->


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>

            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident
              </v-card-title>
              <v-card-subtitle id="cartao">
                jogo
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>

          </div>
      </div>
  </div>
</template>


<script>
import { defineComponent } from 'vue';

export default defineComponent ({
  
   name: 'TelaInicial',

  data() {
     return {
       slider: [
         {
           title: 'Resident Evil 4',
           imageSrc: 'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp',
           value: 'R$ 15,00'
         },
         {
           title: 'Need for speed most wanted',
           imageSrc: 'https://s2.glbimg.com/HJrwvQt3RkodEiv0d50Es5G7XSs=/0x0:620x349/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/8/D/lMIL3bR8mZVAxMFbRUsw/2012-05-25-e3needforspeedmostwanted.jpg',
           value: 'R$ 15,00'
         },
         {
           title: 'Dying light 2',
           imageSrc: 'https://alternativanerd.com.br/wp-content/uploads/2020/01/AN_Dying-Light-2.jpg',
           value: 'R$ 15,00'
         },
         {
           title: 'Resident Evil 4',
           imageSrc: 'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp',
           value: 'R$ 15,00'
         },
         {
           title: 'Need for speed most wanted',
           imageSrc: 'https://s2.glbimg.com/HJrwvQt3RkodEiv0d50Es5G7XSs=/0x0:620x349/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/8/D/lMIL3bR8mZVAxMFbRUsw/2012-05-25-e3needforspeedmostwanted.jpg',
           value: 'R$ 15,00'
         },
         {
           title: 'Dying light 2',
           imageSrc: 'https://alternativanerd.com.br/wp-content/uploads/2020/01/AN_Dying-Light-2.jpg',
           value: 'R$ 15,00'
         },
         {
           title: 'Resident Evil 4',
           imageSrc: 'https://meups.com.br/wp-content/uploads/2023/03/cats-66-900x503.jpg.webp',
           value: 'R$ 15,00'
         },
         {
           title: 'Need for speed most wanted',
           imageSrc: 'https://s2.glbimg.com/HJrwvQt3RkodEiv0d50Es5G7XSs=/0x0:620x349/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/8/D/lMIL3bR8mZVAxMFbRUsw/2012-05-25-e3needforspeedmostwanted.jpg',
           value: 'R$ 15,00'
         },
         {
           title: 'Dying light 2',
           imageSrc: 'https://alternativanerd.com.br/wp-content/uploads/2020/01/AN_Dying-Light-2.jpg',
           value: 'R$ 15,00'
         },


       ]
     }
  },
  computed: {
    columns() {
      if (this.$vuetify.breakpoint.xl) {
        return 4;
      }

      if (this.$vuetify.breakpoint.lg) {
        return 3;
      }

      if (this.$vuetify.breakpoint.md) {
        return 2;
      }

      return 1;
    }
  }
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

#products{
  display: grid;
  grid-template-columns: 3fr 3fr 2fr;
  position: relative;

}

#cartao{
  font-weight: bold;
  color: black;
}

</style>
