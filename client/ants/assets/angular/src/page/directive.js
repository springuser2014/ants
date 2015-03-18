(function(angular) {
	var app = angular.module('issuer-directive', []);
	
	app.directive('pageTable', function() {
		return {
			restrict : 'AEC',
			templateUrl : config.directive.issuer.table
		}
	});
})(window.angular);