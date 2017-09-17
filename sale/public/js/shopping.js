"use strict";

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

/**controller for product*/
app.controller('ProductController', function (productDAO, categoryDAO, allProductDAO) {
	this.products = productDAO.query();
	this.categories = categoryDAO.query();
	this.selectCategory = function (selectedCat) {
		this.products = categoryDAO.query({"cat": selectedCat});
	};
	this.allProducts = function (allPro) {
		this.products = allProductDAO.query({"all": allPro});
	};
});

/**controller for customer*/
app.controller('CustomerController', function (registerDAO, signInDAO, $sessionStorage, $window) {
	this.registerCustomer = function (customer) {
		registerDAO.save(null, customer);
		console.log(customer);
	};

	this.signInMessage = "Please sign in to continue.";

	let ctrl = this;
	this.signIn = function (userName, password) {
// get customer from web service
		signInDAO.get({'userName': userName},
// success
				  function (customer) {						 
// also store the retrieved custome
									 $sessionStorage.customer = customer;
// redirect to home
									 $window.window.location.href = '.';
								 },
				  function () {
					  ctrl.signInMessage = 'Sign in failed. Please try again.';
				  }

		);
	};
});

