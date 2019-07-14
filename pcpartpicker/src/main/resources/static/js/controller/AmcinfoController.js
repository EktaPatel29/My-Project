'use strict';

App.controller('AmcinfoController', [ '$scope', '$http',function($scope, $http) {
	
	var self = this;
			self.description, self.duration;
			self.amc = {

				"description" : '',
				"duration" : ''

			};

			self.getAllAmc = function() {
				var response = $http.get('/getAllAmcType');
				response.success(function(data, status, headers, config) {
					self.amcinfo = data;
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

			self.getAllAmc();

		} ]);