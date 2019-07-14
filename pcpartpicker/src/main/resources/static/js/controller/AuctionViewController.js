

'use strict';

App.controller('AuctionViewController',[ '$scope', '$http','$state','$stateParams', function($scope, $http,$state,$stateParams)
 {
	    var self=this;		
	    self.ItemName,self.ItemPrice,self.Specifications,self.ItemCategory,self.ItemImage;
				
			

	              self.auctionitem=
	              {

							"auctionItemId" : 0,
							"auctionItemName" : '' ,
							"auctionItemPrice": '',
							"category": null,
							"spec":'',
							"auctionItemCondition":'',
							"auctionItemImage":null,
							"startDate":null,
							"endDate":null
					};	
						
	    self.getAllCategory=function()
		{
			var response = $http.get('/getAllCategory1');
			response.success(function(data, status, headers, config) {
				self.category=data;
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		self.getAllCategory();
			
		    self.displayItemById=function(category)
			{
				var response = $http.get('getItemById/'+category.categoryId);
				response.success(function(data, status, headers, config) {
					self.listofitems=data;
					alert(JSON.stringify(self.listofitems));
					//alert( "Successfull: " + JSON.stringify({data: data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});				
			};
			
			self.getBidCount=function(auctionItemId)
			{
				var response = $http.get('getBidCount/'+auctionItemId);
				response.success(function(data, status, headers, config) {
					self.bidCount=data;
					alert( "Successfull: " + JSON.stringify({data: data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
			};
			
			self.getBidCount(self.auctionitem.auctionItemId);
			
			self.displayByAuctionId=function(auctionItemId,auctionItemPrice)
			{
				alert("ID:"+auctionItemId);
				$state.go('bidder',{'prodId':auctionItemId,'price':auctionItemPrice});
				/*var response = $http.get('getAuctionItemById/'+auctionItemId);
				response.success(function(data, status, headers, config) {
					self.listofitems=data;
					alert( "Successfull: " + JSON.stringify({data: data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});*/
			};
			
			
			
		}]);