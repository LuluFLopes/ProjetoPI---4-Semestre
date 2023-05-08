<template>
  <section class="home">
    <div class="home-img">
      <img :src="imagemDetalhes" class="one">
    </div>

    <div class="home-text">
      <h3><i class="fas fa-shopping-cart"></i> ({{product}})</h3>
      <h1>Detalhe Pedido</h1>
      <h5>Resident Evil</h5>
      <h3>R$ 200,00</h3>
      <a href="#" class="btn">Finalizar Compra</a>
    </div>

    <div class="main">
      <div class="row1" v-for="(row, index)  of detalhesImg" :key="'linha-'+index">
        <li><img :src="row.imagem" class="one"  @click="slider(row.imagem)"></li>
      </div>
    </div>


    <div class="container">
      <h1>Checkout de Pedido</h1>
      <form>
        <label for="endereco">Endereço:</label>

        <label for="cep">CEP:</label>

        <label for="produto" >Produto:</label>

        <ul>
          <li id="produto" name="produto" required>1</li>
          <li id="produto" name="produto" required>2</li>
          <li id="produto" name="produto" required>3</li>
          <li id="produto" name="produto" required>4</li>
          <li id="produto" name="produto" required>5</li>
        </ul>

        <label for="quantidade">Total:</label>

      </form>
    </div>

  </section>

</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  data() {
    return {
    }
  },
});
</script>

<style scoped>
/* Incluindo a biblioteca Font Awesome */
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css");

.home {
  position: relative;
  height: 100%;
  width: 100%;
  display: grid;
  grid-template-columns: 2fr 1fr;
  align-items: center;
  gap: 2rem;
  background: rgba(45, 46, 50);
}
.home-text h1{
  font-size: 4rem;
  line-height: 1.2;
  margin-bottom: 2px;

}

.home-text h5{
  color: #ffffff99;
  font-size: 14px;
  font-weight: 400;
  margin-bottom: 60px;
}

.home-text h3{
  font-size: 40px;
  font-weight: 700;
  letter-spacing: 2px;
  margin-bottom: 35px;
}

.home-img img{
  max-width: 100%;
  width: 28rem;
  height: auto;
  margin-left: 25%;
}

.btn{
  display: inline-block;
  padding: 15px 70px;
  font-size: 16px;
  font-weight: 500;
  background: transparent;
  border: solid 2px #ffffff;
  transition: all ease-out;
  color:#ffffff;
  margin-top: 30px;
}

.btn:hover a{
  background: white;
  border: 2px solid #ffffff;
  color: #111111;
}

.main{
  position: absolute;
  top: 50%;
  left: 3%;
  transform: translateY(-50%);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  list-style:none;
}

.main li img{
  width: 120px;
  height: auto;
  max-width: 100%;
}

.row1{
  justify-content: center;
  transition: all ease-out;
  cursor: pointer;
  display: inline-flex;
}

.row1:hover{
  transform: translateY(-8px);
}

.container {
  position: absolute;
  max-width: 600px;
  margin-top: 0px;
  padding: 20px;

}

h1 {
  text-align: center;
}

form {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 20px;
  margin-top: 0px;
}

label {
  display: block;
}

input[type="text"],
input[type="email"],
select,
input[type="number"] {
  width: 100%;
  padding: 1px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
  margin-left: -470px;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #0062cc;
}
#produto{
  margin-left: -470px;
  list-style:none;
}


</style>
