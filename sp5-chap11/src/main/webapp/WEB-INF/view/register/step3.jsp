<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GG
  Date: 2023-01-03
  Time: 오전 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p><strong>${formData.name}</strong>님 회원 가입을 완료했습니다.</p>
    <p>
        <a href="<c:url value='/main/'/>">[첫 화면 이동]</a>
    </p>
</body>
</html>
