<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${sessionScope.user.email}</span><br>

    <label>First Name:</label>
    <span>${sessionScope.user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${sessionScope.user.lastName}</span><br>

    <label>Date of Birth:</label>
    <span>${sessionScope.user.dob}</span><br>

    <label>How did you hear <br> about us?</label>
    <span>${requestScope.survey.hear}</span><br>

    <label>Would you like to <br> receive announcements <br> about new CDs and <br> special offers?</label>
    <div>
        <span>${requestScope.survey.yes1}<br>${requestScope.survey.yes2}</span>
    </div><br>

    <label>Contact Method:</label>
    <span>${requestScope.survey.contactMethod}</span><br>

    <p>The first address on our list is ${sessionScope.users[0].email}<br>
       The second address on our list is ${sessionScope.users[1].email}
    </p>

    <p>For customer service, contact ${initParam.custServEmail}</p>

    <p>To enter another email address, click on the Back
        button in your browser or the Return button shown
        below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

<jsp:include page="/footer.jsp" />