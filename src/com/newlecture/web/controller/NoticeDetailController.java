package com.newlecture.web.controller;

import com.newlecture.web.entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.TitledBorder;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String sql = "SELECT * FROM NOTICE WHERE ID=?";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "SYSTEM", "3410");
            PreparedStatement st = con.prepareStatement(sql);//미리 쿼리문을 준비합니다.
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            rs.next();
            
            String title = rs.getString("TITLE");
            Date regdate = rs.getDate("REGDATE");
            String writerId = rs.getString("WRITER_ID");
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
    
            request.setAttribute("n", notice);
//            request.setAttribute("title", title);
//            request.setAttribute("writerId", writerId);
//            request.setAttribute("regdate", regdate);
//            request.setAttribute("hit", hit);
//            request.setAttribute("files", files);
//            request.setAttribute("content", content);

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //redirect
        
        
        //forward
        request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
        
        
    }
}
