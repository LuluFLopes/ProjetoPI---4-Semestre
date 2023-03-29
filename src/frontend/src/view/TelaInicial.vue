import import Vue from 'vue'


<template>

  <div class="hello">
      <div>
        <img class="imagem-principal" src="../assets/bazinga.png">
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
  margin-left: 370px;
  translate: 60px;
  margin-top: 30px;
  opacity: 0.3;
}
.hello{
  background: rgba(45, 46, 50);
  height: 100%;
}

</style>
