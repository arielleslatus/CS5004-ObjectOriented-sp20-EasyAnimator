package cs5004.animator.model;

/**
 * Represents the Event in which a Shape Scales from one size to another.
 */
public class Scale extends AbstractEvent {
  private int startWidth;
  private int startHeight;
  private int endWidth;
  private int endHeight;

  /**
   * Constructs a Scale Event. Parses the Event's associated ShapeWKey, the time at which the Shape
   * starts to change size, the time at which the Shape has finished changing size, the vertical
   * measurement of the Shape to begin with, the horizontal measurement of the Shape to begin with,
   * the vertical measurement of the Shape's new size, and the horizontal measurement of the Shape's
   * new size.
   * @param s a ShapeWKey
   * @param start an int
   * @param end an int
   * @param sHeight a int
   * @param sWidth a int
   * @param eWidth a int
   * @param eHeight a int
   */
  public Scale(ShapeWKey s, int start, int end, int sHeight, int sWidth,
               int eHeight, int eWidth) {
    super(s, start, end);
    this.startWidth = sWidth;
    this.startHeight = sHeight;
    this.endWidth = eWidth;
    this.endHeight = eHeight;
  }

  /**
   * Returns a String summary of the Scale Event.
   * @return a String
   */
  public String toString() {
    return "Shape " + super.getS().getKey() + " scales from Width: " + this.startWidth +
            ", Height: " + this.startHeight + " to Width: " + this.endWidth + ", Height: " +
            this.endHeight + " from t=" + super.getStart() + " to t=" + super.getEnd();
  }

  public int getStartWidth() {
    return this.startWidth;
  }

  public int getStartHeight() {
    return this.startHeight;
  }

  public int getEndWidth() {
    return this.endWidth;
  }

  public int getEndHeight() {
    return this.endHeight;
  }
}
