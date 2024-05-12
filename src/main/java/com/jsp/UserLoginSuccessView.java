package com.jsp;

import static util.SimpleInput.input;

public class UserLoginSuccessView {
    UserRepository ur = new UserRepository();


    public void loginSuccessMain() {
        firstStart:
        while (true) {
            System.out.println("===================================");
            System.out.println("         1. 오늘 기분 작성하기");
            System.out.println("         2. 다른 회원 게시글 바로가기");
            System.out.println("         3. 달력 보러가기");
            System.out.println("         4. 마이페이지");
            System.out.println("         5. 로그아웃");
            System.out.println("===================================");
            String input = input("메뉴를 입력해주세요. \n >>");

            switch (input) {
                case "1":
                    break;
                case"2":
                    break;
                case"3":
                    break;
                case"4":
                    break;
                case"5":
                    break;
            }
        }
    }
}
