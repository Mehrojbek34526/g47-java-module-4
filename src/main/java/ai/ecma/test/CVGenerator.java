package ai.ecma.test;

/**
 * Created by: Mehrojbek
 * DateTime: 12/09/24 10:51
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CVGenerator {

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

        // Create a BufferedImage
        BufferedImage cvImage = new BufferedImage(800, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = cvImage.createGraphics();

        // Set Background Color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, cvImage.getWidth(), cvImage.getHeight());

        // Load and draw the logo
        try {
            BufferedImage logo = ImageIO.read(new File(logoPath));
            g2d.drawImage(logo, 650, 10, 100, 100, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Draw personal information
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString(name, 50, 50);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.drawString("Address: " + address, 50, 80);
        g2d.drawString("Phone: " + phone, 50, 110);
        g2d.drawString("Email: " + email, 50, 140);

        // Draw education and work experience
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("Education", 50, 200);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.drawString(education, 50, 230);

        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("Work Experience", 50, 320);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.drawString(workExperience, 50, 350);

        // Clean up
        g2d.dispose();

        // Save the image
        try {
            ImageIO.write(cvImage, "PNG", new File("CV.png"));
            System.out.println("CV image created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

