package operations;

import java.io.IOException;

import com.lowagie.text.exceptions.BadPasswordException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class PDFOperations implements Operations{
	
	public StringBuilder fullContent = null;
	
	@Override
	public String readPDF(String file) {
		try (PdfReader pdfreader = new PdfReader(file)) {
            // get pages in PDF
            int pages = pdfreader.getNumberOfPages();
            PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(pdfreader);
            // Iterate through pages to read content
            fullContent = new StringBuilder();
            for(int i = 1; i <= pages; i++) { // Extract content of each page
                String contentOfPage = pdfTextExtractor.getTextFromPage(i, true);
                fullContent.append(contentOfPage);
            } 
            
        } catch (IOException io) { 
        	//not found as file or resource
        	System.err.println("File path entered is not correct. Please validate and try again.");
        } catch (Exception e) { 
        	e.printStackTrace(); 
        }
		
		return fullContent.toString();
		
	}

	@Override
	public String readPDF(String file, String password) {
	    
        try (PdfReader pdfreader = new PdfReader(file, password.getBytes())) {
            // get pages in PDF
            int pages = pdfreader.getNumberOfPages();
            PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(pdfreader);
            // Iterate through pages to read content
            fullContent = new StringBuilder();
            for(int i = 1; i <= pages; i++) { // Extract content of each page
            	String contentOfPage = pdfTextExtractor.getTextFromPage(i, true);
                fullContent.append(contentOfPage);
            } 
            
        } catch (BadPasswordException e) {
        	 System.err.println("Password entered "+password+" is not correct. Please validate and try again."); 
        } catch (IOException io) { 
        	//not found as file or resource
        	System.err.println("File path entered is not correct. Please validate and try again.");
        } catch (Exception e) { 
        	e.printStackTrace(); 
        }
        
        return fullContent.toString();
    
	}

	@Override
	public Boolean validatePDF(String file) {
		boolean isPDFCorrect = false;
		try (PdfReader pdfreader = new PdfReader(file)) {
			isPDFCorrect = true;   
        } catch (IOException io) { 
       	//not found as file or resource
       	System.err.println("File path entered is not correct. Please validate and try again.");
       } catch (Exception e) { 
    	   e.printStackTrace(); 
       }
		
		return isPDFCorrect;
	}

	@Override
	public Boolean validatePDF(String file, String password) {
		boolean isPDFCorrect = false;
		try (PdfReader pdfreader = new PdfReader(file, password.getBytes())) {
			isPDFCorrect = true;   
        } catch (BadPasswordException e) {
       	 System.err.println("Password entered "+password+" is not correct. Please validate and try again."); 
       } catch (IOException io) { 
       	//not found as file or resource
       	System.err.println("File path entered is not correct. Please validate and try again.");
       } catch (Exception e) { 
       	e.printStackTrace(); 
       }
		
		return isPDFCorrect;
	}

	@Override
	public Boolean validatePDF(String file, String password, boolean debugMode) {
		
		boolean isPDFCorrect = false;
		try (PdfReader pdfreader = new PdfReader(file, password.getBytes())) {
			isPDFCorrect = true;   
        } catch (BadPasswordException e) {
        	if(debugMode) System.err.println("Password entered "+password+" is not correct. Please validate and try again."); 
       } catch (IOException io) { 
       	//not found as file or resource
    	   if(debugMode) System.err.println("File path entered is not correct. Please validate and try again.");
       } catch (Exception e) { 
       	e.printStackTrace(); 
       }
		
	   return isPDFCorrect;
	}

}
