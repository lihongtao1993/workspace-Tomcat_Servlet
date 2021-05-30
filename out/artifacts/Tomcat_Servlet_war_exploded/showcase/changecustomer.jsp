<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <div>
        <form action="/changecustomerservlet" method="post">
            <input type="hidden" name="id" value="${requestScope.customer.id}">
            <span>姓名</span><input type="text" name="name" value="${customer.name}"> <br>
            <span>性别</span><input type="radio" name="gender" value="男" <%="男".equals(request.getAttribute("gender"))?"checked":""%> >男
                            <input type="radio" name="gender" value="女" <%="女".equals(request.getAttribute("gender"))?"checked":""%> >女<br>
            <span>年龄</span><input type="text" name="age" value="${customer.age}"><br>
            <span>籍贯</span><input type="text" name="address" value="${customer.address}"><br>
            <span>Q Q</span><input type="text" name="qq" value="${customer.qq}"><br>
            <span>邮箱</span><input type="text" name="email" value="${customer.email}"><br>
            <span></span><input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
