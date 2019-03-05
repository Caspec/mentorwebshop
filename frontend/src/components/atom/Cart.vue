<template>
  <div class="container">
    <h1>Shopping Cart</h1>
  <div v-for="(product, index) in cartProducts" :key="index">

  </div>
  {{ product }}

  </div>
</template>


<script>
import { Store } from "../store/store.js";

export default {
  data(){
    return{
      cartProducts: []
    }
  },
  computed: {
    cart(){
      this.cartProducts = Store.$data.cart
      return Store.$data.cart
      /*return Store.$data.cart.map((product) => {
       product = product.details.product_name
        return product
      })*/
    }
  }

};
</script>


<style scoped>
.container {
  width: 90%;
  height: auto;
  margin-bottom: 2em;
  margin-top: 2em;
  margin-left: 1em;
  border: 5px solid black;
  padding-top: 1em;
  padding-bottom: 1em;
}

</style>