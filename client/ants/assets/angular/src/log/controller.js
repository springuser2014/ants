
(function(angular) {
	var numberElementPerPage = 1;
	var app = angular.module('transaction-controller', ['transaction-serivce', 'transaction-directive', 'issuer-serivce'])
	
	.controller('ColectionTransactionController', ['$scope', '$routeParams', 'transactionService',
		function($scope, $routeParams, transactionService){
			var controller = this

			this.refreshView = function(pageId) {
				transactionService.getAll(pageId).then(function(data) {
					$scope.colectionTransaction  =  data
				})
			}
			console.log($routeParams)
			this.refreshView($routeParams.pageId)
			
		}])
})(window.angular);

