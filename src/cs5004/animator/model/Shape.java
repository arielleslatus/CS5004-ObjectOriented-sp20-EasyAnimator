package cs5004.animator.model;

/**
 * This Interface represents a Shape object used by the Animator.
 */
public interface Shape extends Cloneable {

  /**
   * Takes in a Point representing the Shape's axis, the proposed
   * Color of the Shape, the Shape's vertical and horizontal dimensions.
   * @param p a Point
   * @param c a Color
   * @param dV a int
   * @param dH a int
   * @throws IllegalArgumentException if either of the proposed vertical or horizontal dimensions
   *     are less than or equal to zero
   */
  void setValues(Point p, Color c, int dV, int dH);

  /**
   * Changes the Color of a Shape.
   * @param newColor a Color
   * @throws IllegalArgumentException if the proposed new Color is the same as the current Color
   */
  void changeColor(Color newColor) throws IllegalArgumentException;

  /**
   * Changes the dimensions of a Shape. If the Shape is a Rectangle, the newV and newH will
   * represent the new vertical height and horizontal width. If the Shape is an Oval, the newV
   * and newH will represent the new vertical radius and horizontal radius.
   * @param newV a int
   * @param newH a int
   * @throws IllegalArgumentException if the new width or height are less than or equal to 0 or
   *     if the new proposed dimensions are exactly the same as the current dimensions
   */
  void changeSize(int newV, int newH) throws IllegalArgumentException;

  /**
   * Changes the position of a Shape. If the Shape is a Rectangle, the axis upon it is positioned
   * will be its bottom left hand corner. If the Shape is an Oval, the axis upon it is positioned
   * will be its center point.
   * @param axis a Point
   * @throws IllegalArgumentException if the new proposed position of the Shape is the same as
   *     the Shape's current position
   */
  void changePosition(Point axis) throws IllegalArgumentException;

  /**
   * Returns the Point on which the Shapes axis lies. If the Shape is a Rectangle, the axis will
   * be its bottom left hand corner. If the Shape is an Oval, the axis will be its center point.
   * @return a Point
   */
  Point getAxis();

  /**
   * Returns the Color of a Shape.
   * @return a Color
   */
  Color getColor();

  /**
   * Returns the vertical dimension for a Shape. If the Shape is a Rectangle, this will be its
   * height. If the Shape is an Oval, this will be its vertical radius.
   * @return a int
   */
  int getV();

  /**
   * Returns the horizontal dimension for a Shape. If the Shape is a Rectangle, this will be its
   * width. If the Shape is an Oval, this will be its horizontal radius.
   * @return a int
   */
  int getH();

  int getAppears();

  int getDisappears();


  void setDisappears(int d);

  void setAppears(int a);

  Shape clone() throws CloneNotSupportedException;


}
