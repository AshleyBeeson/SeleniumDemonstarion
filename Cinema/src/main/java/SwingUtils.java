import javax.swing.*;
import java.awt.*;

public class SwingUtils {

    public static JButton createSimpleButton(String text, int... bounds){
        JButton button = new JButton(text);
        button.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        return button;
    }

    public static JTextArea createSimpleTextArea(Color color, int... bounds){
       JTextArea area = new JTextArea();
        area.setVisible(true);
        area.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        area.setBackground(color);
        return area;
    }

    public static JLabel createSimpleLabel(String text, int... bounds){
        JLabel label = new JLabel(text);
        label.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        return label;
    }

}
