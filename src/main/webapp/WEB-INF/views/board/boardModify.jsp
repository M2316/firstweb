<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form name="formData">
                            <div>
                                <label>DATE</label>
                                <p>${content.regDate }</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${content.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${content.writer }">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${content.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${content.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/board/list'">목록</button>    
                            <button type="button" class="btn btn-primary" id="modBtn">변경</button>
                            <button type="button" class="btn btn-info" id="delBtn">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        
        <script>
        $(function (){ //jquery 시작
        	
        	$('#modBtn').click(function (){
        		$('form[name=formData]').attr('action','${pageContext.request.contextPath}/board/updateContent');
        		$('form[name=formData]').attr('method','post');
        		$('form[name=formData]').submit();
        		return;
        	});
        	
        	$('#delBtn').click(function (){
        		$('form[name=formData]').attr('action','${pageContext.request.contextPath}/board/deleteContent');
        		$('form[name=formData]').attr('method','post');
        		$('form[name=formData]').submit();
        	});
        	
        	
        	
        }); //jquery 끝
        
        
        </script>