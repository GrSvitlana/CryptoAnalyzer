package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Result;

public interface Action {
	Result execute(String[] parameters);
	
}
