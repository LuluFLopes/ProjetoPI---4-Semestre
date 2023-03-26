import import Vue from 'vue'


<template>

  <div class="hello">
      <div>
        <img class="imagem-principal" src="@/Images/RE4-2.jpg">
      </div>
  </div>
</template>


<script>
import { defineComponent } from 'vue';

export default defineComponent ({
  
   name: 'TelaInicial'
});

</script>


<style>

.imagem-principal{
  width: auto;
  margin-top: 0px;
}

</style>
