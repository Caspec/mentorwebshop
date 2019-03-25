<template>
  <div class="container">
    <h1>Welcome to Administrator Dashboard !</h1>
    <div class="containerInfo">
      <p>
        You are loggedin as:
        <span class="bold">{{ user_name }}</span>
      </p>
    </div>
    <div class="containerCrud">
      <div class="containerCrud one">
        <table>
          <tr>
            <td>
              <router-link :to="{name: 'productadd', params: {id: user_name, user_name: user_name}}"><button class="add">+ Add product</button></router-link>
            </td>
            <td></td>
          </tr>
          <tr>
            <td class="align">
              <label>Product name</label>
            </td>
            <td></td>
          </tr>
          <tr>
            <td>
              <input class="input" v-model="search" type="text" placeholder="Search product">
            </td>
            <td></td>
          </tr>
        </table>

        <table class="tabl">
          <tr class="table_row">
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Actions</th>
          </tr>
          <div v-for="(product, index) in products" :key="index">
            <tr class="table_row">
              <td>{{ product.product_name }}</td>
              <td>{{ product.product_description }}</td>
              <td>{{ product.product_price | currency }}</td>
              <td>
               <router-link :to="{name: 'productedit', params: {id: product.product_id, product: product, user_name: user_name}}"><button class="edit">Edit</button></router-link> <router-link :to="{name: 'productdelete', params: {id: product.product_id, product: product, user_name: user_name}}"><button class="delete">Delete</button></router-link>
              </td>
            </tr>
          </div>
        </table>
      </div>
      <div class="containerCrud two">maybe some other info....</div>
    </div>
  </div>
</template>

<script>
import { Store } from "../store/store.js";
export default {
  props: {
    user_name: {
      type: String
    }
  },
  data(){
      return {
          products: Store.$data.products,
          search: ''
      }
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
  },
  mounted() {
    this.getProducts();
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
.containerInfo {
  margin-top: 2em;
  margin-bottom: 2em;
}
.containerCrud {
  width: 95%;
  height: auto;
  margin-bottom: 2em;
  margin-left: 1em;
  padding-top: 1em;
  padding-bottom: 1em;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: auto;
}
.one {
  grid-column: span 2;
}
.two {
  grid-template-columns: span 1;
}
.bold {
  font-weight: bold;
  color: green;
  font-size: 1.2em;
  text-transform: uppercase;
}
.align {
  text-align: left;
}
.add {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  font-size: 24px;
  margin: 10px 2px;
  margin-bottom: 0.8em;
  cursor: pointer;
}
.input {
  padding: 10px 5px;
  margin: 2px 2px;
  width: 100%;
}
.tabl {
  width: 100%;
  border: 1px solid black;
}
.table_row {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  text-align: left;
  padding: 1px 1em;
}
.edit{
  background-color: rgba(8, 98, 172, 0.986);
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  font-size: 24px;
  margin-left: 75px;
  cursor: pointer;
}
.delete{
  background-color:red;
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  font-size: 24px;
  margin-left: 75px;
  cursor: pointer;
}
</style>