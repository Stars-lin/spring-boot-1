var clock_email = '',clock_phone='';
var nums_email = 60,nums_phone=60;
var btn_email,btn_phone;

var code_email,code_phone;


/*warning*/
var email_warning_text = ["邮箱不能为空","请输入正确的邮箱格式","该邮箱已经被注册"];
var code_warning_text = ["验证码不能为空","请输入正确的验证码"];
var password_warning_text = ["请输入6-16位数字或字母，字母区分大小写","两次密码不一致"];
var phone_warning_text = ["手机号码不能为空","请输入正确的手机号码","该手机号码已经被注册"];

/*email注册
 * 
 * 判断邮箱*/
function checkEmail(e_mail){
	var is_email = false;
	//判断内容是否为空
	if(e_mail == ""){
		$("#check-email-warning").text(email_warning_text[0]);
		$("#email").css("border-color","red");
		return is_email;
	}
	//判断邮箱是否正确
	var text = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
	if(text.test(e_mail)){
		is_email = true;
	}else{
		$("#email").css("border-color","red");
		$("#check-email-warning").text(email_warning_text[1]);
	}
	return is_email;
}
/*判断邮箱验证码*/
function checkEmailCode(code){
	var is_code = false;
	//判断验证码是否正确
	if(code === code_email){
		is_code = true;
	}else{
		$("#check-email-warning").text(code_warning_text[1]);
		$("#code-email").css("border-color","red");
	}
	return is_code;
}
/*判断密码*/
function checkEmailPassword(password){
	var is_password = false;
	var text = /[0-9a-zA-Z]{6,16}/;
	if(!text.test(password)){
		$("#check-email-warning").text(password_warning_text[0]);
		$("#password-email").css("border-color","red");
	}else{
		is_password = true;
	}
	return is_password;
}

/*手机
 *手机号码检查
 */
/*判断手机号码*/
function checkPhone(phone){
	var is_phone = false;
	//判断内容是否为空
	if(phone == ""){
		$("#check-phone-warning").text(phone_warning_text[0]);
		$("#phone").css("border-color","red");
		return is_phone;
	}
	//判断邮箱是否正确
	var text = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
	if(text.test(phone)){
		is_phone = true;
	}else{
		$("#phone").css("border-color","red");
		$("#check-phone-warning").text(phone_warning_text[1]);
	}
	return is_phone;
}
/*判断手机号码验证码*/
function checkPhoneCode(code){
	var is_code = false;
	//判断验证码是否正确
	if(code === code_phone){
		is_code = true;
	}else{
		$("#check-phone-warning").text(code_warning_text[1]);
		$("#code-phone").css("border-color","red");
	}
	return is_code;
}
/*判断密码*/
function checkPhonePassword(password){
	var is_password = false;
	var text = /[0-9a-zA-Z]{6,16}/;
	if(!text.test(password)){
		$("#check-phone-warning").text(password_warning_text[0]);
		$("#password-phone").css("border-color","red");
	}else{
		is_password = true;
	}
	return is_password;
}

