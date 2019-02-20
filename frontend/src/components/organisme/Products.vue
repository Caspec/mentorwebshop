<template>
    <div id="gridContainer">
        
        <div class="gridItem one">
            <div v-for="(product, index) in products" :key="index">
                {{ product.product_name }}
            </div>
        </div>
        <div class="gridItem two"></div>
    </div>
</template>

<script>
export default {
    data()
    {
        return{
            products: []
        }
    },
    methods:{
        getProducts(){
            this.$http.get('http://localhost:3001/products').then((res) => {
                console.log(res.data);
                this.products = res.data;
            }).then((err) => {
                console.log(err);
            })
        }
    }, 
    mounted(){
        this.getProducts();
    }
}
</script>

<style>
#gridContainer{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: auto;
    grid-gap: 3em;
    min-height: 600px;

}
.one{
    grid-column: span 2;
    background-color:rgb(25, 25, 61);
}
.two{
    grid-template-columns: span 1;
    background-color:rgb(25, 25, 61);
}
</style>

