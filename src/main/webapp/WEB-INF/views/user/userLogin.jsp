<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                        로그인
                    </div>
                    <form action="${pageContext.request.contextPath }/user/login" id="loginForm" method="post">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" name="userId" placeholder="아이디">
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" id="pw" name="userPw" placeholder="비밀번호">
                         </div>
                         <div class="form-group">
                            <button type="button" id="loginBtn" class="btn btn-info btn-block">로그인</button>
                            <button type="button" id="joinBtn" class="btn btn-primary btn-block">회원가입</button>
                         </div>
                    </form>                
                </div>
            </div>
        </div>
    </section>
<%@ include file="../include/footer.jsp" %>


<script>
	$(function(){ //JQuery 시작
		$("#loginBtn").click(function(){//login 이벤트
			console.log("이벤트 실행!");
			$('#loginForm').submit();
		});
	});//JQuery 끝


</script>