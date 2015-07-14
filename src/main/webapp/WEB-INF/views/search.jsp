<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
   prefix="fn" %>
<%@ include file="./header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script>
$(document).ready(function() {
    $('#tbSearch').dataTable({
    	"order": [[ 1, "asc" ]],
    	'iDisplayLength': 15,
    	"bLengthChange": false,
    	"bFilter": false,
        "bInfo": false
    });
} );
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kết quả tìm kiếm</title>
</head>
<body>
<div>
<form id="form" action="bieudo" method="get">
<table id="tbSearch" class="table table-striped table-bordered" cellspacing="0" width="90%">
<thead>
<tr>
<th></th>
<th>Tên sản phẩm</th>
<th>Giá bán</th>
<th>Địa chỉ nơi rao bán</th>
<th>Chọn</th>
</tr>
</thead>
<tbody>
	<c:forEach var="item" items="${products}">		
		    <tr>
		       <td><img src="${item.imageUrl}" style="width:80px; " /></td>
				<td><a name="" href="http://${item.storeUrl}"><c:out value="${item.name}"></c:out></a></td>
				<td><c:out value="${item.price}"></c:out> VNĐ</td>
				<td><a name="" href="http://${item.storeUrl}">http://${item.storeUrl}</a></td>
				<td><a id="btn" class="btn btn-warning" onclick="selectRow('${item.name}','${item.storeUrl}')">Xem biểu đồ giá</a></td>
			</tr>
			</c:forEach>
			</tbody>
</table>
<input type="hidden" id="productName" name="productName" value="">
<input type="hidden" id="productStoreUrl" name="productStoreUrl" value="">
</form>
<script type="text/javascript">
function selectRow(name,storeUrl) {
    $("#productName").val(name);
    $("#productStoreUrl").val(storeUrl);
    document.getElementById('form').submit();

}
</script>
</div>
</body>
</html>