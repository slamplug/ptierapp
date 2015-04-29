'use strict';

/* Controllers */

var ptierUIControllers = angular.module('ptierUIControllers', []);

ptierUIControllers.controller('CustomerDetailsController', ['$scope', '$timeout', 'CustomerDetailsService',

    function ($scope, $timeout, CustomerDetailsService) {

        $scope.getCustomerDetails = function () {
            $scope.customerDetails = CustomerDetailsService.getCustomerDetails( {},{
                 id :  $scope.customerId
            }, function() {
              //success
            }, function(response) {} );
        };

    }]);
