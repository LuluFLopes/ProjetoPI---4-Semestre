<template>

  <div class="container">

      <form action="">

        <div class="row">

          <div class="col">
            <h3 class="title">Endereço de Cobrança</h3>

            <div class="inputBox">
               <span>Nome Completo:</span>
                <input type="text" placeholder="José Stevart Oliveria Guerra Junior">
            </div>
            <div class="inputBox">
              <span>Email:</span>
              <input type="text" placeholder="exemplo@exemplo.com">
            </div>
            <div class="inputBox">
              <span>Endereço:</span>
              <input type="text" placeholder="Rua: Abreu da Silva, 12">
            </div>
            <div class="inputBox">
              <span>Cidade:</span>
              <input type="text" placeholder="São Thomé das Letras">
            </div>

            <div class="flex">
              <div class="inputBox">
                <span>Estado:</span>
                <input type="text" placeholder="São Paulo">
              </div>
              <div class="inputBox">
                <span>CEP:</span>
                <input type="text" placeholder="01245-200">
              </div>

            </div>

          </div>

          <div class="col">
            <h3 class="title">Pagamento</h3>

            <div class="inputBox">
              <span>Cartão Cadastrado:</span>
              <img src="../assets/card_img.png" alt="Cartão de Crédito">
            </div>
            <div class="inputBox">
              <span>Nome no Cartão:</span>
              <input type="text" placeholder="Sr. José Stevart">
            </div>

            <div class="inputBox">
              <span>Numero do Cartão De Crédito:</span>
              <input type="text" placeholder="0001 2548 2587 69">
            </div>
            <div class="inputBox">
              <span>Mês de Vencimento:</span>
              <input type="text" placeholder="Janeiro">
            </div>

            <div class="flex">
              <div class="inputBox">
                <span>Ano de Vencimento:</span>
                <input type="text" placeholder="2023">
              </div>
              <div class="inputBox">
                <span>CVV:</span>
                <input type="text" placeholder="1485">
              </div>

            </div>

          </div>

        </div>

        <input type="submit" value="Processar Pagamento" class="submit-btn">


      </form>

  </div>

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

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  outline: none;
  border: none;
  text-transform: capitalize;
  transition: all .2s linear;
}

.container{
  display:flex;
  justify-content: center;
  align-items: center;
  padding: 25px;
  min-height: 100vh;
  background: rgba(45, 46, 50);
  padding-bottom: 70px;
}

.container form{
  padding: 20px;
  width: 700px;
  background: #ffffff;
  box-shadow: 0 5px 10px rgba(0,0,0,.1);
  border-radius: 5px;
}

.container form .row{
  display: flex;
  flex-wrap: wrap;
  gap: 15px;
}

.container form .row .col{
  flex: 1 1 250px;
}

.container form .row .col .title{
  font-size: 20px;
  color: rgba(45, 46, 50);
  padding-bottom: 5px;
  text-transform: uppercase;
}

.container form .row .col .inputBox{
  margin: 15px 0;
}

.container form .row .col .inputBox span{
  margin-bottom: 10px;
  display: block;
}

.container form .row .col .inputBox input{
  width: 100%;
  border: 1px solid #ccc;
  padding: 10px 15px;
  font-size: 15px;
  text-transform: none;
}

.container form .row .col .inputBox input:focus{
  border: 1px solid #000;
}

.container form .row .col .flex{
  display: flex;
  gap: 15px;
}

.container form .row .col .flex .inputBox{
  margin-top: 5px;
}

.container form .row .col .inputBox img{
  height: 34px;
  margin-top: 5px;
  filter: drop-shadow(0 0 1px #000000);
}

.container form .submit-btn{
  width: 100%;
  padding: 12px;
  font-size: 17px;
  background: #222222;
  color: #ffffff;
  cursor: pointer;
}

.container form .submit-btn:hover{
  background:green ;
}

</style>
