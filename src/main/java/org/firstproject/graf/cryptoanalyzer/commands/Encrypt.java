package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Result;
import org.firstproject.graf.cryptoanalyzer.entity.ResultCode;
import org.firstproject.graf.cryptoanalyzer.exception.AppException;
import org.firstproject.graf.cryptoanalyzer.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.firstproject.graf.cryptoanalyzer.constant.Constants.ALPHABET;

public class Encrypt implements Action {
	
	@Override
	public Result execute(String[] parameters) throws IOException {
		
		String txtFile = parameters[0];
		String encryptedFile = parameters[1];
		int key = Integer.parseInt(parameters[2]);
		String encrypted = "";
		Path path = Path.of(PathFinder.getRoot() + txtFile);
		
		try {
			String strings = String.valueOf(Files.readAllLines(path));
			for (int i = 0; i < strings.length(); i++) {
				int index = ALPHABET.indexOf(strings.charAt(Integer.parseInt(String.valueOf(i))));
				int newIndex = (ALPHABET.length() + index + key) % ALPHABET.length();
				char replaceChar = ALPHABET.charAt(newIndex);
				encrypted += replaceChar;
			}
			Path path2 = Path.of(PathFinder.getRoot() + encryptedFile);
			Files.write(Paths.get(String.valueOf(path2)), encrypted.getBytes());
			
		} catch (IOException e) {
			throw new AppException("Not found", e);
		}
		
		return new Result(ResultCode.OK, "all bytes read" + path);
	}
}