"use strict";

/*create application, and load used modules*/
var app = angular.module('ShoppingApp' , ['ngResource', 'ngStorage']);

/**factory for products*/
app.factory('productDAO', function ($resource){
	return $resource('/api/products/:id');
});

/**factory for category*/
app.factory('categoryDAO', function ($resource) {
	return $resource('/api/categories/:cat');
});

/**controller for product*/
app.controller('ProductController', function(productDAO, categoryDAO){
this.products = productDAO.query();
this.categories = categoryDAO.query();
this.selectCategory = function(selectedCat){
	this.products = categoryDAO.query({"cat": selectedCat});
};
});

/**factory for customer*/
app.factory('registerDAO', function (){
	return $resource('/api/register');
});

/**controller for customer*/
app.controller('CustomerController', function (registerDAO) {
	this.registerCustomer = function (customer) {
		alert("register customer");
		//registerDAO.save(null,customer);
		console.log(customer);
	};
});




