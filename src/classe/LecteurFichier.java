package classe;
import interfaces.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public abstract class LecteurFichier implements LecteurUtilities {
	
	public LecteurFichier() {}
	
	@Override
	public boolean verifyFile(String filepath) {
		File file = new File(filepath);
		boolean result = false;
		if (file.exists()) {
			result = true;
		}
		return result;
	};
	
	@Override
	public abstract boolean verifyExtension(String filepath);

	
	@Override
	public void fileReader(String filename) {
		List<String> lines = getLines(filename);
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
	};

	@Override
	public void reverseReader(String filename) {
		List<String> lines = getLines(filename);
		for (int i = lines.size() - 1; i >= 0; i--) {
			System.out.println(lines.get(i));
		}
	};

	@Override
	public void palindromeReader(String filename) {
		List<String> lines = getLines(filename);
		for (int i = lines.size() - 1; i >= 0; i--) {
			StringBuilder sb = (new StringBuilder(lines.get(i)).reverse());
			System.out.println(sb);
		}
	};

	@Override
	public boolean compareFiles (String filename1, String filename2) {
		
		File file1 = new File(filename1);
		File file2 = new File(filename2);
		Path path1 = file1.toPath();
		Path path2 = file2.toPath();
		
		try {
			//verifie si la taille n'est pas similaire
            if (Files.size(path1) != Files.size(path2)) {
                return false;
            }
            //vérifie si les bytes sont similaires
            byte[] bytePath1 = Files.readAllBytes(path1);
            byte[] bytePath2 = Files.readAllBytes(path2);
            return Arrays.equals(bytePath1, bytePath2);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
	};

	public List<String> getLines(String filepath) {
		List<String> allLines = new ArrayList<>();
		try {
			allLines = Files.readAllLines(Paths.get(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}

}
