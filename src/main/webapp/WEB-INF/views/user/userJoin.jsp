<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <div class="titlebox">
                       	 회원가입
                    </div>
                    <form id="joinForm" action="${pageContext.request.contextPath }/user/insert" method="post">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <div class="input-group"><!--input2탭의 input-addon을 가져온다 -->
                                <input type="text" class="form-control" id="userId" placeholder=아이디를 (영문포함 4~12자 이상)" name="userId">
                                <div class="input-group-addon" id="div-id-check-btn">
                                    <button id="id-check-btn" type="button" class="btn btn-primary">아이디중복체크</button>
                                </div>
                            </div>
                            <span id="msgId"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group"><!--기본 폼그룹을 가져온다-->
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="userPw" name="userPw" placeholder="비밀번호 (영 대/소문자, 숫자 조합 8~16자 이상)">
                            <span id="msgPw"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" id="pwConfirm" placeholder="비밀번호를 확인해주세요.">
                             <span id="msgPw-c"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label>
                            <div class="input-group">
				<select class="form-control phone1" id="phone1" name="phone1">
					<option>010</option>
					<option>011</option>
					<option>017</option>
					<option>018</option>
				</select> 
				<input type="text" class="form-control phone2" id="phone2" name="phone2" placeholder="휴대폰번호를 입력하세요.">
                            </div>
                        </div>
						<div class="form-group email-form">
						  <label for="email">이메일</label> <small id="authMsg"></small><br>
						  <div class="input-group" style="width:100%">
							  <input type="text" class="form-control" id="email1" name="email1" placeholder="이메일" style="width:60%" >
							  <select class="form-control" id="email2" name="email2" style="width:40%">
							    <option>@naver.com</option>
							    <option>@daum.net</option>
							    <option>@gmail.com</option>
							    <option>@hanmail.com</option>
							    <option>@yahoo.co.kr</option>
							  </select>
		                       <div class="input-group-addon" style="width:10%">
		                           <button type="button"  class="btn btn-primary" id="mail-check-btn" >본인인증</button>
		                           <button type="button"  class="btn btn-primary" id="mail-reset" style='display:none'>재인증하기</button>		                           
		                       </div>
	                       </div>
						</div>
                       <div class="input-group-addon input-group" id="auth-group" style="width:10em; display:none">
                       		<input type="text" class="form-control"> 
                       		<button class="btn btn-primary" type="button" id="auth-btn">인증하기</button>
                       </div>
                        <!--readonly 속성 추가시 자동으로 블락-->
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="addrZipNum" name="addrZipNum" placeholder="우편번호" readonly>
                                <div class="input-group-addon">
                                    <button type="button" class="btn btn-primary">주소찾기</button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="address1" name="address1" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="address2" name="address2" placeholder="상세주소">
                        </div>

                        <!--button탭에 들어가서 버튼종류를 확인한다-->
                        <div class="form-group">
                            <button type="button" id="joinBtn" class="btn btn-lg btn-success btn-block">회원가입</button>
                        </div>

                        <div class="form-group">
                            <button type="button"  class="btn btn-lg btn-info btn-block">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
