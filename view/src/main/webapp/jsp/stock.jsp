<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 3/24/15
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
    <script src="/js/stock.js"></script>
</head>
<body>
<div>
    <table>
        <thead>
        <th>Company</th>
        <th>Price</th>
        <th>Volume</th>
        </thead>
        <tbody>
            <tr id="AAPL">
                <td id="AAPL_CELL">AAPL</td>
                <td id="AAPL_PRICE"></td>
                <td id="AAPL_VOLUME"></td>
            </tr>
            <tr id="FB">
                <td id="FB_CELL">FB</td>
                <td id="FB_PRICE"></td>
                <td id="FB_VOLUME"></td>
            </tr>
            <tr id="EPAM">
                <td id="EPAM_CELL">EPAM</td>
                <td id="EPAM_PRICE"></td>
                <td id="EPAM_VOLUME"></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
