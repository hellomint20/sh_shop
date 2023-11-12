// 재고 수정 페이지
function productModi(itemNo){
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
			alert("서버 통신 에러")
		}
	})
}

//재고 수량 수정 (재고 갯수 0 아닐때)
function stockCntModi(itemNo){
	let stock = document.getElementById(itemNo);
	let cnt = document.getElementById('cnt'+itemNo).innerHTML;
	var html = 
	`
	<input type="hidden" id="itemNo" value="${itemNo}">
	<input type="text" name="cnt" id="cnt" value="${cnt}" style="width:50%;">
	<button class="btn btn-sm btn-outline-secondary" style="float: right;" 
		 onclick="stockCntModiDo();">확인</button>`;
	stock.innerHTML = html;
}

//재고 수정 DB 등록(재고 갯수 0 아닐때)
function stockCntModiDo(){
	let itemCnt = document.getElementById("cnt").value;
	let shopNo = document.getElementById("shopNo").value;
	let itemNo = document.getElementById("itemNo").value;
 	
	let form = new Object();	
	form['itemCnt'] = itemCnt;
	form['shopNo'] = shopNo;
	form['itemNo'] = itemNo;
 	
 		$.ajax({
		url : "/shop/stockCntModiDo",
		type : "post",
		data : JSON.stringify(form),
		dataType : "JSON",
		contentType : "application/json; charset=utf-8",
		success : function(result){
			if(result.result == 1){
				alert("수량이 수정되었습니다");
				location.reload();
			}else if(result.result == 99){
				alert("수정 하는데 문제가 생겼어요!")
				location.reload();
			}
		},
		error : function(){
			alert("서버 통신 에러")
		}
	})
}
//재고 수량 수정(재고 갯수 0 일때)
function itemCntModi(itemNo){
	let stock = document.getElementById(itemNo);
	let cnt = document.getElementById('cnt'+itemNo).innerHTML;
	var html = 
	`
	<input type="hidden" id="itemNo" value="${itemNo}">
	<input type="text" name="cnt" id="cnt" value="${cnt}" style="width:50%;">
	<button class="btn btn-sm btn-outline-secondary" style="float: right;" 
		 onclick="itemCntModiDo();">확인</button>`;
	stock.innerHTML = html;
}
//재고 수정 DB 등록(재고 갯수 0 일때)
function itemCntModiDo(){
	let itemCnt = document.getElementById("cnt").value;
	let shopNo = document.getElementById("shopNo").value;
	let itemNo = document.getElementById("itemNo").value;
 	
	let form = new Object();	
	form['itemCnt'] = itemCnt;
	form['shopNo'] = shopNo;
	form['itemNo'] = itemNo;
 	
 		$.ajax({
		url : "/shop/itemCntModiDo",
		type : "post",
		data : JSON.stringify(form),
		dataType : "JSON",
		contentType : "application/json; charset=utf-8",
		success : function(result){
			if(result.result == 1){
				alert("수량이 수정되었습니다");
				location.reload();
			}else if(result.result == 99){
				alert("수정 하는데 문제가 생겼어요!")
				location.reload();
			}
		},
		error : function(){
			alert("서버 통신 에러")
		}
	})
}