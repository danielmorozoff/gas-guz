<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<html>
<head>
	<script type="text/javascript" src='<c:url value="/javascripts/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/javascripts/bootstrap/js/bootstrap.min.js"/>'></script>
	<link href='<c:url value="/javascripts/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">

	<style>

	.staticLink{
		margin-left:6%;
		margin-right:6%;
		font-size:12pt;
		color:#686868;
		opacity:.75;
		text-shadow: 0px 1px 5px #000;
	}
	</style>
	<script>
	var showSignupModal;
	$(document).ready(function(){
		 
		$('#mainCarousel').carousel({
			interval:5000
		})

		$('#mainCarousel').bind("slid",function(event){
			 $(".staticLink")
			 .css("text-decoration","none")
			 .css("color","#686868")
			 .css("text-shadow","0px 1px 5px #000");

			 var id = $("#mainCarousel .active").attr('id');
			$('#'+id.substring(0,id.indexOf("Cont"))+'Link')
			.css("text-decoration","underline")
			.css("color","#7ACD28")
			.css("text-shadow","none");
		})

		$('.staticLink').click(function(){
			$(".staticLink").css("text-decoration","none")
			 .css("color","#686868")
			 .css("text-shadow","0px 1px 5px #000");

			$(this).css("text-decoration","underline")
			.css("color","#7ACD28")
			.css("text-shadow","none");

			var carouselObj = $('#mainCarousel');
			switch ($(this).attr('id')){
				case "hWorksLink":
					carouselObj.carousel(1);
				break;
				case "aUsLink":
					carouselObj.carousel(2);
				break;
				case "wSaidLink":
					carouselObj.carousel(3);
				break;
				case "vendorsLink":
					carouselObj.carousel(4);
				break;
			};
		});
	
	})

	</script>
</head>
	<body>
		<tiles:insert page="/WEB-INF/jsp/customer/loginDiv.jsp" />
		

		<div id="dynamicCentralContainer" style="background:#eee;height:69%;width:100%;box-shadow:0px 2px 50px #FFF" >
			<div id="mainCarousel" class="carousel slide" style="width:100%;height:100%;">
				  <!-- Carousel items -->
				  <div class="carousel-inner">
				  	
				  	<div class="active item" style="width:80%; margin:0 auto">
				  		<img style="margin-left:11%;height:100%" src='<c:url value="/images/gasguzMainWelcome.png"/>' />
				  	</div>
				  	<div id="hWorksCont" class="item"> 
				  		HOW IT WORKS
				  	</div>
				  	<div id="aUsCont" class="item"> 
				  		About Us
				  	</div>
				  	<div id="wSaidCont" class="item"> 
				  		What People are saying
				  	</div>
				  	<div id="vendorsCont" class="item"> 
				  		Vendors
				  	</div>

				   
				  </div>
				  <!-- Carousel nav -->
				  <a class="carousel-control left" href="#mainCarousel" data-slide="prev">&lsaquo;</a>
				  <a class="carousel-control right" href="#mainCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<div id="staticLinksContainer" style="background:#eee; width:100%;height:6%; text-align:center; margin-top:-2.5%; padding-top:2%">
				<a href="#hWorks" id="hWorksLink" class="staticLink">How it Works</a>
				<a href="#aUs" id="aUsLink" class="staticLink">About Us</a>
				<a href="#wSaid" id="wSaidLink" class="staticLink">What People Are Saying</a>
				<a href="#vendors" id="vendorsLink" class="staticLink">Vendors</a>
			</div>	
		</div>


<tiles:insert page="/WEB-INF/jsp/customer/signupModal.jsp" />


	</body>
</html>