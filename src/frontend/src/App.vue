<template>
  <v-app>
    <BarraSuperior />
    <v-main>
      <router-view/>
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import BarraSuperior from "@/components/BarraSuperior.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: 'App',
  components:{
    BarraSuperior,
    Footer

  },

  data: () => ({
    //
  }),
};
</script>
