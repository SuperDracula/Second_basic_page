package business;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

import model.User;
import model.Survey;

public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");

        System.out.println("Action: " + action);

        log("EmailListServlet - action: " + action);

        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            GregorianCalendar currentDate = new GregorianCalendar();

            int currentYear = currentDate.get(Calendar.YEAR);
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
            request.setAttribute("currentYear", currentYear);
            url = "/survey.jsp";   // the "thanks" page
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
