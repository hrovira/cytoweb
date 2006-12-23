<%@include file="includes.jsp"%>
<html>
<head>
    <title>Cytoweb Network Container</title>
</head>
<body>
    <h1>Cytoweb Network Container</h1><br/>
    <h2>Controls</h2><br/>
    <hr/>
    Cytoscape Network<br/>
    <c:url value="getNetwork.html" var="getNetworkURL">
        <c:param name="networkFile" value="${param.networkFile}"/>
    </c:url>
    <object type="image/svg+xml" data="${getNetworkURL}" border="1" height="600" width="800">
        SVG Image is not displayable in your browser
    </object>    
</body>
</html>

