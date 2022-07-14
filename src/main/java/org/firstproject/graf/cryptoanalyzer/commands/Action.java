package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Result;

import java.io.IOException;

public interface Action {
	Result execute(String[] parameters) throws IOException;
	
}
