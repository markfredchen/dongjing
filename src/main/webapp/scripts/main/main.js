'use strict';
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('main', {
                abstract: true,
                views: {
                    '': {
                        templateUrl: 'scripts/main/main.html'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('contentWithNav', {
                parent: 'main',
                abstract: true,
                views: {
                    'navbar': {
                        templateUrl: 'scripts/components/navbar/navbar.html'
                    }
                }
            })
            .state('contentWithLeftNav', {
                parent: 'contentWithNav',
                abstract: true,
                views: {
                    'content@main': {
                        templateUrl: 'scripts/main/main.content.html'
                    }
                }
            })
            .state('welcome', {
                parent: 'contentWithNav',
                url: '/welcome',
                views: {
                    'content@main': {
                        templateUrl: 'scripts/main/welcome.html'
                    }
                }
            });
    }]);
