<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Welcome to ResortHub</title>
</head>
<body>
<main class="relative isolate min-h-screen">
    <%-- Check if User object is not null and Customer object is set --%>
    <c:if test="${not empty sessionScope.User and not empty sessionScope.User.customer}">
        <%-- Access the full name of the customer using the getFullName() method --%>
        Login successfully! Welcome ${sessionScope.User.customer.fullName}
    </c:if>
    <%-- If User object or Customer object is null, display a generic message --%>
    <c:if test="${empty sessionScope.User or empty sessionScope.User.customer}">
        Login successfully! Welcome
    </c:if>
    Continue to home
</main>
</body>
</html>
