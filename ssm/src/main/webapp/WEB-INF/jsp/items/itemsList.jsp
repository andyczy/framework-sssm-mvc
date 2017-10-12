<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">

    //删除
    function deleteItems(){
        document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action";
        document.itemsForm.submit();
    }
    //查询
    function queryItems(){
        document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
        document.itemsForm.submit();
    }
    //批量修改提交
    function editItemsAllSubmit(){
        //提交form
        document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsQueryItems.action";
        document.itemsForm.submit();
    }

</script>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>

当前用户：${username }，
<c:if test="${username!=null }">
    <a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>

<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                商品名称：<input name="itemsCustom.name" type="text"/>
            </td>
            <td>
                <input type="button" value="name属性模糊查询" onclick="queryItems()"/>
                <input type="button" value="批量删除（未实现）" onclick="deleteItems()"/>
                <input type="button" value="批量修改（未实现）" onclick="editItemsAllSubmit()"/>
            </td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>图片</td>
            <%--<td>数量</td>--%>
            <td>操作1</td>
            <td>操作2</td>
        </tr>
        <c:forEach items="${itemsList }" var="item">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
            <td>${item.name }</td>
            <td>${item.price }</td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${item.detail }</td>
            <td>${item.pic }</td>
            <%--<td><input type="text" name="count" value="1"/></td>--%>
            <td>
                <a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">
                    <input type="button" value="修改商品"/></a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath }/cart/addcartList.action?id=${item.id}" >
                    <input type="button" value="加入购物车"/>
                </a>
            </td>
        </tr>
        </c:forEach>

    </table>

</form>


</body>
</html>