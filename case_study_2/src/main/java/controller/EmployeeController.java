package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.Employee;
import model.employee.EmployeeDegree;
import model.employee.EmployeeDivision;
import model.employee.EmployeePosition;
import service.employee.IEmployeeDegreeService;
import service.employee.IEmployeeDivisionService;
import service.employee.IEmployeePositionService;
import service.employee.IEmployeeService;
import service.employee.employee_impl.EmployeeDegreeServiceImpl;
import service.employee.employee_impl.EmployeeDivisionServiceImpl;
import service.employee.employee_impl.EmployeePositionServiceImpl;
import service.employee.employee_impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    IEmployeeService employeeService = new EmployeeServiceImpl();
    IEmployeeDegreeService employeeDegreeService = new EmployeeDegreeServiceImpl();
    IEmployeePositionService employeePositionService = new EmployeePositionServiceImpl();
    IEmployeeDivisionService employeeDivisionService = new EmployeeDivisionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
//            case "edit":
//                editEmployee(request, response);
//                break;
            default:
                listEmployee(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
//            case "edit":
//                editEmployee(request, response);
//                break;
            default:
                listEmployee(request, response);
        }
    }


    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.displayEmployeeList();
        request.setAttribute("employeeList", employeeList);
        List<EmployeeDegree> employeeDegreeList = employeeDegreeService.employeeDegreeList();
        request.setAttribute("employeeDegreeList", employeeDegreeList);
        List<EmployeePosition> employeePositionList = employeePositionService.employeePositionList();
        request.setAttribute("employeePositionList", employeePositionList);
        List<EmployeeDivision> employeeDivisionList = employeeDivisionService.employeeDivisionList();
        request.setAttribute("employeeDivisionList", employeeDivisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDegree> employeeDegreeList = employeeDegreeService.employeeDegreeList();
        request.setAttribute("employeeDegreeList", employeeDegreeList);
        List<EmployeePosition> employeePositionList = employeePositionService.employeePositionList();
        request.setAttribute("employeePositionList", employeePositionList);
        List<EmployeeDivision> employeeDivisionList = employeeDivisionService.employeeDivisionList();
        request.setAttribute("employeeDivisionList", employeeDivisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer idPosition = Integer.parseInt(request.getParameter("employeePosition"));
        Integer idDegree = Integer.parseInt(request.getParameter("employeeDegree"));
        Integer idDivision = Integer.parseInt(request.getParameter("employeeDivision"));
        Employee employee = new Employee(name,dateOfBirth,idCard,salary,phone,email,address,idPosition,idDegree,idDivision);
        employeeService.insertEmployee(employee);
        List<EmployeeDegree> employeeDegreeList = employeeDegreeService.employeeDegreeList();
        request.setAttribute("employeeDegreeList", employeeDegreeList);
        List<EmployeePosition> employeePositionList = employeePositionService.employeePositionList();
        request.setAttribute("employeePositionList", employeePositionList);
        List<EmployeeDivision> employeeDivisionList = employeeDivisionService.employeeDivisionList();
        request.setAttribute("employeeDivisionList", employeeDivisionList);
        request.setAttribute("messageCreate","Create successful !");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
