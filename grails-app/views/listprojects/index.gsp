<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		<asset:stylesheet src="application.css"/>
		<asset:stylesheet src="listprojects/datatables.css"/>
		<asset:javascript src="application.js"/>
		<asset:javascript src="listprojects/datatables.js"/>
		<asset:javascript src="listprojects/init.js"/>
  </head>
  <body>
		<g:render template="/shared/nav" />

	<div class="container">

   	<table id="listproject-table" class="display" cellspacing="0" width="100%">
			<thead>
            <tr>
                <th>Name</th>
                <th>Status</th>
                <th>Source language</th>
                <th>Target languages</th>
            </tr>
        </thead>
				<tbody>
				</tbody>

	  </table>

	</div><!-- /.container -->

  </body>
</html>
