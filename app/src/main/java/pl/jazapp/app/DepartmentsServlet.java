package pl.jazapp.app;

import pl.jazapp.app.webapp.department.DepartmentController;
import pl.jazapp.app.webapp.department.DepartmentRequest;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("Departments")
public class DepartmentsServlet extends HttpServlet {

    @Inject
    DepartmentRequest departmentRequest;

    @Inject
    DepartmentController departmentController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getParameterMap().size() != 0 && req.getParameterMap().containsKey("departmentId")){
//        if(req.getParameterMap().size() != 0 && req.getParameterMap().containsKey("departmentId")){
//            // TODO: fix
//            var id = req.getParameter("departmentId");
//
//            resp.setContentType("text/xml");
//            departmentRequest.setId(Long.valueOf(id));
//            req.getRequestDispatcher("/department/edit.xhtml?departmentId=" + id + "faces-redirect=true&includeViewParams=true3").forward(req, resp);
//
//        } else {
//            resp.setContentType("text/xml");
//            departmentRequest.setId(null);
//            if(req.getRequestURI().equals("/app/department/edit.xhtml")){
//                RequestDispatcher rd = req.getRequestDispatcher("/department/edit.xhtml");
//                rd.include(req, resp);
//            } else if (req.getRequestURI().equals("/app/department/list.xhtml")){
//                RequestDispatcher rd = req.getRequestDispatcher("/department/list.xhtml");
//                rd.include(req, resp);
//            }
//        }

    }

}
