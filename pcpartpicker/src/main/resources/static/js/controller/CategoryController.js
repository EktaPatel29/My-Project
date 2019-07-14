'use strict';


App.controller('CategoryController',[ '$scope', '$http', function($scope, $http)
{
	var self = this;
	self.catName;
	
	self.getAllCategory=function()
	{
		var response = $http.get('/getAllCategory1');
		response.success(function(data, status, headers, config) {
			self.listOfcategory=data;
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
	};
	
	self.category = {
			"categoryId":0,
			"categoryName" : ''	
	};
	
	self.submit = function() 
	{	
		
		var response = $http.post('createCat',self.category);
		response.success(function(data, status, headers, config) {

		//	$scope.list.push(data);									

		});
		response.error(function(data, status, headers, config) {
			self.getAllCategory();
			alert( "Exception details: " + JSON.stringify({data: data}));
		});	
	};
	
	
	self.deleteCategory=function(categoryId)
	{
		var response = $http.delete('deleteCategory/'+categoryId);
		response.success(function(data, status, headers, config) {
			self.getAllCategory();
			
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
	};
	
	
	self.editCategory=function(category)
	{
		
		self.category=category;
	
	};
		
	self.getAllCategory();
}]);

                                                                                    
		
 
