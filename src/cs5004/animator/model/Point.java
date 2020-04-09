package cs5004.animator.model;

/**
 * Represents a point on a two dimensional plane. Has an x coordinate as a horizontal position and
 * a y coordinate as a vertical position.
 */
public class Point {
  private int x;
  private int y;

  /**
   * Creates a point object.
   * @param x the value of the x coordinate.
   * @param y the value of the y coordinate.
   * @throws IllegalArgumentException if the x or y value is negative
   */
  public Point(int x , int y) throws IllegalArgumentException {
    /*if (x < 0 || y < 0) {
      throw new IllegalArgumentException("X and Y cannot be negative.");
    }*/
    this.x = x;
    this.y = y;
  }

  /**
   * Returns a int representing the x coordinate value.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Returns a int representing the y coordinate value.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Returns the Point as a String in the form "(x, y)".
   */
  public String toString() {
    return ("(" + this.x + ", " + this.y + ")");
  }
}
