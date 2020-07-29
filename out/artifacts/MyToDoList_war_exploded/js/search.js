window.onload = function(){
	var input = document.getElementById("input");
	var bg = document.getElementById("search_bg");
	if (input.value != ""){
		bg.style.display = "none";//背景图片的隐藏域显示
	}else{
		bg.style.display = "block";
	}
	input.oninput = function(){
		var bg = document.getElementById("search_bg");
		if (this.value != ""){
			bg.style.display = "none";//背景图片的隐藏域显示
			//模糊查询,放在oninput下频繁发送请求服务器压力大
			window.location.href = "FindWorkByDesServlet?description=" + this.value;
		}else{
			bg.style.display = "block";
			window.location.href = "search.jsp";
		}
	}

	/*===========完成与未完成的切换===========*/
	var doing = document.getElementById("doing");
	var done = document.getElementById("done");
	var imgs1 = doing.getElementsByTagName("img");
	var imgs2 = done.getElementsByTagName("img");
	for(var i = 0; i < imgs1.length; i++){
		var description = input.value;
		imgs1[i].onmouseover = function(){
			this.src = "images/doing_hover.png";
		}
		imgs1[i].onmouseout = function(){
			this.src = "images/doing.png";
		}
		imgs1[i].onmousedown = function(){
			this.src = "images/doing_active.png";
		}
		imgs1[i].onmouseup = function(){
			this.src = "images/done.png";
			window.location.href = "UpdateSearchWorkServlet?id="+this.id+"&state='未完成'&description="+description;
		}
	}
	for(var i = 0; i < imgs2.length; i++){
		var description = input.value;
		imgs2[i].onmouseover = function(){
			this.src = "images/doing_active.png";
		}
		imgs2[i].onmouseout = function(){
			this.src = "images/done.png";
		}
		imgs2[i].onmousedown = function(){
			this.src = "images/doing_hover.png";
		}
		imgs2[i].onmouseup = function(){
			this.src = "images/doing.png";
			window.location.href = "UpdateSearchWorkServlet?id="+this.id+"&state='已完成'&description="+description;
		}
	}
}