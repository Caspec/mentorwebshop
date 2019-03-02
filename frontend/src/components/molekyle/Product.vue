<template>
    <div>
        <p>Dette er et enkelt product!...............</p>
        <p>{{ product.product_id }}</p>
        <p>{{ product.product_name }}</p>
        <p>{{ product.product_price * tax | currency }}</p>
    </div>
</template>
 <script>
 export default {
     props: {
         product: {
             type: Array,
             required: true
         }
     }
 }
 </script>

 <style>
 
 </style>
 
 