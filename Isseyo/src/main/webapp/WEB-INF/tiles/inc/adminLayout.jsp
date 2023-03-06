<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%-- 관리자 공통 --%>
<%@ include file="/WEB-INF/jsp/common/adminCommon.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Isseyo</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="${contextPath}/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${contextPath}/dist/css/adminlte.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet" href="${contextPath}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="${contextPath}/plugins/jqvmap/jqvmap.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet" href="${contextPath}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet" href="${contextPath}/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet" href="${contextPath}/plugins/summernote/summernote-bs4.min.css">
<!-- codemirror -->
<link rel="stylesheet" href="${contextPath}/plugins/codemirror/codemirror.css">
<link rel="stylesheet" href="${contextPath}/plugins/codemirror/theme/monokai.css">
<!-- jQuery -->
<script src="${contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- jQuery-validation -->
<script src="${contextPath}/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${contextPath}/plugins/jquery-validation/additional-methods.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${contextPath}/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath}/dist/js/adminlte.js"></script>

</head>
<body class="hold-transition">
	
	<div class="wrapper">
		<tiles:insertAttribute name="adminHeader" />
	
		<tiles:insertAttribute name="adminLeft" />
		
		<tiles:insertAttribute name="adminContent" />
		
		<tiles:insertAttribute name="adminFooter" />
	</div>
	
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${contextPath}/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="${contextPath}/plugins/sparklines/sparkline.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${contextPath}/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="${contextPath}/plugins/moment/moment.min.js"></script>
	<script src="${contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script src="${contextPath}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="${contextPath}/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script src="${contextPath}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- file -->
	<script src="${contextPath}/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- codemirror -->
	<script src="${contextPath}/plugins/codemirror/codemirror.js"></script>
	<script src="${contextPath}/plugins/codemirror/mode/javascript/javascript.js"></script>
	<script src="${contextPath}/plugins/codemirror/mode/xml/xml.js"></script>
</body>
</html>