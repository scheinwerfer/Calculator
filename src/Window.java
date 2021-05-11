import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Window extends JFrame {
    private JButton[] buttons = new JButton[15];
    private JLabel display = new JLabel("0", JLabel.RIGHT);
    private final String others = "-0+*/C";

    public Window(String title) {
        super.setTitle("Window");
        this.setSize(250, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font font = new Font("Consolas", Font.PLAIN, 26);

        display.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));
        display.setFont(font);

        JPanel pnlButtons = new JPanel(new GridLayout(5, 3, 15, 15));

        for (int i = 0; i < buttons.length; i++) {
            if (i < 9) {
                buttons[i] = new JButton(String.valueOf(i + 1));
            }
            else {
                buttons[i] = new JButton(String.valueOf(others.charAt(i - 10 + 1)));
            }

            buttons[i].setFont(font);
            buttons[i].addActionListener(this::buttonClick);
            pnlButtons.add(buttons[i]);
        }

        JPanel main = (JPanel)this.getContentPane();
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.setLayout(new BorderLayout(5,5));
        main.add(display, BorderLayout.NORTH);
        main.add(pnlButtons, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void buttonClick(ActionEvent e){
        switch (((JButton)e.getSource()).getText()) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                this.display.setText(this.display.getText() + ((JButton)e.getSource()).getText());
                break;

            default:
                this.display.setText(" ");
                break;
        }
    }

    public static void main(final String[] args) {
        new Window("Calc");
    }
}