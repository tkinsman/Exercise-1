package com.matc.controller;

/**
 * Created by toddkinsman on 9/5/16.
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This servlet forwards the user to the search jsp page.
 *
 *@author    Todd Kinsman
 */
@WebServlet (
        name = "employeeSearch",
        urlPatterns = { "/employeeSearch" }
)
public class ResultsUserSearch extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               an httpServlet request
     *@param  response              an httpServlet response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/search.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }

}
