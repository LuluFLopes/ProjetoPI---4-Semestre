import import Vue from 'vue'


<template>

  <div class="hello">
      <BarraSuperior></BarraSuperior>
      <div>
        <img class="imagem-principal" src="@/Images/RE4-2.jpg">
      </div>
  </div>
</template>


<script>
import { defineComponent } from 'vue';
import BarraSuperior from './BarraSuperior.vue';
export default defineComponent ({
  
   name: 'TelaInicial', 
   components:{
    BarraSuperior,
   } 
});

</script>


<style scoped>
  .imagem-principal{
    width: auto;
    margin-top: 0px;
  }

</style>
