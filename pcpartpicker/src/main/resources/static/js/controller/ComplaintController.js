'use strict';
App.controller('ComplaintController', [ '$scope', '$http',
		function($scope, $http) {

			var self = this;

			// self.Typeofcontract=$stateParams.Typeofcontract;

			self.comp = {
				"name=" : '',
				"area" : '',
				"phone" : '',
				"complaintDate" : '',
				"productGroup" : '',
				"deliveryDate" : '',
				"product" : '',
				"problemDescription" : ''

			};

			self.submit = function() {

				var response = $http.post('createComplaint', self.comp);
				response.success(function(data, status, headers, config) {
					self.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					// $scope.getAllAmc();
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});

				// Empty list data after process

			};
			
			 $scope.master = {};

		      $scope.update = function(user) {
		        $scope.master = angular.copy(user);
		      };

		      $scope.reset = function() {
		        $scope.user = angular.copy($scope.master);
		      };

		      $scope.reset();

		} ]);