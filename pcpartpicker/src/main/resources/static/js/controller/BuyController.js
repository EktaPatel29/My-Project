'use strict'

App.controller('BuyController',[ '$scope', '$http', function($scope, $http) {
		var self=this;

		self.buyerName,self.productName,self.amount,self.quantity;
		
		
		self.getAllBuyer=function()
		{
			var response = $http.get('/getAllBuyer');
			response.success(function(data, status, headers, config) {
				self.listofbuyers=data;
				alert("Successful!! " +JSON.stringify({data: data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
		
		self.buyer = {

				"buyerId": 0,
				"buyerName" :'' ,
				"productName" : '',
				"amount" : '',
				"quantity" : '' 
				
				
		};
		

		self.submit = function() 
		{	
			
			var response = $http.post('createBuy',self.buyer);
			response.success(function(data, status, headers, config) {
				self.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				self.getAllBuyer();
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
				
		};
		
		
		
		self.deleteBuyer=function(buyerId)
		{
			var response = $http.delete('deleteBuyer/'+buyerId);
			response.success(function(data, status, headers, config) {
				self.getAllBuyer();
				
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
		self.editBuyer=function(buyer)
		{
			
			self.buyer=buyer;
		
		};	
		self.getAllBuyer();
		
	}]);
