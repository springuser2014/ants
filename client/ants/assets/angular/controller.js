(function() {
	var app = angular.module('root-controller', [])
	.controller('RootController', ['$scope', 
		function($scope) {
			$scope.languageBundle = englishBundle
		}])
	.controller('PageRootController', [ '$scope', '$routeParams',
		function($scope, $routeParams) {
			var logger = Logger('PageRootController')
			logger.info("Welcome to Page Management")
			$scope.initValue = {
				title: "Page Management",
				variablePath: [
					{
						value: "page",
						url: ""
					}
				]
			}
		} ])
	.controller('LogRootController', [ '$scope', '$routeParams',
		function($scope, $routeParams) {
			var logger = Logger('LogRootController')
			logger.info("Welcome to Log Management")
			logger.showObject($routeParams)

			$scope.initValue = {
				title: "Log Management",
				variablePath: [
					{
						value: "page",
						url: "/page"
					},
					{
						value: "log",
						url: ""
					}
				]
			}
		} ])
})();
