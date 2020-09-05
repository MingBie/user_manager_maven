<%--
  Created by IntelliJ IDEA.
  User: 呆自信丶
  Date: 2020/8/28
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <%--<base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script>
        $(function() {
            // 返回按钮 显示所有用户信息list页面
            $("#return").click(function() {
                // 改变当前地址
                // 跳转 查询所有用户信息Servlet
                location.href = "${pageContext.request.contextPath}/FindByPageServlet";
            })
        })
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <%-- 跳转 通过id更新用户信息Service --%>
    <form action="${pageContext.request.contextPath}/UpdateUserByIdServlet" method="post">
        <%-- 隐藏域 --%>
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名"
                    value="${user.name}"/>
        </div>

        <div class="form-group" >
            <label>性别：</label>
                <input type="radio" name="gender" value="男" ${user.gender == '男' ? 'checked':''} />男
                <input type="radio" name="gender" value="女" ${user.gender == '女' ? 'checked':''} />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${user.age}" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id='address' class="form-control">
                <option value="广东" ${user.address == '广东' ? 'selected':''}>广东</option>
                <option value="广西" ${user.address == '广西' ? 'selected':''}>广西</option>
                <option value="湖南" ${user.address == '湖南' ? 'selected':''}>湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id='qq' class="form-control" name="qq" placeholder="请输入QQ号码" value="${user.qq}" />
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id='email' class="form-control" name="email" placeholder="请输入邮箱地址" value="${user.email}" />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" id="return" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
