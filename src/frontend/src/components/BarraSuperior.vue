
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
      <v-btn icon class="login"> 
        <v-icon>mdi-login</v-icon>
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
    data: () => ({
      tab: null,
    }),
  }
</script>


