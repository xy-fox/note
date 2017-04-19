<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
		
		function addvoteOption(){
			 var i =4;
			 var votep = document.getElementById("voteOptionList");
			 var inputt = document.createTextNode("选项"+(i++)+"名称");
			 votep.appendChild(inputt);
			 var inputP = document.createElement("input");
			 inputP.type = "text";
			 inputP.name = "voteOption";
			 votep.appendChild(inputP);
			 var pbr = document.createElement("<br/>");
			 votep.appendChild(pbr);
		}
		
		var msg = "${requestScope.MESSAGE}";
		if(msg != ""){
			alert(msg);
		}
</script>
</head>                                                                                                                                                                                                                                                                
<body>
		<form action="addVoteAction" >
		 	选择投票频道:<select name="channel">
		 				<option value="1">NBA</option>
		 				<option value="2">CBA</option>
		 				<option value="3">财经</option>
		 				<option value="4">娱乐</option>
		 			</select>
		 			<br/>
		 	选择投票名称:<input type="text" name="voteName"/><br/>
		 	<div id="voteOptionList">
		 		选项1名称<input type="text" name="voteOption"/><br/>
		 		选项2名称<input type="text" name="voteOption"/><br/>
		 		选项3名称<input type="text" name="voteOption"/><br/>
		 	</div>
		 	<input type="button" value="新增投票选项" onclick="addvoteOption();"/>
		 	<input type="submit" value="提交"/><input type="reset" value="重置"/>
		</form>
		
</body>
</html>