<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="1" cellspacing="0">
		<s:iterator value="#request.VOTERESULTS" var="voteResult">
		<tr >
			<td> <div>${voteResult.vote.voteID }</div></td>
			<td> <div>${voteResult.vote.voteName }</div></td>
			<s:subset source="#voteResult.voteOptions" id="subvoteOptions"></s:subset>
			<s:iterator value="#attr.subvoteOptions" var="voteOption">
				<td><div>${voteOption.voteoptionName}</div> </td>
			</s:iterator>
			<td><div><span><a href="deleteVote.action?voteID=${voteResult.vote.voteID }">删除</a></span> <span class="STYLE1"></span></div></td>
		</tr>
		</s:iterator>
	</table>
		
      
</body>
</html>