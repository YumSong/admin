<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="text" style=" text-align:center">
		<table align="center" border="1">
			<tr>
				<td>商家ID</td>
				<td>商家姓名</td>
				<td>商家身份证号</td>
				<td>商家地址</td>
				<td>商家状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="m" items="${merchantDetails}">
				<tr>
					<td>${m.merchantID}</td>
					<td>${m.merchantName}</td>
					<td>${m.idcardNum}</td>
					<td>${m.address}</td>
					<td><c:if test="${m.status==0}">待处理</c:if>
					<c:if test="${m.status==1}">审核通过</c:if>
					<c:if test="${m.status==2}">驳回</c:if>
					<c:if test="${m.status==3}">不同意</c:if>
					</td>
					<td><a
						href="http://localhost:9999/admin/MerchantDetail/UpdateStatus.do?merchantDetailID=${m.merchantDetailID}&status=${m.status}&pageNum=${pUtil.pageNum}">拉黑</a>
						<a
						href="http://localhost:9999/admin/MerchantDetail/UpdateStatus.do?merchantDetailID=${m.merchantDetailID}&status=${m.status}&pageNum=${pUtil.pageNum}">拉白</a></td>

				</tr>
			</c:forEach>
		</table>
		<div style=" text-align:center">
		<c:if test="${pUtil.pageNum<1}"><a href="http://localhost:9999/admin/MerchantDetail/ListToUpdate.do?pageNum=${pUtil.pageNum-1}">上一页</a></c:if>						
		<span align="center">${pUtil.pageNum}</span>
		<c:if test="${pUtil.total>pUtil.endNum}"><a href="http://localhost:9999/admin/MerchantDetail/ListToUpdate.do?pageNum=${pUtil.pageNum+1}">下一页</a></c:if>						
		</div>
	</div>
</body>
</html>