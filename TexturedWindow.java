import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TexturedWindow extends JPanel {

    private BufferedImage grassTexture;

    public TexturedWindow() {
        try {
            // Загружаем текстуру (трава)
            grassTexture = ImageIO.read(getClass().getResource("grass_texture.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (grassTexture != null) {
            int textureWidth = grassTexture.getWidth();
            int textureHeight = grassTexture.getHeight();

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Повторяем текстуру, чтобы заполнить окно
            for (int x = 0; x < panelWidth; x += textureWidth) {
                for (int y = 0; y < panelHeight; y += textureHeight) {
                    g.drawImage(grassTexture, x, y, null);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Текстурное окно");
        TexturedWindow texturedWindow = new TexturedWindow();
        frame.add(texturedWindow);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
