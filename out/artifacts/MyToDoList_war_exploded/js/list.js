window.onload = function(){

	var list = document.getElementById("list");
	var worklist= document.getElementById("worklist");
	var addlist = document.getElementById("addlist");
	/*===========添加清单===========*/
	addlist.onclick = function(){
		// var node = document.createElement("li");
		if (document.getElementById("newlist") == undefined){
			var input = document.createElement("input");
			input.id = "newlist";
			input.type = "text";
			input.value = "新建清单";
			/* input.focus();
			input.select; */
			//添加
			var submit = document.createElement("button");
			submit.id = "submit";
			submit.innerHTML = "添加";
			submit.onclick = function(){
				//将input里的内容加到清单列表中
				window.location.href="AddListServlet?name="+input.value;
				list.removeChild(input);
				list.removeChild(submit);
				list.removeChild(cancel);
			}
			//取消添加
			var cancel = document.createElement("button");
			cancel.id = "cancel";
			cancel.innerHTML = "取消";
			cancel.onclick = function(){
				// alert("cancel");
				list.removeChild(input);
				list.removeChild(submit);
				list.removeChild(cancel);
			}
			list.appendChild(input);
			list.appendChild(submit);
			list.appendChild(cancel);
		}
		return false;
	}
	
	/*========删除、重命名清单========*/
	var menu = document.getElementById("menu");//右键菜单
    var ul = menu.getElementsByTagName("ul")[0];
	var lis = worklist.getElementsByTagName("li");
	for(var i = 0; i < lis.length; i++){
		lis[i].oncontextmenu = function(e){
			var evt = e || event;
            evt.preventDefault();
			var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
			menu.style.display = "block";
			menu.style.left = evt.clientX + "px";
			//当滑动滚动条时也能准确获取菜单位置
			menu.style.top = evt.clientY + scrollTop + "px";
			//将li与菜单一一对应
			ul.id = this.id;
			return false;
		}
	}
	document.onclick = function(){
		menu.style.display = "none";
	}
	menu.getElementsByTagName("ul")[0].onclick = function (e) {
        menu.style.display = "none";
		var t = e.target;
		if (t.innerText == '重命名') {
			var newname = prompt("请填写新名字：");
			//修改清单名
            if (newname != null && newname != ""){
                window.location.href = "UpdateListServlet?id="+this.id+"&name="+newname;
            }
		}
		else if (t.innerText == '删除清单') {
			if(confirm("确认删除？")){
			    window.location.href = "DeleteListServlet?id="+this.id;
            }
		}
	}

	/*========打开/关闭搜索页面=========*/
	var search = document.getElementById("search");
	search.onclick = function(){
		if (getComputedStyle(this)["backgroundColor"] == "rgb(255, 255, 255)"){
			//打开搜索页面
			this.style.backgroundColor = "#ededed";
			this.href = "search.jsp";
		}else{
			//关闭搜索页面
			this.style.backgroundColor = "#fff";
			this.href = "FindAllWorkServlet";
		}
	}
}