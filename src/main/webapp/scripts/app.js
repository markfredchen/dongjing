'use strict';

/**
 * @ngdoc overview
 * @name dongjingApp
 * @description
 * # dongjingApp
 *
 * Main module of the application.
 */
angular
    .module('dongjingApp', [
        'ngResource',
        'ui.router',
        'ngCookies',
        'ngMessages',
        'LocalStorageModule',
        'tmh.dynamicLocale',
        'pascalprecht.translate',
        'mc.chosen'
    ])
    .run(['localStorageService', '$translate', 'Right', function(localStorageService, $translate, Right){
        Right.getAllRights().then(function (data) {
            localStorageService.set('application.rights', data);
        });
        $translate.use('zh_cn');

    }])
    .config(['$urlRouterProvider', '$resourceProvider', 'localStorageServiceProvider', '$translateProvider', 'tmhDynamicLocaleProvider',
        function ($urlRouterProvider, $resourceProvider, localStorageServiceProvider, $translateProvider, tmhDynamicLocaleProvider) {
        localStorageServiceProvider.setPrefix('dongjing');
        $urlRouterProvider.otherwise('/');
        $resourceProvider.defaults.stripTrailingSlashes = false;
        // Initialize angular-translate
        $translateProvider.useLoader('$translatePartialLoader', {
            urlTemplate: 'i18n/{lang}/{part}.json'
        });

        $translateProvider.preferredLanguage('zh_cn');
        $translateProvider.useCookieStorage();

        tmhDynamicLocaleProvider.localeLocationPattern('bower_components/angular-i18n/angular-locale_{{locale}}.js');
        tmhDynamicLocaleProvider.useCookieStorage('NG_TRANSLATE_LANG_KEY');

    }]);
