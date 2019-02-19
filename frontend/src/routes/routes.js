//import Home from './components/Home.vue';
//import Portfolio from './components/portfolio/Portfolio.vue';
//import Stocks from './components/stocks/Stocks.vue';
//import Products from './components/organisme/Products';
import Products from '../components/organisme/Products.vue';
import Home from '../Home.vue';

export const routes = [
    { path: '/', component: Home },
    { path: '/products', component: Products }
];