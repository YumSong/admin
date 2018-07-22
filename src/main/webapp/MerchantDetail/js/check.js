/**
 * 
 */
$(document).ready(function(){
	let result = localStorage.getItem("result");
	if(result!=null){
		let status = JSON.parse(result).status;
		let t=localStorage.getItem("currTime");
		let newtime = new Date();
		let oldtime =JSON.parse(t);
		let minus=newtime.getTime()-oldtime;
		console.log("minus: "+minus);
		if(minus>1800000){
	    window.location.href="http://10.222.29.152:9999/admin/Login.html";
		}
		else if(status==true){
		console.log("logined");
		}else{
			window.location.href="http://10.222.29.152:9999/admin/Login.html";
		}
	}else{

		    window.location.href="http://10.222.29.152:9999/admin/Login.html";
			
	}
	
});