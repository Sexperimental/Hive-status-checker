package util.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiUtil {

    public static JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dimension.width - frame.getWidth()) / 2, (dimension.height - frame.getHeight()) / 2);
    }

    public static JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }

    public static JButton createButton(String text, int x, int y, int width, int height, ActionListener action) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(action);
        return button;
    }
}
