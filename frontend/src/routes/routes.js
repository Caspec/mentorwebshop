import Products from '../components/organisme/Products.vue';
import Home from '../Home.vue';
import Login from '../components/atom/Login.vue';
import Dashboard from '../components/atom/Dashboard.vue'

export const routes = [
    { path: '/', component: Home },
    { path: '/products', component: Products },
	{ path: '/products/:id', component: Products },
    { path: '/login', component: Login },
    { path: '/dashboard', component: Dashboard }
];