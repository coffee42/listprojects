<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		<asset:stylesheet src="application.css"/>
  </head>
  <body>
		<g:render template="/shared/nav" />

	<div class="container">

		<g:form class="form-setup" action="save">
	         <h2 class="form-setup-heading">Setup user</h2>
	         <label for="userName" class="sr-only">User name</label>
					 <input type="text" name="userName" class="form-control" placeholder="User name" value="${fieldValue(bean: setup, field: 'userName')}" required autofocus/>
	         <label for="password" class="sr-only">Password</label>
	         <input type="text" id="password" name="password" class="form-control" placeholder="Password" value="${fieldValue(bean: setup, field: 'password')}" required>
	         <div class="message">
						 <span></span>
	         </div>
	         <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
	   </g:form>

	</div><!-- /.container -->


		<asset:javascript src="bootstrap.js"/>
  </body>
</html>
