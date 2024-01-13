package com.example.exam.servlet;

import com.example.exam.dao.EmployeeDAO;
import com.example.exam.dao.implement.EmployeeDAOImpl;
import com.example.exam.entity.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet({"/employee","/employee/list"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init(){
        employeeDAO = new EmployeeDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        req.setCharacterEncoding("utf-8");

        if (url.contains("list")) {
            List<EmployeeEntity> employeeList = employeeDAO.getAllEmployee();
            req.setAttribute("employeeList", employeeList);
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/employee.jsp").forward(req,resp);

    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String birthdayStr = req.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = formatter.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
System.out.print(fullName);
        EmployeeEntity newEmployee = new EmployeeEntity(fullName,birthday,address,position,department);


        // Gọi phương thức tạo nhân viên mới từ EmployeeDAO
        employeeDAO.createEmployee(newEmployee);

        // Sau khi tạo thành công, chuyển hướng trở lại trang danh sách nhân viên
        resp.sendRedirect(req.getContextPath()+"/employee/list");
    }
}
