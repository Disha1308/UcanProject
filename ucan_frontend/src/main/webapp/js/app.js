var myApp = angular.module("myApp",['ngRoute']);

myApp.config(['$routeProvider',
	function($routeProvider)
	{
		$routeProvider.
			when('/',
			{
				templateUrl: "/html/login.html",
				controller: "login"
			}).
			when('/viewAll',
			{
				templateUrl: "/html/displayAllUsers.html",
				controller: "displayAllUsers"
			}).
			when('/editUser',
			{	
				templateUrl: "/html/editUser.html",
				controller: "editUser"
			}).
			when('/signUp',
			{
				templateUrl: '/html/signUp.html',
				controller: 'signUp'
			}).
			when('/home',
			{
				templateUrl: '/html/home.html',
				controller: 'home'
			}).
			when('/topicSelection',
			{
				templateUrl: '/html/topicSelection.html',
				controller: 'topicSelection'
			});
	}
]);