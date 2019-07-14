<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>AngularJS Post Form Spring MVC example</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('formSubmit', []);
	
	app.controller('FormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Registrartion for user: Submit below form';
			$scope.userId,$scope.userName,$scope.email,$scope.password,$scope.enabled;
			
			$scope.submit = function() {
				
				var formData = {
						"userId" : $scope.userId,
						"userName" : $scope.userName,
						"email" : $scope.email,
						"password":$scope.password,
						"enabled":$scope.enabled
				};
				
				var response = $http.post('PostFormData', formData);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
				//Empty list data after process
			//	$scope.list = [];
				
			};
		}]);
</script>
</head>
<body>
	<form data-ng-submit="submit()" data-ng-controller="FormSubmitController">
		<h3>{{headerText}}</h3>
		<p>User Id: <input type="text" data-ng-model="userId"></p>
		<p>User Name: <input type="text" data-ng-model="userName"></p>
		<p>Email: <input type="text" data-ng-model="email"></p>
		<p>Password: <input type="password" data-ng-model="password"></p>
		<p>Enabled<input type="text" data-ng-model="enabled"></p>
		<input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 <pre>Form data ={{list}}</pre>
	</form>
</body>
</html>
