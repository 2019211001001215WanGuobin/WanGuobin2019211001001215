package com.WanGuobin.week5.demo;

import com.WanGuobin.dao.UserDao;
import com.WanGuobin.model.User;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")

    public class LoginServlet extends HttpServlet {
        Connection con=null;
        public void init() throws ServletException {
            super.init();

            con=(Connection)getServletContext().getAttribute("con");
        }


//    public Connection dbConn;
//    public void init() {
//        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
//            dbConn = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("Username"), getServletConfig().getServletContext().getInitParameter("Password"));
//        } catch (Exception e) {
//            System.out.println(e); }
       // con =(Connection)getServletContext().getAttribute("dbConn");
//        System.out.println(con);



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username + password);
//        System.out.println(con);
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username, password);
            if(user!=null){
                //week 8
                // Cookie c=new Cookie(name:"sessionID"),value:""+user.getID());
                //c.setMaxAge(10*60);
                //response.addCookie(c);



                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null &&rememberMe.equals("1"))
                {
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie= new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",request.getParameter("rememberMe"));
                    usernameCookie.setMaxAge(10);
                    passwordCookie.setMaxAge(10);
                    rememberMeCookie.setMaxAge(10);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }


                HttpSession session=   request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);


                session.setAttribute("user",user);
                //request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("msg","Username or password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if( con != null){
                /*String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    // writer.println("Login Success!!!");
                    // writer.println("Welcome "+name+".");
                    request.setAttribute("ID",rs.getInt("id"));
                    request.setAttribute("Username",rs.getString("name"));
                    request.setAttribute("Password",rs.getString("password"));
                    request.setAttribute("Email",rs.getString("email"));
                    request.setAttribute("Gender",rs.getString("gender"));
                    request.setAttribute("Birthdate",rs.getDate("birthdate"));
                    request.getRequestDispatcher("userinfo.jsp").forward(request, response);
                }else{
                    request.setAttribute("msg" ,"username or password Error");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    //    writer.print("Please Enter Again");
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }*/
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}