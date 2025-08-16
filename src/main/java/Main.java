import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Object");
        
        
        DrawThings drawThings = new DrawThings();

        frame.add(drawThings);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //new Keys();

        
        drawThings.Run();
    }
}
