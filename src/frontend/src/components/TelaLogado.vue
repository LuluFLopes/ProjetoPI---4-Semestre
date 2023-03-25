<template>

  <div class="fundo">
    <div>
      <BarraSuperior></BarraSuperior>
    </div>
    <div class="menuLateral1">
      <MenuLateral></MenuLateral>
    </div>
  </div>

</template>

<script>
import BarraSuperior from "@/components/BarraSuperior";
import MenuLateral from "@/components/MenuLateral";
export default {
  name: "TelaLogado",
  components: {MenuLateral, BarraSuperior}
}
</script>

<style scoped>
.fundo{
  height: 100%;
  background: rgba(45, 46, 50);
}
.menuLateral1{
  height: 100%;
}
</style>