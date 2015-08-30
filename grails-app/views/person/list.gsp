<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Render Domain</title>
</head>
<body>
<table>
<tr>
    <td>Actions</td>
    <td>Name</td>
    <td>Age</td>
</tr>
<g:each in="${personList}" var="person">
    <tr>
        <td>
            <g:link class="btn btn-small btn-inverse" action="edit" id="${person.id}">
                Edit
            </g:link>/
            <g:link class="btn btn-small btn-inverse" action="delete" id="${person.id}">
                Delete
            </g:link>
        </td>
        <td>
            <g:link class="btn btn-small btn-inverse" action="show" id="${person.id}">
                ${person.lastName}, ${person.firstName}</td>
             </g:link>
        <td>${person.age}</td>
    </tr>
</g:each>
</table>
<g:link class="btn btn-small btn-inverse" action="create">
    Create new person
</g:link>
</body>
</html>