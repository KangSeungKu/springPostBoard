<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav nav-sidebar">
		<li class="active"><a href="${cp }/postBoard">게시판 생성<span class="sr-only">(current)</span></a></li>
		
		<%-- boardList --%>
		<c:forEach items="${boardList }" var="board">
			<c:if test="${board.boardusage == 'Y' }">
				<li class="active"><a href="${cp }/board?menuBoardSeq=${board.boardseq }">${board.boardnm }<span class="sr-only">(current)</span></a></li>
			</c:if>
		</c:forEach>
</ul>