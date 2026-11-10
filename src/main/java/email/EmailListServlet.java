package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import business.Survey;

public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";    // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String hear = request.getParameter("hear");
            String yes1 = request.getParameter("yes1");
            String yes2 = request.getParameter("yes2");
            String[] contactRequested = request.getParameterValues("contactMethod");

            String contactMethod = "";
            if (contactRequested != null && contactRequested.length > 0) {
                contactMethod = String.join(", ", contactRequested);
            } else {
                contactMethod = "None";
            }

            if (yes1 != null) {
                yes1 = "yes, I'd like that";
            }

            if (yes2 != null) {
                yes2 = "yes, please send me the email announcements";
            }

            User user = new User(firstName, lastName, email, dob);
            Survey survey = new Survey(hear, yes1, yes2, contactMethod);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            request.setAttribute("survey", survey);
            url = "/thanks.jsp";   // the "thanks" page
        }

        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
