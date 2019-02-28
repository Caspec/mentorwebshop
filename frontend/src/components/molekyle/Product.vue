<template>
    <div>
        <p>Dette er et enkelt product!</p>
        <p>{{ product }}</p>
    </div>
</template>
 <script>
 export default {
     props: {
         product: {
             required: true
         }
     }
 }
 </script>

 <style>
 
 </style>
 
 