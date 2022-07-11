package org.firstproject.graf.cryptoanalyzer;

import org.firstproject.graf.cryptoanalyzer.app.Application;
import org.firstproject.graf.cryptoanalyzer.constant.Constants;
import org.firstproject.graf.cryptoanalyzer.controllers.MainController;
import org.firstproject.graf.cryptoanalyzer.entity.Result;

public class MainApp {
	
	public static void main(String... args) throws Exception {
		
		MainController mainController = new MainController();
		// encode text.txt encoded.txt 45
		Application application = new Application(mainController);
		Result result = application.run(args);
		System.out.println(result);
		String txtFolder = Constants.TXT_FOLDER;
		System.out.println(txtFolder);
	}
	
}