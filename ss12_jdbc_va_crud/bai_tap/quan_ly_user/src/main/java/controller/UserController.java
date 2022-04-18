package controller;

import model.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/user", "/"})
public class UserController extends HttpServlet {
    IUserService iUserService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            default:
                listUser(request, response);
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
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                searchUserByCountry(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "sort":
                listSortedUser(request, response);
            default:
                listUser(request, response);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = null;
        try {
            userList = iUserService.selectAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        try {
            iUserService.insertUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = null;
        try {
            existingUser = iUserService.selectUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        User existingUser = new User();
        existingUser.setId(Integer.parseInt(request.getParameter("id")));
        existingUser.setName(request.getParameter("name"));
        existingUser.setEmail(request.getParameter("email"));
        existingUser.setCountry(request.getParameter("country"));
        try {
            iUserService.updateUser(existingUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iUserService.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<User> userList = null;
        try {
            userList = iUserService.selectAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response) {
        List<User> userFindingList = null;
        List<User> userList = null;
        String message = null;
        String country = request.getParameter("search");
        try {
            userList = iUserService.selectAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            userFindingList = iUserService.selectUserByCountry(country);
            if (userFindingList.isEmpty()) {
                message = "User with country: " + country + " is not exist !";
                request.setAttribute("message", message);
                request.setAttribute("userList", userList);
            } else {
                request.setAttribute("userList", userFindingList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listSortedUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userSortedList = null;
        try {
            userSortedList = iUserService.sortByName();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("userList", userSortedList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
