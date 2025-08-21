import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;


public class DrawThings extends JComponent {

    private ArrayList<CelObj> objects = new ArrayList<CelObj>();

    private MovingObjectPanel panel;

    public DrawThings() {
        
        //weirdSquare();
        vortex(); 
        //Chaos();
        //Square(); 
        //bigSquare(); 
        //colision();
        //planets();
        //blackHole(); 

        setPreferredSize(new java.awt.Dimension(1300, 550));
    }

    public void Run() {
        Timer timer = new Timer(4, e -> {
            resetObjAccelerations();
            calculateForces();

            calculateApplyColisions();

            updateThings();
            // panel.update();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        // drawRocket(g);
        drawObjects(g);
    }

    public void drawBackground(Graphics g) {
        Image background = Toolkit.getDefaultToolkit().getImage("spacebackground.png");
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void drawObjects(Graphics g) {
        for (CelObj obj : objects) {

            g.setColor(Color.LIGHT_GRAY);
            g.drawOval((int) (obj.getX()) + 100, (int) (obj.getY()) + 100, 2 * (int) obj.radius, 2 * (int) obj.radius);
        } // relative cords
    }

    public void calculateForces() {

        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                objects.get(i).calcForceWithObj(objects.get(j));

            }
        }
    }

    public void resetObjAccelerations() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).resetAcceleration();
        }
    }

    public void updateThings() {

        for (CelObj obj : objects) {
            obj.updatePos();
        }
    }

    public void calculateApplyColisions() {

        returnVect[] newVelos = new returnVect[objects.size()];

        for (int i = 0; i < objects.size(); i++) {
            returnVect vect = new returnVect(objects.get(i).dx, objects.get(i).dy);

            for (int j = 0; j < objects.size(); j++) {
                if (j != i) {
                    returnVect vect2 = objects.get(i).calcCollison(objects.get(j));
                    if (vect2 != null) {
                        vect = vect2;
                        break;
                    }
                }
            }
            newVelos[i] = vect;
        }
        for (int i = 0; i < newVelos.length; i++) {
            objects.get(i).dx = newVelos[i].x;
            objects.get(i).dy = newVelos[i].y;
        }
    }

    public void weirdSquare() {
        objects.add(new CelObj(10, 50, 0, 0.05));
        objects.add(new CelObj(50, 90, 0.05, 0));
        objects.add(new CelObj(90, 50, 0, -0.05));
        objects.add(new CelObj(50, 10, -0.05, 0));
    }
    public void colision() {
        objects.add(new CelObj(50, -100, 0, 0.2));
        objects.add(new CelObj(50, 300, 0, -0.3));
        objects.add(new CelObj(-100, 50, 0.2, 0));
        objects.add(new CelObj(200, 50, -0.3, 0));
    }
        
    public void Square() {

        for(int i=-90;i<200;i+=80){
            for(int j=-90;j<200;j+=80){
             objects.add(new CelObj(i, j, 0, 0));
            }
        }
    }
    public void bigSquare() {

        for(int i=-90;i<200;i+=15){
            for(int j=-90;j<200;j+=15){
             objects.add(new CelObj(i, j, 0, 0,5,5));
            }
        }
    }
    public void Chaos() {

        for(int i=0;i<200;i+=10){
            for(int j=0;j<200;j+=10){
             objects.add(new CelObj(i, j, 0, 0));
            }
        }
    }
    

    public void planets() {
        objects.add(new CelObj(75, 75, 0, 0, 100, 20));

        objects.add(new CelObj(0, 100, 0, -0.1, 5, 5));
        objects.add(new CelObj(75, 190, 0.1, 0, 3, 3));
        objects.add(new CelObj(75, -100, 0.1, 0, 8, 8));

        objects.add(new CelObj(-300000, 75, 40, 0, 80000, 8));

    }

    public void blackHole() {
        objects.add(new CelObj(75, 195, 0, 9, 9999999, 0.0000000000000000001));
    }
    public void vortex() {
        objects.add(new CelObj(70, 70, 0, 0, 24, 600)); 
        objects.add(new CelObj(75, 195, 0, 0, 9999999, 0.0000000000000000001)); 
    }
    public void vortex(int x) {
        int p = 65; 
        for (int i = 0; i < x; i++) {
            objects.add(new CelObj(70, p, 0, 0, 24, 18)); 
            p += 10; 
        } 
        objects.add(new CelObj(75, 195, 0, 0, 999999999, 0.0000000000000000001)); 
    }

} 
