<template>
  <div id="gridContainer">
    <div class="gridItem one">
      <div v-for="(product, index) in products" :key="index">
          <div class="container"> 
            <div class="headline"><h1><router-link :to="{name: 'product', params: {id: product.product_id, product: product}}">{{ product.product_name }}</router-link></h1></div>
            <div class="image"><router-link :to="{name: 'product', params: {id: product.product_id, product: product}}"><img :src="'./src/assets/' + product.image_name" /></router-link></div>
            <div class="desc"><h3>Description about the product:</h3> <p>{{ product.product_description }}</p></div>
            <div class="price"><h3>Price: {{ product.product_price * tax | currency }}</h3></div>
            <div class="add"><button class="button" name="addToCart" @click="addToCart(product)">Add to cart</button></div>
          </div>  

      </div>
    </div>
    <div class="gridItem two">
        <app-cart></app-cart>
    </div>
  </div>
</template>

<script>
import { Store } from "../store/store.js";
import Cart from "../atom/Cart.vue";

export default {
  components: {
    appCart: Cart
  },
  data() {
    return {
      products: Store.$data.products
    };
  },
  methods: {
    getProducts() {
      this.$http.get("http://localhost:3001/products").then(res => {
          this.products = res.data;
        })
        .catch(err => {
          console.log("error: " + res.status.send(err));
        });
    },
    addToCart(product) {
      Store.addToCart(product)
    }
  },
  mounted() {
    this.getProducts();
  }
};
</script>

<style>
#gridContainer {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: auto;
  grid-gap: 3em;
  min-height: 600px;
}
.one {
  grid-column: span 2;
  /*background-color: rgb(25, 25, 61);*/
}
h1{
    font-weight: 900;
}
.routerlink {
    text-decoration: none;
    color: white;
}
.container {
    width: 100%;
    height: auto;
    margin-bottom: 2em;
    margin-top: 2em;
    margin-left: 1em;
    border: 5px solid black;
    padding-top: 1em;
    padding-bottom: 1em;
}
.headline {
    width: 100%;
    height: auto;
    margin-bottom: 1em;
}
.image {
    width: 100%;
    height: auto;
}
.desc {
    width: 100%;
    height: auto;
    margin-top: 1em;
}
.desc p {
    margin-top: 1em;
}
.price {
    width: 100%;
    height: auto;
    margin-top: 1em;
}
.add {
    width: 100%;
    height: auto;
    margin-top: 1em;
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 24px;
  margin: 4px 2px;
  cursor: pointer;
}
.two {
  grid-template-columns: span 1;
  /*background-color: rgb(25, 25, 61);*/
}
</style>

