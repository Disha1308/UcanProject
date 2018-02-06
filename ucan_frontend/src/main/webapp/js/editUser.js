myApp.controller('editUser', function ($scope, $http, $q, $location, $rootScope)
  {
    //take input from user and change profile attributes
    $scope.id = $rootScope.userId;
    $scope.userName = null;
    $scope.password = null;
    $scope.email = null;
    $scope.contact = null;
    $scope.country = null;
    $scope.editUser = function(in_userName, in_password, in_email, in_contact, in_country){
      var data ={
        id: $rootScope.userId,
        userName: in_userName,
        password: in_password,
        email: in_email,
    	  contact: in_contact,
    	  country: in_country
      };
      
      var deferred = $q.defer();
      var url = 'http://localhost:8080/v1.0/users/'+$scope.id
      $http.put(url, JSON.stringify(data))
      .success(function(response){
        $scope.msg = "Put Data Method Executed Successfully!";
        $scope.statusCode = 1;
        deferred.resolve(response);   
      })
      .error(function(response){
        $scope.msg = "Service doesn't exist!";
        $scope.statusCode = 0;
	      deferred.reject(response);
      });

      return deferred.promise;
    };

    $scope.changeView = function(view){
      $location.path(view);
    }
  });