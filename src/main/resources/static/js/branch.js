function branchDelete(shopNo){ //지점 삭제
	console.log(shopNo)
	
	$.ajax({
		url : "/shop/branchDelete", type : "post",
		data : JSON.stringify(shopNo),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(result){
			console.log("통신 성공");
			if(result == '1'){
					 alert("삭제 되었습니다");
			 		location.href="/shop/branchList";
				}else if(result == '0'){
					alert("삭제 실패");
			 		location.href="/shop/branchList";
				}
		},
		error : () =>{
			console.log("문제 발생");
		}
	})
}

function branchModifyPage() { //지점 정보 수정 페이지
	let content = document.getElementById("branchInfo");
	let branchInfoName = document.getElementById("branchInfoName").value;
	let branchInfoTel = document.getElementById("branchInfoTel").value;
	let branchInfoAddr = document.getElementById("branchInfoAddr").value;
	console.log(branchInfoAddr);
	let branchInfoManager = document.getElementById("branchInfoManager").value;
	let branchInfoManagerTel = document.getElementById("branchInfoManagerTel").value;
	content.innerHTML =
		`<form id="branchModify">
			<div class="row mb-3">
				<div class="col-md-6">
					<div class="form-floating mb-3 mb-md-0">
						<input class="form-control" id="branchInfoName" name="shopName" type="text"
							 value=${branchInfoName}  />
						<label for="branchInfoName">지점명</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-floating">
						<input class="form-control" id="branchInfoTel" name="shopTel" type="text"
							 value=${branchInfoTel} />
						<label for="branchInfoTel">전화번호</label>
					</div>
				</div>
			</div>
			<div class="form-floating mb-3">
				<input class="form-control" id="branchInfoAddr" type="text" name="shopAddr"
					 value="${branchInfoAddr}" />
				<label for="branchInfoAddr">주소</label>
			</div>
			<div class="row mb-3">
				<div class="col-md-6">
					<div class="form-floating mb-3 mb-md-0">
						<input class="form-control" id="branchInfoManager" name="managerName" type="text"
							  value=${branchInfoManager} />
						<label for="branchInfoManager">매니저</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-floating mb-3 mb-md-0">
						<input class="form-control" id="branchInfoManagerTel" name="managerHp"
							type="text" value=${branchInfoManagerTel} />
						<label for="branchInfoManagerTel">매니저 전화번호</label>
					</div>
				</div>
			</div>
			<div class="mt-4 mb-0">
				<div class="d-grid">
					<button class="btn btn-secondary btn-block" type="button" onclick="branchModify()">수정하기</button>
				</div>
			</div>
		</form>`;
}

function branchModify(){
	let form ={};
	let arr = $("#branchModify").serializeArray();
		arr.forEach( data => {
			form[data.name] = data.value;
		});
		console.log(form)
		
		$.ajax({
			url : "/shop/branchModify", type : "post",
			data : JSON.stringify( form ),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(result){
				console.log("통신 성공");
				console.log(result);
				if(result == '1'){
					 alert("지점 정보 수정 성공");
			 		location.href="/shop/branchInfo";
				}else if(result == '0'){
					alert("지점 정보 수정 실패");
			 		location.href="/shop/branchInfo";
				}
			},
			error : () => {
				alert("통신 문제 발생")
			}
		}) 
}