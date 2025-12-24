import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BrownianMotion {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Brownian Motion Simulator alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SimulationPanel panel = new SimulationPanel(); 
        frame.add(panel); 
        
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

// Combine everything into ONE class
class SimulationPanel extends JPanel implements ActionListener {
    private int x, y, dx, dy;
    
    public SimulationPanel() {
        this.setBackground(Color.WHITE); // From your first version
        x = 400;
        y = 400;
        dx = 5;
        dy = 5; // Added dy for diagonal movement
        
        Timer timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Update position
        x += dx;
        y += dy;

        // 2. Check for Wall Collisions (The "Bounce")
        // If x hits the right edge (800) or left edge (0)
        if (x + 30 > getWidth() || x < 0) {
            dx = -dx; // Reverse horizontal direction
        }

        // If y hits the bottom edge (800) or top edge (0)
        if (y + 30 > getHeight() || y < 0) {
            dy = -dy; // Reverse vertical direction
        }

        // 3. Tell Java to redraw the ball in the new spot
        repaint();
    }
}
