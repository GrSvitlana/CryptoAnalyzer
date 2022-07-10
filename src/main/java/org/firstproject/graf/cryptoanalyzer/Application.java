package org.firstproject.graf.cryptoanalyzer;

import org.firstproject.graf.cryptoanalyzer.controllers.MainController;
import org.firstproject.graf.cryptoanalyzer.entity.Resulte;
import org.firstproject.graf.cryptoanalyzer.exceptions.AppException;

import java.util.Arrays;

public class Application {
	
	private final MainController mainController;
	
	public Application(MainController mainController) {
		this.mainController = mainController;
		//private mainController = new MainController();
	}
	
	public Resulte run(String[] args) {
		//if (args.length > 0) {
			String action = args[0];
			String[] parameters = Arrays.copyOfRange(args, 1, args.length);
			Resulte resulte = mainController.execute(action, parameters);
			return resulte;
		//}
		//throw new AppException();
	}
}
