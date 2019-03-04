<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="box">
	<div class="box-header with-border">
		<c:if test="${msg == null}">
			<h3 class="box-title">게시판 목록보기</h3>
		</c:if>
		<c:if test="${msg != null}">
			<h3 class="box-title">${msg}</h3>
		</c:if>
	</div>

	<div class="box-header with-border">
		<span>목록개수</span> <select id="count" class="form-control">
			<option value="5"
				<c:out value=
		"${map.pageMaker.cri.perPageNum==5?'selected':'' }"/>>
				5개씩 보기</option>
			<option value="10"
				<c:out value=
		"${map.pageMaker.cri.perPageNum==10?'selected':'' }"/>>
				10개씩 보기</option>
			<option value="15"
				<c:out value=
		"${map.pageMaker.cri.perPageNum==15?'selected':'' }"/>>
				15개씩 보기</option>
			<option value="20"
				<c:out value=
		"${map.pageMaker.cri.perPageNum==20?'selected':'' }"/>>
				20개씩 보기</option>
		</select>
	</div>


	<div class="box-body">
		<table class="table table-bordered">
			<tr>
				<th width="70">글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th width="70">조회수</th>
			</tr>
			<c:forEach var="vo" items="${map.list}">
				<tr>
					<td align="right">${vo.bno}&nbsp;</td>
					<td>&nbsp; <a
						href='detail?bno=${vo.bno}&page=${map.pageMaker.cri.page}&perPageNum=${map.pageMaker.cri.perPageNum}'>${vo.title}</a></td>
					<td>&nbsp;<a href="../user/sendmail?email=${vo.email}">${vo.nickname}</a>
					</td>
					<td>&nbsp;${vo.dispdate}</td>

					<td align="right"><span class="badge bg-blue">
							${vo.readcnt}</span>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${map.pageMaker.totalCount != 0 }">
					<c:if test="${map.pageMaker.prev}">
						<li><a
							href="list?page=${map.pageMaker.startPage-1}
			&perPageNum=${map.pageMaker.cri.perPageNum}">
								이전 </a></li>
					</c:if>

					<c:forEach var="idx" begin="${map.pageMaker.startPage}"
						end="${map.pageMaker.endPage}">
						<li
							<c:out value=
	"${map.pageMaker.cri.page==idx?'class=active':''}"/>>
							<a
							href="list?page=${idx}
	&perPageNum=${map.pageMaker.cri.perPageNum}">${idx}
						</a>
						</li>
					</c:forEach>

					<c:if test="${map.pageMaker.next}">
						<li><a
							href="list?page=${map.pageMaker.endPage+1}
	&perPageNum=${map.pageMaker.cri.perPageNum}">
								다음 </a></li>
					</c:if>
				</c:if>
			</ul>
		</div>

		<div class="box-footer">
			<div class="text-center">
				<button id='mainBtn' class="btn-primary">메인으로</button>
			</div>
			<script>
				document.getElementById('mainBtn').addEventListener("click",
						function(event) {
							location.href = "../";
						});
			</script>
		</div>
	</div>
</div>
%@include file="../include/footer.jsp"%

<script>
	document.getElementById("count").addEventListener("change",function() {
		location.href = 'list?' + 'page=1&perPageNum=' + this.value;
	});
</script>
