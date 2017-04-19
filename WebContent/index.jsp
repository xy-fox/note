<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
  var msg = "${requestScope.MESSAGE}";
  if(msg !=""){
	  alert(msg);
  }
</script>
</head>
<body>
	<s:iterator value="#request.VOTERESULTS" var="voteResult">
		<p>${voteResult.vote.voteName }</p>
		<form action="doVote.action" method="post">
			<s:iterator value="#voteResult.voteOptions" var="voteoption">
				<input type="radio" name="voteOptionID"/>
				${voteoption.voteoptionName }<br/>		
			</s:iterator>
			<input type="radio" name="voteOptionID" value="0">其他<br/>
			<input type="text" value="其他选项"/>
			<input type="hidden" name="voteID" value="${voteResult.vote.voteID }">
			<input type="hidden" name="channelID" value="${voteResult.vote.channelID }">
			<a href="voteResult?voteID=${voteResult.vote.voteID }">查看投票结果</a>
			<input type="submit" value="投票">
			<input type="reset" value="重置">
		</form>
	</s:iterator>
	<s:if test="#request.VOTERESULTS.size==0">没有任何结果</s:if>	
</body>
</html>