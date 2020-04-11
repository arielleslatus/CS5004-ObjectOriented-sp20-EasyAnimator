package cs5004.animator.model;

/**
 * Represents a Rectangle. Has a height and a width. The height and width would be equal to each
 * other to represent a square. The starting Point is at the bottom left corner.
 */
public class Rectangle extends AbstractShape {
  private Point topLeft;
  private Point topRight;
  private Point bottomRight;

  /**
   * Constructs a rectangle.
   * @param point
   * @param color
   * @param i
   * @param i1
   * @param i2
   * @param i3
   * @param i4
   */
  public Rectangle(Point point, Color color, int i, int i1, int i2, int i3, int i4) {
    //Constructs a Rectangle without parameters
  }

  /**
   * Returns the Point at which a Rectangle's top left hand corner is positioned.
   * @return a Point
   */
  public Point getTopLeft() {
    return this.topLeft;
  }

  /**
   * Returns the Point at which a Rectangle's top right hand corner is positioned.
   * @return a Point
   */
  public Point getTopRight() {
    return this.topRight;
  }

  /**
   * Returns the Point at which a Rectangle's bottom right hand corner is positioned.
   * @return a Point
   */
  public Point getBottomRight() {
    return this.bottomRight;
  }

}
