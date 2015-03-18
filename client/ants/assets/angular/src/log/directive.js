(function(angular) {
	var transactionDirective = angular.module('transaction-directive', [])
	.directive('transactionTable', function() {
		return {
			restrict : 'AEC',
			templateUrl : config.directive.transaction.table
		}
	})
})(window.angular);