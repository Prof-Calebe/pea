<%
    request.getSession(true).invalidate();
    response.sendRedirect("login.jsp");
%>
