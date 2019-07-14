'use strict';


App.controller('BrandController',[ '$scope', '$http', function($scope, $http)
{
	
	var self=this;
	
	$scope.list = [];
	$scope.headerText = 'Enter details of brands into system:';
	$scope.brandName;
	
	
	
	self.brand = {
			"brandId":0,
			"brandName" : '',
			"category" : ''
	};
	
	
	self.submit = function() 
	{	
		
		var response = $http.post('createBrand',$scope.brand);
		response.success(function(data, status, headers, config) {

			$scope.list.push(data);									

		});
		response.error(function(data, status, headers, config) {
			self.getAllBrand();
			alert( "Exception details: " + JSON.stringify({data: data}));
		});	
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
	
	
	self.getAllBrand=function()
	{
		var response = $http.get('/getAllBrand1');
		response.success(function(data, status, headers, config) {
			$scope.listofbrand=data;
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
	};
	self.getAllBrand();
	
		
		
		self.deleteBrand=function(brandId)
		{
			var response = $http.delete('/deleteBrand/'+brandId);
			response.success(function(data, status, headers, config) {
				$scope.getAllBrand();
				
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
		
		self.editBrand=function(brand)
		{
			
			$scope.brand=brand;
		
		};
		
		
}]);

                                                                                    
		
 
