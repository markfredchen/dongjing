/**
 * Created by markfredchen on 4/10/15.
 */
'use strict';
angular.module('dongjingApp')
    .factory('User', ['$resource', function ($resource) {
        return $resource('api/users/:userOID', {userOID: '@userOID'}, {
            'update' : {method: 'PUT'}
        });
    }]);
