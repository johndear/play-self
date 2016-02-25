package server;

import java.io.File;

import play.Logger;
import play.Play;
import play.server.Server;

public class BootStrap {
	
	public static void main(String[] args) throws Exception {
//        File root = new File(System.getProperty("application.path"));
        String appPath = "F:\\github\\play-self"; 
        File root = new File(appPath);
        if (System.getProperty("precompiled", "false").equals("true")) {
            Play.usePrecompiled = true;
        }
        if (System.getProperty("writepid", "false").equals("true")) {
            Server.writePID(root);
        }
        Play.init(root, System.getProperty("play.id", ""));
        if (System.getProperty("precompile") == null) {
            new Server(args);
        } else {
            Logger.info("Done.");
        }
    }

}
