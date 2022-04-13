import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        float firstOperand = 0;
        float secondOperand = 0;
        try{
             firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
             secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        } catch (NumberFormatException numberFormatException){
            message = "ô giá trị không được rỗng";
        }
        char operator = request.getParameter("operator").charAt(0);
        float result = 0;
        try{
            result = Calculator.calculate(firstOperand,operator,secondOperand);
        }catch (ArithmeticException arithmeticException){
            message = "mẫu không được là 0 !";
        }
        request.setAttribute("message",message);
        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
