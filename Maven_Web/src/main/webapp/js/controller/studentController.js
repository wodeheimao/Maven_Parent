app.controller("studentController",function ($scope, studentService, classesService) {

    $scope.pagination = {
        currentPage: 1,	                    //代表当前页
        itemsPerPage: 5,	                    //代表每页的记录数
        totalItems: 100,	                    //代表总记录数
        perPageOptions: [5, 10, 15, 20, 25, 30],  //代表分页的选项列表
        onChange: function () {
            $scope.search();
        }
    }
    $scope.search = ()=>{
        studentService.search($scope.pagination.currentPage,$scope.pagination.itemsPerPage,$scope.entity).success(response=>{
            $scope.students = response.rows;
            $scope.pagination.totalItems=response.total;
        })
    }

    $scope.findAllClasses = ()=>{
        classesService.findAllClasses().success(function (response) {
            $scope.classes = response;
        })
    }
    $scope.toAdd = () => {
        $scope.stuEntity={};
        $("#myModal").modal("show");
    }
    $scope.toUpdate=(stu)=>{
        $scope.stuEntity=stu;
        $("#myModal").modal("show");
    }

    $scope.save = () => {
        if()
    }
    $scope.toDelete=(sid)=>{
        studentService.delete(sid).success(response=>{

        })
    }
})