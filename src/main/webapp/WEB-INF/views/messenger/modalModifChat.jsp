<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방 수정</title>
</head>
<body>
채팅방 정보 설정 임시 페이지<br>
채팅방 이미지 : 한다면 수정 가능하도록<br>

채팅방 이름 : <br>
<form id="modifChat" name="modifChat" action="/messenger/modifChatName">
<input type="hidden" name="seq" value="${messenger.seq}">
<input type="text" id="name" name="name" value="${messenger.name}" placeholder="채팅방 이름을 설정해주세요.">
<div id="msg"></div>
<button type="button" id="btn_submit" >확인</button>
<button type="button" id="cancle">취소</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

let name = $("#name").val();

document.getElementById("btn_submit").addEventListener("click", fn_submit);

document.getElementById("cancle").addEventListener("click", fn_cancle);


</script>

</body>
</html>