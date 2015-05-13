/**
 * Created by markfredchen on 4/11/15.
 */
angular.module('dongjingApp')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('admin', {
                parent: 'contentWithLeftNav',
                abstract: true,
                url: '/admin',
                views: {
                    'leftNavi': {
                        templateUrl: 'scripts/main/admin/left.navi.tpl.html'
                    }
                }
            })
            .state('admin.users', {
                url: '/users',
                views: {
                    'mainContent@contentWithLeftNav': {
                        templateUrl: 'scripts/main/admin/user.html'
                    }
                }
            })
    }]);
