package cs5004.animator.model;

/**
 * Represents an AbstractEvent that signals some change in a Shape's state.
 */
abstract class AbstractEvent implements Event {
  private ShapeWKey s;
  private int start;
  private int end;

  /**
   * Constructs an AbstractEvent. Has an associated ShapeWKey to point to the Shape for which the
   * Event is occurring, as well as a start and end int encompassing the time in which the Event
   * takes place.
   * @param s a ShapeWKey
   * @param start an int
   * @param end an int
   */
  public AbstractEvent(ShapeWKey s, int start, int end) throws IllegalArgumentException,
          IllegalStateException {
    if (start > end) {
      throw new IllegalArgumentException("start must be less than end.");
    }
    this.s = s;
    this.start = start;
    this.end = end;

  }

  @Override
  public int getStart() {
    return this.start;
  }

  @Override
  public int getEnd() {
    return this.end;
  }

  @Override
  public ShapeWKey getS() {
    return this.s;
  }

  @Override
  public int compareTo(Event other) {
    return Integer.compare(this.start, other.getStart());
  }


}
