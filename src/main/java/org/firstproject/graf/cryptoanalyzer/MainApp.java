package org.firstproject.graf.cryptoanalyzer;

import org.firstproject.graf.cryptoanalyzer.constants.Constants;
import org.firstproject.graf.cryptoanalyzer.controllers.MainController;
import org.firstproject.graf.cryptoanalyzer.entity.Resulte;

public class MainApp {
	
	public static void main(String... args) throws Exception {
		
		MainController mainController = new MainController();
		Application application = new Application(mainController);
		Resulte resulte = application.run(args);
		System.out.println(resulte);
		String txtFolder = Constants.TXT_FOLDER;
		System.out.println(txtFolder);
	}
	
}
		
		/*int key = 123; // <<< args
		String encrypt = "Java is a high-level, class-based, object-oriented programming language that is designed" +
				" to have as few implementation dependencies as possible."; // <<< args
		String decrypt = ""; // <<< args*/