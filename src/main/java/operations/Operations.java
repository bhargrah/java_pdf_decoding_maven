package operations;

public interface Operations {
	
	public String readPDF(String file);
	public String readPDF(String file, String password);
	
	public Boolean validatePDF(String file);
	public Boolean validatePDF(String file, String password);
	public Boolean validatePDF(String file, String password ,boolean debugMode);
	
}
