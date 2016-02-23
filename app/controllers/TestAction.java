package controllers;

import play.mvc.Controller;

public class TestAction extends Controller {
	
	public static void test(){
		System.out.println("test=123=======");
		render("Application/index.html");
	}

}
