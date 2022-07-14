package org.firstproject.graf.cryptoanalyzer.commands;

import org.firstproject.graf.cryptoanalyzer.entity.Result;
import org.firstproject.graf.cryptoanalyzer.entity.ResultCode;
import org.firstproject.graf.cryptoanalyzer.exception.AppException;
import org.firstproject.graf.cryptoanalyzer.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.firstproject.graf.cryptoanalyzer.constant.Constants.ALPHABET;

public class Encrypt implements Action {
	
	@Override
	public Result execute(String[] parameters) {

		String txtFile = parameters[0];
		String encryptedFile = parameters[1];
		String encrypted = "";
		int key = Integer.parseInt(parameters[2]);
		Path path = Path.of(PathFinder.getRoot() + txtFile);
		Path path2 = Path.of(PathFinder.getRoot() + encryptedFile);
		try {
			String strings = String.valueOf(Files.readAllLines(path));
			//for (String string : strings) {
					for (int i = 0; i < strings.length(); i++) {
						
						int index = ALPHABET.indexOf(strings.charAt(Integer.parseInt(String.valueOf(i))));
						int newIndex = (key + index) % ALPHABET.length();
						System.out.println("length = " + ALPHABET.length());
						System.out.println(key + index);
						char replaceChar = ALPHABET.charAt(newIndex);
						encrypted += replaceChar;
						System.out.println(encrypted);
					}
			System.out.print(encrypted);
			
					
			//}
			
		} catch (IOException e) {
			throw new AppException("Not found", e);
		}

		System.out.println();
		System.out.println();System.out.println();
		return new Result(ResultCode.OK, "all bytes read" + path);
	}
}
