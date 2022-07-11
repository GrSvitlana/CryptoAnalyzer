package org.firstproject.graf.cryptoanalyzer.controllers;

import org.firstproject.graf.cryptoanalyzer.commands.Action;
import org.firstproject.graf.cryptoanalyzer.commands.Decrypt;
import org.firstproject.graf.cryptoanalyzer.commands.Encrypt;

public enum Actions {
	
	ENCRYPT(new Encrypt()),
	DECRYPT(new Decrypt());
	
	private final Action action;
	
	Actions(Action action) {
		this.action = action;
	}
	
	public static Action find(String command) {
		return Actions.valueOf(command.toUpperCase()).action;
	}
}
