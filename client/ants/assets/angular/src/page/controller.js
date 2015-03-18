
(function(angular) {
	var app = angular.module('issuer-controller', ['issuer-serivce', 'issuer-directive']);
	
	app.controller('ColectionIssuerController', ['$scope', 'issuerService',
		function($scope, issuerService){

			var controller = this,
			logger = Logger('ColectionIssuerController')


			$scope.refreshView = function() {
				logger.info('Refresh element in view')

				var getAllIssuerRequest = issuerService.getAll()

				getAllIssuerRequest.then(function(theListIssuers) {
					$scope.colectionIssuers = theListIssuers
				})

				getAllIssuerRequest.catch(function(data) {

				})
			}

			logger.info('Welcome!!!')
			$scope.refreshView()
		}])
})(window.angular);

