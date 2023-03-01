<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/adminCommon.jsp" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">제품관리</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">제품관리</li>
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
							<h3 class="card-title">제품목록</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-primary">등록</button>
								<button type="button" class="btn btn-danger">삭제</button>
							</div>
						</div>
						<div class="card-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="width: 10px">No.</th>
										<th>품목명</th>
										<th>품목코드</th>
										<th>규격</th>
										<th>단위</th>
										<th>비고</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${list}" varStatus="istatus">
										<tr>
											<td><c:out value="${istatus.count}"/></td>
											<c:forEach var="j" items="${list[istatus.index]}" varStatus="jstatus">
												<td><c:out value="${j.value}"/></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div class="card-footer clearfix">
							<ul class="pagination pagination-sm m-0 float-right">
								<li class="page-item"><a class="page-link" href="#">«</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">»</a></li>
							</ul>
						</div>
					</div>
					<!-- /.card -->
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">엑셀 업로드</h3>

							<div class="card-tools">
								<form id="form_test" action="excelUpload.do" method="post" encType="multipart/form-data">
						            <div class="custom-file">
										<input type="file" name="file" class="custom-file-input" id="customFile">
										<label class="custom-file-label" for="customFile"></label>
			                    	</div>
						            <button id="btn_register" type="submit" class="btn btn-primary">등록</button>
						        </form>
							</div>
						</div>
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
<script>
$( document ).ready(function() {
	bsCustomFileInput.init();
});
</script>