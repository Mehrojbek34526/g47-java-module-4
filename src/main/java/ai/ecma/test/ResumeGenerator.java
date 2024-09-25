package ai.ecma.test;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ResumeGenerator {

    public static void main(String[] args) {
        // Personal Information
        String name = "John Doe";
        String address = "1234 Elm Street, Springfield";
        String phone = "+1 234 567 890";
        String email = "john.doe@example.com";
        
        // Education
        String education = "Bachelor of Science in Computer Science\nXYZ University, 2015-2019";
        
        // Work Experience
        String workExperience = "Software Engineer\nABC Corp.\nJan 2020 - Present\n\n" +
                                "Intern Developer\nXYZ Ltd.\nJun 2019 - Dec 2019";
        
        // Custom Logo Path
        String logoPath = "/Users/mehrojbekmavlonov/Downloads/logotest.png";
        
        try {
            // Create Document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Resume.pdf"));
            document.open();
            
            // Add Logo
            Image logo = Image.getInstance(logoPath);
            logo.setAbsolutePosition(450, 730); // Position of the logo
            logo.scaleToFit(100, 100); // Scale logo size
            document.add(logo);
            
            // Add Personal Information
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            
            document.add(new Paragraph(name, headerFont));
            document.add(new Paragraph(address, normalFont));
            document.add(new Paragraph("Phone: " + phone, normalFont));
            document.add(new Paragraph("Email: " + email, normalFont));
            
            // Add Education
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Education", headerFont));
            document.add(new Paragraph(education, normalFont));
            
            // Add Work Experience
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Work Experience", headerFont));
            document.add(new Paragraph(workExperience, normalFont));
            
            // Close Document
            document.close();
            
            System.out.println("Resume PDF created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
