<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询结果</title>
    <style>
        table{
            border-collapse: collapse;
            width: 100%;
        }
        th,tr,td{
            border: 1px solid;
            text-align: center;
        }
        h1{
            text-align: center;
        }
        #result_list{
            text-align: center;
            margin-left: 40px;
            margin-right: 40px;
        }
        #search{
            margin-left: 40px;
        }
        .searchBox{
            width: 150px;
        }
        .change{
            float: right;
            margin-right: 40px;
        }
    </style>
    <script>
        var deleteBottom = document.getElementsByClassName("deleteCustomer");
        function del(obj){

            var parentElement = obj.parentElement.parentElement.parentElement;
            parentElement.removeChild(obj.parentElement.parentElement);
        }

        function addNewCustomer(){
            location.href = "/showcase/addcustomer.jsp"
        }

    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>用户信息</h1>
    <di>
        <%--搜素区域--%>
        <div style="position: fixed">
            <form id="search" action="/searchCustomerServlet" method="post">
                <span>姓名</span><input class="searchBox" type="text" name="name" placeholder="姓名">
                <spa>籍贯</spa><input   class="searchBox" type="text" name="address" placeholder="籍贯">
                <span>邮箱</span><input class="searchBox" type="text" name="email" placeholder="邮箱">
                <input type="submit" value="查询">
            </form>
        </div>
        <%--右上角添加和删除选中--%>
        <div class="change" >
            <input id="addNew" type="submit" value="添加联系人" onclick="addNewCustomer()">
            <input id="deleteAll" type="submit" value="删除选中">
        </div>
    </di>

<%--    表格内容区--%>
    <div id="result_list" style="margin-top: 55px">
        <table>
            <tr style="background-color: #00ff77">
                <th><input type="checkbox" ></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>qq</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="customer" varStatus="s">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${s.count}</td>
                    <td>${customer.name}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.age}</td>
                    <td>${customer.address}</td>
                    <td>${customer.qq}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a  href="${pageContext.request.contextPath}/getCustomerServlet?id=${customer.id}">修改</a>
                        <a  href="${pageContext.request.contextPath}/deleteustomerservlet?id=${customer.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<%--分页导航条区--%>
    <nav aria-label="Page navigation">
        <ul class="pagination">
<%--            前一页功能，当前页减一--%>
            <c:if test="${currentPage>1}">
                <li>
                    <a href="/customerservlet?pageIndex=${requestScope.currentPage-1}&pageSize=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
<%--            当为第一页时，屏蔽前一页选择,也可以不出来，当时第一页的时候，没有前一页的按钮--%>
<%--            <c:if test="${currentPage==1}">
                <li class="disabled">
                    <a href="" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>--%>


            <c:forEach begin="1" end="${totalPageCount}" var="i" varStatus="s" step="1">
                <c:if test="${i==currentPage}">
                    <li class="active"><a href="/customerservlet?pageIndex=${i}&pageSize=5">${i}</a></li>
                </c:if>
                <c:if test="${i != currentPage}">
                    <li><a href="/customerservlet?pageIndex=${i}&pageSize=5">${i}</a></li>
                </c:if>
            </c:forEach>
<%--            <li><a href="#">1</a></li>--%>
<%--            <li><a href="#">2</a></li>--%>
<%--            <li><a href="#">3</a></li>--%>
<%--            <li><a href="#">4</a></li>--%>
<%--            <li><a href="/customerservlet?pageIndex=1&pageSize=5">5</a></li>--%>
<%--            <li><a href="#">…</a></li>--%>
<%--            <li><a href="#">7</a></li>--%>
<%--            <li><a href="#">8</a></li>--%>
            <c:if test="${currentPage<totalPageCount}">
                <li>
                    <a href="/customerservlet?pageIndex=${currentPage+1}&pageSize=5" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
        <div>总共${totalCount}条数据 <span>共${totalPageCount}页</span></div>
    </nav>
</body>
</html>
