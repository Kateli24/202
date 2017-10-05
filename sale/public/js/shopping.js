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
			total += item.product.price * item.quantityPurchased;
		}
		return total;
	}
}


/*create application, and load used modules*/
var app = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

/**We have taken care of the sign in process itself but we also need to ensure 
 * that the authentication token has been added to Authorization header for each
 *  HTTP request. We can do this by adding a config block to our ShoppingApp module*/

app.config(function ($sessionStorageProvider, $httpProvider) {
   // get the auth token from the session storage
   let authToken = $sessionStorageProvider.get('authToken');

   // does the auth token actually exist?
   if (authToken) {
      // add the token to all HTTP requests
      $httpProvider.defaults.headers.common.Authorization = 'Basic ' + authToken;
   }
});


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

/**factory for sale*/
app.factory('saleDAO', function ($resource) {
	return $resource('/api/sales');
});

/**controller for product*/
app.controller('ProductController', function (productDAO, categoryDAO, allProductDAO, $sessionStorage, $window) {
	this.products = productDAO.query();
	this.categories = categoryDAO.query();
	this.selectCategory = function (selectedCat) {
		this.products = categoryDAO.query({"cat": selectedCat});
	};
	this.allProducts = function (allPro) {
		this.products = allProductDAO.query({"all": allPro});
	};

	this.buy = function (data) {
		$sessionStorage.selectedProduct = data;
		$window.window.location.href = '/QuantityToPurchase.html';
	};

});

/**cotroller for quantityToPurchase*/
app.controller('QuantityController', function ($sessionStorage, $window, cart) {

	this.getProduct = function () {
		if ($sessionStorage.selectedProduct) {
			this.selectedProduct = $sessionStorage.selectedProduct;
		}
	};

	this.addToCart = function (quantity) {
		let selectedProduct = $sessionStorage.selectedProduct;
		let saleItem = new SaleItem(selectedProduct, quantity);
		cart.addItem(saleItem);
		$sessionStorage.cart = cart;
		alert('the product has been added to shopping cart');
		$window.window.location.href = '/cart.html';

	};
});

/**controller for shopping cart*/
app.controller('ShoppingCartController', function (cart, $sessionStorage, $window, saleDAO) {
	this.items = cart.getItems();
	this.total = cart.getTotal();
	this.checkOut = function () {
		cart.setCustomer($sessionStorage.customer);
		saleDAO.save(null, cart);
		console.log(cart);
		$sessionStorage.$reset();
		alert("You have checked out.");
		
		$window.window.location.href = '/thankYou.html';
	};
});

/**controller for customer*/
app.controller('CustomerController', function (registerDAO, signInDAO, $sessionStorage, $window, $http) {
	this.registerCustomer = function (customer) {
		registerDAO.save(null, customer);
		console.log(customer);
		alert("Your account has created.");
	};

	this.signInMessage = "Please sign in to continue.";
	this.welcome = 'guest';

	let ctrl = this;
	this.signIn = function (userName, password) {
		// generate authentication token
		let authToken = $window.btoa(userName + ":" + password);

// store token
		$sessionStorage.authToken = authToken;

// add token to the sign in HTTP request
		$http.defaults.headers.common.Authorization = 'Basic ' + authToken;

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



