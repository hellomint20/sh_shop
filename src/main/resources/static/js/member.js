function memberModify() {
	let content = document.getElementById("memberInfo");
	let memberInfoId = document.getElementById("memberInfoId").value;
	let memberInfoPw = document.getElementById("memberInfoPw").value;
	let memberInfoName = document.getElementById("memberInfoName").value;
	let memberInfoShopName = document.getElementById("memberInfoShopName").value;
	let memberInfoAuthType = document.getElementById("memberInfoAuthType").value;
	content.innerHTML =
		`<form action="memberModify" method="post">
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
												  value=${memberInfoShopName} />
											<label for="memberInfoShopName">지점명</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="memberInfoAuthType" name="authType"
												type="text" value=${memberInfoAuthType} />
											<label for="memberInfoAuthType">관리자 등급</label>
										</div>
									</div>
								</div>
								<div class="mt-4 mb-0">
									<div class="d-grid"><input class="btn btn-secondary btn-block" type="submit" value="수정하기">
									</div>
								</div>
							</form>`;
}