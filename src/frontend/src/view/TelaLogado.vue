<template>
  <div class="fundo">
    <div class="menuLateral1">
      <MenuLateral @usuario-ativo="verificarUsuarioAtivo" @produto-ativo="verificarProdutoAtivo"/>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import MenuLateral from "@/components/MenuLateral.vue";
export default defineComponent ({
  name: "TelaLogado",
  components: {
    MenuLateral
  },

  data(){
    return{
      usuarioAtivo: false,
      produtoAtivo: false
    }
  },
  methods:{
    verificarUsuarioAtivo(){
      if(this.produtoAtivo === true){
        this.produtoAtivo = false;
      }
      if(this.usuarioAtivo === false){
        this.usuarioAtivo = true;
      }
      else{
        this.usuarioAtivo = false;
      }
    },
    verificarProdutoAtivo(){
      console.log('clicou')
      if(this.usuarioAtivo === true){
        this.usuarioAtivo = false;
      }
      if(this.produtoAtivo === false){
        this.produtoAtivo = true;
      }
      else{
        this.produtoAtivo = false;
      }
      console.log(this.usuarioAtivo)
      console.log(this.produtoAtivo)
      console.log('Clicou')
    }

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