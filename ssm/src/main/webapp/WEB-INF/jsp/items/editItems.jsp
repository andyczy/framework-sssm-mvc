<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>
</head>
<body>


<!-- 显示错误信息:validated校验 -->
<c:if test="${allErrors!=null }">
    <c:forEach items="${allErrors }" var="error">
        ${error.defaultMessage}<br/>
    </c:forEach>
</c:if>


<form id="itemForm" action="${pageContext.request.contextPath}/items/updateItemsSubmit.action"
      enctype="multipart/form-base.dataStructure.data" method="post">

    <input type="hidden" name="id" value="${itemsCustom.id }" />
    修改商品信息：
    <table width="100%" border=1 align="center">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustom.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustom.price }"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <%-- name="createtime"时间修改有点问题 --%>
            <td><input type="text" value="<fmt:formatDate value="${itemsCustom.createtime}" />"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustom.pic !=null}">
                    <%--/pic已经配置好--%>
                    <img src="/pic/${itemsCustom.pic}" width=400 height=100/>
                    <br/>
                </c:if>
                <input type="file"  name="items_pic"/>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
</form>


</body>
</html>