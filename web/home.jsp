<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/28
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小瓶找</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastTime")){
                flag = true;
            }
        }
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
    if (flag){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastTime")){
                response.getWriter().write("您上次访问时间"+ URLDecoder.decode(cookie.getValue(),"utf-8"));
                cookie.setValue(URLEncoder.encode(simpleDateFormat.format(new Date()),"utf-8"));
                cookie.setMaxAge(30*24*60*60);
                response.addCookie(cookie);
                return;
            }
        }
    }else {
        response.getWriter().write("您好，欢迎您首次访问！");
        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(simpleDateFormat.format(new Date()),"utf-8"));
        cookie.setMaxAge(30*24*60*60);
        response.addCookie(cookie);
    }
%>

</body>
</html>
