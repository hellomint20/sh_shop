function branchDelete(shopNo) { //지점 삭제

	$.ajax({
		url: "/shop/branchDelete", type: "post",
		data: JSON.stringify(shopNo),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(result) {
			console.log("통신 성공");
			if (result == '1') {
				alert("삭제 되었습니다");
				location.href = "/shop/branchList";
			} else if (result == '0') {
				alert("삭제 실패");
				location.href = "/shop/branchList";
			}
		},
		error: () => {
			console.log("문제 발생");
		}
	})
}

//지점 정보 수정 페이지
function branchModiPage(shopNo) {
	let f = document.createElement('form');

	let obj;
	obj = document.createElement('input');
	obj.setAttribute('type', 'hidden');
	obj.setAttribute('name', 'shopNo');
	obj.setAttribute('value', shopNo);

	f.appendChild(obj);
	f.setAttribute('method', 'post');
	f.setAttribute('action', '/shop/branchModi.page');
	document.body.appendChild(f);
	f.submit();
}

//지점 정보 수정 DB 등록
function branchModiDo() {
	let form = {};
	let arr = $("#branchModiDo").serializeArray();
	arr.forEach(data => {
		form[data.name] = data.value;
	});
	form['shopNo'] = document.getElementById("shopNo").value;
	console.log(form)

	$.ajax({
		url: "/shop/branchModi.do", 
		type: "post",
		data: JSON.stringify(form),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(result) {
			if (result.result === 1) {
				alert("지점 정보 수정 성공");
				location.href = "/shop/branchList";
			} else if (result.result === 99) {
				alert("지점 정보 수정 실패");
				location.reload();
			}
		},
		error: () => {
			alert("통신 문제 발생")
		}
	})
}