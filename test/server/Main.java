package server;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import play.Invoker;
import play.Logger;
import play.Play;
import play.classloading.ApplicationClasses;
import play.classloading.ApplicationClassloader;
import play.classloading.ApplicationClasses.ApplicationClass;
import play.plugins.PluginCollection;
import play.server.Server;
import play.server.PlayHandler.NettyInvocation;
import play.vfs.VirtualFile;


public class Main {

	public static void main(String[] args) throws Exception {
		String appPath = "F:\\workspace\\play-self"; 
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
    	
//    	controllers.TestAction
    	Class clazz = Play.classloader.loadApplicationClass("controllers.TestAction");
        
    }
}
