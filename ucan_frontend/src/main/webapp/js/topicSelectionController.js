myApp.controller('topicSelection',function($scope, $rootScope, $http, $q, $location){
	$scope.id = $rootScope.userId;
	$scope.topicsArr = [];	//get topics array from backend
	var deferred = $q.defer();
	$scope.checkedTopic = [];	//get topics selected by the user
	//$scope.pushApiTopics = [];	//push these topics into the backend for this user

	//retrieving topics(id,name,followers) stored in database
	var url = "http://localhost:8081/v1.0/topics";
	$http.get(url)
	.success(function(api_response)
	{
		deferred.resolve(api_response);	
	})
	.error(function(api_response)
	{
		deferred.reject(api_response);
	});
	
	deferred.promise.then(function(get_topics_response)
	{
		$scope.topics_length = get_topics_response.length;
		for(var i = 0; i < $scope.topics_length; i++)
		{
			$scope.topicsArr.push({
				name: get_topics_response[i].name,
				followers: get_topics_response[i].followerCount,
				id: get_topics_response[i].id
			});
		}
	});	
	$scope.topics = $scope.topicsArr;

	//function to submit topics chosen by the user
	$scope.submitTopics = function(){

		console.log("The submitted list is: ",$scope.checkedTopic);
		for(var i = 1; i <= $scope.checkedTopic.length; i++)
		{
			//if topic is selected, post it to backend
			if($scope.checkedTopic[i] === true){
				url = "http://localhost:8080/v1.0/topics/"+$scope.topicsArr[i-1].id+"/users/"+$scope.id;
				deferred = $q.defer();
				$http.post(url)
				.success(function(post_api_response){
					console.log("posted for topic id",$scope.topicsArr[i-1]);
					deferred.resolve(post_api_response);
					$scope.flag = true;
				})
				.error(function(post_api_response){
					deferred.reject(post_api_response);
					$scope.flag = false;
				});
			}
		}	

	};

	$scope.changeView = function(newView){
		$location.path(newView);
	}	
});