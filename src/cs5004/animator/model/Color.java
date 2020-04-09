package cs5004.animator.model;

/**
 * Represents the Color of a Shape.
 */
public class Color {
  private int red;
  private int blue;
  private int green;

  /**
   * Constructs a Color object. Takes as parameters the decimal percent at which the Color should
   * be Red, Blue, and Green according to the RBG color model.
   * @param red an int
   * @param blue an int
   * @param green an int
   * @throws IllegalArgumentException if any of the red, blue, or green values are negative or
   *     greater than 1.
   */
  public Color(int red, int green, int blue) throws IllegalArgumentException {
    if (red < 0 || blue < 0 || green < 0 || red > 255 || blue > 255 || green > 255) {
      throw new IllegalArgumentException("Invalid RGB value.");
    }
    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  /**
   * Returns color as an RGB value in the form "(red), (blue), (green)".
   */
  public String toString() {
    return ("(" + red + ", " + green + ", " + blue + ")");
  }


  /**
   * Returns the red value for this color.
   * @return an int
   */
  public int getR() {
    return this.red;
  }

  /**
   * Returns the blue value for this color.
   * @return an int
   */
  public int getB() {
    return this.blue;
  }

  /**
   * Returns the green value for this color.
   * @return an int
   */
  public int getG() {
    return this.green;
  }

  public String getHex() {
    return String.format("#%02x%02x%02x", this.getR(), this.getG(), this.getB());
  }
}
