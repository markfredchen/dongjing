/**
 * Created by markfredchen on 4/16/15.
 */
'use strict';
angular.module('dongjingApp')
    .controller('admin.UserController',['$scope', function ($scope) {
        $scope.roles = [{name: 'test'}, {name: 'system'}];
    }])
