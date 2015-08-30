<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Render Domain</title>
</head>
<body>
<div>
     <strong>Quick search</strong>
    <g:form url='[controller: "search", action: "search"]' id="searchForm" name="searchForm" method="get">
         <input type="text" name="query" value="${query ?: 'Keywords'}" onClick="javascript:if (this.value=='Keywords') { this.value='' }">
        <input type="image" src="${resource(dir:'images',file:'go_quick_search.png')}">
    </g:form>
</div>
<div>
    <g:if test="${haveResults}">
        <g:each var="result" in="${searchResults}">
            ${result.lastName}, ${result.firstName}
            ${result.age}
            <br/>
        </g:each>
    </g:if>
</div>
</body>
</html>