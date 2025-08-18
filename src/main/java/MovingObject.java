
public class MovingObject {

    double x, y;

    public double mass = 10;
    public double radius = 10;

    public double  collisionCoeffect=0.5;

    public double dx;
    public double dy;

    public double ddx;
    public double ddy;

    public MovingObject(double x, double y, double dx, double dy,double mass,double  radius) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.mass=mass;
        this.radius=radius;
        }
    public MovingObject(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        }
    
    

    public void resetAcceleration() {
        ddx = 0;
        ddy = 0;
    }

    public void updatePos() {
        dx += ddx;
        dy += ddy;

        x += dx;
        y += dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void calcForceWithObj(MovingObject obj) {
        double distance = Math.sqrt(Math.pow((obj.x - x), 2) + Math.pow((obj.y - y), 2));

        if (distance != 0) {
            double factor = 0.008 * (obj.mass * mass) / Math.pow(distance, 2);

            ddx += factor * (obj.x - x) / (distance*mass);
            ddy += factor * (obj.y - y) / (distance*mass);
            // ((obj.x - x)/distance)=xcomponet of force
            obj.ddx -= factor * (obj.x - x) / (distance*obj.mass);
            obj.ddy -= factor * (obj.y - y) / (distance*obj.mass);
            // -=, Isaac's 3ed law
        }
    }
    public returnVect calcCollison(MovingObject obj) {
        double distance = Math.sqrt(Math.pow((obj.x - x), 2) + Math.pow((obj.y - y), 2));
        
        if (radius + obj.radius >= distance && distance != 0) {

            double collisionAngle = Math.atan2((obj.y - y), (obj.x - x)); 
            
            double velocityAngle = Math.atan2((obj.dy - dy), (obj.dx - dx)); 
            
            double angleDifference = velocityAngle - collisionAngle;

            double relVelo = Math.sqrt(Math.pow((obj.dy - dy), 2) + Math.pow((obj.dx - dx), 2));
            
            double normalComponentScaler = Math.cos(angleDifference) * relVelo;
            double tangentialComponentScaler = Math.sin(angleDifference) * relVelo;


            double normalUnitVectX=Math.cos(collisionAngle);
            double normalUnitVectY=Math.sin(collisionAngle);

            double tangentialUnitVectX=Math.cos(collisionAngle+Math.PI);
            double tangentialUnitVectY=Math.sin(collisionAngle+Math.PI);
            
            
            //normalComponentScaler *= -1;

            double dxNew = normalComponentScaler * normalUnitVectX + tangentialComponentScaler * tangentialUnitVectX;
            
            double dyNew = normalComponentScaler * normalUnitVectY + tangentialComponentScaler * tangentialUnitVectY;

            
            
            return new returnVect(dxNew*collisionCoeffect, dyNew*collisionCoeffect);
        } else {
            return null;
        }
    }
}
