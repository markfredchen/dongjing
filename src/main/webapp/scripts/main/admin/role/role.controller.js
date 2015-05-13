/**
 * Created by markfredchen on 4/12/15.
 */
'use strict';
angular.module('dongjingApp')
    .controller('RoleCtrl', ['$scope','Role', 'localStorageService', '$translate', function ($scope, Role, localStorageService, $translate) {
        $scope.allRoles = Role.query();
        $scope.allRights = localStorageService.get('application.rights');
        $scope.isAdd = true;
        $scope.role = {};
        $scope.submit = function() {
            if ($scope.isAdd) {
                Role.save($scope.adaptRoleModel()).$promise.then(function (data) {
                    $scope.role.roleOID = data.id;
                    $scope.postSave();
                    $scope.allRoles.push($scope.role);
                    $scope.resetForm();

                });
            } else {
                var role = $scope.adaptRoleModel();
                Role.update(role).$promise.then(function (data) {
                    $scope.postSave();
                    $scope.resetForm();
                });
            }
        };

        $scope.addRole = function () {
            $scope.resetForm();
        };

        $scope.editRole = function (role) {
            $scope.resetForm();
            Role.get({roleOID: role.roleOID}).$promise.then(function (data) {
                $scope.role = $scope.adaptRoleForm(data);
            });
            $scope.isAdd = false;

        }

        $scope.getRightsByModule = function(module) {
            var rights = [];
            for (var i = 0; i < $scope.allRights.length; i++) {
                var right = $scope.allRights[i];
                if (right.indexOf(module) > -1) {
                    rights.push(right);
                }
            }
            return rights;
        }

        $scope.toggleRight = function(right){
            if (!$scope.role.rights) {
                $scope.role.rights = [];
            }
            var idx = $scope.role.rights.indexOf(right);
            if (idx > -1) {
                $scope.role.rights.splice(idx, 1);
            } else {
                $scope.role.rights.push(right);
            }
        };

        $scope.resetForm = function () {
            $scope.role = {};
            $scope.isAdd = true;
            $scope.roleForm.$setPristine();
            $scope.roleForm.$setUntouched();
        }

        $scope.adaptRoleModel = function () {
            var roleResource = {}
            roleResource.name = $scope.role.name;
            roleResource.roleOID = $scope.role.roleOID;
            roleResource.rights = $scope.role.rights;
            for (var i = 0; i < $scope.role.blocks.length; i++) {
                var block = $scope.role.blocks[i];
                roleResource.rights.push(block);
            }
            if(roleResource.rights.indexOf('SYSTEM') > -1) {
                roleResource.rights = ['SYSTEM'];
            }
            return roleResource;
        }
        $scope.adaptRoleForm = function (roleResource) {
            var role = {};
            role.name = roleResource.name;
            role.roleOID = roleResource.roleOID;
            role.blocks = [];
            role.rights = [];
            for (var i = 0; i < roleResource.rights.length; i++) {
                var right = roleResource.rights[i];
                if(right.indexOf("BLOCK.") === 0) {
                    role.blocks.push(right);
                } else {
                    role.rights.push(right);
                }
            }
            return role;
        }
        $scope.postSave = function () {
            if($scope.role.rights.indexOf('SYSTEM') > -1) {
                $scope.role.rights = ['SYSTEM'];
                $scope.role.blocks = [];
            }
        }
    }]);

