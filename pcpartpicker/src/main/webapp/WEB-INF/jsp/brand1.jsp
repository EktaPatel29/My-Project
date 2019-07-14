<!DOCTYPE html>
<html data-ng-app="brandformSubmit">
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
	var app = angular.module('brandformSubmit', []);
	
	app.controller('BrandFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Enter details of brands into system:';
			$scope.brandName,
			$scope.selectedCategory;		
			
			
			$scope.submit = function() 
			{
					
				var brand = {

						
						"brandName" : $scope.brandName,
						"category"  : $scope.selectedCategory
						
				};			
				
				//console.log("+"+JSON.stringify(brand));
				
				var response = $http.post('createBrand',brand);
				response.success(function(data, status, headers, config) {
					
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					
					$scope.getAllBrand();
					//alert( "Exception details: " + JSON.stringify({data: data}));
				});				
				
			};	
			
			
			
			
			$scope.getAllCategory=function()
			{
				var response = $http.get('/getAllCategory1');
				response.success(function(data, status, headers, config) {
					$scope.category=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			$scope.getAllCategory();
			
			
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
			
			
			/*
			$scope.deleteBrandById=function(brandId)
			{
				var response = $http.delete('deleteBrand/'+brandId);
				response.success(function(data, status, headers, config) {
					
				});
				response.error(function(data, status, headers, config) {
					$scope.getAllBrand();
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			*/
			
			
			
			
			
			
			
			
			
			
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
	
	<form data-ng-submit="submit()" data-ng-controller="BrandFormSubmitController">
		<h3>{{headerText}}</h3>	
		
		
		<p>Brand Name: <input type="text" data-ng-model="brandName"></p>
		
		Enter Category :<select ng-model="selectedCategory" ng-options="x.categoryName for x in category">
						</select>
		
		
				<input type="submit" id="submit" value="Submit" /><br>	
				
				
				 <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Category</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in brand">

                              <td><span ng-bind="u.brandId"></span></td>
                              <td><span ng-bind="u.brandName"></span></td>
                              <td><span ng-bind="u.category.categoryName"></span></td>
                              <!-- td>   
                               <button type="button" ng-click="deleteBrandById(u.brandId)" class="btn btn-danger custom-width">Remove</button>
                              </td-->
                          </tr>
                      </tbody>
                  </table>
              </div>
		
		
	</form>
</body>
</html>