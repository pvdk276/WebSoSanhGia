<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web báo giá</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>

@import url(http://fonts.googleapis.com/css?family=Oxygen+Mono);
/* Starter CSS for Menu */
#cssmenu {
  padding: 0;
  margin: 0;
  border: 0;
  width: auto;
}
#cssmenu ul,
#cssmenu li {
  list-style: none;
  margin: 0;
  padding: 0;
}
#cssmenu ul {
  position: relative;
  z-index: 597;
}
#cssmenu ul li {
  float: left;
  min-height: 1px;
  vertical-align: middle;
}
#cssmenu ul li.hover,
#cssmenu ul li:hover {
  position: relative;
  z-index: 599;
  cursor: default;
}
#cssmenu ul ul {
  visibility: hidden;
  position: absolute;
  top: 100%;
  left: 0;
  z-index: 598;
  width: 100%;
}
#cssmenu ul ul li {
  float: none;
}
#cssmenu ul ul ul {
  top: 0;
  left: 190px;
  width: 190px;
}
#cssmenu ul li:hover > ul {
  visibility: visible;
}
#cssmenu ul ul {
  bottom: 0;
  left: 0;
}
#cssmenu ul ul {
  margin-top: 0;
}
#cssmenu ul ul li {
  font-weight: normal;
}
#cssmenu a {
  display: block;
  line-height: 1em;
  text-decoration: none;
}
/* Custom CSS Styles */
#cssmenu {
  background: #333333;
  border-bottom: 4px solid #1b9bff;
  font-family: 'Oxygen Mono', Tahoma, Arial, sans-serif;
  font-size: 12px;
}
#cssmenu > ul {
  *display: inline-block;
}
#cssmenu:after,
#cssmenu ul:after {
  content: '';
  display: block;
  clear: both;
}
#cssmenu ul {
  text-transform: uppercase;
}
#cssmenu ul ul {
  border-top: 4px solid #1b9bff;
  text-transform: none;
  min-width: 190px;
}
#cssmenu ul ul a {
  background: #1b9bff;
  color: #ffffff;
  border: 1px solid #0082e7;
  border-top: 0 none;
  line-height: 150%;
  padding: 16px 20px;
  font-size: 12px;
}
#cssmenu ul ul ul {
  border-top: 0 none;
}
#cssmenu ul ul li {
  position: relative;
}
#cssmenu ul ul li:first-child > a {
  border-top: 1px solid #0082e7;
}
#cssmenu ul ul li:hover > a {
  background: #4eb1ff;
  color: #ffffff;
}
#cssmenu ul ul li:last-child > a {
  -moz-border-radius: 0 0 3px 3px;
  -webkit-border-radius: 0 0 3px 3px;
  border-radius: 0 0 3px 3px;
  -moz-background-clip: padding;
  -webkit-background-clip: padding-box;
  background-clip: padding-box;
  -moz-box-shadow: 0 1px 0 #1b9bff;
  -webkit-box-shadow: 0 1px 0 #1b9bff;
  box-shadow: 0 1px 0 #1b9bff;
}
#cssmenu ul ul li:last-child:hover > a {
  -moz-border-radius: 0 0 0 3px;
  -webkit-border-radius: 0 0 0 3px;
  border-radius: 0 0 0 3px;
  -moz-background-clip: padding;
  -webkit-background-clip: padding-box;
  background-clip: padding-box;
}
#cssmenu ul ul li.has-sub > a:after {
  content: '+';
  position: absolute;
  top: 50%;
  right: 15px;
  margin-top: -8px;
}
#cssmenu ul li:hover > a,
#cssmenu ul li.active > a {
  background: #1b9bff;
  color: #ffffff;
}
#cssmenu ul li.has-sub > a:after {
  content: '+';
  margin-left: 5px;
}
#cssmenu ul li.last ul {
  left: auto;
  right: 0;
}
#cssmenu ul li.last ul ul {
  left: auto;
  right: 99.5%;
}
#cssmenu a {
  background: #333333;
  color: #CBCBCB;
  padding: 0 20px;
}
#cssmenu > ul > li > a {
  line-height: 48px;
  font-size: 12px;
}

</style>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li><a href='http://localhost:8080/webss/'><span>Web Báo Giá</span></a></li>
   <li class='active has-sub'><a href='http://localhost:8080/webss/'><span>Sản phẩm</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Điện thoại - Máy tính bảng</span></a>
            <ul>
               <li><a href='http://localhost:8080/webss/dienthoai'><span>Điện thoại di động</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/maytinhbang'><span>Máy tính bảng</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/smartwatch'><span>Smart watch</span></a></li>
                <li class='last'><a href='http://localhost:8080/webss/phukiendidong'><span>Phụ kiện di động</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Tin học</span></a>
            <ul>
               <li><a href='http://localhost:8080/webss/laptop'><span>Laptop</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/maytinhdeban'><span>Máy tính để bàn</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/linhkienlaptop'><span>Linh kiện laptop</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/linhkienpc'><span>Linh kiện máy tính để bàn</span></a></li>
               
            </ul>
         </li>
          <li class='has-sub'><a href='#'><span>Điện lạnh</span></a>
            <ul>
               <li><a href='http://localhost:8080/webss/dieuhoa'><span>Điều hòa</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/tulanh'><span>Tủ lạnh</span></a></li>
               <li class='last'><a href='http://localhost:8080/webss/tumat'><span>Tủ mát</span></a></li>
               
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>About</span></a></li>
   
</ul>
</div>
</body>
</html>