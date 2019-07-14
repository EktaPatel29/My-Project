
<!DOCTYPE html>
<html data-ng-app="AmcformSubmit">
<head>
<meta charset="ISO-8859-1">
<title>AmcForm</title>

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
	var app = angular.module('AmcformSubmit', []);
	
	app.controller('AmcFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
		   
			$scope.headerText = 'Enter various details of amcform into system:';
			$scope.names = ["Desktop", "Laptop", "Printer"];
			$scope.cost = [2500,1000,2000];
			$scope.total;
			
			
			$scope.name,$scope.email,$scope.Toc,$scope.period,$scope.doc,$scope.doe,$scope.particular;
			
			$scope.amcF={
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
			$scope.submit = function() 
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
				
				var response = $http.post('createamcF',$scope.amcF);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					//$scope.getAllAmc();
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
				
				
				//Empty list data after process
				$scope.list = [];
				
			};
			
			$scope.calcost=function(item,quantity)
			{  
			 	if(item==="Desktop")
			 	{
			 		$scope.total=$scope.cost[0]*quantity;
			 		
			 	}
			 	alert($scope.total);
			 	
			};
			
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
	
	
	<form data-ng-submit="submit()" data-ng-controller="AmcFormSubmitController">
		<h3>{{headerText}}</h3>
		
		
		<p>Name: <input type="text" data-ng-model="$scope.name"></p>
		<p>Email: <input type="text" data-ng-model="$scope.email"></p>
		<p>Type Of Contract: <input type="text"  data-ng-model="$scope.Toc">
		 
		<p>Agreement Period: <input type="text" data-ng-model="$scope.period"></p>
		<p>Date Of Contract: <input type="text" data-ng-model="$scope.doc"></p>
		<p>Date Of Expiry: <input type="text" data-ng-model="$scope.doe"></p>
		
		<p>Product: 

		<select ng-model="selectedName" ng-options="x for x in names">
		</select></p>
		<p>Quantity: <input type="text" data-ng-model="$scope.quantity" ng-change="calcost(selectedName,$scope.quantity)"></p>
		<p>Cost: <input type="text" data-ng-model="total" ></p>
		
		
		<input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 <pre>Form data ={{list}}</pre>
	
	</form>
	
	

</body>
</html>