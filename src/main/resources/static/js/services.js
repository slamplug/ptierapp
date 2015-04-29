'use strict';

/* Services */

angular.module('ptierUIServices', ['ngResource'])
    .factory('CustomerDetailsService', ['$resource',
        function ($resource) {
            return $resource('/ui/customer/:id', {}, {
                getCustomerDetails: {method: 'GET', params: {id: '@id'}, isArray: false}
            });
        }])
