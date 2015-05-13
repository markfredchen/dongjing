/**
 * Created by markfredchen on 4/16/15.
 */
'use strict';
angular.module('dongjingApp')
    .directive('uniqueRole', ['$http', '$q', function ($http, $q) {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function ($scope, element, attrs, ctrl) {
                ctrl.$asyncValidators.uniqueRole = function (modelValue, viewValue) {
                    var value = modelValue || viewValue;
                    if (ctrl.$isEmpty(value)) {
                        return $q.when();
                    }
                    var def = $q.defer();
                    $http.get('/api/roles/check/name/' + value)
                        .success(function(data, status, headers, cfg){
                            if(data.isUnique) {
                                def.resolve();
                            }else {
                                def.reject();
                            }
                        })
                        .error(function (data, status, headers, cfg) {
                            def.reject();
                        });
                    return def.promise;
                };
            }
        }
    }]);
