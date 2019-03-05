<template>
    <div class="headerGrid">
        <div class="logo">
            <router-link to="/" class="navbar-brand"><img src="../../assets/logo.png"></router-link>
        </div>
        <div class="nav">
            <nav>
                <ul>
                    <router-link to="/" class="navbar-brand">Home</router-link>
                    <router-link to="/products" class="navbar-brand">Products</router-link>
                    <router-link to="/login" class="navbar-brand">Login</router-link>
                </ul>
            </nav>
        </div>
        <div class="bag">
           <img src="../../assets/bag.png" alt="whateverbag" /> "total antal"
        </div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style>
.headerGrid{
    display: grid;
    grid-template-columns: 0.5fr 3fr 1fr;
    margin-bottom: 1em;
}
.nav{
    grid-column: span 1;
    
}
.logo{
    width: 150px;
    height: 150px;
    background-color: azure;
    grid-column: span 1;
}
.navbar-brand{
    margin-right: 3em;
    font-size: 1.5em;
}
nav{
    margin-top: 5em;
}
.bag {
    width: 100%;
    height: 100%;
    margin-top: 1em;
}
</style>

