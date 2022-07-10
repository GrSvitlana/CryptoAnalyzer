package org.firstproject.graf.cryptoanalyzer;

import org.firstproject.graf.cryptoanalyzer.entity.Resulte;

public class MainApp {
	
	public static void main(String... args) throws Exception {
		
		Application application = new Application(args);
		Resulte resulte = application.run();
	}
	
}
		
		/*int key = 123; // <<< args
		String encrypt = "Java is a high-level, class-based, object-oriented programming language that is designed" +
				" to have as few implementation dependencies as possible."; // <<< args
		String decrypt = ""; // <<< args*/