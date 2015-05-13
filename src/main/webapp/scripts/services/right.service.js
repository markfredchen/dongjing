/**
 * Created by markfredchen on 4/10/15.
 */
'use strict';
angular.module('dongjingApp')
    .factory('Right', ['$http', '$q', function Right($http, $q) {
        return {
            getAllRights: function () {
                var deferred = $q.defer();
                $http.get('api/rights').success(function (data) {
                    deferred.resolve(data.rights);
                });
                return deferred.promise;
            }
        };
    }]);
