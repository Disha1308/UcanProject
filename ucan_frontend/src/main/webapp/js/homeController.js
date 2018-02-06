myApp.controller('home',function($scope, $rootScope, $http, $q, $location){
	//binding global userId variable to id
	$scope.id = $rootScope.userId;
	$scope.topics_flag = false;
	$scope.topicsSubscribed = [];
	var deferred = $q.defer();
	var url = "http://localhost:8080/v1.0/users/"+$scope.id+"/topics";
	
	$http.get(url)
	.success(function(api_response)
	{
		deferred.resolve(api_response);
	})
	.error(function(api_response)
	{
		$scope.msg = "No such User/Error in js";
		deferred.reject(api_response);
	});
	
	deferred.promise.then(function(api_topics_reponse)
	{
		$scope.length = api_topics_reponse.length
		if($scope.length === 0)
		{
			$scope.topics_flag = false;
		}
		else
		{
			$scope.topics_flag = true;
			for(var i = 0; i < $scope.length; i++)
			{
				$scope.topicsSubscribed.push({
				name:api_topics_reponse[i].name,
				id: api_topics_reponse[i].id,
				followerCount: api_topics_reponse[i].followerCount 
				});
			}
		};
		$scope.topics = $scope.topicsSubscribed;
	});
	
	//change from current view to newView
	$scope.changeView = function(newView){
		$location.path(newView);
	};
});