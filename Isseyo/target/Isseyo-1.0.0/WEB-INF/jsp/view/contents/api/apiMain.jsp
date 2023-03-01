<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/adminCommon.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">API</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">api</li>
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
							<h3 class="card-title">JSON</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-primary" id="sendJsonBtn">전송</button>
							</div>
						</div>
						<div class="card-body p-0">
							<textarea id="jsonTextarea" class="p-3">
								{
									"ISY_PRODUCT" : {
										"HEADER" : {
											"BIZ_API_KEY" : "dc7465ba-6719-4955-84e3-db8be90378f2"
											, "BIZ_NUM" : "사업자 번호"
											, "BIZ_NM" : "회사명"
											, "BIZ_CODE" : "회사 코드"
										}
										, "BODY" : {
											"PRODUCT" : [
											{
												"PRODUCT_NAME" : "품목명"
												, "PRODUCT_CODE" : "품목코드"
												, "STANDARD" : "규격"
												, "UNIT" : "단위"
												, "ETC" : "비고"
											}
											,{
												"PRODUCT_NAME" : "품목명"
												, "PRODUCT_CODE" : "품목코드"
												, "STANDARD" : "규격"
												, "UNIT" : "단위"
												, "ETC" : "비고"
											}
											,{
												"PRODUCT_NAME" : "품목명"
												, "PRODUCT_CODE" : "품목코드"
												, "STANDARD" : "규격"
												, "UNIT" : "단위"
												, "ETC" : "비고"
											}
											,{
												"PRODUCT_NAME" : "품목명"
												, "PRODUCT_CODE" : "품목코드"
												, "STANDARD" : "규격"
												, "UNIT" : "단위"
												, "ETC" : "비고"
											}
											,{
												"PRODUCT_NAME" : "품목명"
												, "PRODUCT_CODE" : "품목코드"
												, "STANDARD" : "규격"
												, "UNIT" : "단위"
												, "ETC" : "비고"
											}
											]
										}
									}
								}
							
							</textarea>
						</div>

						<div class="card-footer"></div>
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col -->
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">XML</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-primary" id="sendXmlBtn">전송</button>
							</div>
						</div>
						<div class="card-body  p-0">
							<textarea id="xmlTextarea" class="p-3">
								<?xml version="1.0" encoding="euc-kr"?>
								<ISY_PRODUCT>
									<HEADER>
										<BIZ_API_KEY>dc7465ba-6719-4955-84e3-db8be90378f2</BIZ_API_KEY>
										<BIZ_NUM>사업자 번호</BIZ_NUM>
										<BIZ_NM>회사명</BIZ_NM>
										<BIZ_CODE>회사 코드</BIZ_CODE>
									</HEADER>
									<BODY>
										<PRODUCT>
											<PRODUCT_NAME>품목명</PRODUCT_NAME>
											<PRODUCT_CODE>품목코드</PRODUCT_CODE>
											<STANDARD>규격</STANDARD>
											<UNIT>단위</UNIT>
											<ETC>비고</ETC>
										</PRODUCT>
										<PRODUCT>
											<PRODUCT_NAME>품목명</PRODUCT_NAME>
											<PRODUCT_CODE>품목코드</PRODUCT_CODE>
											<STANDARD>규격</STANDARD>
											<UNIT>단위</UNIT>
											<ETC>비고</ETC>
										</PRODUCT>
										<PRODUCT>
											<PRODUCT_NAME>품목명</PRODUCT_NAME>
											<PRODUCT_CODE>품목코드</PRODUCT_CODE>
											<STANDARD>규격</STANDARD>
											<UNIT>단위</UNIT>
											<ETC>비고</ETC>
										</PRODUCT>
										<PRODUCT>
											<PRODUCT_NAME>품목명</PRODUCT_NAME>
											<PRODUCT_CODE>품목코드</PRODUCT_CODE>
											<STANDARD>규격</STANDARD>
											<UNIT>단위</UNIT>
											<ETC>비고</ETC>
										</PRODUCT>
										<PRODUCT>
											<PRODUCT_NAME>품목명</PRODUCT_NAME>
											<PRODUCT_CODE>품목코드</PRODUCT_CODE>
											<STANDARD>규격</STANDARD>
											<UNIT>단위</UNIT>
											<ETC>비고</ETC>
										</PRODUCT>
									</BODY>
								</ISY_PRODUCT>
							</textarea>
						</div>

						<div class="card-footer"></div>
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
	$(document).ready(function() {
		// CodeMirror
		CodeMirror.fromTextArea(document.getElementById("jsonTextarea"), {
			mode : "application/ld+json",
			theme : "monokai"
		});

		CodeMirror.fromTextArea(document.getElementById("xmlTextarea"), {
			mode : "application/xml",
			theme : "monokai"
		});
		//var message = {"ISY_PRODUCT":{"HEADER":{"BIZ_API_KEY":"dc7465ba-6719-4955-84e3-db8be90378f2","BIZ_NUM":"사업자번호","BIZ_NM":"회사명","BIZ_CODE":"회사코드"},"BODY":{"PRODUCT":{"PRODUCT_NAME":"품목명","PRODUCT_CODE":"품목코드","STANDARD":"규격","UNIT":"단위","ETC":"비고"}}}};
		
		
		
		
		//message = message.replace('\t', '');
		//message = message.replace('\n', '');
		//message = message.replace(/&quot;/g, '');
		$('#sendJsonBtn').click(function() {
			var message = $("#jsonTextarea").val();
			$.ajax({
				url: 'apiJson.do',
				type: "POST",
				dataType: "json",
				async: false,
				data: {
					message : message
				},
				success: function(result) {
					
					alter("성공!");
			    },
			    error: function (xhr, option, error) {
			    	if( xhr.status == 404 ) {
			        	alert( "서버통신 오류입니다.(상태코드:" + xhr.status + ")");
			    	} else if( xhr.status == 401 || xhr.status == 403 ) {
			        	alert( "서버통신 오류입니다.(상태코드:" + xhr.status + ")");
			        } else {
			            try{ alert(JSON.parse(xhr.responseText).message); }catch(e){ alert(xhr.status);}
			        }
			    }
			});

			;
		});
		
		$('#sendXmlBtn').click(function() {
			var message = $("#xmlTextarea").val();
			$.ajax({
				url: 'apiXml.do',
				type: "POST",
				dataType: "xml",
				async: false,
				data: {
					message : message
				},
				success: function(result) {
					
					
			    },
			    error: function (xhr, option, error) {
			    	if( xhr.status == 404 ) {
			        	alert( "서버통신 오류입니다.(상태코드:" + xhr.status + ")");
			    	} else if( xhr.status == 401 || xhr.status == 403 ) {
			        	alert( "서버통신 오류입니다.(상태코드:" + xhr.status + ")");
			        } else {
			            try{ alert(JSON.parse(xhr.responseText).message); }catch(e){ alert("서버통신 실패하였습니다.");}
			        }
			    }
			});

			;
		});

	});
</script>