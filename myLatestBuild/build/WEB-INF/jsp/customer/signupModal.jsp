<style>
.singInp{
	margin-bottom:2.7% !important;
	height:5% !important;
}
.control-label{
	font-size:12pt;
	margin-bottom:12% !important;
}
</style> 
<div class="modal fade hide" id="signupModal">
  <div class="modal-header">
    <button class="close" data-dismiss="modal">X</button>
    <h3>GasGuz Signup</h3>
  </div>
<div class="modal-body">
    <p>Hi There!</p>
	<p>We are excited that you want to try out GasGuz, save money and help the planet in the process! All you have to do is fill out some basic info about yourself and voila. You will then log in, fillout some payment information and it's your show!</p>
	
  <legend>Please share some information with us.</legend>
	 <fieldset>
	 	<div  style=" width:30%">
			<label class="control-label" for="fname">	<b>First Name:</b>
			</label>
			<label class="control-label" for="lname">	<b>Last Name:</b>	
			</label>
			<label class="control-label" for="email">	<b>Email:</b>	
			</label>	
			<label class="control-label" for="username">	<b>Username:</b>	
			</label>	
			<label class="control-label" for="password">	<b>Password:</b>	
			</label>
			<label class="control-label" for="password2"> <b>Retype Password:</b>	
			</label>
		</div>
	  </fieldset>	
	
<div  style="margin-left:30%;margin-top:-42%">
	<input type="text" style="background:rgba(255,0,0,.5)" class='singInp' name='fname' id="fname" />
	<input type="text" style="background:rgba(255,0,0,.5)" class=' singInp' name='lname' id="lname" />  
	<input type="text" style="background:rgba(255,0,0,.5)" class=' singInp' name='email' id="email" />
	<input type="text" style="background:rgba(255,0,0,.5)" class=' singInp' name='username' id="username" />
	<input  class=' singInp' style="background:rgba(255,0,0,.5)" type="password" name='password' id="password"/>
	<input  class=' singInp' style="background:rgba(255,0,0,.5)" type="password" name='password2' id="password2" />
</div>

  </div>
  <div class="modal-footer">
    <button id ='signupButtonSubmit' class="btn btn-inverse regButton" disabled="disabled">Sign Me Up!</button>
  </div>
</div>

<script>
$(document).ready(function(){

	showSignupModal = function(){
		
			$('#signupModal').modal('show');
			return false;
		}
		//Load Modal
		$('#signupModal').modal({
			keyboard:true,
			backdrop:true,
			show:false
			});

		
		
		//Signup form validation
		$(".singInp").keyup( function() {
			var iObj = $(this);
		
			switch(iObj.attr('name')){
				case "fname":
					if(iObj.val().length>0)iObj.css('background',"rgba(0,255,0,.5)");
					else iObj.css('background',"rgba(255,0,0,.5)");
				break;
				case "lname":
					if(iObj.val().length>0)iObj.css('background',"rgba(0,255,0,.5)");
					else iObj.css('background',"rgba(255,0,0,.5)");	
				break;
				case "email":
					var inpu =iObj.val();

						var atpos=inpu.indexOf("@");
						var dotpos=inpu.lastIndexOf(".");
						if (atpos<1 || dotpos<atpos+2 || dotpos+2>=inpu.length){
								iObj.css('background',"rgba(255,0,0,.5)");	
							}
						else{
							iObj.css('background',"rgba(0,255,0,.5)");
						} 
				break;
				case "username":
					if(iObj.val().length>=6) iObj.css('background',"rgba(0,255,0,.5)");
					else iObj.css('background',"rgba(255,0,0,.5)");	
				break;
				case "password":
					testPasswords();
				break;
				case "password2":
					testPasswords();
				break;
			}
		
			if(checkAllInputs()){
				$('#signupButtonSubmit').removeAttr("disabled");
			}
			else{
				$('#signupButtonSubmit').attr("disabled","disbaled");
			}
		});
		
		function testPasswords(){
			var p1= $('#password'), p2 = $('#password2');
			if(p1.val()==p2.val() && p1.val().length>6 && p2.val().length>6){
				p1.css('background',"rgba(0,255,0,.5)");
				p2.css('background',"rgba(0,255,0,.5)");
			}
			else{
				p1.css('background',"rgba(255,0,0,.5)");	
				p2.css('background',"rgba(255,0,0,.5)");	
			}
		}
		function checkAllInputs(){
			var variable =true;
			var curColor;
			$('.singInp').each(function(){
 if($(this).css('backgroundColor').substring(5,$(this).css('backgroundColor').indexOf(','))=="255"){
					variable=false;
				}
			})
				return variable;
		}
		
		
		//SignupButton press
		$('#signupButtonSubmit').click(function(){
			$(this).attr('disbaled','disabled');
			var submissionObj = {};
					$('.singInp').each(function(){
						eval("submissionObj."+$(this).attr('name')+"='"+$(this).val()+"'");
					});
			
			$.post('customer/signup.html?method=signup',
			    {"fname":$("#fname").val(), "lname":$("#lname").val(), "email":$("#email").val(), "username":$("#username").val(), "password":$("#password").val()},
			    function(resp){
				if(resp.indexOf('userCreated_')>-1){
					var username = resp.substring(resp.indexOf('_')+1);
					$('#loginDiv').empty();
					$('#loginDiv').append('<h5> <div class="btn-group"> <a class="btn btn-xsmall btn-inverse dropdown-toggle" data-toggle="dropdown" style="background:#258800" href="#"><span class="caret"></span></a><ul class="dropdown-menu"><li><a href="#"> <i class="icon-pencil"></i> &nbsp;Flagged Documents</a></li><li><a href="#" onClick="logout()"><i class="icon-leaf"></i> &nbsp;Logout</a></li></ul>&nbsp;<i class="icon-user icon-white"></i> <a target="_blank" href="/userDashboard/userName_'+username+'">'+username+'</a></div></h5>');

					$('#signupModal').modal('hide');
					$('.singInp').each(function(){
						$(this).css("backgroundColor","rgba(255,0,0,.5)");
						$(this).val('');
						
					})
				}
				else{
					alert(resp)
				}
			})	
		})
})
</script>