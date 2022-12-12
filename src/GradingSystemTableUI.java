import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;

public class GradingSystemTableUI extends JFrame {
    private JPanel panel;
    private JLabel image;
    private JButton saveImageAsButton;

    public GradingSystemTableUI() {
        this.setSize((int) (GradingSystemUI.dimension.getWidth() / 2), (int) (GradingSystemUI.dimension.getHeight() / 2));
        this.setContentPane(panel);
        this.setTitle("Grading System Official Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initializeComponents();
    }

    private void initializeComponents() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GradingSystemUI.isGradingSystemTableWindowActive = false;
            }
        });

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

                // In case of actual image size change
                float actualImageSizeWidth = 1545;
                float actualImageSizeHeight = 1470F;
                int imageAndFrameGap = 60;
                String imageFilename = "table.png";

                int componentWidth = (int) e.getComponent().getSize().getWidth();
                int componentHeight = (int) e.getComponent().getSize().getHeight();
                int newImageHeight = (componentHeight - imageAndFrameGap);
                int newImageWidth = (int) ((newImageHeight / (actualImageSizeHeight / actualImageSizeWidth)));
                if (componentWidth <= newImageWidth) {
                    newImageWidth = componentWidth - imageAndFrameGap;
                    newImageHeight = (int) ((newImageWidth * (actualImageSizeHeight / actualImageSizeWidth)));
                    try {
                        image.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imageFilename)))).getImage().getScaledInstance(newImageWidth, newImageHeight, Image.SCALE_SMOOTH)));
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                } else {
                    try {
                        image.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imageFilename)))).getImage().getScaledInstance(newImageWidth, newImageHeight, Image.SCALE_SMOOTH)));
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
        });

        saveImageAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
