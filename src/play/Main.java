package play;

import java.io.File;

import play.Logger;
import play.Play;
import play.server.Server;


public class Main {

	public static void main(String[] args) throws Exception {
		File root = new File("F:\\workspace\\play-self"); 
		String id;
        Play.init(root, System.getProperty("play.id", ""));
        if (System.getProperty("precompile") == null) {
            new Server(new String[]{});
        } else {
            Logger.info("Done.");
        }
    }
}
