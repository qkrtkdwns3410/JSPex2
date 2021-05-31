package com.newlecture.app.console;

import com.neclecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {
    private NoticeService service;
    private int page;
    private int count;
    
    public NoticeConsole() {
        
        service = new NoticeService();
        page = 1;
        count = 0;
    }
    
    public void printNoticeList() throws SQLException, ClassNotFoundException {
    
        List<Notice> list = service.getList(page);
        count = service.getCount();
        
        System.out.println("----------------------------");
        System.out.printf("<공지사항> 총 %d게시글\n", count);
        System.out.println("----------------------------");
        
        for (Notice n : list) {
            System.out.printf("%d.   %s / %s /  %s\n", n.getId(), n.getTitle(), n.getWriterId(), n.getRegDate());
        }
        System.out.println("----------------------------");
        System.out.printf("                    %d/%d pages\n", 1, 2);
    }
    
    
    public int inputNoticeMenu() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("< 1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.종료>");
        String menu_ = sc.nextLine();
        int menu = Integer.parseInt(menu_);
        
        return menu;
    }
    
    public void moveNextList() {
//        if (page ==?) {
//            System.out.println("이전 페이지가 없습니다. ");
//            return;
//        }
        page--;
    }
    
    public void movePrevList() {
        if (page == 1) {
            System.out.println("마지막 페이지 입니다.");
            return;
        }
        page++;
    }
}
