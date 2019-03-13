<template>
  <div class="container">
    <h1>Checkout</h1>
    <div class="bold" v-if="cart.length === 0">Cart is empty..... fill some in it to buy them!</div>
    <div v-else>
      <table class="tabl">
        <div v-for="(product, index) in carts" :key="index">
          <tr class="table_row">
            <th>Product Name</th>
            <th>Product Description</th>
            <th>Product Price</th>
            <th>Product Quantity</th>
          </tr>
          <tr class="table_row">
            <td>{{ product.details.product_name }}</td>
            <td>{{ product.details.product_description }}</td>
            <td class="left">{{ product.details.product_price | currency }}</td>
            <td class="left">
              {{ product.quantity }}
              <button
                class="add_button"
                @click="addToQuantity(product.details.product_id)"
              >+</button>
              <button class="subtract_button" @click="removeFromCart(product.details.product_id)">-</button>
            </td>
            <td>
              <img :src="'../src/assets/' + product.details.image_name">
            </td>
          </tr>
        </div>
      </table>
      <div class="alignCost">Total Incl. taxing: {{ totalCost * tax | currency }}</div>
      <div><button class="checkout">Finish my order</button></div>
    </div>
  </div>
</template>

<script>
import { Store } from "../store/store.js";
export default {
  props: {
    carts: {
      type: Array
    }
  },
  computed: {
    totalCost() {
      return Store.totalCost;
    },
    cart() {
      return Store.$data.cart;
    }
  },
  methods: {
    removeFromCart(product_id) {
      Store.removeFromCart(product_id);
    },
    addToQuantity(product_id) {
      Store.addToQuantity(product_id);
    }
  }
};
</script>

<style scoped>
.container {
  width: 95%;
  height: auto;
  margin-bottom: 2em;
  margin-top: 2em;
  margin-left: 1em;
  border: 5px solid black;
  padding-top: 1em;
  padding-bottom: 1em;
}
.bold {
  font-weight: bold;
  margin-top: 1em;
}
.add_button {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  height: auto;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  margin: 2px;
  width: 1em;
  cursor: pointer;
}
.subtract_button {
  background-color: rgb(209, 60, 60); /* Red */
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  margin: 2px;
  width: 1em;
  cursor: pointer;
}
.tabl {
  width: 100%;
  margin-top: 1em;
}
.table_row {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  text-align: left;
  padding: 1px 1em;
}
.alignCost {
  text-align: left;
  padding-left: 1.2em;
  font-weight: bold;
}
.checkout {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display:block;
  font-size: 24px;
  font-weight: bold;
  margin: 4px 2px;
  margin-top: 1em;
  margin-left: 0.8em;
  cursor: pointer;
}
.left {
    padding-left: 1.5em;
}
</style>

