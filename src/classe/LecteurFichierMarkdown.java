package classe;

public class LecteurFichierMarkdown extends LecteurFichier{
	
	public boolean verifyExtension(String filename) {
		boolean result = false;
		if (filename.endsWith(".md"))
			result =  true;
		return result;
	}

}
