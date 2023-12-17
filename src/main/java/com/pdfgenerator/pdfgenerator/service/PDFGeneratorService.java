package com.pdfgenerator.pdfgenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse httpServletResponse) throws IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.COURIER_BOLD);
        fontTitle.setSize(16);
        fontTitle.setColor(108, 142, 163);

        Paragraph paragraph = new Paragraph("Generate a PDF Using Spring Boot", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        fontParagraph.setColor(153, 153, 255);

        Paragraph headingPara = new Paragraph("This is Heading for a Paragraph.",fontParagraph);
        headingPara.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(headingPara);

        document.close();

    }
}
