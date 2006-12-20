<%@ page contentType="image/svg+xml" %>
<%@ include file="includes.jsp" %>


<svg xmlns="http://www.w3.org/2000/svg"
     xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" baseProfile="full"
     width="200" height="170">
    <title>Cat</title>
    <desc>Stick Figure of a cat</desc>

    <circle cx="70" cy="95" r="50" style="stroke: black; fill: none;"/>
    <circle cx="55" cy="80" r="5" style="stroke: black; fill: #339933;"/>
    <circle cx="85" cy="80" r="5" style="stroke: black; fill: #339933;"/>

    <g id="whiskers">
        <line x1="75" y1="95" x2="135" y2="85" style="stroke: black;"/>
        <line x1="75" y1="95" x2="135" y2="105" style="stroke: black;"/>
    </g>

    <use xlink:href="#whiskers" transform="scale(-1 1) translate(-140 0)"/>

    <!-- ears -->
    <polyline points="108 62, 90 10, 70 45, 50, 10, 32, 62" style="stroke: black; fill: none;"/>

    <!-- mouth -->
    <polyline points="35 110, 45 120, 95 120, 105, 110" style="stroke: black; fill: none;"/>

    <!-- nose -->
    <path d="M 75 90 L 65 90 A 5 10 0 0 0 75 90" style="stroke: black; fill: #ffcccc"/>

    <text x="25" y="165" style="font-family: sans-serif; font-size: 14pt; stroke: none; fill: black;">Isola's Cat!</text>
</svg>

