package controllers;

import java.util.Date;
import java.util.List;

import play.Play;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
//@Check("administrator")
public class Application extends Controller {

    public static void index(String name) {
    	System.out.println("index...........");
        render();
    }

}