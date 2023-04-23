import import Vue from 'vue'


<template>

  <div class="hello">
      <div>
        <img class="imagem-principal" src="../assets/bazinga.png">


        <h1>Lista Jogos</h1>
          <div class="products">
            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Resident Evil 4
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$ 200,00
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
                Dead Island 2
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$ 250,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn1.epicgames.com/offer/236c74b4cd2e4e3099cbe2ebdc9686fd/EGS_DeadIsland2_DeepSilverDambusterStudios_S1_2560x1440-fdc688ce46680914ee3c4a7949ce8a67'"
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
                Diablo IV
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$ 300,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://blz-contentstack-images.akamaized.net/v3/assets/blt9c12f249ac15c7ec/blt197bfce3b1cb7880/6286c2cccf13bb4bbe6278ad/open-graph.jpg'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>
</div>



            <h1>Jogos de Ação</h1>
<div class="products">
            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Dying Light 2 Stay Human
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$151,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn1.epicgames.com/salesEvent/salesEvent/EGS_DyingLight2StayHuman_Techland_S3_2560x1440-f1dcd15207f091674615ccb4bd9dc3c7'"
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
                Red Dead Redemption 2
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$99,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn1.epicgames.com/b30b6d1b4dfd4dcc93b5490be5e094e5/offer/RDR2476298253_Epic_Games_Wishlist_RDR2_2560x1440_V01-2560x1440-2a9ebe1f7ee202102555be202d5632ec.jpg'"
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
                EA SPORTS™ FIFA 23
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$299,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn1.epicgames.com/offer/f5deacee017b4b109476933f7dd2edbd/EGS_EASPORTSFIFA23StandardEdition_EACanada_S1_2560x1440-aaf9c5273c27a485f2cce8cb7e804f5c'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>

</div>


            <h1>Jogos de Aventura</h1>
        <div class="products">
            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Grand Theft Auto V
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$214,00
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://image.api.playstation.com/vulcan/ap/rnd/202203/0911/VIB0SeEj9vT6DTv7P4thJLZi.jpg'"
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
                Wartales
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$97,49
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://whatifgaming.com/wp-content/uploads/2021/11/Wartales-Key-Art-1920.jpg'"
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
                Path of Exile
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$24,99
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn.akamai.steamstatic.com/steam/apps/238960/header.jpg?t=1680737814'"
                     height="200"
              />
              <v-card-actions>
                <router-link to="DetalheProduto"><v-btn >Detalhes</v-btn></router-link>
              </v-card-actions>
            </v-card>


</div>

            <h1>Jogos online</h1>
<div class="products">
            <v-card
                class="prod"
                variant="tonal"
                width="400px"
            >
              <v-card-title>
                Call of Duty: Modern Warfare II
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$88,99
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://image.api.playstation.com/vulcan/ap/rnd/202205/2800/iQGgKYUg9YwjPVNM0kE8jeRN.jpg'"
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
                Counter-Strike: Global Offensive
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$71,99
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn.akamai.steamstatic.com/steam/apps/730/capsule_616x353.jpg?t=1641233427'"
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
                Sea of Thieves 2023 Edition
              </v-card-title>
              <v-card-subtitle id="cartao">
                R$ 44,99
              </v-card-subtitle>
              <v-img width="100%"
                     :src="'https://cdn.cloudflare.steamstatic.com/steam/apps/1172620/extras/4_SoT_SKU_2023Edition__Steam_Retail_s.png?t=1678991207'"
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

.products{
  display: grid;
  grid-template-columns: 3fr 3fr 2fr;
  position: relative;
  padding: 50px;
  border: solid 2px #ffffff;
  margin: 10px 10px;

}

#cartao{
  font-weight: bold;
  color: black;
}
h1{
  padding: 10px;
}

</style>
