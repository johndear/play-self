package controllers;

import play.mvc.Controller;
import server.Test;

public class TestAction extends Controller {
	
	public static void test(){
		System.out.println("test=1111=======");
		render("Application/index.html");
	}
	
	public static void test2(){
		System.out.println("test=2222=======");
	}
	
	public void test3(){
		System.out.println("test=3333=======");
		Application app =new Application();
		app.hello("123");
	    System.out.println("classLoader: "+ app.getClass().getClassLoader().getClass());
	    
	    Test test =new Test();
	    test.test();
	    System.out.println("classLoader: "+ test.getClass().getClassLoader().getClass());
	}
	
//	public void test4(){
//		System.out.println("test=444=======");
//		Application app =new Application();
//		app.hello("123");
//	    System.out.println("classLoader: "+ app.getClass().getClassLoader().getClass());
//	    
//	    Test test =new Test();
//	    test.test();
//	    System.out.println("classLoader: "+ test.getClass().getClassLoader().getClass());
//	}

}
