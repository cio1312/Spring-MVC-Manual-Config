<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <title>Home Page</title>
   </head>
   <body>
      <div class="container mt-3">
         <c:if test="${not empty sucMsg}">
            <div class="alert alert-success">
               <b>
                  <c:out value="${sucMsg}"></c:out>
               </b>
            </div>
         </c:if>
         <div class="row mt-5">
            <div class="col-md-10">
               <c:if test="${pagename=='home'}">
                  <h1 class="text-center">
                     <c:out value="${pageContent}"></c:out>
                  </h1>
               </c:if>
               <c:if test="${pagename=='add'}">
                  <h1 class="text-center">
                     <c:out value="${pageContent}"></c:out>
                  </h1>
                  <br>
                  <form:form action="save" method="post" modelAttribute="todo">
                     <!-- //if method = post,data will not be seen in URl  -->
                     <div class="form-group">
                        <form:input path="title" cssClass="form-control"
                           placeholder="todo title" />
                     </div>
                     <div class="form-group">
                        <form:textarea path="content" cssClass="form-control"
                           cssStyle="height:170px;" placeholder="type here . . . " />
                     </div>
                     <br>
                     <div class="container text-center">
                        <button class="btn btn-outline-success">ADD</button>
                     </div>
                  </form:form>
               </c:if>
               <c:if test="${pagename=='view'}">
                  <h1 class="text-center">
                     <c:out value="${pageContent}"></c:out>
                  </h1>
                  <c:forEach items="${TodoList}" var="t">
                     <div class="card">
                        <div class="card-body">
                           <h3>
                              <c:out value="${t.title}"></c:out>
                           </h3>
                           <p>
                              <c:out value="${t.content}"></c:out>
                           <div class="text-right">
                              <c:out value="${t.date}"></c:out>
                           </div>
                           </p>
                        </div>
                     </div>
                  </c:forEach>
               </c:if>
            </div>
            <div class="col-md-2">
               <div class="list-group">
                  <a class="list-group-item list-group-item-action"
                     href="<c:url value = "/home"/>">Home</a> <a
                     class="list-group-item list-group-item-action"
                     href="<c:url value = "/add"/>">Add</a> <a
                     class="list-group-item list-group-item-action"
                     href="<c:url value = "/view"/>">View</a>
               </div>
            </div>
         </div>
      </div>
      <!-- Optional JavaScript -->
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   </body>
</html>