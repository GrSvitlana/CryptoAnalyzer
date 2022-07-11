package org.firstproject.graf.cryptoanalyzer.controllers;

import org.firstproject.graf.cryptoanalyzer.commands.Action;
import org.firstproject.graf.cryptoanalyzer.entity.Result;

public class MainController {
	
	/*public Resulte doAction(String action, String[] parameters) {
		return null;
	}*/
	
	public Result execute (String command, String[] parameters) {
		Action action = Actions.find(command);
		Result result = action.execute(parameters);
		return result;
	}
}
