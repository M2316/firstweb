<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

    <%@ include file="../include/header.jsp" %>

    
    
    <section>
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
            <form action="${pageContext.request.contextPath }/board/list">
		    		<div class="search-wrap">
                       <button id="searchBtn" type="submit" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input" placeholder="검색어를 입력하세요!" name="keyword" value="">
                       <select name="condition" class="form-control search-select" >
                            <option value="title" ${pc.paging.condition == 'title' ? 'selected':''} >제목</option>
                            <option value="content" ${pc.paging.condition == 'content' ? 'selected':''}>내용</option>
                            <option value="writer" ${pc.paging.condition == 'writer' ? 'selected':''}>작성자</option>
                            <option value="titleContent" ${pc.paging.condition == 'titleContent' ? 'selected':''}>제목+내용</option>
                       </select>
                    </div>
		    </form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="vo" items="${contents}">
	                            <tr>
	                                <td>${vo.bno}</td>
	                                <td><a href="${pageContext.request.contextPath }/board/detail/${vo.bno }${pc.makeURI(pc.paging.selPageNum)}">${vo.title}</a></td>
	                                <td>${vo.writer}</td>
	                                <td>${vo.regDate}</td>
	                                <td>${vo.modDate}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form name="pageForm" action="${pageContext.request.contextPath }/board/list">
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm">
                    
                    <c:if test="${pc.backBtn }">
                        <li><a data-selpagenum="${pc.startPage-1 }">이전</a></li>
                    </c:if>
                                      
                    <c:forEach begin="${pc.startPage}" end="${pc.endPage }"  var="cnt">
                        <li name="pageBtn" data-cnt="${cnt }"><a href="#" data-selpagenum="${cnt}" }>${cnt}</a></li>
                    </c:forEach>      
                    

                        
                    <c:if test="${pc.nextBtn }">
                        <li id="nextBtn"><a data-selpagenum="${pc.endPage+1}">다음</a></li>
                    </c:if>
                        
                    </ul>
                    <button type="button" class="btn btn-info">글쓰기</button>
                    </div>
                    <input hidden name="selPageNum" value="${pc.paging.selPageNum }">
                    <input hidden name="condition" value="${pc.paging.condition }">
                    <input hidden name="keyword" value="${pc.paging.keyword }">
                    
                    <input hidden name="contentPcs" value="${pc.paging.contentPcs }">
                    
		    </form>

                </div>
            </div>
        </div>
	</section>
	
	<%@ include file="../include/footer.jsp" %>

	<script>
		$(function(){ //JQuery 시작
			
			//사용자가 선택한 페이지 표시
			$('.pagination li[data-cnt="${pc.paging.selPageNum}"]').attr('class','active'); 
			
		
			// 페이지 버튼 클릭 이벤트 시작
			$('.pagination li').on('click','a',function(e){
				console.log('이벤트 실행');
				$('input[name=selPageNum]').val($(this).data('selpagenum'));
				$('form[name=pageForm]').submit();

			});//페이지 버튼 클릭 이벤트 끝
			
		
		
			
		}); // JQuery 끝
	
	
	</script>


