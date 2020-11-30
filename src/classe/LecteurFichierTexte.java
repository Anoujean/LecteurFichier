package classe;

public class LecteurFichierTexte extends LecteurFichier{
	
	public boolean verifyExtension(String filename) {
		boolean result = false;
		if (filename.endsWith(".txt"))
			result =  true;
		return result;
	}

}
