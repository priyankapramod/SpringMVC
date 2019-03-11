<%@include file="header.html"%>
<html>
<head>
<title>View Contact Success page</title>
</head>


<%@ page import="java.util.*"%>
<%@ page import="assign.dbaccess.EMailAddressVOO"%>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
	<%@ page session="true"%>

	<center>
		<h2>View All Contacts</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
        <% List<EMailAddressVOO> emailaddresses = null;%>
		
		<%
		
			emailaddresses = (ArrayList<EMailAddressVOO>) session.getAttribute("allList");//emaillist
			System.out.println(emailaddresses);
			System.out.println(emailaddresses.size());
		
		%>
		<table border="1" cellpadding="1" cellspacing="0" width="50%"">
			<tr>
				<th>email address</th>
				<th>first name</th>
				<th>middle name</th>
				<th>last name</th>
				<th>home phone no</th>
				<th>work phone no</th>
				<th>mobile no</th>
				<th>group id</th>
			</tr>
			<%
				for (int i = 0; i < emailaddresses.size(); i += 1) {
			%>


			<tr>
				<td><%=emailaddresses.get(i).geteMailID()%></td>

				<td><%=emailaddresses.get(i).getfName()%></td>

				<td><%=emailaddresses.get(i).getmName()%></td>

				<td><%=emailaddresses.get(i).getlName()%></td>

				<td><%=emailaddresses.get(i).gethPhone()%></td>

				<td><%=emailaddresses.get(i).getwPhone()%></td>

				<td><%=emailaddresses.get(i).getmPhone()%></td>

				<td><%=emailaddresses.get(i).getgroupID()%></td>
			</tr>


			<%
				}
			%>

		</table>
		
	</center>
</body>



</html>
<%@include file="footer.html"%>