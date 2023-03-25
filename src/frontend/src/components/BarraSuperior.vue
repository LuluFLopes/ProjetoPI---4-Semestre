
<template>

    <v-toolbar color="rgba(217, 217, 217, 1)" density="confortable">

      <v-toolbar-title>Bazinga Games</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn icon class="login">
        <router-link to="login"><v-icon>mdi-login</v-icon></router-link>
      </v-btn>
    </v-toolbar>


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


