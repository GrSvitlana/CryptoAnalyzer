package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Result;
import org.firstproject.graf.cryptoanalyzer.exception.AppException;
import org.firstproject.graf.cryptoanalyzer.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Decrypt implements Action {
	
	@Override
	public Result execute(String[] parameters) {
		
		String txtFile = parameters[0];
		String encryptedFiel = parameters[0];
		Path path = Path.of(PathFinder.getRoot() + txtFile);
		try {
			List<String> strings = Files.readAllLines(path);
			for (String string : strings) {
				System.out.println(string);
			}
		} catch (IOException e) {
			throw new AppException("Not found", e);
		}
		
		return null;
	}
}
