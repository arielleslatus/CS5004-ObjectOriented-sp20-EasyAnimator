package cs5004.animator.model;

/**
 * Represents an AbstractShape object. The AbstractShape will have a Color, an axis Point, a
 * vertical dimension, a horizontal dimension, a layer in which it lies on the screen, an
 * appearing time, and a disappearing time.
 */
public class AbstractShape implements Shape, Cloneable {
  private Color color;
  private Point axis;
  private int height;
  private int width;
  private int appears;
  private int disappears;

  /**
   * Constructs an AbstractShape.
   */
  public AbstractShape() throws IllegalArgumentException {
    // Constructs an empty Shape without parameters
  }


  @Override
  public void setValues(Point p, Color c, int height, int width) {
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Invalid parameter.");
    }
    this.axis = p;
    this.color = c;
    this.height = height;
    this.width = width;
  }

  public void setAppearsDisappears(int appears, int disappears) {
    this.appears = appears;
    this.disappears = disappears;
  }

  @Override
  public void changeColor(Color newColor) throws IllegalArgumentException {
    this.color = newColor;
  }

  @Override
  public void changeSize(int height, int width) throws IllegalArgumentException {
    /*if (newV <= 0 || newH <= 0) {
      throw new IllegalArgumentException("New dimensions must be positive.");
    }*/
    this.height = height;
    this.width = width;
  }

  @Override
  public void changePosition(Point newAxis) {
    this.axis = newAxis;
  }

  @Override
  public Point getAxis() {
    return this.axis;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public int getV() {
    return this.height;
  }

  @Override
  public int getH() {
    return this.width;
  }

  public void setAppears(int a) {
    this.appears = a;
  }

  public void setDisappears(int d) {
    this.disappears = d;
  }

  public int getAppears() {
    return this.appears;
  }

  public int getDisappears() {
    return this.disappears;
  }

  public Shape clone() throws CloneNotSupportedException {
    return (Shape) super.clone();
  }
}