function sendEmailCode(thisBtn) {
	var email = $("#email").val();
	
	if(!checkEmail(email)) return;
	
	btn_email = thisBtn;
	btn_email.disabled = true; //将按钮置为不可点击
	$.post("../register/emailCode",{"e_mail":email},function(data){
		code_email = data;
	});
	btn_email.value = nums_email + '秒';
	clock_email = setInterval(doLoopEmail, 1000); //一秒执行一次
}
function sendPhoneCode(thisBtn) {
	var phone = $("#phone").val();
	if(!checkPhone(phone)) return;
	
	btn_phone = thisBtn;
	btn_phone.disabled = true; //将按钮置为不可点击
	$.post("../register/phoneCode",{"u_phone":phone},function(data){
		code_phone = data;
	});
	btn_phone.value = nums_phone + '秒';
	clock_phone = setInterval(doLoopPhone, 1000); //一秒执行一次
}
function doLoopPhone() {
	nums_phone--;
	if(nums_phone > 0) {
		btn_phone.value = nums_phone + '秒';
	} else {
		clearInterval(clock_phone); //清除js定时器
		btn_phone.disabled = false;
		btn_phone.value = '获取';
		nums_phone = 60; //重置时间
	}
}
function doLoopEmail() {
	nums_email--;
	if(nums_email > 0) {
		btn_email.value = nums_email + '秒';
	} else {
		clearInterval(clock_email); //清除js定时器
		btn_email.disabled = false;
		btn_email.value = '获取';
		nums_email = 60; //重置时间
	}
}
$(function(){
	/*email foucs*/
	$("#email").focus(function(){
		this.style = "border-color:white";
		$("#email-note").removeClass();
		for(var i=0;i<email_warning_text.length;i++){
			if($("#check-email-warning").text() === email_warning_text[i]){
				$("#check-email-warning").text("");
				break;
			}
		}
	});
	$("#code-email").focus(function(){
		this.style = "border-color:white";
		for(var i=0;i<code_warning_text.length;i++){
			if($("#check-email-warning").text() === code_warning_text[i]){
				$("#check-email-warning").text("");
				break;
			}
		}
	});
	$("#password-email").focus(function(){
		var warning_text = $("#check-email-warning").text();
		if(warning_text === password_warning_text[0]){
			 $("#check-email-warning").text("")
	 		 this.style = "border-color:white";
		}
	})
	$("#passwordRepeat-email").focus(function(){
		this.style = "border-color:white";
	})
	/*phone foucs*/
	$("#phone").focus(function(){
		this.style = "border-color:white";
		$("#phone-note").removeClass();
		for(var i=0;i<phone_warning_text.length;i++){
			if($("#check-phone-warning").text() === phone_warning_text[i]){
				$("#check-phone-warning").text("");
				break;
			}
		}
	})
	$("#code-phone").focus(function(){
		this.style = "border-color:white";
		for(var i=0;i<code_warning_text.length;i++){
			if($("#check-phone-warning").text() === code_warning_text[i]){
				$("#check-phone-warning").text("");
				break;
			}
		}
	});
	$("#password-phone").focus(function(){
		var warning_text = $("#check-phone-warning").text();
		if(warning_text === password_warning_text[0]){
			 $("#check-phone-warning").text("")
	 		 this.style = "border-color:white";
		}
	})
	$("#passwordRepeat-phone").focus(function(){
		this.style = "border-color:white";
	})
	/*email blur*/
	//检查邮箱是否注册
	$("#email").blur(function(){
		var is_email_exit = false;
		var e_mail = $("#email").val();
		if(!checkEmail(e_mail)) return;
		$.post("../register/checkEmail",{'e_mail':this.value},function(data){
			if(data){
				$("#email-note").addClass("check-true");
				is_email_exit = true;
			}else{
				$("#email-note").addClass("check-false");
				$("#check-email-warning").text(email_warning_text[2]);
			}
		});
		return is_email_exit;
	});
	$("#password-email").blur(function(){
		checkEmailPassword(this.value);
		var warning_text =  $("#check-email-warning").text();
		if(warning_text === password_warning_text[1]){
			if(this.value === $("#passwordRepeat-email").val()){
				this.style = "border-color:white";
				$("#check-email-warning").text("");
				$("#passwordRepeat-email").css("border-color","white");
			}
		}
	})
	$("#passwordRepeat-email").blur(function(){
		if(this.value != $("#password-email").val()){
			$("#check-email-warning").text(password_warning_text[1]);
			$("#password-email").css("border-color","red");
			$(this).css("border-color","red");
		}else{
			$("#check-email-warning").text("");
			this.style = "border-color:white";
			$("#password-email").css("border-color","white");
		}
	})
	/*phone blur*/
	$("#phone").blur(function(){
		var is_phone_exit = false;
		var phone = $("#phone").val();
		if(!checkPhone(phone)) return;
		$.post("../register/checkPhone",{'u_phone':this.value},function(data){
			if(data){
				$("#phone-note").addClass("check-true");
				is_phone_exit = true;
			}else{
				$("#phone-note").addClass("check-false");
				$("#check-phone-warning").text(phone_warning_text[2]);
			}
		});
		return is_phone_exit;
	})
	$("#password-phone").blur(function(){
		checkPhonePassword(this.value);
		var warning_text =  $("#check-phone-warning").text();
		if(warning_text === password_warning_text[1]){
			if(this.value === $("#passwordRepeat-phone").val()){
				this.style = "border-color:white";
				$("#check-phone-warning").text("");
				$("#passwordRepeat-phone").css("border-color","white");
			}
		}
	})
	$("#passwordRepeat-phone").blur(function(){
		if(this.value != $("#password-phone").val()){
			$("#check-phone-warning").text(password_warning_text[1]);
			$("#password-phone").css("border-color","red");
			$(this).css("border-color","red");
		}else{
			$("#check-phone-warning").text("");
			this.style = "border-color:white";
			$("#password-phone").css("border-color","white");
		}
	})
	
	/*判断是否勾选email注册同意服务*/
	$("#reader-me-email").change(function(){
		if(this.checked){
			$("#register-email").removeAttr("disabled");
		}else{
			$("#register-email").attr("disabled","false");
		}
	});
	
	//邮箱注册按钮
	$("#register-email").click(function(){
		var email = $("#email").val();
		var code = $("#code-email").val();
		var pwd = $("#password-email").val();
		var pwd_repeat = $("#passwordRepeat-email").val();
		
		if(!checkEmail(email)) return;
		if(!checkEmailCode(code)) return;
		if(!checkEmailPassword(pwd)) return;
		if(pwd != pwd_repeat) return;
		
		var formparam = $("#form-email").serialize();
		$.post("../register/addUserByEmail",formparam,function(data){
			if(data){
				alert("注册成功！");
				location.href = "login.html"
			}
		})
	});
	
	/*判断是否勾选phone注册同意服务*/
	$("#reader-me-phone").change(function(){
		if(this.checked){
			$("#register-phone").removeAttr("disabled");
		}else{
			$("#register-phone").attr("disabled","false");
		}
	})
	//手机注册按钮
	$("#register-phone").click(function(){
		var phone = $("#phone").val();
		var code = $("#code-phone").val();
		var pwd = $("#password-phone").val();
		var pwd_repeat = $("#passwordRepeat-phone").val();
		
		if(!checkPhone(phone)) return;
		if(!checkPhoneCode(code)) return;
		if(!checkPhonePassword(pwd)) return;
		if(pwd != pwd_repeat) return;
		var formparam = $("#form-phone").serialize();
		$.post("../register/addUserByPhone",formparam,function(data){
			if(data){
				alert("注册成功！");
				location.href = "login.html"
			}
		})
	});
	
	
	
});
