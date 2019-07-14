
<!DOCTYPE html>
<html data-ng-app="Amcdisplay">
<head>

<title>AmcIntro</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('Amcdisplay', []);

	app.controller('AmcdisplayController', [ '$scope', '$http',
			function($scope, $http) {
				$scope.description, $scope.duration;
				$scope.amc = {

					"description" : '',
					"duration" : ''

				};

				$scope.getAllAmc = function() {
					var response = $http.get('/getAllAmcType');
					response.success(function(data, status, headers, config) {
						$scope.amcinfo = data;
						alert("Success:" + JSON.stringify({
							data : data
						}));
					});
					response.error(function(data, status, headers, config) {
						alert("Exception details: " + JSON.stringify({
							data : data
						}));
					});

				};

				$scope.getAllAmc();

			} ]);
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
					<div class="clearfix"></div>
				</div>
				<div class="top-header-right">
					<div class="down-top"></div>
					<div class="down-top top-down"></div>
					<!---->
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=" " /></a>
					</div>
					<div class="search">
						<input type="text" value="" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}"> <input
							type="submit" value="SEARCH">

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<div class="account">
						<a href="login.html"><span> </span>YOUR ACCOUNT</a>
					</div>
					<ul class="login">
						<li><a href="login.html"><span> </span>LOGIN</a></li>
						<li><a href="register.html">SIGNUP</a></li>
					</ul>
					<div class="cart">
						<a href="#"><span> </span>CART</a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<b>Annual Maintenance Contract</b>
	<br>
	<p>
		We always think that prevention is better than Cure, as we also
		believe that proper maintenance and Follow-up provides lowest down
		time in case of computer systems. We had noticed that most of the
		organization in IT industry is unable to provide sound after sales
		support, simply because of lack of concentration in the field of
		after-sales-support. <br> <br> We have full fledged after
		sales department. Headed by one of the trained staff of the
		organization. We have huge inventory of the spares, we are sure that
		will minimize your down time to great extent. Our teams of support
		engineers are always on alert to solve your problem irrelevant of
		Software or Hardware.
	</p>
	<br>
	<br>
	<br>
	<p>
		After long discussions with different groups of users, we have
		designed different packages for maintenance. We strongly recommend you
		to select plan, which suits you the most. <br> We at
		OnlineTronics realize that it is not easy and affordable for all
		business's / Society to staff a reliable and effective information
		technology department. Maintenance Contracts is most suitable to any
		small / medium-sized business / Society that does not require a full
		time technical support staff. With a Maintenance Agreement, you can
		afford the same support and technology expertise as a large
		corporation.<br> The Computer Hardware and Networking division of
		OnlineTronics Provides Computer AMC, Maintenance on Call Basis,
		Networking Support including Cable Laying etc. There are however,
		certain things that you must know about these contracts before you
		actually get into one. If you are concerned about repair and
		maintenance costs, we offer annual maintenance contracts (AMC). Our
		highly skilled engineers install, maintain and repair Windows-based
		PCs, Macintosh Computers, Laptop / Notebook, terminals, modems, and
		network connections. Certified technicians can make on-site repairs in
		departmental offices / Individuals, or you can bring your equipment to
		the workshop.
	</p>
	<br> We offer two types of Annual Maintenance Services (Computer
	AMC services):
	<br>

	<div class="tablecontainer" data-ng-controller="AmcdisplayController">
		<div ng-repeat="u in amcinfo"  ng-if="u.name=='Comprehensive'">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><span ng-bind="u.name"></span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><span ng-bind="u.descrption"></span></td>
                     </tr>
				<tr>
					<td><span ng-bind="u.duration"></span></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div ng-repeat="u in amcinfo" ng-if="u.name=='Non-comprehensive'" >
		<table class="table table-hover">
				<thead>
					<tr>
						<th><span ng-bind="u.name"></span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><span ng-bind="u.descrption"></span></td>
                     </tr>
				<tr>
					<td><span ng-bind="u.duration"></span></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<a href="form"><input type="button"
		value="Select Non-Comprehensive" /> </a>
	<br>
	<br> Comprehensive Annual Maintenance Contract
	<br> Comprehensive Computer AMC’s includes all parts (Here, you
	are not charged separately for the labour or for the parts replaced).
	<br>
	<ul>
		<li>12 months on site</li>
		<li>Including Labour + Spares</li>
		<li>Replacement of Spares, if available</li>
		<li>Routine preventive Maintenance</li>
		<li>Priority in Support</li>
		<li>Ideal for Serious user who think Time is Money</li>
	</ul>
	<a href="form"><input type="button" value="Select Comprehensive" /></a>


</body>
</html>