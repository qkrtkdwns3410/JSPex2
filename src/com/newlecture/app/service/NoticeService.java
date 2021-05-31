package com.newlecture.app.service;

import com.neclecture.app.entity.Notice;
import com.sun.xml.internal.ws.util.NoCloseInputStream;

import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.StartDocument;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String uid = "system";
    private String pwd = "3410";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    
    public List<Notice> getList(int page,String field,String query) throws SQLException, ClassNotFoundException {
        
        int Start = 1 + (page - 1) * 10;
        int end = 10 * page;
        
        String sql = "SELECT *  FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
        
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1,"%"+query+"%");
        st.setInt(2, Start);
        st.setInt(3, end);
        ResultSet rs = st.executeQuery();
        
        List<Notice> list = new ArrayList<Notice>();
        
        while (rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");
            Notice notice = new Notice(id, title, writerId, regDate, content, hit, files);
            list.add(notice);
        }
        rs.close();
        st.close();
        con.close();
        
        return list;
    }
    
    public int insert(Notice notice) throws SQLException, ClassNotFoundException {
        String title = notice.getTitle();
        String writer_id = notice.getWriterId();
        String content = notice.getContent();
        String files = notice.getFiles();
        
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String sql = "insert into NOTICE(" +
                "                   title," +
                "                   writer_id," +
                "                   content," +
                "                   files" +
                ") values (?,?,?,?)";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
//        Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, title);
        st.setString(2, writer_id);
        st.setString(3, content);
        st.setString(4, files);
        
        int result = st.executeUpdate();
        
        System.out.println(result);
        st.close();
        con.close();
        
        return result;
    }
    
    public int update(Notice notice) {
        return 0;
    }
    
    public int delete(int id) {
        return 0;
    }
    
    
    //Scalar값을 얻어오는 함수입니다.
    public int getCount() throws SQLException, ClassNotFoundException {
        int count = 0;
        
        String sql = "SELECT  COUNT(ID) COUNT  FROM NOTICE";
        
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        List<Notice> list = new ArrayList<Notice>();
        
        if(rs.next())
            count = rs.getInt("COUNT");
        
        
        rs.close();
        st.close();
        con.close();
        
        return count;
    }
}
