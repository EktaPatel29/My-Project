<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

<style>
.head{
border: 1px solid black;
   background-color: white; 
   height: 10%;
}
.logo{
font-family: Georgia;
font-size: 200%;
font-weight: italics;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    /* background-color: #333;
      */
}

li {
    float: left;
/*    border-right:1px solid #bbb;*/
}

li:last-child {
    border-right: none;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
  /*  background-color: white;*/
}
.active {
    background-color: #4CAF50;
    
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #F97E76;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    
    font-family: 'Open Sans', sans-serif;;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: #00004d;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color:#00004d;
   /* background-color: #f9f9f9;*/
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    
    font-family: 'Open Sans', sans-serif;
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.button {
   /* background-color: #4CAF50; Green */
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    padding: 4px 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button4 {
    background-color: white;
    color: black;
    border: 2px solid #e7e7e7;
}

.button4:hover {
background-color: #e7e7e7;
}

input[type=text] {
    width: 100%;
    // padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
}

input[type=text]:focus {
    border: 3px solid #555;

div.img {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}

}
</style>
</head>
<body>

 <div>
<ul>
<li class="head"><img src="images/logo.png" alt=" " /></li>   
<li style="float:right"><a href="#contact">Contact Us</a></li>
<li style="float:right"><a href="#news">My Cart</a></li>
<li style="float:right"><a href="#home">Login/Register</a></li>
</ul>
</div>

<div>
<ul>
  <li class="dropdown"><a href="#home" class="dropbtn">All Products</a>
 <div class="dropdown-content">
      <a href="#">Computer</a>
      <a href="#">Laptop</a>
      <a href="#">Pendrive</a>
    </div>
</li>
 <li class="dropdown"><a href="#home" class="dropbtn">Contract&Services</a>
 <div class="dropdown-content">
      <a href="#">AMC Contract</a>
      <a href="#">Maintenance</a>
      <a href="#">Repairing</a>
    </div>
</li>

  <li class="dropdown">
    <a href="#" class="dropbtn">Auction</a>
    <div class="dropdown-content">
      <a href="#">Products</a>
      <a href="#">Bid</a>
      <a href="#">Bidders</a>
    </div>
  </li>

 

<li style="float:right">
<button class="button button4">Search</button>
</li>

<li style="float:right">
      <input type="text" id="fname" name="fname" value="Search....">
    </li>

  </ul>
</div>

<div class="grid-product">
		  <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic13.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				</div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
              </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic2.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic3.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
		  <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic4.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
              </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic6.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic7.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
		  <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic8.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
              </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic11.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
			 <div class=" product-grid">
			<div class="content_box"><a href="single.html">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="images/pic12.jpg" class="img-responsive watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
</body>
</html>