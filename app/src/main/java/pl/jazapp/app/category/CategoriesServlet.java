package pl.jazapp.app.category;

import pl.jazapp.app.webapp.categories.CategoryController;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("Categories")
public class CategoriesServlet extends HttpServlet {

    @Inject
    private CategoryController categoryController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        RequestDispatcher rd = req.getRequestDispatcher("category/edit.xhtml");
        rd.include(req, resp);
    }
}
