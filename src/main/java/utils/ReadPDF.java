package utils;

import operations.PDFOperations;

public class ReadPDF {
	// PDF to be read
	public static final String READ_PDF_WITH_NO_PASSWORD = "src/main/java/pdf/sample.PDF";

	public static void main(String[] args) {

		String output = "dummy";
		PDFOperations ops = new PDFOperations();

		if (ops.validatePDF(READ_PDF_WITH_NO_PASSWORD))
			output = ops.readPDF(READ_PDF_WITH_NO_PASSWORD);

		System.out.println(output);

	}
}