<template>

  <div class="menuLateral">

      <p class="botao"><router-link style="text-decoration: none; color: inherit;" to="login">Cadastro de Usuários</router-link></p>

      <p class="botao"><router-link style="text-decoration: none; color: inherit;" to="login">Cadastro de Produtos</router-link></p>

  </div>

</template>

<script>
export default {
  name: "MenuLateral"
}
</script>

<style scoped>

.menuLateral{
  width: 16%;
  height: 100%;
  background: rgba(217, 217, 217, 1);
  margin: 0px;

  justify-content: center;

}

.menuLateral p{
  padding-top: 20px;
  padding-left: 10px;
}

.botao{
  width: 80%;
  text-align: center;

}

</style>