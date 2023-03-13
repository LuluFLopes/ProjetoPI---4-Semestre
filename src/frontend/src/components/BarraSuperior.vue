import TelaCadastro from '@/components/TelaCadastro';
import Router from 'vue-router';

<template>
  <v-card
    color="grey-lighten-4"
    flat
    height="70px"
    rounded="0"
  >
    <v-toolbar density="compact">

      <v-toolbar-title>Bazinga Games</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn icon class="login" @click="TelaCadastro" >

        <router-link to="TelaCadastro"><v-icon>mdi-login</v-icon></router-link>


      </v-btn>
    </v-toolbar>

  </v-card>
</template>


<style scoped>
  .barra{
    color-scheme:darkblue;
  };

  .login{
    margin: auto;
    position: absolute;
    display: block;
  }

</style>



<script>
  export default {
    components: {},

    data: () => ({
      tab: null,
    })
  }
</script>


