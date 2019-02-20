import Products from '../components/organisme/Products.vue';
import Home from '../Home.vue';
import Login from '../components/atom/Login.vue';

export const routes = [
    { path: '/', component: Home },
    { path: '/products', component: Products },
	{ path: '/products/:id', component: Products },
	{ path: '/login', component: Login }
];