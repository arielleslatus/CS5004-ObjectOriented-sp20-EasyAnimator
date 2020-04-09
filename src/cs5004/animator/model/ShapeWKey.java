package cs5004.animator.model;

/**
 * Wrapper class containing a shape and its corresponding name as a String.
 */
public class ShapeWKey implements Cloneable {
  private Shape sh;
  private String key;

  /**
   * Constructs a ShapeWKey object. Takes a Shape object and a String representation of that
   * particular Shape as parameters.
   * @param sh a Shape
   * @param key a String
   * @throws IllegalArgumentException if sh is null, or key is null or empty
   */
  public ShapeWKey(Shape sh, String key) throws IllegalArgumentException {
    if (sh == null || key == null || key.isEmpty()) {
      throw new IllegalArgumentException("invalid parameters.");
    }
    this.sh = sh;
    this.key = key;
  }

  /**
   * Checks if the shape's values have been set.
   */
  public boolean isSet() {
    return this.sh.getColor() != null || this.sh.getAxis() != null;
  }

  /**
   * Returns the Shape object associated with this ShapeWKey.
   * @return a Shape
   */
  public Shape getShape() {
    return this.sh;
  }

  /**
   * Returns the String representation of a particular Shape's name.
   * @return a String
   */
  public String getKey() {
    return this.key;
  }

  public ShapeWKey clone() throws CloneNotSupportedException {
    ShapeWKey clone = (ShapeWKey) super.clone();
    return clone;
  }
}
