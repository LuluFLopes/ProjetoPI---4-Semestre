
<template>
  <header class="cabecalho">
    <v-toolbar color="rgba(217, 217, 217, 1)" density="confortable">
      <v-toolbar-title><router-link to="/" style="text-decoration: none; color: inherit;"><h1>Bazinga Games</h1></router-link></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon class="login">
        <router-link to="login"><v-icon>mdi-login</v-icon></router-link>
      </v-btn>
    </v-toolbar>
  </header>
</template>


<script>

import {defineComponent} from "vue";
  export default defineComponent(  {
    components: {},

    data: () => ({
      tab: null,
    })
  });

</script>


<style>

.login{
  margin: auto;
  position: absolute;
  display: block;
}

.cabecalho{
  border-bottom: 2px solid #111;

}


</style>