<%@ include file="../include/footer.jsp" %>
    <script>
		let idCheck = false;
		let pwCheck = false;
		let nameCheck = false;
		let emailCheck = true;
		
		
		
		
    	$(function(){//JQuery 시작
    		
    		let auth = '';
    	
    	
    		$('#id-check-btn').click(function(){// ID 중복 체크 시작
    			console.log('ID 중복 체크 이벤트 발생');
				const userId = $('#userId').val();
				console.log('입력된 userId : ' + userId);
				
				$.ajax({ // 중복확인 비동기 통신 시작
					type:'post',
					url:'${pageContext.request.contextPath}/user/userCheck',
					data:userId,
					contentType:'application/json',
					success:function(result){
						console.log(result);
						if(result === 'success'){
							alert('사용 가능한 아이디 입니다.');
							$('#userId').attr('readonly',true);
							$('#div-id-check-btn').css('disabled','disabled');
							$('#msgId').html('사용 가능한 아이디 입니다.');
							$('#msgId').css('color','blue');
							idCheck = true;
						}if(result ==='fail'){
							$('#msgId').html('입력하신 아이디는 중복된 아이디입니다.');
							$('#msgId').css('color','red');
							$('#userId').val('');
						}
						
					},
					error:function(){
						alert('서버와 통신 실패! : ID중복확인error 발생');						
					}
				});//ID 중복확인 비동기 통신 

    		}); //ID 중복 체크 끝
    		
    		/*이름 공백 확인검사*/
            const userName = $('#userName').val();
    		if(userName !== '') nameCheck = true;
    		
			// 회원가입 버튼 클릭 이벤트 처리    		
    		$('#joinBtn').click(function (){
    			
    			if(idCheck||pwCheck||nameCheck){
    				if(confirm('가입을 진행 하시겠습니까?')){
    					$('#joinForm').submit();
    				}
    			}	
    		}); // 회원가입 버튼 클릭 이벤트 처리 끝
            
    		//인증번호를 이메일로 전송
    		$('#mail-check-btn').click(function(){
    			const email = $('#email1').val() + $('#email2').val();
    			console.log('입력된 이메일 값 : ' + email)
    			$.ajax({//이메일 비동기 통신 시작
    				type:'get',
    				url:'${pageContext.request.contextPath}/user/emailCheck/'+email,
    				success:function(result){
   						auth = result;
   						console.log('이메일 전송! : ' + result);
   						$('#auth-group').css('display','block');
   						alert('입력하신 이메일로 발송 된 인증 코드를 입력해 주세요~!');
    				},
    				error:function(){
    					alert('이메일인증 서버통신 실패! 관리자에게 문의 하세요~');
    				}
    			});//이메일 비동기 통신 끝
    		}); // 이메일 전송 끝
			
    		$('#auth-btn').click(function (){ // 이메일 인증코드를 검증하는 버튼
    			if(auth !== $('#auth-group input').val()){
    				console.log('인증 실패!');
    				$('#authMsg').css('color','red');
    				$('#authMsg').html('인증 번호가 일치하지 않습니다.');
    				$('#auth-group input[type=text]').val('');
    				emailCheck = false;
    			}else{
    				console.log('인증 성공!');
    				$('#email1').attr('readonly','true');
    				$('#email2').attr('readonly','true');
    				$('#auth-group').css('display','none');
    				$('#email2 option').not(":selected").attr("disabled", "disabled"); // 인증이 완료되면 option이 변하지 않도록 해준다
     				$('#mail-check-btn').css('display','none');
    				$('#mail-reset').css('display','block');
					alert('인증 성공!');
    				$('#authMsg').css('color','blue');
    				$('#authMsg').html('이메일 인증 완료!');
    			}
    		});// 이메일 인증코드를 검증하는 버튼 끝
    		
    		$('#mail-reset').click(function(){ // 이메일 재인증하기 버튼 이벤트 시작
				$('#email1').removeAttr('readonly','readonly');
				$('#email2').removeAttr('readonly','readonly');
				$('#email2 option').removeAttr("disabled", "disabled");
				$('#email1').val('');
				$('#email2').val('@naver.com');
				$('#auth-group input[type=text]').val('');
 				$('#mail-check-btn').css('display','block');
				$('#mail-reset').css('display','none');
    		});// 이메일 재인증하기 버튼 이벤트 끝
    		
    	});//JQuery 끝
    
    	
    
    
    
        /*아이디 형식 검사 스크립트*/
        var id = document.getElementById("userId");
        id.onkeyup = function() {
            /*자바스크립트의 정규표현식 입니다*/
            /*test메서드를 통해 비교하며, 매칭되면 true, 아니면 false반*/
            var regex = /^[A-Za-z0-9+]{4,12}$/; 
            if(regex.test(document.getElementById("userId").value )) {
                document.getElementById("userId").style.borderColor = "green";
                document.getElementById("msgId").innerHTML = "아이디중복체크는 필수 입니다";

            } else {
                document.getElementById("userId").style.borderColor = "red";
                document.getElementById("msgId").innerHTML = "";
            }
        }
        /*비밀번호 형식 검사 스크립트*/
        var pw = document.getElementById("userPw");
        pw.onkeyup = function(){
            var regex = /^[A-Za-z0-9+]{8,16}$/;
             if(regex.test(document.getElementById("userPw").value )) {
                document.getElementById("userPw").style.borderColor = "green";
                document.getElementById("msgPw").innerHTML = "사용가능합니다";
            } else {
                document.getElementById("userPw").style.borderColor = "red";
                document.getElementById("msgPw").innerHTML = "";
            }
        }
        /*비밀번호 확인검사*/
        var pwConfirm = document.getElementById("pwConfirm");
        pwConfirm.onkeyup = function() {
            var regex = /^[A-Za-z0-9+]{8,16}$/;
            if(document.getElementById("pwConfirm").value == document.getElementById("userPw").value ) {
                document.getElementById("pwConfirm").style.borderColor = "green";
                document.getElementById("msgPw-c").innerHTML = "비밀번호가 일치합니다";
                pwCheck = true;
            } else {
                document.getElementById("pwConfirm").style.borderColor = "red";
                document.getElementById("msgPw-c").innerHTML = "비밀번호 확인란을 확인하세요";
            }
        }        
        
        
    </script>
