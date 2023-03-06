<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/adminCommon.jsp" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">품목 등록</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">품목 등록</li>
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
						<form id="productForm" method="post">
							<div class="card-body">
								<div class="form-group">
									<label for="productName">품목명</label> <input type="text"
										class="form-control" id="productName" name="productName"
										placeholder="품목명" required>
								</div>
								<div class="form-group">
									<label for="productCode">품목코드</label> <input type="text"
										class="form-control" id="productCode" name="productCode" placeholder="품목코드"
										required>
								</div>
								<div class="form-group">
									<label for="standard">규격</label> <input type="text"
										class="form-control" id="standard" name="standard"
										placeholder="규격" required>
								</div>
								<div class="form-group">
									<label for="unit">단위</label> <input type="text"
										class="form-control" id="unit" name="unit"
										placeholder="단위" required>
								</div>
								<div class="form-group">
									<label for="productImg">이미지</label> <input type="text"
										class="form-control" id="productImg" name="productImg"
										placeholder="이미지">
								</div>
								<div class="form-group">
									<label for="divn">품목구분</label> <input type="text"
										class="form-control" id="divn" name="divn"
										placeholder="품목구분">
								</div>
								<div class="form-group">
									<label for="etc">비고</label> <input type="text"
										class="form-control" id="etc" name="etc"
										placeholder="업종">
								</div>
							</div>
							<div class="card-footer">
								<div class="card-tools">
									<button type="submit" class="btn btn-primary">등록</button>
									<button type="button" class="btn btn-danger">삭제</button>
								</div>
							</div>
						</form>
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
$(function() {
	$('#productForm').validate({
		submitHandler : function() {
			var form = document.querySelector("#productForm");
			form.action = 'productCreate.do';
			form.submit();
		},
		rules : {
			productName : {
				required : true,
			},
			productCode : {
				required : true,
			},
			standard : {
				required : true,
			},
			unit : {
				required : true,
			}
		},
		messages : {
			productName : {
				required : "품목명을 입력해 주세요."
			},
			productCode : {
				required : "품목코드를 입력해 주세요."
			},
			standard : {
				required : "규격을 입력해 주세요."
			},
			unit : {
				required : "단위를 입력해 주세요."
			}
			
		},
		errorElement : 'span',
		errorPlacement : function(error, element) {
			error.addClass('invalid-feedback');
			element.closest('.form-group').append(error);
		},
		highlight : function(element, errorClass,
				validClass) {
			$(element).addClass('is-invalid');
		},
		unhighlight : function(element, errorClass,
				validClass) {
			$(element).removeClass('is-invalid');
		}
	});
});
</script>