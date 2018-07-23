/**
 * 
 */
/**
 * 
 */
	( getList=function (){
		
		let merchantDetails;
		let currNum =1;
		let pageLength =5;

		setPageLength = function(newLength){
			pageLength =newLength;
			getData(currNum);
		}
		
		
		
		getData = function(currNum){
			
		    $.ajax({
                type:"POST",
                url:"http://localhost:9999/admin/MerchantDetail/ListVerify.do",
                data:"pageNum="+currNum+"&pageLength="+pageLength,
                success:function(data){
                let result = JSON.parse(data);
                merchantDetails = result.data.list;
                pageUtil = result.data.pUtil;
                displayList(merchantDetails);
            },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("status:"+XMLHttpRequest.status+" readystatus:"+XMLHttpRequest.readyState+" textStatus:"+textStatus);//获取的信息即是异常中的Message
                } 
            });
			
		}
		
		getPage = function(pageNum){
			if(pageNum==="-1"){			
				if(currNum > 1){
					currNum =currNum-1;
					getData(currNum);
				}
			}else if(pageNum==="+1"){			
				if(pageUtil.total>pageUtil.endNum || pageUtil==""){
					currNum =currNum+1;
					getData(currNum);
				}
			}
					
		
		}
		
		refreshUpdate = function(merchantDetail){
			let oldtr =$("#"+merchantDetail.merchantDetailID);
			oldtr.remove();
			
		}
		
		
		updateStatus= function(merchantDetailID,status,lastUpdateTime){					 
			let id = merchantDetailID;
			let tStatus = status;
			let time = lastUpdateTime;			
			    $.ajax({
	                type:"POST",
	                url:"http://localhost:9999/admin/MerchantDetail/UpdateStatus.do",
	                data:"merchantDetailID="+id+"&status="+tStatus+"&lastUpdateTime="+time,
	                success:function(data){
	                let result = JSON.parse(data);
	                let flag = result.status;
	                console.log(flag);
	                if(flag==true){
	                	let merchantDetail = result.data.merchantDetail;
	                	refreshUpdate(merchantDetail);
	                }
	                else{
	                	let message = result.message;
	                	$("#message").html(message);
	                	$('#myModal').modal('show');
	                }
	            },
	                error:function (XMLHttpRequest, textStatus, errorThrown) {
	                	let message = "status:"+XMLHttpRequest.status+" readystatus:"+XMLHttpRequest.readyState+" textStatus:"+textStatus;
	                	$("#message").html(message);
	                	$('#myModal').modal('show');              
	                } 
	            });
		
		}
			
		getButtun = function(merchantDetailID,status,lastUpdateTime){
			let td = $("<td>");
			td.addClass("pmd-table-row-action");
			
			let a1 = $("<a>");
			a1.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
			let i1 = $("<i>done</i>");
			i1.addClass("material-icons md-dark pmd-sm");
			
			let a2 = $("<a>");
			a2.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
			let i2 = $("<i>update</i>");
			i2.addClass("material-icons md-dark pmd-sm");
			
			let a3 = $("<a>");
			a3.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
			let i3 = $("<i>clear</i>");
			i3.addClass("material-icons md-dark pmd-sm");
					
			let a4 = $("<a>");
			a4.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm child-table-expand direct-expand");
			a4.attr("id","bc"+merchantDetailID);
			let i4 = $("<i></i>");
			i4.addClass("material-icons md-dark pmd-sm");
		
			
			a1.on("click",function(){updateStatus(merchantDetailID,1,lastUpdateTime);});
			a2.on("click",function(){updateStatus(merchantDetailID,2,lastUpdateTime);});
			a3.on("click",function(){updateStatus(merchantDetailID,3,lastUpdateTime);});
			
			a4.on("click",function(){toggleC("c"+merchantDetailID);});
			
			a1.append(i1);
			a2.append(i2);
			a3.append(i3);
			a4.append(i4);
			td.append(a1);
			td.append(a2);
			td.append(a3);
			td.append(a4);
			
			return td;
		}
		
		getStatus = function(status){
			let td = $("<td>");
			
			let thisStatus="";
			if(status==0){
				thisStatus="未处理";
			}else if(status==1){
				thisStatus="同意";
			}else if(status==2){
				thisStatus="驳回";
			}else if(status==3){
				thisStatus="不同意";
			}
			
			td.html(thisStatus);
			return td;
		}
		
		createEle = function(merchantDetail){
			
			let mytr = $("<tr>");
			mytr.attr("id",merchantDetail.merchantDetailID);
		
			let idcardNum=$("<td>"+merchantDetail.idcardNum+"</td>");
			let merchantName=$("<td>"+merchantDetail.merchantName+"</td>");
			let introduction=$("<td>"+merchantDetail.introduction+"</td>");
			let address=$("<td>"+merchantDetail.address+"</td>");
			let status=getStatus(merchantDetail.status);
			let button = getButtun(merchantDetail.merchantDetailID,merchantDetail.status,merchantDetail.lastUpdateTime);			
			
			mytr.append(idcardNum);
			mytr.append(merchantName);
			mytr.append(introduction);
			mytr.append(address);
			mytr.append(status);
			mytr.append(button);
			return mytr;
		}
		
		ctreateChild = function(merchantDetail){
			
			let child = $("<tr>");
				child.addClass("child-table");
			let childTd = $("<td>");
				childTd.attr("colspan","12");
			let div = $("<div>");
				div.addClass("direct-child-table");
				div.attr("style","display:none;");
				div.attr("id","c"+merchantDetail.merchantDetailID);
			let table = $("<table>");
				table.addClass("table pmd-table table-striped table-sm");
				
			let thead = $("<thead>");
			let tr1 = $("<tr>");
			let td11 = $("<th>身份证图片</th>");
			let td12 = $("<th>营业执照图片</th>");
			let td13 = $("<th>店内图片1</th>");
			let td14 = $("<th>店内图片2</th>");
			tr1.append(td11);
			tr1.append(td12);
			tr1.append(td13);
			tr1.append(td14);
			thead.append(tr1);
			
			let tbody = $("<tbody>");
			let tr2 = $("<tr>");
			let td21 = $("<th><img src='"+merchantDetail.idcardPic+"'></th>");
			let td22 = $("<th><img src='"+merchantDetail.businessPic+"'></th>");
			if(merchantDetail.shopPic!=null){
				for(let i=0;i<merchantDetail.shopPic.length;i++){
					console.log(merchantDetail.shopPic[i]);
					tr2.append($("<th><img src='"+merchantDetail.shopPic[i]+"'></th>"));
					
				}
			}
			tr2.append(td21);
			tr2.append(td22);
			tbody.append(tr2);
			
			table.append(thead);
			table.append(tbody);
			div.append(table);
			childTd.append(div);
			child.append(childTd);		
			return child;
		}
		
		
		displayList = function(merchantDetails){

			let tbody = $("#dataTable");
			let tr =$("#dataTable>tr");
			tr.remove();

			for(let i =0,l=merchantDetails.length;i<l;i++){
				let mytr = createEle(merchantDetails[i]);
				let trchild = ctreateChild(merchantDetails[i]);
				tbody.append(mytr);
				tbody.append(trchild);
			}
			
			
		}
		
		getData(currNum);

		
	   toggleC=function (id) {
		   $("#"+id).toggle();
		   $("#b"+id).toggleClass("child-table-collapse");
		}
		
	})();
	

	