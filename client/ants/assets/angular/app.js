/**
 * 
 */
(function(angular) {
	var app = angular.module('ThincaServer', [ 'ngRoute', 'root-controller', 'issuer-controller', 'transaction-controller','ui.bootstrap.datetimepicker']);
	
	app.config(function($routeProvider, $locationProvider) {
		$routeProvider
		.when("/issuer", {
			templateUrl : config.directive.issuer.layout,
			controller : 'PageRootController'
		})
		.when("/page/:pageId", {
			templateUrl: config.directive.transaction.layout,
			controller: 'LogRootController'

		})
		.otherwise({
        	templateUrl : config.directive.issuer.layout,
			controller : 'PageRootController'
      	});

		$locationProvider.html5Mode( 
			{ 
				enabled: true,
  				requireBase: false
  			});
	})
	.directive('headerPage', function() {
		return {
			restrict : 'AEC',
			templateUrl : config.directive.main.headerPage
		}
	});
})(window.angular);