

<!DOCTYPE html>
<html data-ng-app="CategoryformSubmit">
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
	var app = angular.module('CategoryformSubmit', []);
	
	app.controller('CategoryFormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'Enter various details of categories into system:';
			$scope.catName;
			
			$scope.getAllCategory=function()
			{
				var response = $http.get('/getAllCategory1');
				response.success(function(data, status, headers, config) {
					$scope.listOfcategory=data;
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			$scope.category = {
					"categoryId":0,
					"categoryName" : ''	
			};
			
			$scope.submit = function() 
			{	
				
				var response = $http.post('createCat',$scope.category);
				response.success(function(data, status, headers, config) {

					$scope.list.push(data);									

				});
				response.error(function(data, status, headers, config) {
					$scope.getAllCategory();
					alert( "Exception details: " + JSON.stringify({data: data}));
				});	
			};
			
			
			$scope.deleteCategory=function(categoryId)
			{
				var response = $http.delete('deleteCategory/'+categoryId);
				response.success(function(data, status, headers, config) {
					$scope.getAllCategory();
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
			
			
			$scope.editCategory=function(category)
			{
				
				$scope.category=category;
			
			};
			
			
			
			
			$scope.getAllCategory();
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

	<form data-ng-submit="submit()" data-ng-controller="CategoryFormSubmitController">
		<h3>{{heading}}</h3>
		
		
		<p>Category Name: <input type="text" data-ng-model="category.categoryName"></p>
		
		<input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 <pre>Form data ={{list}}</pre>
		 
		 
		 <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in listOfcategory">

                              <td><span ng-bind="u.categoryId"></span></td>
                              <td><span ng-bind="u.categoryName"></span></td>
                              <td>
                              <button type="button" ng-click="editCategory(u)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="deleteCategory(u.categoryId)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
		 
		 
		 
		 
		 
		 
	</form>
</body>
</html>