package assign.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

public class UpdateAddressServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String errors = "";
		// step1
		String emailaddress = request.getParameter("emailId");//emailid
    	System.out.println(emailaddress);
		String wphone = request.getParameter("wphone");//
		String mphone = request.getParameter("mphone");
		System.out.println(wphone);
		System.out.println(mphone);

		// step2 JDBC
		// 2a
		EMailBO eMailBO = new EMailBO();
		EMailAddressVOO eMailAddressVOO = new EMailAddressVOO();
		
		
		
		
		//eMailBO.updateEMailAddress(eMailAddressVOO);
		
		try {
			eMailAddressVOO = eMailBO.getEMailAddress(emailaddress);
			eMailAddressVOO.seteMailID(emailaddress);
			eMailAddressVOO.setwPhone(wphone);
			eMailAddressVOO.setmPhone(mphone);
			eMailBO.updateEMailAddress(eMailAddressVOO);
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (errors.equals("")) {
			System.out.println("first Name: " + eMailAddressVOO.getfName());
			request.setAttribute("emailVO", eMailAddressVOO);
			RequestDispatcher rd = request.getRequestDispatcher("/displayrecordupdate.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/modifycontact.jsp");
		}

	}

	

}
