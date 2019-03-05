<template>
  <div>
    <div class="container">
      <div class="headline">
        <h1>{{ product.product_name }}</h1>
      </div>
      <div class="image">
        <img :src="'../src/assets/' + product.image_name">
      </div>
      <div class="desc">
        <h3>Description about the product:</h3>
        <p>{{ product.product_description }}</p>
      </div>
      <div class="price">
        <h3>Price: {{ product.product_price * tax | currency }}</h3>
      </div>
      <div class="add">
        <button class="button" name="addToCart" @click="addToCart(product)">Add to cart</button>
      </div>
    </div>
  </div>
</template>
 <script>
export default {
  props: {
    product: {
      type: Object,
      required: true
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
</style>
 
 