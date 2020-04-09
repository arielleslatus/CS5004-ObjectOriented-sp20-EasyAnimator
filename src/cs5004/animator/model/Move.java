package cs5004.animator.model;

/**
 * Represents the Event in which a Shape Moves from one position on the screen to another.
 */
public class Move extends AbstractEvent {
  private Point oldP;
  private Point newP;

  /**
   * Constructs a Move Event. Parses the Event's associated ShapeWKey, the time at which the Shape
   * starts to move, the time at which the Shape stops moving, the axis at which the Shape is
   * originally positioned at, and the axis at which the Shape will land at.
   * @param s a ShapeWKey
   * @param start an int
   * @param end an int
   * @param oldP a Point
   * @param newP a Point
   */
  public Move(ShapeWKey s, int start, int end, Point oldP, Point newP) {
    super(s, start, end);
    this.oldP = oldP;
    this.newP = newP;
  }

  /**
   * Returns a String summary of the Move Event.
   * @return a String
   */
  public String toString() {
    return "Shape " + super.getS().getKey() + " moves from: " + this.oldP.toString() +
            " to " + this.newP.toString() + " from t=" + super.getStart() +
            " to t=" + super.getEnd();
  }

  public Point getOldP() {
    return this.oldP;
  }

  public Point getNewP() {
    return this.newP;
  }
}
