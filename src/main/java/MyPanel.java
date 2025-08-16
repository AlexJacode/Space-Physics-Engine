import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {

    public MyPanel() {
        // Add the MouseListener to the panel
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at X: " + e.getX() + " Y: " + e.getY());
    }

    /*
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    */ 

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyPanel());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
