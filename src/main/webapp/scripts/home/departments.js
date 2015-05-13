'use strict';
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('departments', {
                parent: 'home',
                url: '/departments',
                templateUrl: 'scripts/home/departments.html',
                controller: 'DepartmentsCtrl'
            });
    }])
    .controller('DepartmentsCtrl', ['$scope', '$state', function ($scope, $state) {
        $scope.goWelcomeThrough = function(departments) {
            if(departments === 'jfb') {
                $state.go('welcome');
            }
        };
    }]);
