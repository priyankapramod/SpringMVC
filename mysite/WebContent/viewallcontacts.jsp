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
		<h2>View Contact</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
        <% List<EMailAddressVOO> emailaddresses = null;%>
		
		<%
		
			emailaddresses = (ArrayList<EMailAddressVOO>) session.getAttribute("emailList");//emaillist
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
		<%-- <table border="1" cellpadding="1" cellspacing="0" width="50%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</td>
				<td><jsp:getProperty name="emailVO" property="eMailID" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">firstName</td>
				<td><jsp:getProperty name="emailVO" property="fName" /></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">LastName</td>
				<td><jsp:getProperty name="emailVO" property="lName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MiddleName</td>
				<td><jsp:getProperty name="emailVO" property="mName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">HomePhone</td>
				<td><jsp:getProperty name="emailVO" property="hPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MobilePhone</td>
				<td><jsp:getProperty name="emailVO" property="mPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">WorkPhone</td>
				<td><jsp:getProperty name="emailVO" property="wPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Group</td>
				<td><jsp:getProperty name="emailVO" property="groupID" /></td>
			</tr>
		</table>
 --%>
	</center>
</body>



</html>
<%@include file="footer.html"%>