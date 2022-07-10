package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Resulte;

public interface Action {
	Resulte execute(String[] parameters);
	
}
