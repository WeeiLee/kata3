package software.ulpgc.kata3.dirty;

import software.ulpgc.kata3.clean.view.BarchartDisplay;
import software.ulpgc.kata3.clean.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private BarchartDisplay barchartDisplay;
    private final Map<String, Command> commands;

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Movies");
        this.setLocationRelativeTo(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLayout(new BorderLayout());
        this.add(menu(), BorderLayout.NORTH);
        this.add(barChartDisplay());
        this.commands = new HashMap<>();
    }

    public void put(String key, Command value){commands.put(key,value);}
    public BarchartDisplay getBarchartDisplay(){return barchartDisplay;}
    private JPanel barChartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    private JPanel menu() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(toggle());
        return panel;
    }

    private JButton toggle() {
        JButton toggle = new JButton("toggle");
        toggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("toggle").execute();
            }
        });
        return toggle;
    }
}
