package cs5004.animator.model;

/**
 * Represents an Event that occurs within an Animation. An Event is instantiated when a Shape
 * changes color, moves locations on the screen, or scales its size.
 */
public interface Event {

  /**
   * Returns an int representing the start time of an Event.
   * @return an int
   */
  int getStart();

  /**
   * Returns an int representing the end time of an Event.
   * @return an int
   */
  int getEnd();

  /**
   * Returns the ShapeWKey object associated with an Event.
   * @return a ShapeWKey
   */
  ShapeWKey getS();

  int compareTo(Event other);
}
