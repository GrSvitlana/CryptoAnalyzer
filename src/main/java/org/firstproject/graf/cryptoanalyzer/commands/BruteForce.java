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

public class BruteForce implements Action {
	
	@Override
	public Result execute(String[] parameters) throws IOException {
		
		String encryptedFile = parameters[0];
		String brutedecryptedFile = parameters[1];
		String decrypted = "";
		
		Path path = Path.of(PathFinder.getRoot() + encryptedFile);
		String strings = String.valueOf(Files.readAllLines(path));
		
		try {
			for (int key = 1; key <= ALPHABET.length(); key++) {
				for (int i = 0; i < strings.length(); i++) {
					int index = ALPHABET.indexOf(strings.charAt(Integer.parseInt(String.valueOf(i))));
					int newIndex = (ALPHABET.length() + index - key) % ALPHABET.length();
					if (newIndex < 0) {
						newIndex = ALPHABET.length() + newIndex;
					}
					char replaceChar = ALPHABET.charAt(newIndex);
					decrypted += replaceChar;
				}
				
				if (decrypted.contains(", ") && !decrypted.contains("ьь") && decrypted.contains("--")
						&& !decrypted.contains(" ы") && !decrypted.contains(" ь") && !decrypted.contains(" ъ") &&
						!decrypted.contains(" Ы") && !decrypted.contains(" Ь") && !decrypted.contains(" Ъ")) {
					
					System.out.println("key = " + key);
					Path path3 = Path.of(PathFinder.getRoot() + brutedecryptedFile);
					Files.write(Paths.get(String.valueOf(path3)), decrypted.getBytes());
					break;
				} else decrypted = "";
			}
		} catch (IOException e) {
			throw new AppException("Not found", e);
		}
		
		return new Result(ResultCode.OK, "all bytes read" + path);
	}
}