

class CelObj extends MovingObject {

  public CelObj(int x, int y, double dx, double dy,double mass, double radius) {
    super(x, y, dx,dy,mass,radius);

  }

  public CelObj(int x, int y, double dx, double dy) {
    super(x, y, dx,dy);

  }


}
/*
 * 
 * class Planet extends CelObj {
 * public Planet(int x,int y, int radius, int mass) {
 * super(x,y,radius,mass);
 * 
 * }
 * public void landing() {
 * /* if () { // if distance between rocket and planet is zero then rocket stops
 * moving
 * 
 * }
 * }
 * }/*
 * 
 * class Star extends CelObj {
 * public Star(int x,int y, int radius, int mass) {
 * super(x,y,radius,mass);
 * 
 * }
 * public void contactElim(Rocket obj) {
 * if (distenceToOtherThing(obj) == 0) { // Refuses To Allow Another Object To
 * Be Compared
 * // Delete/Destroy Rocket Object Here
 * }
 * }
 * }
 */
