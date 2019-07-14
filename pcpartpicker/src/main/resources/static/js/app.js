'use strict';

var App = angular.module('myApp',['ui.router']);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	
	
	$stateProvider
	.state('category', {
		url: "/category",
		templateUrl: '/template/Category.html',
		controller : "CategoryController as catCtrl",
		params: {
			Typeofcontract:"Comprehensive"
	        
	    }
		})
		
	.state('brand', {
		url: "/brand",
		templateUrl: '/template/brand.html',
		controller : "BrandController as brandCtrl"
		})
		
		.state('amclist', {
		url: "/amcList",
		templateUrl: '/template/amclist.html',
		controller : "AmclistController as amclistCtrl"
		})
		
		.state('amcform', {
		url: "/amcForm",
		templateUrl: '/template/amcform.html',
		controller : "AmcformController as amcformCtrl"
			
		})
		
		.state('amcinfo', {
		url: "/amcInfo",
		templateUrl: '/template/amcinfo.html',
		controller : "AmcinfoController as amcinfoCtrl",
		 params: {
		       
			 Typeofcontract: "Comprehensive"
		    }
			
		})
		
		.state('buyer', {
		url: "/buyer",
		templateUrl: '/template/buyer.html',
		controller : "BuyController as buyCtrl"
		})
		
		.state('login', {
		url: "/login",
		templateUrl: '/template/login.html'
		
		})

}]);