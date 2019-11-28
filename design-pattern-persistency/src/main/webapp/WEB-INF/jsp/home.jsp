<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/ -->


<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/login.min.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <form method="POST" action="/addFriend" class="form-signin">
        <h2 class="form-heading">add friend with username</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="friendName" type="text" class="form-control" placeholder="Username"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Add Friend">
        </div>
      </form>
    </div>
    
    <div class="container">
      <form method="POST" action="/getUserByName" class="form-signin">
        <h2 class="form-heading">get user by name</h2>
			<input name="name" type="text" class="form-control" placeholder="Username"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           <input class="btn btn-lg btn-primary btn-block" type="submit" value="Get User">
      </form>
     
    </div>
    
        <div class="container">
      <form method="POST" action="/getUserByAddress" class="form-signin">
        <h2 class="form-heading">get user by address</h2>
			<input name="address" type="text" class="form-control" placeholder="Username"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Get User">
      </form>
    </div>
    
        <div class="container">
      <form method="POST" action="/getUserByFriendName" class="form-signin">
        <h2 class="form-heading">get an user by friend name</h2>
			<input name="name" type="text" class="form-control" placeholder="Friend's username"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Get User">
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </body>
</html>