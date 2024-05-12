package com.jsp;


import java.util.Scanner;

import static com.jsp.UserRepository.loggingUser;
import static util.SimpleInput.input;

public class UserLoginView {

    UserRepository ur = new UserRepository();


    public void loginMenu() {
        firstStart:
        while (true) {
            System.out.println("===================================");
            System.out.println("         1. 회원가입");
            System.out.println("         2. 로그인");
            System.out.println("         3. 아이디/비밀번호 찾기");
            System.out.println("         4. 프로그램 종료");
            System.out.println("===================================");
            String input = input("메뉴를 입력해주세요. \n >>");

            switch (input) {
                case "1":
                    newUser();
                    break;
                case"2":
                    LoginView();
                    break;
                case"3":
                    break;
                case"4":
                        System.exit(0);
            }
        }
    }
    /**
     * 아이디, 비밀번호 맞으면 로그인 성공 시킴.
     */
    public void LoginView () {

        System.out.println("로그인할 아이디와 비밀번호를 입력해주세요");
        String id = input("id : >>");
        String passsword = input("password : >>");
        boolean b = ur.userLogin(id, passsword);
        if (b) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }


    public void newUser () {
        System.out.println("회원가입을 시작합니다.");
        String id = input("사용하실 아이디를 입력해주세요 \n >>");
        if (ur.newUserCheckId(id)) { // -- 아이디 검증
            System.out.println("사용가능한 아이디입니다.");
            String passowrd = input("사용하실 패스워드를 입력해주세요 \n >>");
            if (ur.newUserPassCheck(passowrd)) { // -- 패스워드 조건 검증
                System.out.println("유효한 패스워드입니다.");
                try {
                int age = Integer.parseInt(input("회원님의 나이를 입력해주세요. \n >>"));
                    if (ur.newUserAgeCheck(age)) {  // -- 나이 조건 확인.
                        System.out.printf("회원님의 나이가 %d로 설정되었습니다.",age);
                        String name = input("회원님의 이름을을 입력해주세요. \n >>");
                        String genderCheck = input("회원님의 성별을 입력해주세요. (M,F))n >>").toUpperCase();
                        Gender gender = ur.newUserGenderCheck(genderCheck);
                        if (gender == Gender.FEMALE) {
                            System.out.println("여성으로 설정되었습니다.");
                        } else if ( gender== Gender.MALE) {
                            System.out.println("남성으로 설정되었습니다.");
                        } else {
                            System.out.println("성별을 제대로 입력해주세요.");
                        }
                        String nickname = input("사용하실 회원님의 닉네임을 입력해주세요. \n >>");
                        String email = input("사용하실 이메일을 작성해주세요. \n >>");
                        User user = new User(id, passowrd, email, age, name, nickname, gender);
                        UserRepository.addUser(user);
                        System.out.println("성공적으로 회원가입이 완료되었습니다.");

                    } else {
                        System.out.println("나이는 14 ~ 120살 까지 가입 가능합니다.");
                    }
                } catch (Exception e) {
                    System.out.println("나이는 정수로만 작성 가능합니다.");
                }
            } else {
                System.out.println("사용불가능한 패스워드입니다.");
                System.out.println("대문자, 특수문자, 최소 8글자 이상 조건을 만족해야합니다.");
            }
        } else {
            System.out.println("이미 가입된 회원입니다.");
        }
    }


}
