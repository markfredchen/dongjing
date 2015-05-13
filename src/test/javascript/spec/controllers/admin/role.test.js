/**
 * Created by markfredchen on 4/16/15.
 */
'use strict';
describe('RoleCtrl', function () {
    var DATA_ALL_ROLES = [
        {roleOID: '0da31270-44ca-4fb3-9c76-cd77d32bca06', name: "Admin", rights: ['SYSTEM']},
        {roleOID: '1e385368-88ee-42a1-917d-eccb903f5373', name: "Guest", rights: ['GUEST']},
        {roleOID: 'eb1b4af3-ba04-4633-a2ba-d1a1388e832e', name: "User", rights: ['USER']}
    ];
    var DATA_ALL_RIGHTS = ['SYSTEM', 'GUEST', 'USER'];
    beforeEach(module('dongjingApp'));


    var mockRoleQuery = function(){
        return DATA_ALL_ROLES;
    };
    var mockLocalStorageServiceGet = function (key) {
        return DATA_ALL_RIGHTS;
    };
    beforeEach(module({
        Role: {
            query: mockRoleQuery
        },
        localStorageService: {
            get: mockLocalStorageServiceGet
        }
    }));
    var RoleCtrl,
        scope;
    beforeEach(inject(function ($controller, $rootScope, _Role_, _localStorageService_) {
        scope = $rootScope.$new();
        RoleCtrl = $controller('RoleCtrl', {
            $scope: scope,
            Role: _Role_,
            localStorageService: _localStorageService_
        });
    }));
    it('initialize states', function () {
        expect(scope.allRights).toEqual(DATA_ALL_RIGHTS);
        expect(scope.allRoles).toEqual(DATA_ALL_ROLES);
        expect(scope.isAdd).toBe(true);
    })
});
