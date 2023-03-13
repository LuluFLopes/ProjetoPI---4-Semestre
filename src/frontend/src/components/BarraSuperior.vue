
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
      <v-btn icon class="login" @click="TelaLoginFuncionario" >

        <router-link to="TelaLoginFuncionario"><v-icon>mdi-login</v-icon></router-link>


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


