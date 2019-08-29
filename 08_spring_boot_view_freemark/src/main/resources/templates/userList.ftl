<html>
	<head>
		<title>freemarker demo.</title>
		<meta charset="utf-8"></meta>
	</head>
	<body>
		<table border="1" align="center" width="50%">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
			</tr>
			<#list list222 as user>
				<tr>
					<td>${user.id}</td>
					<td>${user.userName}</td>
					<td>${user.userAge}</td>
				</tr>
			</#list>
		</table>
	</body>
</html>