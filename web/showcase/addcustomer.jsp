<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/9
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
    <style>
        .addinput{
            margin-top: 15px;
            width: 200px;
        }
        .under_bottom{
            float: right;
            margin-top: 15px;
            margin-left: 6px;
        }
    </style>
</head>
<body>
    <div>
        <form style="position: fixed" action="/addcustomerservlet" method="post">
            <span>姓名</span><input class="addinput" type="text" name="name" placeholder="请输入姓名"> <br>
            <span>性别</span><label class="checkbox-inline">
                <input type="radio" name="gender" value="男" checked="checked"> 男
            </label>
            <label class="checkbox-inline">
                <input type="radio" name="gender" value="女"> 女
            </label> <br>
            <span>年龄</span><input class="addinput"  type="text" name="age" placeholder="请输入年龄"> <br>
            <span>籍贯</span><input class="addinput" type="text" name="address" placeholder="请输入籍贯"> <br>
            <span>Q Q</span><input class="addinput" type="text" name="qq" placeholder="请输入QQ"> <br>
            <span>邮箱</span><input class="addinput" type="text" name="email" placeholder="请输入邮箱地址"> <br>
            <input class="under_bottom" type="submit" value="返回">
            <input class="under_bottom" type="submit" value="重置">
            <input class="under_bottom" type="submit" value="提交">
        </form>
    </div>

</body>
</html>
