window.onload = function(){
	var button = document.getElementsByTagName("button");
	var doing = document.getElementById("doing");
	var done = document.getElementById("done");
	/*===========工作内容的隐藏与显示===========*/
	button[0].onclick = function(){
		if(doing.style.display != "none"){
			doing.style.display = "none";
			this.style.backgroundImage = "url(images/jiantou_you.png)";
		}else{
			doing.style.display = "block";
			this.style.backgroundImage = "url(images/jiantou_xia.png)";
		}
	}
	button[1].onclick = function(){
		if(done.style.display != "none"){
			done.style.display = "none";
			this.style.backgroundImage = "url(images/jiantou_you.png)";
		}else{
			done.style.display = "block";
			this.style.backgroundImage = "url(images/jiantou_xia.png)";
		}
	}
	/*==============工作任务的删除============*/
	var menu = document.getElementById("menu");//右键菜单
	var ul = menu.getElementsByTagName("ul")[0];
	var doingworks = doing.getElementsByTagName("li");
	var doneworks = done.getElementsByTagName("li");
	for (var i = 0; i < doingworks.length; i++) {
		doingworks[i].oncontextmenu = function (e) {
			var evt = e || event;
			evt.preventDefault();
			var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
			menu.style.display = "block";
			menu.style.left = evt.clientX + "px";
			//当滑动滚动条时也能准确获取菜单位置
			menu.style.top = evt.clientY + scrollTop + "px";
			ul.id = this.id;
		}
	}
	for (var i = 0; i < doneworks.length; i++){
		doneworks[i].oncontextmenu = function(e){
			var evt = e || event;
			evt.preventDefault();
			var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
			menu.style.display = "block";
			menu.style.left = evt.clientX + "px";
			//当滑动滚动条时也能准确获取菜单位置
			menu.style.top = evt.clientY + scrollTop + "px";
			ul.id = this.id;
		}
	}
	document.onclick = function(){
		menu.style.display = "none";
	}
	ul.onclick = function (e) {
		menu.style.display = "none";
		var t = e.target;
		if (t.innerText == '删除任务') {
			if(confirm("确认删除？")){
				window.location.href = "DeleteWorkServlet?id="+this.id;
			}
		}
	}       
	
	
	/*===========完成与未完成的切换===========*/
	var imgs1 = doing.getElementsByTagName("img");
	var imgs2 = done.getElementsByTagName("img");
	for(var i = 0; i < imgs1.length; i++){
		imgs1[i].id = doingworks[i].id;
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
			window.location.href = "UpdateWorkServlet?id="+this.id+"&state='未完成'";
		}
	}
	for(var j = 0; j < imgs2.length; j++){
		imgs2[j].id = doneworks[j].id;
		imgs2[j].onmouseover = function(){
			this.src = "images/doing_active.png";
		}
		imgs2[j].onmouseout = function(){
			this.src = "images/done.png";
		}
		imgs2[j].onmousedown = function(){
			this.src = "images/doing_hover.png";
		}
		imgs2[j].onmouseup = function(){
			this.src = "images/doing.png";
			window.location.href = "UpdateWorkServlet?id="+this.id+"&state='已完成'";
		}
	}
	
	/*============添加新任务============*/
	var newtask = document.getElementById("newtask");
	newtask.onkeydown = function(e){
		var evt = e || event;
		if (evt.keyCode == 13){//按下回车建
			// alert("添加任务");
			//将任务添加到数据库
			window.location.href = "AddWorkServlet?description="+newtask.value;
			newtask.value = "";
		}
	}
	
}