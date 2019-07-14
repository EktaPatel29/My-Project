
<!DOCTYPE html>
<html data-ng-app="BuyerformSubmit">
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

var app = angular.module('BuyerformSubmit', []);

app.controller('BuyerFormSubmitController',[ '$scope', '$http', function($scope, $http) {
		
	$scope.list = [];
		$scope.headerText = 'Enter buyer information';
		$scope.buyer_name,$scope.product_name,$scope.amt,$scope.quant;
		
		$scope.submit = function() 
		{	
			var buy = {

					
					"buyerName" : $scope.buyer_name,
					"productName" : $scope.product_name,
					"amount" : $scope.amt,
					"quantity" : $scope.quant
					
					
			};
			
			var response = $http.post('createBuy',buy);
			response.success(function(data, status, headers, config) {
				$scope.list.push(data);
			});
			response.error(function(data, status, headers, config) {
				$scope.getAllBuyer();
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
				
		};
		
		
		$scope.getAllBuyer=function()
		{
			var response = $http.get('/getAllBuyer');
			response.success(function(data, status, headers, config) {
				$scope.listofbuyers=data;
				alert("Successful!! " +JSON.stringify({data: data}));
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			
		};
		$scope.getAllBuyer();		
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
 


<form data-ng-submit="submit()" data-ng-controller="BuyerFormSubmitController">
<h3>{{headerText}}</h3>


<p> Name: <input type="text" data-ng-model="buyer_name"> </p>
<br><br>
<p> Product Name: <input type="text" data-ng-model="product_name"> </p> 
<br><br>
<p> Amount: <input type="number" data-ng-model="amt"></p>
<br><br>
<p> Quantity:<input type="number" data-ng-model="quant"> </p>
<br><br>
<input type="submit" id="submit" value="Submit">

<h4>You submitted below data through post:</h4>
<pre>Form data ={{list}}</pre>
	
	
	<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Buyers </span></div>
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
                          <tr ng-repeat="u in listofbuyers">
                              <td><span ng-bind="u.buyerId"></span></td>
                              <td><span ng-bind="u.buyerName"></span></td>
                              <td><span ng-bind="u.productName"></span></td>
                              <td><span ng-bind="u.amount"></span></td>
                              <td><span ng-bind="u.quantity"></span></td>
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