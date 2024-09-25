package ai.ecma.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;

public class PDFBoxVerticalLineWithCircles {
    public static void main(String[] args) {
        // Path to the PDF file
        String dest = "PDFBox_vertical_line_with_circles.pdf";

        // Create a new PDF document
        try (PDDocument document = new PDDocument()) {
            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Starting and ending positions for the vertical line
            float startX = 100f; // X position of the line
            float startY = 750f; // Starting Y position of the line
            float endY = 150f;   // Ending Y position of the line

            // Draw the vertical line and circles using a content stream
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Set the line width and draw the vertical line
                contentStream.setLineWidth(2f);
                contentStream.moveTo(startX, startY);
                contentStream.lineTo(startX, endY);
                contentStream.stroke();

                // Define the positions where circles will be drawn
                float[] circlePositionsY = {750f, 650f, 550f, 450f}; // Y positions for circles
                float circleRadius = 6f; // Radius of the circles

                // Draw circles at the specified positions
                for (float posY : circlePositionsY) {
                    drawCircle(contentStream, startX, posY, circleRadius);
                }
            }

            // Save the PDF document
            document.save(dest);
            System.out.println("PDF created successfully at: " + dest);
        } catch (IOException e) {
            System.err.println("An error occurred while creating the PDF: " + e.getMessage());
        }
    }

    // Method to draw a circle using Bezier curves
    private static void drawCircle(PDPageContentStream contentStream, float xCenter, float yCenter, float radius) throws IOException {
        // Draw a circle using 4 connected Bézier curves
        float c = 0.551915024494f; // Constant for approximating a circle using Bézier curves

        // Calculate points around the circle
        float x0 = xCenter;
        float y0 = yCenter + radius;
        float x1 = xCenter + (c * radius);
        float y1 = yCenter + radius;
        float x2 = xCenter + radius;
        float y2 = yCenter + (c * radius);
        float x3 = xCenter + radius;
        float y3 = yCenter;
        float x4 = xCenter + radius;
        float y4 = yCenter - (c * radius);
        float x5 = xCenter + (c * radius);
        float y5 = yCenter - radius;
        float x6 = xCenter;
        float y6 = yCenter - radius;
        float x7 = xCenter - (c * radius);
        float y7 = yCenter - radius;
        float x8 = xCenter - radius;
        float y8 = yCenter - (c * radius);
        float x9 = xCenter - radius;
        float y9 = yCenter;
        float x10 = xCenter - radius;
        float y10 = yCenter + (c * radius);
        float x11 = xCenter - (c * radius);
        float y11 = yCenter + radius;

        // Move to the starting point
        contentStream.moveTo(x0, y0);

        // Draw the circle in 4 segments using Bézier curves
        contentStream.curveTo(x1, y1, x2, y2, x3, y3);
        contentStream.curveTo(x4, y4, x5, y5, x6, y6);
        contentStream.curveTo(x7, y7, x8, y8, x9, y9);
        contentStream.curveTo(x10, y10, x11, y11, x0, y0);

        // Stroke the path to draw the circle
        contentStream.stroke();
    }
}
