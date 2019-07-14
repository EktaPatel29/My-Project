<!DOCTYPE html>
<html data-ng-app="BillingformSubmit">
<head>
<meta charset=ISO-8859-1>
<title>AngularJS Post Form Spring MVC example</title>
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

var app = angular.module('BillingformSubmit', []);

app.controller('BillingFormSubmitController',[ '$scope', '$http', function($scope, $http) {
		
	$scope.list = [];
		$scope.headerText = 'Enter bill information';
		$scope.quant,$scope.Rate,$scope.Per,$scope.amt,$scope.desc;
		
		$scope.submit = function() 
		{	
			var bill = {

					
					"quantity" : $scope.quant,
					"rate" : $scope.Rate,
					"per" : $scope.Per,
					"amount" : $scope.amt,
					"description": $scope.desc
					
			};
			var response = $http.post('createBill',bill);
			response.success(function(data, status, headers, config) {
				$scope.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				$scope.getAllBills();
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
				
		};
		
		$scope.getAllBills=function()
		{
			var response = $http.get('/getAllBills');
			response.success(function(data, status, headers, config) {
				$scope.listofbills=data;
				alert("Successful!! " +JSON.stringify({data: data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		$scope.getAllBills();
		
		
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
								<li><a href="login.html"><span> </span>LOGIN</a></li> |
								<li ><a href="register.html">SIGNUP</a></li>
							</ul>
						<div class="cart"><a href="#"><span> </span>CART</a></div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
 


		
	
<form data-ng-submit="submit()" data-ng-controller="BillingFormSubmitController">
<h3>{{headerText}}</h3>


<p> Quantity <input type="number" data-ng-model="quant"> </p>
<br><br>
<p> Rate: <input type="text" data-ng-model="Rate"> </p> 
<br><br>
<p> Per: <input type="text" data-ng-model="Per"></p>
<br><br>
<p> Amount: <input type="number" data-ng-model="amt"></p>
<br><br>
<p> Description: <input type="text" data-ng-model="desc"> </p>
<br><br>
<input type="submit" id="submit" value="Submit">

<h4>You submitted below data through post:</h4>
	<pre>Form data ={{list}}</pre>
	
	
  	<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Bills </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Address</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in listofbills">
                              <td><span ng-bind="u.Id"></span></td>
                              <td><span ng-bind="u.quantity"></span></td>
                              <td><span ng-bind="u.rate"></span></td>
                              <td><span ng-bind="u.per"></span></td>
                              <td><span ng-bind="u.amount"></span></td>
                              <td><span ng-bind="u.description"></span></td>
                              <td>
                              <button type="button" ng-click="edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>   
		 </form>
</body>
</html>
	
	