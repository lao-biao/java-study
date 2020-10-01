<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBoot整合Freemarker</title>
</head>
<body>
<table border="1px" align="center" width="50%">
    <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Age</th>
    </tr>
    <#list list as user>
        <tr>
            <td>${user.uname}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>