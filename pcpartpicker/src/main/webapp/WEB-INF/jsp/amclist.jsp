
<!DOCTYPE html>
<html data-ng-app="AmcListformSubmit">
<head>
<meta charset="ISO-8859-1">
<title>AmcList</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js/jquery.min.js"></script>
<!--script-->
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('AmcListformSubmit', []);
	
	app.controller('AmcListFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Enter various details of amclist into system:';
			$scope.description,$scope.name,$scope.duration;
			
			$scope.amc={
                     "type_id=":0,
                     "name":'',
					"description":'',
					
					"duration" :''

			};
			$scope.submit = function() 
			{	
				/*var amcL = {

						
						"description" : $scope.desc,
						"cost" : $scope.cost,
						"duration" : $scope.duration
						
				};*/
				
				var response = $http.post('createamcL',$scope.amc);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					$scope.getAllAmc();
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
				
				
				//Empty list data after process
			//	$scope.list = [];
				
			};
			
			$scope.getAllAmc=function()
			{
				var response = $http.get('/getAllAmcType');
				response.success(function(data, status, headers, config) {
					$scope.amclist=data;
					alert("Success:"+JSON.stringify({data:data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			$scope.deleteAmc=function(type_id)
			{
				var response = $http.delete('deleteAmc/'+type_id);
				response.success(function(data, status, headers, config) {
					$scope.getAllAmc();
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			$scope.editAmc=function(amc)
			{
				
				$scope.amc=amc;
			
			};
			
			
			
			
			$scope.getAllAmc();
			
			
			
		}]);
</script>
</head>
<body>

<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<ul class="support">
						
					</ul>
					<ul class="support">
						
					</ul>
					<div class="clearfix"> </div>
				</div>
				<div class="top-header-right">
				 <div class="down-top">		
						  
					 </div>
					<div class="down-top top-down">
						  
					 </div>
					 <!---->
					<div class="clearfix"> </div>	
				</div>
				<div class="clearfix"> </div>		
			</div>
		</div>

<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=" " /></a>
					</div>
					<div class="search">
						<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
						<input type="submit"  value="SEARCH">

					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="header-bottom-right">					
						<div class="account"><a href="login.html"><span> </span>YOUR ACCOUNT</a></div>
							<ul class="login">
								<li><a href="login.html"><span> </span>LOGIN</a></li>
								<li ><a href="register.html">SIGNUP</a></li>
							</ul>
						<div class="cart"><a href="#"><span> </span>CART</a></div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	
	
	<form data-ng-submit="submit()" data-ng-controller="AmcListFormSubmitController">
		<h3>{{headerText}}</h3>
		
		
		<p>Name: <input type="text" data-ng-model="amc.name"></p>
		<p>Description: <input type="text" data-ng-model="amc.description"></p>
		<p>Duration: <input type="text" data-ng-model="amc.duration"></p>
		
		<input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 <pre>Form data ={{list}}</pre>
	
	
	
	<div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>NAME</th>
                              <th>DESCRIPTION</th>
                              
                              <th>DURATION</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in amclist">
                              
                              <td><span ng-bind="u.type_id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              
                              <td><span ng-bind="u.descrption"></span></td>
                              <td><span ng-bind="u.duration"></span></td>
                              <td>
                              <button type="button" ng-click="editAmc(u)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="deleteAmc(u.type_id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
                  </div>
                  

</body>
</html>