<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 4/4/15
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<div class="index-container">
<table>
  <thead>
    <th>Id</th><th>Account Number</th><th>Amount</th><th>Date</th><th>Edit transaction</th>
  </thead>
  <c:forEach var="transaction" items="${transactions}">
    <tr>
      <td>${transaction.id}</td>
      <td>${transaction.accountNumber}</td>
      <td>${transaction.amount}</td>
      <td>${transaction.date}</td>
      <td><button class="edit-transaction" data-id="${transaction.id}" data-account-number="${transaction.accountNumber}" >Edit</button></td>
    </tr>
  </c:forEach>
</table>


</div>
<div id="popup-wrapper" class="easy-modal"></div>