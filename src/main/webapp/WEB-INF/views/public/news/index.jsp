<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Новости мегапортала</h1>

<ol>
<c:forEach items="${items.items}" var="newsItem">
    <li>
        <p>${newsItem.title}</p>
        <p>${newsItem.file}</p>
        <p>Автор: ${newsItem.author.fullName}</p>
    </li>
</c:forEach>
</ol>