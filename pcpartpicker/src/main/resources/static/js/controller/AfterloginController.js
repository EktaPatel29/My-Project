'use strict';


App.controller('AfterloginController',[ '$scope', '$http', function($scope, $http) 
{
    var self=this;	
    alert("Welcome to customer page:");
    //self.bidobj=$stateParams.bidobj;
    //alert("Bidder:"+JSON.stringify($stateParams.bidobj));
     
     
     var person = {
    		    UName: '' 
    		  };
     
    self.getUser=function()
	{
		alert("Inside getUser");
		var response = $http.get('/getUserName');
		response.success(function(data, status, headers, config) {
			self.user=data;
			alert( "Successfull: " + JSON.stringify({data: data}));
			
			self.UName=self.user.userName;
			alert("Name:"+self.UName);
			//self.insertUser(self.user);
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});
		
	}		
    self.getUser();
		
	}]);