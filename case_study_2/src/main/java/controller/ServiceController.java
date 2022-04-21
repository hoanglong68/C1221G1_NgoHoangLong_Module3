package controller;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import service.service.IRentTypeService;
import service.service.IServiceService;
import service.service.IServiceTypeService;
import service.service.service_impl.RentTypeServiceImpl;
import service.service.service_impl.ServiceServiceImpl;
import service.service.service_impl.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceController", urlPatterns = "/service")
public class ServiceController extends HttpServlet {
    IServiceService serviceService = new ServiceServiceImpl();
    IRentTypeService rentTypeService = new RentTypeServiceImpl();
    IServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            default:
                listService(request, response);
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
            default:
                listService(request, response);
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.displayServiceList();
        request.setAttribute("serviceList", serviceList);
        List<RentType> rentTypeList = rentTypeService.rentTypeList();
        request.setAttribute("rentTypeList", rentTypeList);
        List<ServiceType> serviceTypeList = serviceTypeService.serviceTypeList();
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.rentTypeList();
        request.setAttribute("rentTypeList", rentTypeList);
        List<ServiceType> serviceTypeList = serviceTypeService.serviceTypeList();
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer capacity = Integer.parseInt(request.getParameter("capacity"));
        Integer idRentType = Integer.parseInt(request.getParameter("rentType"));
        Integer idServiceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String convenient = request.getParameter("convenient");
        Double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        Integer floors = Integer.parseInt(request.getParameter("floors"));
        Service service = new Service(name, area, price, capacity, idRentType, idServiceType, standardRoom, convenient, poolArea, floors);
        serviceService.insertService(service);
        request.setAttribute("messageCreate","Create successful !");
        List<RentType> rentTypeList = rentTypeService.rentTypeList();
        request.setAttribute("rentTypeList", rentTypeList);
        List<ServiceType> serviceTypeList = serviceTypeService.serviceTypeList();
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
