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
				<td>身份证图片</td>
				<td>商家地址</td>
				<td>商家营业执照</td>
				<td>店内图1</td>
				<td>店内图2</td>
				<td>商家自我宣传</td>
				<td>商家状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="m" items="${merchantDetails}">
				<tr>
					<td>${m.merchantID}</td>
					<td>${m.merchantName}</td>
					<td>${m.idcardNum}</td>
					<td><img src="${m.idcardPic}" width="160" height="90"></img></td>
					<td>${m.address}</td>
					<td><img src="${m.businessPic}" width="160" height="90"></img></td>
					<td><img src="${m.shopPic[0]}" width="160" height="90"></img></td>
					<td><img src="${m.shopPic[1]}" width="160" height="90"></img></td>
					<td>${m.introduction}</td>
					<td><c:if test="${m.status==0}">待处理</c:if>
					<c:if test="${m.status==1}">审核通过</c:if>
					<c:if test="${m.status==2}">驳回</c:if>
					<c:if test="${m.status==3}">不同意</c:if>
					</td>
					<td><a
						href="http://localhost:9999/admin/MerchantDetail/VerifyStatus.do?merchantDetailID=${m.merchantDetailID}&status=1&pageNum=${pUtil.pageNum}">同意</a>
						<a
						href="http://localhost:9999/admin/MerchantDetail/VerifyStatus.do?merchantDetailID=${m.merchantDetailID}&status=2&pageNum=${pUtil.pageNum}">驳回</a>
						<a
						href="http://localhost:9999/admin/MerchantDetail/VerifyStatus.do?merchantDetailID=${m.merchantDetailID}&status=3&pageNum=${pUtil.pageNum}">不同意</a>
						
						</td>

				</tr>
			</c:forEach>
		</table>
		<div style=" text-align:center">
		<c:if test="${pUtil.pageNum<1}"><a href="http://localhost:9999/admin/MerchantDetail/ListVerify.do?pageNum=${pUtil.pageNum-1}">上一页</a></c:if>						
		<span align="center">${pUtil.pageNum}</span>
		<c:if test="${pUtil.total>pUtil.endNum}"><a href="http://localhost:9999/admin/MerchantDetail/ListVerify.do?pageNum=${pUtil.pageNum+1}">下一页</a></c:if>						
		</div>
	</div>
</body>
</html>