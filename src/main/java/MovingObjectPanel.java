import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class MovingObjectPanel extends JPanel {
    private MovingObject object;

    public MovingObjectPanel(MovingObject object) {
        this.object = object;
        setPreferredSize(new java.awt.Dimension(600, 400));  // Set preferred size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int)object.getX(), (int)object.getY(), 20, 20);  // Draw the object as a red circle
    }

    public void update() {
        repaint();
    }
}
