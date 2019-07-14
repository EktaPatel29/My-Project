'use strict';


                                                          
		
 
App.controller('AmcformController',[ '$scope', '$http', function($scope, $http) {
	
	var self=this;
	
	App.controller('amcinfoCtrl', function ($stateParams, $scope) {       
	   
	    $.scope.Typeofcontract = $stateParams.Typeofcontract;
	});
	   
	self.headerText = 'Enter various details of amcform into system:';
	self.names = ["Desktop", "Laptop", "Printer"];
	self.cost = [2500,1000,2000];
	self.total;
	
	
	
	self.amcF={
            "name=":'',
			"email":'',
			"Typeofcontract" :'Comprehensive',
			"period" : '',
			"dateofcontract" : '',
			"dateofexpiry" : '',		
			"product" :'',
			"quantity":'',
			"cost":''
			
	};
	self.submit = function() 
	{	
		/*var amcF = {

				
				"name" : $scope.name,
				"email" : $scope.email,
				"Typeofcontract" : $scope.Toc,
				"period" : $scope.period,
				"dateofcontract" : $scope.doc,
				"dateofexpiry" : $scope.doe,		
				"particular" : $scope.particular
				
		};*/
		
		var response = $http.post('createamcF',self.amcF);
		response.success(function(data, status, headers, config) {
			self.list.push(data);
		});
		response.error(function(data, status, headers, config) {
			//$scope.getAllAmc();
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
		
		
		//Empty list data after process
	
		
	};
	
	self.calcost=function(item,quantity)
	{  
		alert("calculate cost");
	 	if(item==="Desktop")
	 	{
	 		alert("cal"+JSON.stringify(self.total=self.cost[0]*quantity));
	 		
	 	}
	 	alert(self.total);
	 	
	};
		
	}]);