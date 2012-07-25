<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<html>
<head>
	<script type="text/javascript" src='<c:url value="/javascripts/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/javascripts/bootstrap/js/bootstrap.min.js"/>'></script>
	<link href='<c:url value="/javascripts/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">

	<title>GasGuz Welcome</title>
	<style>

	.staticLink{
		margin-left:6%;
		margin-right:6%;
		font-size:12pt;
		color:#686868;
		opacity:.75;
		text-shadow: 0px 1px 5px #000;
	}

	.textBody{
		height:70%;
		margin-top:1%;
		margin-left:14%;
		width:75%;
		font-family: Verdana, Geneva, sans-serif;
		font-size:14pt;

	}
	.listClass{
		margin-top:2%;
	}
	</style>
	<script>
	var showSignupModal;
	var saveEmail;
	$(document).ready(function(){
		 saveEmail = function(){

		 	


		 	$.post("/saveEmail",{"emailAddress":$('#emailInput').val(),"authTok":$('[name="authenticityToken"]').val() },function(resp){
		 		if(resp=="Success")$('#thankYouModal').modal('show');
		 		else {
		 			var header = $('#thankYouModal').children('.modal-header')[0];
		 			var body =	$('#thankYouModal').children('.modal-body')[0];

		 				$(header).html('<h3>Thanks For Being Super Excited About GasGuz!</h3>');
		 				$(body).html('<p>We already have you on file, but have dutily noted that you really care about the project!</p>');
		 			$('#thankYouModal').modal('show');	
		 			
		 		}

		 		})

		 	return false;

		 }
		$('#mainCarousel').carousel({
			interval:15000
		})

		$('#mainCarousel').bind("slid",function(event){
			 $(".staticLink")
			 .css("text-decoration","none")
			 .css("color","#686868")
			 .css("text-shadow","0px 1px 5px #000");

			 var id = $("#mainCarousel .active").attr('id');
			if (typeof id != "undefined"){ 
				$('#'+id.substring(0,id.indexOf("Cont"))+'Link')
				.css("text-decoration","underline")
				.css("color","#7ACD28")
				.css("text-shadow","none");
			}
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
				case "vendorsLink":
					carouselObj.carousel(3);
				break;
			};
		});
	
	})

	</script>
</head>
	<body>
		<tiles:insert page="/WEB-INF/jsp/customer/loginDiv.jsp" />
		
	<div id="dynamicCentralContainer" style="background:#eee;height:69%;width:100%;min-height:69%;box-shadow:0px 2px 50px #FFF" >
			<div id="mainCarousel" class="carousel slide" style="width:100%;height:100%;">
				  <!-- Carousel items -->
				  <div class="carousel-inner">
				  	
				  	<div class="active item" >
				  		<img style="margin-left:23%;height:80%;min-height:325px;min-width:325px;max-height:500px" src='<c:url value="/images/WelcomePage/gasguzLogo.png" />' />
				  	</div>
				  	<div id="hWorksCont" class="item" > 
				  		<img style="margin-left:12%;height:22%;max-height:100px" src="<c:url value='/images/WelcomePage/HowItWorksLogo.png' />" />
				  		<img style="margin-left:12%;height:65%;width:40%" src="<c:url value='/images/WelcomePage/HowItWorksSchematic.png'  />" />
				  		<div class="textBody" style="position:absolute;left:40%;top:23%;width:40%;height:80%">
				  			<ul style="list-style:decimal;">
				  				<li class="listClass">Sign-up with GasGuz. Access your account from any computer or mobile device. </li>

									<li class="listClass">When you’re ready to buy gas, login to your GasGuz account and take advantage of the various options given to you by our platform. Pre-buy and lock-in the price of gas. Share it with family and friends. Offset your carbon-footprint and/or share gas with your favorite non-profit organization. </li>

									<li class="listClass">Redeem gas from your account at selected stations. Redemption is as easy as a cash transaction.</li>

									<li class="listClass">With the price of gas changing so frequently the ability to pre-purchase gasoline that GasGuz gives you helps you save money and the environment!</li>
				  				
				  			</ul>	
				  		</div>	
				  	</div>
				  	<div id="aUsCont" class="item"> 
				  		<img style="margin-left:12%;height:22%;max-height:100px" src="<c:url value='/images/WelcomePage/gasguzAboutUsLogo.png'  />" />
				  		<div class="textBody">
				  			The gas station and its technology has changed little. Its purpose was simple; to transfer gas from station to automobile.  The GasGuz project plans on reinventing the gas station by implementing current newest technology. By introducing the latest technology into an age-old industry, GasGuz aims to give consumers the ability to consume gas in a frugal, responsible and convenient fashion.
				  			<br/>
				  			<br/>
							The reinvention of the gas station is by no means a modest task. GasGuz will develop in three phases, each building upon the other to create a more complete and integrated user experience.
							<br/>
							<br/>
							Phase 1 - This phase will be focused on frugality. 
							<br/>
							Phase 2 - This phase will focus on responsible consumption. 
							<br/>
							Phase 3 - This phase will focus on convenience
							<br/>
							<br/>
							Our team is composed of dedicated individuals from various backgrounds.
							With a strong core of engineering and business expertise from leading academic institutions, we lend ourselves to a distinctive approach in reinventing an enduring industry.

				  		</div>
				  	</div>
				  	<div id="vendorsCont" class="item"> 
				  		<img style="margin-left:12%;height:22%;max-height:100px" src="<c:url value='/images/WelcomePage/StationsLogo.png'  />" />
				  		<div class="textBody">
				  			Do you like what you see on our website? Operate a gas station? Want to see how GasGuz can help you increase your profit and reinvent your station? Please provide us with some of your contact information below so we can keep you updated on our progress. 
				  			
				  			<center>
				  				<h1 style='margin-top:5%;'><a href="mailto:contact@gasguz.com?subject=Would like more information about GasGuz!"> Contact Us!</a></h1>
				  			</center>
				  		</div>
				  	</div>

				   
				  </div>
				  <!-- Carousel nav -->
				  <a class="carousel-control left" href="#mainCarousel" data-slide="prev">&lsaquo;</a>
				  <a class="carousel-control right" href="#mainCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<div id="staticLinksContainer" style="background:#eee; width:100%;height:6%; text-align:center; margin-top:-2.5%; padding-top:2%">
				<a href="#hWorks" id="hWorksLink" class="staticLink">How it Works</a>
				<a href="#aUs" id="aUsLink" class="staticLink">About Us</a>
				<a href="#vendors" id="vendorsLink" class="staticLink">Own a Gas Station?</a>
			</div>	
		</div>

<tiles:insert page="/WEB-INF/jsp/customer/signupModal.jsp" />


	</body>
</html>