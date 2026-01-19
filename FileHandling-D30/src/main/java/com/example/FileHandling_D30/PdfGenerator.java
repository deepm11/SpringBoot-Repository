package com.example.FileHandling_D30;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileOutputStream;

public class PdfGenerator {

    public static String generatePdf(String content) throws Exception {

        String filePath = "uploads/generated.pdf";

        PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        document.add(new Paragraph(content));

        document.close();

        return filePath;
    }
}
