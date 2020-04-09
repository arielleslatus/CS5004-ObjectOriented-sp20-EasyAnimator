package cs5004.animator.model;

/**
 * Represents the Event in which a Shape changes Color.
 */
public class ChangeColor extends AbstractEvent {
  private Color oldC;
  private Color newC;

  /**
   * Constructs a ChangeColor object. Parses the Event's associated ShapeWKey, the time at which the
   * Shape starts to change color, the time at which the Shape has finished changing color, the
   * original Color of the Shape, and the Color that the Shape will change to.
   * @param s a ShapeWKey
   * @param start an int
   * @param end an int
   * @param oldC a Color
   * @param newC a Color
   */
  public ChangeColor(ShapeWKey s, int start, int end, Color oldC, Color newC) {
    super(s, start, end);
    this.oldC = oldC;
    this.newC = newC;
  }

  /**
   * Returns a String summary of the ChangeColor Event.
   * @return a String
   */
  public String toString() {
    return "Shape " + super.getS().getKey() + " changes color from: " + this.oldC.toString() +
           " to " + this.newC.toString() + " from t=" + super.getStart() +
            " to t=" + super.getEnd();
  }

  public Color getOldC() {
    return this.oldC;
  }

  public Color getNewC() {
    return this.newC;
  }
}
