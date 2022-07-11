package org.firstproject.graf.cryptoanalyzer.controllers;

import org.firstproject.graf.cryptoanalyzer.commands.Action;
import org.firstproject.graf.cryptoanalyzer.entity.Result;
import org.firstproject.graf.cryptoanalyzer.entity.ResultCode;
import org.firstproject.graf.cryptoanalyzer.exception.AppException;

public class MainController {
	
	public Result execute(String command, String[] parameters) {
		try {
			Action action = Actions.find(command);
			return action.execute(parameters);
		} catch (AppException e) {
			//TODO log file for exception
			return new Result(ResultCode.ERROR, e.getMessage());
		}
		}
	}
