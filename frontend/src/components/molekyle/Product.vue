<template>
    <div>
        <p>Dette er et enkelt product!</p>
        <p>{{ thisproduct}}</p>
    </div>
</template>
 <script>
 export default {
     props: {
         thisproduct: {
             required: true
         }
     }
 }
 </script>

 <style>
 
 </style>
 
 