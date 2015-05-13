'use strict';
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('login', {
                parent: 'home',
                url: '/',
                templateUrl: 'scripts/home/login.html',
                controller: 'LoginCtrl'
            });
    }])
    .controller('LoginCtrl', ['$scope', '$state', function ($scope, $state) {
        $scope.login = function () {
            $state.go('departments');
        };
    }]);
