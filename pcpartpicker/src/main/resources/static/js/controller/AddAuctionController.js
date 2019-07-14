'use strict';


		
 
App.controller('AddAuctionController',[ '$scope', '$http','Upload', function($scope, $http,Upload) 
{
    var self=this;	
		self.headerText = 'Form to add items for Auction:';
		self.ItemName,self.ItemPrice,self.Specifications,self.ItemCategory,self.ItemImage,self.ItemCondition,self.startDate,self.endDate;
		
		self.auctionitem={

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
		
		self.submit = function() 
		{
				
			/*var auctionitem = {

					
					"auctionItemName" : $scope.ItemName,
					"auctionItemPrice"  : $scope.ItemPrice,
					"category":$scope.ItemCategory,
					"spec":$scope.Specifications
					
			};*/			
			
			
			
			var response = $http.post('insertAuctionItem',self.auctionitem);
			response.success(function(data, status, headers, config) {
				//$scope.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				self.getAllAuctionItem();
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
			//Empty list data after process
		//	$scope.list = [];
			
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
		
		self.getAllAuctionItem=function()
		{
			var response = $http.get('/getAllAuctionItem');
			response.success(function(data, status, headers, config) {
				self.listofitems=data;
				alert( "Successfull: " + JSON.stringify({data: data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		self.getAllAuctionItem();
		
		self.deleteAuctionItemById=function(auctionItemId)
		{
			var response = $http.delete('deleteAuctionItem/'+auctionItemId);
			response.success(function(data, status, headers, config) {
				self.getAllAuctionItem();
				alert( "Successfull: " + JSON.stringify({data: data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
		}
		
		self.editAuctionItem=function(auctionitem)
		{
			self.auctionitem=auctionitem;
			
			alert(" "+JSON.stringify(self.auctionitem));
		};
		
		
		self.uploadFiles = function(file, errFiles) {
	        $scope.f = file;
	        $scope.errFile = errFiles && errFiles[0];
	        if (file) {
	            file.upload = Upload.upload({
	                url: '/saveFile',
	                data: {file: file,username:"abc"}
	            });

	            file.upload.then(function (response) {
	                $timeout(function () {
	                    file.result = response.data;
	                });
	            }, function (response) {
	                if (response.status > 0)
	                    $scope.errorMsg = response.status + ': ' + response.data;
	            }, function (evt) {
	                file.progress = Math.min(100, parseInt(100.0 * 
	                                         evt.loaded / evt.total));
	            });
	        }   
	    };
		
		
	}]);