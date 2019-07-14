<!DOCTYPE html>
<html data-ng-app="productformSubmit">
<head>
<meta charset="ISO-8859-1">
<title>AngularJS Post Form Spring MVC example</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('productformSubmit', []);
	
	app.controller('productFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Enter details of products into system:';
			$scope.proName,$scope.proPrice,$scope.proSpecific,
			$scope.selectedBrand;
			
			$scope.submit = function() 
			{
					
				var product = {

						
						"productName" : $scope.proName,
						"productPrice" : $scope.proPrice,
						"productSpecific" : $scope.proSpecific						
						"brand"  : $scope.selectedBrand
						
				};			
				
				console.log("+"+JSON.stringify(brand));
				
				var response = $http.post('createProduct',product);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			
			};
			
			$scope.getAllBrand=function()
			{
				var response = $http.get('/getAllBrand1');
				response.success(function(data, status, headers, config) {
					$scope.brand=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			$scope.getAllBrand();	
			
			
		}]);
</script>
</head>
<body>
	<form data-ng-submit="submit()" data-ng-controller="productFormSubmitController">
		<h3>{{headerText}}</h3>
		
		
		<p>Product Name: <input type="text" data-ng-model="proName"></p>
		<p>Product Price: <input type="text" data-ng-model="proPrice"></p>
		<p>Product Specifications: <input type="text" data-ng-model="proSpecific"></p>
		
		Select Brand : <select ng-model="selectedBrand" ng-options="x.brandName for x in brand">
						</select>
		
	    <input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 Form data ={{list}}
	</form>
</body>
</html>