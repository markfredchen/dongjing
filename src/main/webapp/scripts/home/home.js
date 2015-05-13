/**
 * Created by markfredchen on 4/10/15.
 */
'use strict';
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home', {
                abstract: true,
                templateUrl: 'scripts/home/home.html'
            });
    }]);
