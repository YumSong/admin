/**
 * 
 */
    (function(){
        let errMsg1 = "";
        let errMsg2 = "";
        let errMsg3 = "";
        let loginName;
        let loginPassword;
        check = function (){
            errMsg1 = "";
            errMsg2 = "";
            loginName = $("#loginName").val();
            loginPassword =$("#loginPassword").val();
            if(loginName.length==0){
                errMsg1="loginName can not be empty";;
            }
            if(loginPassword.length==0){
                errMsg2="loginPassword can not be empty";
            }
            if(loginName.length!=0&&loginPassword.length!=0){
                login();
            }
                warming();
            
             
        }
        
        login = function(){
		
            $.ajax({
                type:"POST",
                url:"http://10.222.29.152:9999/admin/Login.do",
                data:"loginName="+loginName+"&loginPassword="+loginPassword,
                success:function(data){
                let result = JSON.parse(data);
                console.log(result.status);
                if(result.status==false){
                	errMsg3 = result.message;
                	warming();
                	
                }else{
                	let currTime = new Date();
                	let oldtime = currTime.getTime();
                	let time =JSON.stringify(oldtime);
                	localStorage.setItem("currTime",time);
                	localStorage.setItem("result",data);
                    window.location.href="http://10.222.29.152:9999/admin/MerchantDetail/ListToUpdate.html";
                }
                console.log(data);
                
            },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("status:"+XMLHttpRequest.status+" readystatus:"+XMLHttpRequest.readyState+" textStatus:"+textStatus);//获取的信息即是异常中的Message
                } 
            });
           
        }
        
         warming = function(){
            let span1=$("#errMsg1");
            let span2=$("#errMsg2");
            let span3=$("#errMsg3");
             span1.html("");
             span2.html("");
             span3.html("");
            if(errMsg1.length!=""){
                span1.html(errMsg1);
            }
            if(errMsg2.length!=""){
                span2.html(errMsg2);
            }
            if(errMsg3.length!=""){
                span3.html(errMsg3);
            }
            $(".pmd-checkbox").css("color","red");
             
        }
        
    })();