<template>
  <div class="text-center">
    <v-btn
        color="primary"
        @click="modalLogin()"
    >
      <v-icon>mdi-login</v-icon>
      <v-dialog
          class="main-dialog"
          v-model="this.dialog"
          activator="parent"
          width="20%"
      >
        <v-card>
          <v-card-text class="card-main-text">
            Selecione o tipo de Login:
          </v-card-text>
          <v-card-actions>
            <v-btn color="primary" block @click="rotaFuncionario()">
                Funcionário
            </v-btn>
          </v-card-actions>
          <v-card-actions>
            <v-btn color="primary" block @click="rotaCliente()">
                Cliente
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-btn>
  </div>

</template>

<script>

import {defineComponent} from "vue";
import router from "@/router";

export default defineComponent({

  data() {
    return {
      dialog: false,
    }
  },
  methods: {
    modalLogin() {
      if (this.dialog === true){
        this.dialog = false;
      } else {
        this.dialog = true;
      }
    },
    rotaFuncionario(){
      this.dialog = false;
      router.push('/login');
    },
    rotaCliente(){
      this.dialog = false;
      router.push('/loginCliente');
    }
  }

});

</script>

<style>

.card-main-text {
  padding-top: 25px !important;
  text-align: center;
  font-weight: bold !important;
  font-size: 15px !important;
}

</style>
