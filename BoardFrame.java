

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;

import javax.swing.JFrame;

public class BoardFrame extends JFrame {
    Component component;
    public BoardFrame() throws IOException
    {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");
        this.setResizable(false);
        component = new Board();
        this.add(component, BorderLayout.CENTER);
        
        this.setLocation(700, 50);
        this.pack();
        this.setVisible(true);
    }
}
