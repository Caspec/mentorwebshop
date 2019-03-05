import Vue from 'vue'
import products from '../organisme/Products.vue'

export const Store = new Vue({
	data() {
	    return {
	    	products,
	    	cart: []
	    };
	},
	computed: {
		totalCost(){
			return this.cart.reduce((accum, product) => {
				return accum + product.product_price * 1 // product.quantity
			}, 0)
		}
	},
	methods: {
		addToCart(product){
			const locationInCart = this.cart.findIndex(p => {return p.details.product_id === product.product_id})

		    if (locationInCart === -1) {
		        this.cart.push({
		          details: product,
		          quantity: 1
		        })
		    } else {
				this.cart[locationInCart].quantity++
		    }
		},
		removeFromCart(product_id){
			const locationInCart = this.cart.findIndex(product => {
				return product.product_id === product_id
			})

			if(this.cart[locationInCart].quantity <= 1){
				this.cart.splice(locationInCart, 1)
			} else {
				this.cart[locationInCart].quantity--
			}
		}
	}
});