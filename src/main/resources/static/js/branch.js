function branchModify() {
	let content = document.getElementById("branchInfo");
	let branchInfoName = document.getElementById("branchInfoName").value;
	let branchInfoTel = document.getElementById("branchInfoTel").value;
	let branchInfoAddr = document.getElementById("branchInfoAddr").value;
	console.log(branchInfoAddr);
	let branchInfoManager = document.getElementById("branchInfoManager").value;
	let branchInfoManagerTel = document.getElementById("branchInfoManagerTel").value;
	content.innerHTML =
		`<form action="branchModify" method="post">
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
					<input class="btn btn-secondary btn-block" type="submit" value="수정하기">
				</div>
			</div>
		</form>`;
}