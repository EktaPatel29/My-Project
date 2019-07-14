'use strict';



                                                                                    
		
 
App.controller('AmcrequestController',[ '$scope', '$http', function($scope, $http) {
	
	var self=this;
	
	self.amcF = {
			"name=" : '',
			"email" : '',
			"typeofcontract" : '' ,
			"period" : '',
			"dateofcontract" : '',
			"dateofexpiry" : '',
			"product" : '',
			"quantity" : '',
			"cost" : ''

		};
		
		
		
		self.getAllAmc=function()
		{
			var response = $http.get('/getAllAmcRequest');
			response.success(function(data, status, headers, config) {
				self.amcrequest=data;
				alert("Success:"+JSON.stringify({data:data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
		self.deleteAmc=function(type_id)
		{
			var response = $http.delete('deleteAmcRequest/'+type_id);
			response.success(function(data, status, headers, config) {
				self.getAllAmc();
				
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
	/*	self.editAmc=function(amc)
		{
			
			self.amc=amc;
		
		};*/
		
		
		
		
		self.getAllAmc();
		/*self.accept=function()
		{
			var response = $http.get('/acceptAmcRequest');
			response.success(function(data, status, headers, config) {
				//self.amcrequest=data;
				alert("Success:"+JSON.stringify({data:data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};*/
		
		self.accept = function() {
			
			var response = $http.post('acceptAmcRequest', self.amcF);
			response.success(function(data, status, headers, config) {
				self.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				// $scope.getAllAmc();
				alert("Exception details: " + JSON.stringify({
					data : data
				}));
			});
		
		};
	}]);