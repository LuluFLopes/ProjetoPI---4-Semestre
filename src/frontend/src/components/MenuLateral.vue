<template>
  <div class="menuLateral">
    <template v-for="(item, index) of getSideBarList">
      <router-link
          :key="index"
          :to="item.route"
          custom v-slot="{ navigate }">
        <button
            class="botao text-no-wrap"
            @click="navigate"
            role="link">{{ item.label }}
        </button>
      </router-link>
    </template>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {sideBarList} from '@/constants'
import {mapState} from "vuex";

export default defineComponent({
  name: "MenuLateral",
  computed: {
    ...mapState([
      'user'
    ]),
    getSideBarList() {
      return sideBarList.filter((itemList) => {
        return itemList.grupo.find((role) => role === this.user.grupo);
      })
    },
  }
});

</script>

<style>
.menuLateral {
  width: 16%;
  height: 100%;
  background: rgba(217, 217, 217, 1);
  justify-content: center;
  border-right: 2px solid #111;
  padding: 10px;

}

.botao {
  width: 80%;
  text-align: center;
  padding: 5px;
  margin: auto;
}

.botao:hover {
  color: gold;
  font-weight: bold;
  background-color: red;
  border-radius: 5px;
}
</style>