// 한번에 바로 간다가 아니라 여기를 거쳐간다고 생각하면 됨
let idSubmit = false; // 아이디 중복체크 하는 값. false 기본 값으로 지정
let pwdSubmit = false;
id.addEventListener("input", function(e) {	// 아이디 본인 것 입력 받은 값. event e에 담겨있음
	// 시작은 영어로, 영어, 숫자로만 10 ~ 14글자 -> 정규표현식!
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
		
	// 중복 체크
	$.ajax({
		type: 'post',
		url: '/check',
		data: {	// 객체 방식으로 처리!
			id: e.target.value
		},
		success: function(data) {
			if(data) {
				// (data가 true일 때) 정보가 있을 때니까 '중복된 아이디입니다!'
				idCheck.innerHTML = "중복된 아이디입니다. 다시 입력해주세요 ㅜㅜ";
				idCheck.style.color = "red";
				idSubmit = false;
			} else { // 여기에서만 true인 상황
				if(regExp.test(e.target.value)) {	// 일치한 경우가 쓸 수 있는 아이디라는 것
					idCheck.style.color = "skyblue";
					idCheck.innerHTML = "OK!";
					idSubmit = true; // 허용할 때만 true로 처리	
				} else if(e.target.value === "") {
					idCheck.innerHTML = "";
					idSubmit = false;
				} else {
					idCheck.style.color = "red";
					idCheck.innerHTML = "첫글자는 영어로, 영어 또는 숫자로만 10 ~ 14글자로 입력하세요.";
					idSubmit = false;
				}
			}
		}
	});
});

password.addEventListener("input", function(e) {
	// 특수문자 무조건 하나 이상 포함
	// 대문자, 소문자 하나씩 전부다 포함이 되어 있는 경우
	// 숫자도 하나씩 포함되어 있는 경우
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).*$/;
	if(regExp.test(e.target.value)) {
		pwdCheck.innerHTML = "OK!";
		pwdCheck.style.color = "skyblue";
		pwdSubmit = true;
	} else if(e.target.value === "") {
		pwdCheck.innerHTML = "";
		pwdSubmit = false;
	} else {
		pwdCheck.innerHTML = "특수문자, 대문자, 소문자, 숫자 한 개 이상 무조건 포함되어야 합니다.";
		pwdCheck.style.color = "red";
		pwdSubmit = false;
	}
});

function validate() {
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
	return idSubmit && pwdSubmit;	// idSubmit도 true이면서 pwdSubmit도 true인 경우만
	
}

