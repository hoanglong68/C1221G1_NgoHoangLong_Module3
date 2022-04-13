import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String productDescription = request.getParameter("ProductDescription");
        double price = Double.parseDouble(request.getParameter("ListPrice"));
        double rate = Double.parseDouble(request.getParameter("DiscountPercent"));
        double discountAmount = price * rate * 0.01;
        double discountPrice = price - discountAmount;
       request.setAttribute("ProductDescription",productDescription);
       request.setAttribute("discountAmount",discountAmount);
       request.setAttribute("discountPrice",discountPrice);
       request.getRequestDispatcher("/discount_client.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
