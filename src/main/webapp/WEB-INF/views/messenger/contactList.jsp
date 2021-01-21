<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="/css/messenger.css">
</head>
<!--Coded With Love By Mutiullah Samim-->
<body>
	<div class="w-100 h-100 chat container-fluid p-0 min-w-450">
            <!-- top head -->
            <div class="row w-100 m-0 h15">
                <div class="card-header bgMain w-100 p-0" style="border-radius: 0%;">
                    <div class="window-control d-flex justify-content-end">
                        <div class="p-2">-</div>
                        <div class="p-2">ㅁ</div>
                        <div class="p-2">X</div>
                    </div>
                    <div class="input-group float-right col-10 col-sm-8 col-md-5 p-2">
                        <input type="text" placeholder="Search..." name="" class="form-control search">
                        <div class="input-group-prepend">
                            <span class="input-group-text search_btn">
                                <i class="fas fa-search"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- contact list sidebar -->
            <div class="row m-0 h85">
                <div class="col-2 bgMain container-fluid p-o m-0 con-sidebar">
                    <a href="#">
                        <div class="row p-2">
                            전체
                        </div>
                    </a>
                    <a href="#">
                        <div class="row p-2">
                            부서원
                        </div>
                    </a>
                    <a href="#">
                        <div class="row p-2">
                            팀원
                        </div>
                    </a>
                    <a href="#">
                        <div class="row p-2">
                            채팅방
                        </div>
                    </a>
                </div>
                <!-- contact list part -->
                <div class="col-10 p-0">
                    <div class="card contacts_card h-100 b-radius-0">
                        <div
                            class="card-body contacts_body h-75 style="
                            border-radius:0px;!important"="border-radius:0px;!important"">
                            <ui class="contacts">
                                <li class="active con-list">
									<a href="#">
										<div class="d-flex bd-highlight">
											<div class="img_cont">
												<img src="/img/profile-default.jpg" class="rounded-circle user_img">
											</div>
											<div class="user_info">
												<span>임소형</span>
												<p>개발부/웹개발팀</p>
											</div>
										</div>
									</a>
                                </li>
                                <li class="con-list">
                                <!-- 사진 부분과 내용 부분 나눠서 a태그 걸기? -->
										<div class="d-flex bd-highlight">
											<div class="img_cont">
												<a href="#">
													<img src="/img/profile-default.jpg" class="rounded-circle user_img">
												</a>
											</div>
											<a href="#">	
												<div class="user_info">
													<span>정의진</span>
													<p>개발부/앱개발팀</p>
												</div>
											</a>
										</div>
                                </li>
                                <li class="con-list">
									<a href="#">
										<div class="d-flex bd-highlight">
											<div class="img_cont">
												<img src="/img/profile-default.jpg" class="rounded-circle user_img">
											</div>
											<div class="user_info">
												<span>김지영</span>
												<p>개발부/보안팀</p>
											</div>
										</div>
									</a>
                                </li>
                                <li class="con-list">
									<a href="#">
										<div class="d-flex bd-highlight">
											<div class="img_cont">
												<img src="/img/profile-default.jpg" class="rounded-circle user_img">
											</div>
											<div class="user_info">
												<span>이종탄</span>
												<p>법무부/회계팀</p>
											</div>
										</div>
									</a>
                                </li>
                            </ui>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/resources/static/js/messenger.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>
</body>
</html>