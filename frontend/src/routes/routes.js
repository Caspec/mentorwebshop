import Products from '../components/organisme/Products.vue';
import Home from '../Home.vue';
import Login from '../components/atom/Login.vue';
import Dashboard from '../components/atom/Dashboard.vue';
import Product from '../components/molekyle/Product.vue';
import Checkout from '../components/atom/Checkout.vue';

export const routes = [
    { path: '/', component: Home },
    { path: '/products', component: Products },
	{ path: '/product/:id', name: 'product', component: Product, props: true },
    { path: '/login', component: Login },
    { path: '/checkout', name:'checkout', component: Checkout, props: true },
    { path: '/dashboard', component: Dashboard }
];