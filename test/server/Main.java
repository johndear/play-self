package server;


import java.io.File;
import java.lang.reflect.Method;

import controllers.Application;
import controllers.TestAction;
import play.Play;
import play.classloading.ApplicationClassloader;
import play.classloading.ApplicationClassloaderState;
import play.classloading.HotswapAgent;
import play.utils.Java;


public class Main {

	public static void main(String[] args) throws Exception {
		String appPath = "F:\\github\\play-self"; 
		File root = new File(appPath); 
        Play.init(root, System.getProperty("play.id", ""));
        
        Play.classloader = new ApplicationClassloader();
        Play.initialized = true;
//		  1:        
//        Play.detectChanges();
        
//        2:
//        Play.classloader.detectChanges(); // 
//        Play.classloader.getAllClasses();
        
//        3:
//        List<ApplicationClass> all = new ArrayList<ApplicationClass>();
//    	for (VirtualFile virtualFile : Play.javaPath) {
//    		Play.classloader.getAllClasses(virtualFile);
//        }
//    	
//    	for (ApplicationClass applicationClass : Play.classes.all()) {
//            Class clazz = Play.classloader.loadApplicationClass(applicationClass.name);
//        }
        
        // genral => 系统AppClassLoader
        Application app =new Application();
        System.out.println(app.getClass().getClassLoader().getClass());
        TestAction test =new TestAction();
        System.out.println(test.getClass().getClassLoader().getClass());
        
    	
    	// http => 自定义ApplicationClassloader
        Play.classloader.getAllClasses();
//        Class appClass = Play.classloader.getClassIgnoreCase("controllers.Application");
    	Class controllerClass = Play.classloader.getClassIgnoreCase("controllers.TestAction"); // actionInvoker.resolve() -> getActionMethod()
    	System.out.println(controllerClass.getClassLoader().getClass());
    	Method actionMethod = Java.findActionMethod("test3", controllerClass);
    	Object instance = controllerClass.newInstance();
    	actionMethod.invoke(instance, args);
    	
    	
    	// test
    	Class clazz = Play.classloader.loadApplicationClass("controllers.TestAction");
    	System.out.println(clazz.getClassLoader().getClass());
    	Method m = clazz.getMethod("test3", null);
    	Object obj = clazz.newInstance();
    	m.invoke(obj, new Object[]{});
    	
    	int i=0;
    	while(i<50){
			try {
				// test
//				Play.classloader.currentState = new ApplicationClassloaderState();
				clazz = Play.classloader.loadApplicationClass("controllers.TestAction");
//				HotswapAgent.enabled = true;
				Play.classloader.detectChanges();
				System.out.println(clazz.getClassLoader().getClass());
				m = clazz.getMethod("test4", null);
				obj = clazz.newInstance();
				m.invoke(obj, new Object[]{});
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				Thread.sleep(3000);
				i++;
			}
    	}
    	
//    	Thread.sleep(60000);
    }
}
