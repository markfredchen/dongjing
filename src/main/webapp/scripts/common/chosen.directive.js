/**
 * Created by markfredchen on 4/16/15.
 */
'use strict';
angular.module('mc.chosen', [])
    .directive('chosen', function () {
        return {
            restrict: 'A',
            link: function (scope, element, attrs, ctrl) {
                scope.$watch(attrs.chosen, function () {
                    element.trigger('chosen:updated');
                });
                scope.$watch(attrs.ngModel, function () {
                    element.trigger('chosen:updated');
                });
                var chosenOptions = {
                    search_contains: true
                };
                if(attrs.chosenSearchMessage && attrs.chosenSearchMessage !== '') {
                    chosenOptions.no_results_text = attrs.chosenSearchMessage;
                }
                element.chosen(chosenOptions);
            }
        };
    })
