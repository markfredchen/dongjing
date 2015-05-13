/**
 * Created by markfredchen on 4/10/15.
 */
'use strict';
angular.module('dongjingApp')
    .factory('Role', ['$resource', 'API_URL', function ($resource, API_URL) {
        return $resource(API_URL.ROLE, {roleOID: '@roleOID'}, {
            'update': {method: 'PUT'}
        });
    }]);
