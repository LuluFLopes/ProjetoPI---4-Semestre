<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral />
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import MenuLateral from "@/components/MenuLateral.vue";
export default defineComponent( {
  name: "TelaListaUsuario",
  components:{
    MenuLateral
  }
});
</script>

<style>

.fundo{
  height: 100%;
  background: rgba(45, 46, 50);
}

.menuLateral1{
  height: 100%;
}
</style>