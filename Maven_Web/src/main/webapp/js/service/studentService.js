app.service("studentService",function($http) {

    this.search =(page,pageSize,entity)=>{
        return $http.post("student/search.do?page="+page+"&pageSize="+pageSize,entity);
    }
})