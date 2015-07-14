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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biểu đồ giá</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script src="./resources/js/canvasjs.min.js" type="text/javascript"></script>
<script type="text/javascript">
  window.onload = function () {
	  var json = ${jsPrice};
	  if(json.length == 0) 
		  {
		  	alert("Xin lỗi, chúng tôi đang cập nhật dữ liệu cho sản phẩm này!");
		  	window.history.back();  	
		  }
	  var dataPoints = [];
	  for(var i = 0;i<=json.length-1;i++)
		  {
		  	dataPoints.push({label: json[i]["priceDate"], y: json[i]["price"]});
		  }
    var chart = new CanvasJS.Chart("chartContainer", {

      title:{
        text: "Biểu đồ giá của <c:out value="${productName}"></c:out>"              
      },
      data: [
             {
               type: "column",
               dataPoints: dataPoints
             }
             ]
           });

    chart.render();
  }
  </script>
</head>
<body>
<div style="padding-top:100px">
<div id="chartContainer" style="height: 300px; width: 100%;">
Chi tiết giá:
  </div>
<table id="tbSearch" class="table table-striped table-bordered" cellspacing="0" width="90%">
<tr>
<th>Ngày</th>
<th>Giá</th>
</tr>
<c:forEach var="item" items="${prices}">		
<tr>
<td><c:out value="${item.priceDate}"></c:out></td>
<td><c:out value="${item.price}"></c:out> VNĐ</td>
</tr>   
</c:forEach>
</table>
</div>
  <div>
  
</div>
</body>
</html>