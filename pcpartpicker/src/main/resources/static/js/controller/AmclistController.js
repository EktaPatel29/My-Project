'use strict';



                                                                                    
		
 
App.controller('AmclistController',[ '$scope', '$http', function($scope, $http) {
	
	var self=this;
	
		self.description,self.name,self.duration;
		
		self.amc={
                 "type_id=":0,
                 "name":'',
				"description":'',
				
				"duration" :''

		};
		self.submit = function() 
		{	
			/*var amcL = {

					
					"description" : $scope.desc,
					"cost" : $scope.cost,
					"duration" : $scope.duration
					
			};*/
			
			var response = $http.post('createamcL',self.amc);
			response.success(function(data, status, headers, config) {
				self.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				self.getAllAmc();
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
			
			
			//Empty list data after process
		//	$scope.list = [];
			
		};
		
		self.getAllAmc=function()
		{
			var response = $http.get('/getAllAmcType');
			response.success(function(data, status, headers, config) {
				self.amclist=data;
				alert("Success:"+JSON.stringify({data:data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
		self.deleteAmc=function(type_id)
		{
			var response = $http.delete('deleteAmc/'+type_id);
			response.success(function(data, status, headers, config) {
				self.getAllAmc();
				
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		
	self.editAmc=function(amc)
		{
			
			self.amc=amc;
		
		};
		
		
		
		
		self.getAllAmc();
		
		
		
	}]);