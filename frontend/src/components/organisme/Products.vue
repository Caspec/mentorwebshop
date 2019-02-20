<template>
    <div id="gridContainer">
        
        <div class="gridItem one">
        </div>
        <div class="gridItem two"></div>
    </div>
</template>

<script>
export default {
    
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

