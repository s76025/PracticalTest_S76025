/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.lab.dao.SessionDAO;
import com.lab.dao.SessionDAO;
import com.lab.bean.SessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author MP2-4
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SessionDAO sessionDAO;

    public void init() {
        sessionDAO = new SessionDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<SessionBean> listSessions;
        listSessions = (List<SessionBean>) sessionDAO.getAllSessions();
        request.setAttribute("sessionList", listSessions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("schedule.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
