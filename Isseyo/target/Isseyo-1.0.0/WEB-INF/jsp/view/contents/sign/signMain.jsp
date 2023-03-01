<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="login-box">
	<div class="login-logo">
		<a href="loginView.do">Isseyo<b>?!</b></a>
	</div>
	<!-- /.login-logo -->
	<div class="card">
		<div class="card-body">

			<form action="loginFrom.do" method="post">
				<div class="input-group mb-3">
					<input name="userId" type="id" class="form-control" placeholder="Id">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input name="password" type="password" class="form-control" placeholder="Password">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="submit" class="btn btn-success btn-block">로그인</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<!-- <div class="social-auth-links text-center mb-3">
				<a href="#" class="btn btn-block btn-primary">
					<i class="fab fa-facebook mr-2"></i> Sign in using Facebook
				</a> 
				<a href="#" class="btn btn-block btn-danger">
					<i class="fab fa-google-plus mr-2"></i> Sign in using Google+
				</a>
			</div> -->
			<!-- /.social-auth-links -->
			<p class="mb-1">
				<a href="#">아이디 찾기 /</a><a href="#"> 비밀벝호 찾기 /</a><a href="signUp.do"> 회원가입</a>
			</p>
		</div>
		<!-- /.login-card-body -->
	</div>
</div>
<!-- /.login-box -->
