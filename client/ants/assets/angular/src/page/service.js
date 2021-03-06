(function(angular) {
	var app = angular.module('issuer-serivce', []);
	var logger = Logger('issuerService')

	app.service('issuerService', function($http, $q) {
		return ({
			find: find,
			getAll: getAll
		})

		

		function find(id) {
			var url = config.service.page + "/" + id
			logger.info('Find issuer in server with ' + url)

			var request = $http({
				method : 'get',
				url : url,
				headers : {
					'Content-Type' : 'application/json; charset=utf8'
				}
			})
			
			return (request.then(handleSuccess, handleError));	
		}

		function getAll() {
			var url = config.service.page
			logger.info('Get all issuer in server in ' + url)

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

