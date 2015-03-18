(function(angular) {
	var app = angular.module('transaction-serivce', []);
	var logger = Logger('transactionService')

	app.service('transactionService', function($http, $q) {
		return ({
			getAll: getAll

		})
		

		function getAll(issuerId) {
			var url = passParameter('pageId',issuerId,config.service.log) 

			logger.info('Get all issuer in server with URI ' + url)

			var request = $http({
				method : 'get',
				url : url
			})

			return (request.then(handleSuccess, handleError));	
		}

		function handleError(response) {
			logger.info('It has a exception')
			logger.showObject(response)
			if (!angular.isObject(response.data) || !response.data.message) {
				return ($q.reject("An unknown error occurred."));
			}
			return ($q.reject(response.data.message));
		}
		function handleSuccess(response) {
			logger.info('Submit to server successful. Response data is')
			logger.showObject(response.data)
			return response.data
		}
	})
})(window.angular);

