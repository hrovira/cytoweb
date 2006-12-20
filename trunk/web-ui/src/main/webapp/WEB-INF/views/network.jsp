<%@ page contentType="image/svg+xml" %>
<%@ include file="includes.jsp" %>

<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
     width="2000" height="2000">
    <title>${network.label}</title>
    <desc>${network.description}</desc>
    <script type="text/javascript">
        <![CDATA[
                function enlarge_circle(evt) {
                    var circle = evt.target;
                    circle.setAttribute("r", 10);
                }
                function shrink_circle(evt) {
                    var circle = evt.target;
                    circle.setAttribute("r", 5);
                }
                function enlarge_line(evt) {
                    var line = evt.target;
                    line.setAttribute("style", "stroke: red;");
                }
                function shrink_line(evt) {
                    var line = evt.target;
                    line.setAttribute("style", "stroke: black;");
                }
                function touch(label) {
                    alert("touch(" + label + ")");
                }
           // ]]>
    </script>
    <defs>
        <style type="text/css">
            <![CDATA[
            circle { stroke: black; fill: #339933;}
            line { stroke: black;}
            ]]>
        </style>
    </defs>

    <c:forEach var="node" items="${network.nodes}">
        <circle cx="${node.position.x}" cy="${node.position.y}" r="5" onclick="touch('${node.label}')"
                onmouseover="enlarge_circle(evt)" onmouseout="shrink_circle(evt)"/>
    </c:forEach>

    <c:forEach var="link" items="${network.links}">
        <line x1="${link.startNode.position.x}" y1="${link.startNode.position.y}" x2="${link.endNode.position.x}"
              y2="${link.endNode.position.y}" onclick="touch('${link.label}')"
              onmouseover="enlarge_line(evt)" onmouseout="shrink_line(evt)"/>
    </c:forEach>

    <text x="25" y="300"
          style="font-family: sans-serif; font-size: 14pt; stroke: none; fill: black;">${network.label}</text>
</svg>

