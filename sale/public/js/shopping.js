"use strict";

class SaleItem {
	constructor(product, quantity) {
		this.product = product;
		this.quantityPurchased = quantity;
	}
}

class ShoppingCart {
	constructor(items) {
		if (items) {
			this.items = items;
		} else {
			this.items = new Array();
		}
	}
	getItems() {
		return this.items;
	}
	addItem(item) {
		this.items.push(item);
	}
	setCustomer(customer) {
		this.customer = customer;
	}
	getTotal() {
		let total = 0;
		for (const item of this.items) {
			total += item.product.purchusePrice * item.quantityPurchased;
		}
		return total;
	}
}

/*create application, and load used modules*/
var app = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

/**factory for products according to id*/
app.factory('productDAO', function ($resource) {
	return $resource('/api/products/:id');
});

/**factory for getting all the products*/
app.factory('allProductDAO', function ($resource) {
	return $resource('/api/products');
});

/**factory for category*/
app.factory('categoryDAO', function ($resource) {
	return $resource('/api/categories/:cat');
});

/**factory for customer*/
app.factory('registerDAO', function ($resource) {
	return $resource('/api/register');
});

/**factory for sign in*/
app.factory('signInDAO', function ($resource) {
	return $resource('/api/customers/:userName');
});

/**factory for shopping cart*/
app.factory('cart', function ($sessionStorage) {
// is the cart in the session storage?
	if ($sessionStorage.cart) {
// recreate the object from the items array
		return new ShoppingCart($sessionStorage.cart.items);
	} else {
		return new ShoppingCart();
	}
});

/**controller for product*/
app.controller('ProductController',function (productDAO, categoryDAO, allProductDAO,$sessionStorage, $window) {
	this.products = productDAO.query();
	this.categories = categoryDAO.query();
	this.selectCategory = function (selectedCat) {
		this.products = categoryDAO.query({"cat": selectedCat});
	};
	this.allProducts = function (allPro) {
		this.products = allProductDAO.query({"all": allPro});
	};
	
	this.buy = function(data){
		$sessionStorage.selectedProduct = data;
		$window.window.location.href = '/QuantityToPurchase.html';
	};
	
});

/**cotroller for quantityToPurchase*/
app.controller('QuantityController',function($sessionStorage,$window){
	
		this.getProduct = function(){
			if($sessionStorage.selectedProduct){
				this.selectedProduct = $sessionStorage.selectedProduct;
			}
		};
		this.addToCart = function(selectedProduct){
			if($sessionStorage.cart){
				var saleItem = [];
				var i;
				for(i=0;i<$sessionStorage.cart.length;i++){
					saleItem.push($sessionStorage.cart[i]);
				}
				saleItem.push(selectedProduct);
				$sessionStorage.cart = saleItem;
				alert('the product has been added to shopping cart');
				$window.window.location.href = '/cart.html';
			}
			else{
				var saleItem = [];
				saleItem.push(selectedProduct);
				$sessionStorage.cart = saleItem;
				alert('the product has been added to shopping cart');
				$window.window.location.href = '/cart.html';
				}
			
		};
	});

/**controller for shopping cart*/
app.controller('ShoppingCartController', function(cart,$sessionStorage,$window){
	this.items = cart.getItems();
	this.total = cart.getTotal();
	
	this.bindItems = function(){
		if($sessionStorage.cart){
			this.cartItems = $sessionStorage.cart;
		}
	};
});

/**controller for customer*/
app.controller('CustomerController', function (registerDAO, signInDAO, $sessionStorage, $window) {
	this.registerCustomer = function (customer) {
		registerDAO.save(null, customer);
		console.log(customer);
		alert("Your account has created.");
	};

	this.signInMessage = "Please sign in to continue.";
	this.welcome= 'guest';

	let ctrl = this;
	this.signIn = function (userName, password) {
// get customer from web service
		signInDAO.get({'userName': userName},
// success
				  function (customer) {
// also store the retrieved custome
					  $sessionStorage.customer = customer;
					  
					  alert("logged in successfully.");
					  
// redirect to home
					  $window.window.location.href = '.';
					  
				  },
				  function () {
					  ctrl.signInMessage = 'Sign in failed. Please try again.';
					 
				  }
		);
	};
	
	let control = this;
	this.checkSignIn = function () {
		if ($sessionStorage.customer) {
			control.welcome = $sessionStorage.customer.username;
			this.signedIn = true;
			return true;
		}
		return false;
	};
	
	this.signOut = function () {
		$sessionStorage.$reset();
		alert("logged out!");
		$window.window.location.href = '.';
	};	
});



