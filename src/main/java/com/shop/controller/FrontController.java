package com.shop.controller;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FrontController extends HttpServlet {
   private static final long serialVersionUID =1L;
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //한글 깨짐 방지
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      //getRequestURI(): "/프로젝트명/파일명(*.go)"라는 문자열을 반환해주는 메서드
      System.out.println("========================");
      String uri = request.getRequestURI();
      System.out.println("1: "+uri);
      
      //현재 프로젝트명을 문자열로 반환해주는 메서드
      String path = request.getContextPath();
      System.out.println("2: "+path);
      
      String command = uri.substring(path.length()+1);
      System.out.println("3: "+command);
      
      Action action = null;
      ActionForward forward = null;
      
      Properties prop = new Properties();
   
      
       FileInputStream fis = new FileInputStream("C:\\NCS\\workSpaceEE\\16_MiniShopMall\\src\\main\\java\\com\\shop\\controller\\mapping.properties");
       prop.load(fis);
       String value = prop.getProperty(command);
       System.out.println("value: "+value);
       
       if(value.substring(0, 7).equals("execute")) {
          StringTokenizer st = new StringTokenizer(value, "|");
          
          String url_1 = st.nextToken(); // "excute" 문자열
          System.out.println("4: "+url_1);
          String url_2 = st.nextToken(); // "패키지명.클래스" 문자열
          System.out.println("5: "+url_2);
         
          try {
            Class<?> url = Class.forName(url_2);
            
             // 동적으로 로딩된 클래스(객체)의 생성자 (기본생성자)를 가져오는 메서드
             Constructor<?> constructor = url.getConstructor();
             
             //가져온 기본생성자를 써서 newInstance() 메서드 호출해서 객체를 생성하는 메서드
             action = (Action)constructor.newInstance(); 
             //newInstance 메서드 사용을 위해 Action 인터페이스로 형변환
             //Constructor 클래스 제네릭 타입이 ?이기 때문에
             
             //비지니스 로직을 실행하는 메서드 호출
             forward = action.execute(request, response);
             
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            } else {
                //value에 들어온 값이 "excute|...."가 아닐 때
                forward = new ActionForward();
                forward.setRedirect(false);
                forward.setPath(value);
            } 
       
           if(forward != null) {
             if(forward.isRedirect()) { //true인 경우
                response.sendRedirect(forward.getPath());
             } else { //false인 경우
                //view 페이지로 이동
                request.getRequestDispatcher(forward.getPath())
                   .forward(request, response);
             }
          }
         
      }

}