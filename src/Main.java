import com.formdev.flatlaf.FlatDarkLaf;
import controll.Panel;
import util.model.GuiUtil;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatDarkLaf.setup();
            JFrame frame = createMainFrame();
            Panel.initialize(frame);
        });
    }

    private static JFrame createMainFrame() {
        JFrame frame = new JFrame();
        frame.setSize(750, 605);
        frame.setLayout(null);
        frame.setTitle("Hive status checker");
        frame.setResizable(false);
        GuiUtil.centerWindow(frame);
        frame.setVisible(true);
        return frame;
    }
}
