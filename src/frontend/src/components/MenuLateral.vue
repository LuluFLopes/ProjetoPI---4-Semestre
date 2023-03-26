<template>

  <div class="menuLateral">
      <button class="botao text-no-wrap" @click="$emit('usuarioAtivo')">Cadastro de Usuários</button>
      <button class="botao text-no-wrap" @click="$emit('produtoAtivo')">Cadastro de Produtos</button>
  </div>

</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "MenuLateral",
  emits:['usuarioAtivo', 'produtoAtivo']
})
</script>

<style>

.menuLateral{
  width: 16%;
  height: 100%;
  background: rgba(217, 217, 217, 1);
  justify-content: center;
  border-right: 2px solid #111;
  padding: 10px;

}

.botao{
  width: 80%;
  text-align: center;
  padding: 5px;
  margin: auto;
}

.botao:hover{
  color: gold;
  font-weight: bold;
  background-color: red;
  border-radius: 5px;

}

</style>