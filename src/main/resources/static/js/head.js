var app = angular.module("springDemo",[]);
app.controller("AppCtrl",function ($scope,$http) {
    $scope.websites =[];
    $http.get("http://localhost:8080/dev").success(function (data) {
        $scope.websites =data;
    })
    
    $scope.sortField=undefined;
    $scope.revers =false;

    $scope.sort = function (field) {
        if($scope.sortField === field){
            $scope.revers = !$scope.revers;
        }
        else{
            $scope.sortField =field;
            $scope.revers = false;
        }
    };
    
    app.controller("AppCtrleer",function ($scope) {
        $scope.wee =[];
        $http.get("http://localhost:8080/admin/devs").success(function (data) {
            $scope.websites =data;
        })
    })
});

