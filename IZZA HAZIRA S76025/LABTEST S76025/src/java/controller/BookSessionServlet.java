package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.lab.dao.SessionDAO;
import com.lab.bean.SessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MP2-4
 */
@WebServlet("/BookSessionServlet")
public class BookSessionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SessionDAO sessionDAO;

    @Override
    public void init() {
        sessionDAO = new SessionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
    // retrieve parameter
    String student_name = request.getParameter("student_name");
    String branch_location = request.getParameter("branch_location");
    String lesson_type = request.getParameter("lesson_type");

    //Instantiate SessionBean, 
    SessionBean newSession = new SessionBean();
    newSession.setStudentName (student_name);
    newSession.setBranchLocation(branch_location);
    newSession.setLessonType(lesson_type);
    newSession.setStatus("Booked");

//pass the object
sessionDAO.bookSession (newSession);

//Upon success, use response.sendRedirect() to redirect the user to the Schedule 
    response.sendRedirect ("ScheduleServlet");
}
}