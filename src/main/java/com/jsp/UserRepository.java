package com.jsp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.SimpleInput.input;

public class UserRepository {

    public static final List<User> userList = new ArrayList<>();
    public static User loggingUser; // 현재 로그인한 사용자 정보를 저장하는 변수
    public static boolean userLoginStatus;
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(?=\\S+$).{8,}$";

    static {
        userList.add(new User("wlstkdgns","kk00228","tkdgnsdldkdlel",13,"진상훈","상후닝",Gender.MALE));
    }

    public static void addUser(User user) {
        userList.add(user);
    }


    /**
     *
     * @param id 가입 완료 된 id 입력
     * @param password 가입 된 아이디에 맞는 패스워드 입력.
     * @return / 성공하면 true 반환 실패 시 false 반환.
     */
    public boolean userLogin (String id, String password) {
        for (User user : userList) {
            if (user.getId().equals(id) && user.getPassword().equals(password)){
                loggingUser = user; // 로그인하면 loggedInuser에 유저 정보 넣기.
                userLoginStatus = true; // 유저 로그인 성공 시 true 바꿈.
                return true;
            }
        }
        return false;
    }


    /**
     *  사용자의 아이디가 이미 등록된 아이디인지를 확인하는 코드
     * @return - 없으면 true 리턴 있으면 false 리턴.
     */
    public boolean newUserCheckId (String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) return false;
        }
        return true;
    }


    /**
     * 대문자 1글자, 특수문자 1글자 , 최소 길이 8글자 조건을 만족시켜야 함.
     * @param password -- 사용할 패스워드
     * @return 사용할 패스워드에 조건에 맞으면 true 안 맞으면 false 반환.
     */
   public boolean newUserPassCheck (String password){
       Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
       Matcher matcher = pattern.matcher(password);
       return matcher.matches();
   }

    /**
     *  나이가 15살이상이고, 150살보다 작은지 확인.
     * @param age - 가입할 나이를 파라미터로 받음.
     * @return 조건에 걸리면 false 안 걸리면 true 반환.
     */
   public boolean newUserAgeCheck (int age) {
       if (age < 14 || age > 150) return false;
       return true;
   }


    /**
     * 회원가입 유저가 여성이라면 열거형 Gender을 female 남성시 male로 바꿈.
     * @param gender m,f 둘 중 하나를 입력받음.
     * @return 젠더 타입을 리턴.
     */
   public Gender newUserGenderCheck (String gender) {
       if (gender.equals("M")) return Gender.MALE;
       if (gender.equals("F")) return  Gender.FEMALE;
       return Gender.NULL;
   }


}
