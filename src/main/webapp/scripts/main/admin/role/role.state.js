/**
 * Created by markfredchen on 4/16/15.
 */
'use strict';
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('admin.roles', {
                url: '/roles',
                views: {
                    'mainContent@contentWithLeftNav': {
                        templateUrl: 'scripts/main/admin/role/role.tpl.html',
                        controller: 'RoleCtrl'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('roles');
                        return $translate.refresh();
                    }]
                }
            })
    }]);
