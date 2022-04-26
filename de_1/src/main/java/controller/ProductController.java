package controller;

import model.Category;
import model.Color;
import model.Product;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", urlPatterns = {"/", "/product"})
public class ProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IColorService colorService = new ColorServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = null;
        Integer quantity = null;
        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.getStackTrace();
        }
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.getStackTrace();
        }
        Integer idColor = Integer.parseInt(request.getParameter("idColor"));
        Integer idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Product product = new Product(name, price, quantity, idColor, idCategory);
        Map<String, String> validate = productService.insertProduct(product);
        if (validate.isEmpty()) {
            request.setAttribute("message", "create successful !");
            this.listProduct(request,response);
        } else {
            name = request.getParameter("name");
            price = Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            request.setAttribute("name",name);
            request.setAttribute("price",price);
            request.setAttribute("quantity",quantity);
            request.setAttribute("validate", validate);
            this.showCreateForm(request, response);
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
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Color> colorList = colorService.displayColorList();
        List<Category> categoryList = categoryService.displayCategoryList();
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searchByName");
        String price = request.getParameter("searchByPrice");
        List<Product> productFindList = productService.findProduct(name, price);
        List<Color> colorList = colorService.displayColorList();
        List<Category> categoryList = categoryService.displayCategoryList();
        request.setAttribute("productList", productFindList);
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void  deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        request.setAttribute("message", "delete successful !");
        this.listProduct(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.displayProductList();
        List<Color> colorList = colorService.displayColorList();
        List<Category> categoryList = categoryService.displayCategoryList();
        request.setAttribute("productList", productList);
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
