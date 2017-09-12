"use strict";

/*create application, and load used modules*/
var app = angular.module('ShoppingApp' , ['ngResource', 'ngStorage']);

app.factory('productDAO', function ($resource){
	return $resource('/api/products/:id');
});

app.controller('ProductController', function(productDAO){
this.products = productDAO.query();
});




