<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
   prefix="fn" %>
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
    	
    });
} );
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kết quả tìm kiếm</title>
<style>
body{

}

</style>
</head>
<body>
<div>
<table id="tbSearch" class="table table-striped table-bordered" cellspacing="0" width="100%">
<thead>
<tr>
<th>Tên sản phẩm</th>
<th>Giá bán</th>
<th>Địa chỉ nơi rao bán</th>
</tr>
</thead>
<tbody>
	<c:forEach var="item" items="${products}">		
		    <tr>
		       
				<td><a href="http://${item.storeUrl}"><c:out value="${item.name}"></c:out></a></td>
				<td><c:out value="${item.price}"></c:out> VNĐ</td>
				<td><a href="http://${item.storeUrl}">http://${item.storeUrl}</a></td>
				
			</tr>
			</c:forEach>
			</tbody>
</table>
</div>
</body>
</html>