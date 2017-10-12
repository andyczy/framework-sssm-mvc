<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>


<a href="${pageContext.request.contextPath }/items/queryItems.action">返回商品列表</a>
<c:choose>

    <%-- 如果没有车，或车的内容集合为0长 --%>
    <c:when test="${empty sessionScope.cart }">
        <img src="<c:url value='/images/cart.png'/>" width="300"/>
    </c:when>
    <c:otherwise>
        <table border="1" width="100%" cellspacing="0" background="black">
            <tr>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    <a href="${pageContext.request.contextPath }/cart/deleteClear.action">清空购物车</a>
                </td>
            </tr>
            <tr>
                <th>id</th>
                <th>书名</th>
                <th>单价</th>
                <th>描述</th>
                <th>上架时间</th>
                <th>数量</th>
            </tr>

            <c:forEach items="${sessionScope.cart.cartItems }" var="cartItem">
                <tr>
                    <td>${cartItem.itemsCustom.id }</td>
                    <td>${cartItem.itemsCustom.name }</td>
                    <td>${cartItem.itemsCustom.price }元</td>
                    <td>${cartItem.itemsCustom.detail}</td>
                    <td>${cartItem.itemsCustom.createtime }</td>
                    <td><input type="text" size="3" name="count" value="1"/></td>
                    <td><a href="${pageContext.request.contextPath }/cart/deleteCart.action?id=${cartItem.itemsCustom.id}">删除</a></td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    合计：${sessionScope.cart.total }元
                </td>
            </tr>
            <tr>
                <td>问题</td>
                <td></td>
                <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
                    <a href="javascript:alert('别点了，再点就去银行页面了！');"><input type="button" value="购买"></a>
                </td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>





</body>

</html>