Kakao.init('c45f9c0a385ab45ff2fe4548d4311539'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
kakaoLogout();
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	const kakaoForm = document.getElementById('kakao_L');
        	
        	const userNs = response.properties.nickname
        	const userIds = response.id + "kakao";
        	const emails = response.properties.email;
        	
        	console.log(userNs);
        	console.log(userIds);
        	console.log(emails);
        	
			const input1 = document.createElement('input');
       		input1.type = "text"; input1.name = "id"; input1.value = userIds;
       		kakaoForm.append(input1);
       		const input2 = document.createElement('input');
       		input2.type = "text"; input2.name = "name"; input2.value = userNs;
       		kakaoForm.append(input2);
       		const input3 = document.createElement('input');
       		input3.type = "text"; input3.name = "email"; input3.value = emails;
       		kakaoForm.append(input3);
       		//console.log(response);
       		kakaoForm.submit();
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
   }
}  