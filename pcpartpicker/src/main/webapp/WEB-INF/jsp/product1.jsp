<!DOCTYPE html>
<html data-ng-app="productformSubmit">
<head>
<meta charset="ISO-8859-1">
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
	var app = angular.module('productformSubmit', []);
	
	app.controller('ProductFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Enter details of products into system:';
			$scope.proName,
			$scope.proPrice,
			$scope.proSpecific;
			
			var product = {
					"productId"  : 0,
					"productName" : '',
					"productPrice" : '',
					"productSpecific" : '',					
					"brand"  : ''					
			};
			
			
			
			$scope.submit = function() 
			{
				var response = $http.post('createProduct',$scope.product);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
					//alert("Success");
				});
				response.error(function(data, status, headers, config) {
					$scope.getAllProduct();
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
			
			$scope.getAllProduct=function()
			{
				var response = $http.get('/getAllProduct1');
				response.success(function(data, status, headers, config) {
					$scope.listofproduct=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			$scope.getAllProduct();	
			
			
			$scope.deleteProduct=function(productId)
			{
				var response = $http.delete('/deleteProduct/'+productId);
				response.success(function(data, status, headers, config) {
					$scope.getAllProduct();
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			
			$scope.editProduct=function(product)
			{
				
				$scope.product=product;
			
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

	<form data-ng-submit="submit()" data-ng-controller="ProductFormSubmitController">
		<h3>{{headerText}}</h3>
		
				
		<p>Product Name: <input type="text" data-ng-model="product.productName"></p>
		<p>Product Price: <input type="text" data-ng-model="product.productPrice"></p>
		<p>Product Specifications: <input type="text" data-ng-model="product.productSpecific"></p>
		
		Select Brand : <select ng-model="product.brand" ng-options="x.brandName for x in brand">
						</select>
		
	    <input type="submit" id="submit" value="Submit" /><br>	
	    
	    
	     <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Price</th>
                              <th>Specifications</th> 
                              <th>Brand</th>                            
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in listofproduct">

                              <td><span ng-bind="u.productId"></span></td>
                              <td><span ng-bind="u.productName"></span></td>
                               <td><span ng-bind="u.productPrice"></span></td>
                                <td><span ng-bind="u.productSpecific"></span></td>
                                <td><span ng-bind="u.brand.brandName"></span></td>
                                <td>
                                <button type="button" ng-click="editProduct(u)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="deleteProduct(u.productId)" class="btn btn-danger custom-width">Remove</button>
                                </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
		
		
	</form>
</body>
</html>