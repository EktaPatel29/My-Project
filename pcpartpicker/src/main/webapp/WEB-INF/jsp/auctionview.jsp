
<!DOCTYPE html>
<html data-ng-app="auctionview">
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
	var app = angular.module('auctionview', []);
	
	app.controller('AuctionViewController',[ '$scope', '$http', function($scope, $http) {
		
		$scope.ItemName,$scope.ItemPrice,$scope.Specifications,$scope.ItemCategory,$scope.ItemImage;
				
			

					$scope.auctionitem={

							"auctionItemId" : 0,
							"auctionItemName" : '' ,
							"auctionItemPrice": '',
							"category": null,
							"spec":'',
							"auctionItemImage":null
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
			
			$scope.displayItemById=function(category)
			{
				var response = $http.get('getItemById/'+category.categoryId);
				response.success(function(data, status, headers, config) {
					$scope.listofitems=data;
					alert(JSON.stringify($scope.listofitems));
					//alert( "Successfull: " + JSON.stringify({data: data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});				
			};
			
			$scope.displayByAuctionId=function(auctionItemId)
			{
				var response = $http.get('getAuctionItemById/'+auctionItemId);
				response.success(function(data, status, headers, config) {
					$scope.listofitems=data;
					alert( "Successfull: " + JSON.stringify({data: data}));
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
			}
			
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
	
	<form data-ng-controller="AuctionViewController">
	
	<div class="sub-cate">
                <div  class=" top-nav rsidebar span_1_of_left"">
                    <h3 class="cate">CATEGORIES</h3>
          <ul class="menu" data-ng-repeat="u in category">
        <li class="item1" ng-click="displayItemById(u)"><a href="#">{{u.categoryName}}</a>
        		
			
        </li>       
    </ul>
    </div>
    
   
    
                    </div>
                   
                    
              
          
                   
<script type="text/javascript">
            /*$(function() {
                var menu_ul = $('.menu > li > ul'),
                       menu_select  = $('.menu > li > select');
                menu_ul.hide();
                menu_a.click(function(e) {
                    e.preventDefault();
                    if(!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true,true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true,true).slideUp('normal');
                    }
                });
            
            });*/
        </script>
        
        
 <div class="grid-product"  ng-repeat="u in listofitems">
		  <div class="product-grid"  >
			<div class="content_box" >
			   	<div class="left-grid-view grid-view-left" >
			   	              <p><span ng-bind="u.auctionItemImage"></span></p>
			   	              <div class="mask">
	                        <div class="info">Quick View</div>
			                </div>
                              <p><span ng-bind="u.auctionItemName"></span></p>
                              <p><span ng-bind="u.auctionItemPrice"></span></p>
                              
                              <p>
                              <button  type="button"  class="btn btn-success custom-width" ng-click="displayByAuctionId(u.auctionItemId)" class="btn btn-success custom-width">Bid</button>
                              </p>
                              	
			            </div>
                           
				</div>
				    
				     
			   	</div>
              </div>
			 </div>
			<div class="clearfix"> </div>

</form>
     

</body>
</html>