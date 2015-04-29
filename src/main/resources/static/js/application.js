'use strict';

/* App Module */

var ptierUiApp = angular.module('ptierUiApp', [
  'ngRoute',
  'ptierUIControllers',
  'ptierUIServices'
]);

ptierUiApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/summary', {
        templateUrl: 'partials/summary.html',
        controller: 'CustomerDetailsController'
      }).
      otherwise({
        redirectTo: '/summary'
      });
  }]);
