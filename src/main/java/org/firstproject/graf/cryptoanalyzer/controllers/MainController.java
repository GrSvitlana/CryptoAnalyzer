package org.firstproject.graf.cryptoanalyzer.controllers;

import org.firstproject.graf.cryptoanalyzer.commands.Action;
import org.firstproject.graf.cryptoanalyzer.entity.Result;

public class MainController {
	
	public Result execute (String command, String[] parameters) {
		Action action = Actions.find(command);
		return action.execute(parameters);
	}
}
