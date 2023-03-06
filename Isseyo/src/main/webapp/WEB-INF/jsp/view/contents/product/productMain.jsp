<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/adminCommon.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">품목 관리</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">품목 관리</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->
	
	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Small boxes (Stat box) -->
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">품목 목록</h3>

							<div class="card-tools">
								<button onclick="location.href='productFrom.do'" type="button"
									class="btn btn-primary">등록</button>
								<button type="button" class="btn btn-danger">삭제</button>
								<button type="button" class="btn btn-success"
									data-toggle="modal" data-target="#modal-success">
									Excel</button>
							</div>
						</div>
						<div class="card-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="width: 10px">No.</th>
										<th>품목명</th>
										<th>품목 코드</th>
										<th>규격</th>
										<th>단위</th>
										<th>이미지</th>
										<th>구분</th>
										<th>비고</th>
										<th>등록 일시</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${resultList}" varStatus="istatus">
										<tr>
											<td><c:out value="${istatus.count}" /></td>
											<td><c:out value="${i.productName}" /></td>
											<td><c:out value="${i.productCode}" /></td>
											<td><c:out value="${i.standard}" /></td>
											<td><c:out value="${i.unit}" /></td>
											<td><c:out value="${i.productImg}" /></td>
											<td><c:out value="${i.divn}" /></td>
											<td><c:out value="${i.etc}" /></td>
											<td><c:out value="${i.registDt}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<form:form commandName="searchVO" id="listForm" name="listForm" method="post">
						<form:hidden path="pageIndex" />
						<div class="card-footer clearfix">
							<ul class="pagination pagination-sm m-0 float-right">
								<li class="page-item"><a class="page-link" href="javascript:paging(1);">«</a></li>
								<c:forEach var="i" begin="1" end="${paginationInfo.totalPageCount}" varStatus="istatus">
									<li class="page-item"><a class="page-link" href="javascript:paging(${i});"><c:out value="${i}" /></a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link" href="javascript:paging(${paginationInfo.lastPageNoOnPageList});">»</a></li>
							</ul>
						</div>
						</form:form>
						<!-- /.card-footer -->
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
			<!-- Main row -->
		</div>
		<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<div class="modal fade" id="modal-success" style="display: none;"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content bg-success">
			<form id="form_test" action="excelUpload.do" method="post"
				encType="multipart/form-data">
				<div class="modal-header">
					<h4 class="modal-title">Excel</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="custom-file">
						<input type="file" name="file" class="custom-file-input"
							id="customFile"> <label class="custom-file-label"
							for="customFile"></label>
					</div>

				</div>
				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn-outline-light"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-outline-light">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javaScript" language="javascript" defer="defer">
    
	function paging(pageNo){
		document.listForm.pageIndex.value = pageNo;
		document.listForm.action = "<c:url value='/productMain.do'/>";
	   	document.listForm.submit();
	}
	$(document).ready(function() {
		bsCustomFileInput.init();
	});
</script>