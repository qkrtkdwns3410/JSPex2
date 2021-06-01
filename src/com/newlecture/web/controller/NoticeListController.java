package com.newlecture.web.controller;

import com.newlecture.web.entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Notice> list = new ArrayList<>();
        
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String sql = "SELECT * FROM NOTICE";
        
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "SYSTEM", "3410");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                String hit = rs.getString("HIT");
                String files = rs.getString("FILES");
                String content = rs.getString("CONTENT");
    
                Notice notice = new Notice(
                        id,
                        title,
                        regdate,
                        writerId,
                        hit,
                        files,
                        content
                );
                list.add(notice);
            }
            
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/notice/list.jsp").forward(request, response);
    }
}

