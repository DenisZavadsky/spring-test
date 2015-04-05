<%@ page isELIgnored="false" %>
<div class="popup-content">
    <form id="edit-form" action="edit-popup.jsp">
    <div>
        <input name="id" type="text" value="${transaction.id}" disabled="disabled">
    </div>
    <div>
        <input name="accountNumber" type="text" value="${transaction.accountNumber}">
    </div>
    <div>
        <input name="amount" type="text" value="${transaction.amount}">
    </div>
    <div>
        <input name="date" type="text" value="${transaction.date}" disabled="disabled">
    </div>

    <input type="button" id="edit-submit">Send</input>
    </form>
</div>