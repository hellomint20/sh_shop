function memberModifyPage(){ //수정 폼으로 변경
	let content = document.getElementById("memberInfo");
	let memberInfoId = document.getElementById("memberInfoId").value;
	let memberInfoPw = document.getElementById("memberInfoPw").value;
	let memberInfoName = document.getElementById("memberInfoName").value;
	let memberInfoShopName = document.getElementById("memberInfoShopName").value;
	let memberInfoAuthType = document.getElementById("memberInfoAuthType").value;
	content.innerHTML =
		`<form id="memberModify">
			<div class="row mb-3">
				<div class="col-md-6">
					<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="memberInfoId" name="memberId" type="text"
												 value=${memberInfoId} readonly />
											<label for="memberInfoId">아이디</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating">
											<input class="form-control" id="inputLamemberInfoPwstName" name="memberPw" type="password"
												 value=${memberInfoPw} />
											<label for="memberInfoPw">비밀번호</label>
										</div>
									</div>
								</div>
								<div class="form-floating mb-3">
									<input class="form-control" id="memberInfoName" type="text" name="memberName"
										 value=${memberInfoName} />
									<label for="memberInfoName">이름</label>
								</div>
								<div class="row mb-3">
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="memberInfoShopName" name="shopNo" type="text"
												  value=${memberInfoShopName} readonly/>
											<label for="memberInfoShopName">지점명</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="memberInfoAuthType" name="authType"
												type="text" value=${memberInfoAuthType} readonly/>
											<label for="memberInfoAuthType">관리자 등급</label>
										</div>
									</div>
								</div>
								<div class="mt-4 mb-0">
									<div class="d-grid"><button class="btn btn-secondary" type="button" onclick="memberModify()">수정하기</button>
									</div>
								</div>
							</form>`;
}
function memberModify(){ //수정 내용 DB 등록	 
		let form = {};
		let arr = $("#memberModify").serializeArray();
		arr.forEach( data => {
			form[data.name] = data.value;
		});		
		
		$.ajax({
			url : "/shop/memberModify", type : "post",
			data : JSON.stringify( form ),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(result){
				if(result == '1'){
					 alert("개인 정보 수정 성공");
			 		location.href="/shop/memberInfo";
				}else if(result == '0'){
					alert("개인 정보 수정 실패");
			 		location.href="/shop/memberInfo";
				}
			},
			error : () => {
				alert("통신 문제 발생")
			}
		})
}

function memberDelete(memberId) { //삭제	 
	var result = confirm("정말로 삭제 하시겠습니까?");

	if (result == true) {
		$.ajax({
			url: "/shop/memberDelete", type: "post",
			data: JSON.stringify(memberId),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(result) {
				if (result == '1') {
					alert("삭제 하였습니다.");
					location.href = "/shop/memberList";
				} else if (result == '0') {
					alert("삭제 실패");
					location.href = "/shop/memberList";
				}
			},
			error: () => {
				alert("통신 문제 발생")
			}
		})
	}
	else {
		alert("취소를 눌렀습니다.");
	}
}
