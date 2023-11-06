// 재고 수정 페이지
function productModi(itemNo){
	console.log(itemNo)
	let f = document.createElement('form');
    
    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'itemNo');
    obj.setAttribute('value', itemNo);
    
    f.appendChild(obj);
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/shop/productModi');
    document.body.appendChild(f);
    f.submit();
}

//재고 수정 DB 등록
function productModiDo(){
	let itemCategory = document.getElementById("inputCategory").options[document.getElementById("inputCategory").selectedIndex].text;
	let itemState = document.getElementById("inputState").options[document.getElementById("inputState").selectedIndex].text;
	
	let form = new Object();
	let arr = $("#productModifyDo").serializeArray();
	arr.forEach( data => {
		form[data.name] = data.value;
	});
	
	form['itemNo'] = document.getElementById("itemNo").value;
	form['itemCategory'] = itemCategory;
	form['itemState'] = itemState;
	console.log(form);
	
	$.ajax({
		url : "/shop/productModiDo",
		type : "post",
		data : JSON.stringify(form),
		dataType : "JSON",
		contentType : "application/json; charset=utf-8",
		success : function(result){
			if(result.result == 1){
				alert("재고가 수정되었습니다");
				location.href = "/shop/productAllList";
			}else if(result.result == 99){
				alert("수정 하는데 문제가 생겼어요!")
				location.reload();
			}
		},
		error : function(){
			console.log("서버 통신 에러")
		}
	})
}