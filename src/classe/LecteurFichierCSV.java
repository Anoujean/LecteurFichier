package classe;

public class LecteurFichierCSV extends LecteurFichier{
	public boolean verifyExtension(String filename) {
		boolean result = false;
		if (filename.endsWith(".csv"))
			result =  true;
		return result;
	}

}
