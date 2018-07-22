/**
 * 
 */
$(document).ready(function(){

	let currTime = new Date();	
	let oldtime = currTime.getTime();
	let time =JSON.stringify(oldtime);
	localStorage.setItem("currTime",time);
});