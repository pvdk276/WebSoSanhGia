<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>Web so sánh giá</title>
<style>
body {
	background: #343d46;
	font-family: "Oxygen",Helvetica,Arial,sans-serif;
}
h3{
font-weight: 500;
    line-height: 1.1;
    font-size: 22px;
    color: #fff;
}
.box {
	margin: 100px auto;
	width: 500px;
	height: 50px;
	text-align: center;
}

.container-1 {
	overflow: hidden;
	width: 500px;
	vertical-align: middle;
	white-space: nowrap;
}

.container-1 input#search {
	width: 500px;
	height: 50px;
	background: #2b303b;
	border: none;
	font-size: 10pt;
	float: left;
	color: #fff;
	padding-left: 15px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}

.container-1 button.icon {
	-webkit-border-top-right-radius: 5px;
	-webkit-border-bottom-right-radius: 5px;
	-moz-border-radius-topright: 5px;
	-moz-border-radius-bottomright: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: none;
	background: #232833;
	height: 50px;
	width: 50px;
	color: #4f5b66;
	opacity: 0;
	font-size: 10pt;
	-webkit-transition: all .55s ease;
	-moz-transition: all .55s ease;
	-ms-transition: all .55s ease;
	-o-transition: all .55s ease;
	transition: all .55s ease;
}

.container-1:hover button.icon, .container-4:active button.icon,
	.container-4:focus button.icon {
	outline: none;
	opacity: 1;
	margin-left: -50px;
}

.container-1:hover button.icon:hover {
	background: white;
}
</style>
</head>
<body>
	<form action="search" method="get">
		<div>
			<div class="box">
			<h3>WebSoSanh - Công cụ tìm kiếm giá cả trực tuyến</h3>
				<div class="container-1">
				
					<input type="search" name="item" id="search"
						placeholder="Search..." />
					<button class="icon">
						<i class="fa fa-search"></i>
					</button>
				</div>
				
			</div>
		</div>
	</form>
</body>
</html>
