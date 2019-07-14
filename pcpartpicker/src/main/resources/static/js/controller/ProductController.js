'use strict';



App.controller('ProductController',[ '$scope', '$http','$state', function($scope, $http,$state) 
 {
	var self = this;
		self.list = [];
			self.headerText = 'Enter details of products into system:';
			self.proName,
			self.proPrice,
			self.proSpecific;
			
			self.product = {
					"productId"  : 0,
					"productName" : '',
					"productPrice" : '',
					"productSpecific" : '',					
					"brand"  : ''					
			};
			
			
			
			self.submit = function() 
			{
				var response = $http.post('createProduct',self.product);
				response.success(function(data, status, headers, config) {
					//self.list.push(data);
					//alert("Success");
				});
				response.error(function(data, status, headers, config) {
					self.getAllProduct();
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			
			};
			
			self.getAllBrand=function()
			{
				var response = $http.get('/getAllBrand1');
				response.success(function(data, status, headers, config) {
					self.brand=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			self.getAllBrand();	
			
			self.getAllProduct=function()
			{
				var response = $http.get('/getAllProduct1');
				response.success(function(data, status, headers, config) {
					self.listofproduct=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			self.getAllProduct();	
			
			
			self.deleteProduct=function(productId)
			{
				var response = $http.delete('/deleteProduct/'+productId);
				response.success(function(data, status, headers, config) {
					self.getAllProduct();
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			
			self.editProduct=function(product)
			{
				
				self.product=product;
			
			};
			
			self.getProductById=function(prodId)
			{
				$state.go('productDisplay',{productId:prodId});
				
				/*
				var response = $http.get('/getProductById/'+productId);
				response.success(function(data, status, headers, config) {
					alert( "Product" +
							" details: " + JSON.stringify({data: data}));
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
				*/
			}
			
			
			
			
			
			
			
			
			
		}]);
