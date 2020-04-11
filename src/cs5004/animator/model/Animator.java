package cs5004.animator.model;

import java.util.List;

import java.util.NoSuchElementException;

/**
 * Animator interface.
 */
public interface Animator {

  /**
   * Takes ints as the proposed width and height of the screen,
   * and an int representing the total duration of time that the animation takes.
   * @param position a Point
   * @param width a int
   * @param height a int
   * @throws IllegalArgumentException if the screen's proposed width or height are less than or
   *     equal to zero
   */
  void setBounds(Point position, int width, int height);

  /**
   * Adds a Shape object to the Animator.
   * @param s a Shape
   * @param key a String representation of the Shape
   * @throws IllegalArgumentException if the position of the shape is outside the bounds of the
   *     Animator's screen, if the key is null or empty, if the key already exists, or if the
   *     shape is null
   */
  void addShape(Shape s, String key) throws IllegalArgumentException;

  /**
   * Removes a Shape object from the Animator.
   * @param id a String representation of a Shape
   * @throws IllegalArgumentException if String passed in is empty or null
   * @throws NoSuchElementException if the element attempting to be removed does not exist
   */
  void removeShape(String id) throws IllegalArgumentException, NoSuchElementException;

  /**
   * Returns the ShapeWKey object associated with the input String.
   * @param id a String representation of s Shape
   * @return a ShapeWKey
   * @throws IllegalArgumentException if String passed in is empty or null
   * @throws NoSuchElementException if the Shape attempting to be retrieved does not exist
   */
  ShapeWKey getShapeWKey(String id) throws IllegalArgumentException, NoSuchElementException;


  /**
   * Changes the Color of a Shape.
   * @param s a ShapeWKey
   * @param newColor a Color
   * @param start an int
   * @param end an int
   * @throws IllegalArgumentException if s is null, newColor is null, or start or end
   *     have invalid values
   */
  void changeColor(ShapeWKey s, Color newColor, int start, int end);


  /**
   * Changes the size of a Shape.
   * @param s a ShapeWKey
   * @param newV a int
   * @param newH a int
   * @param start an int
   * @param end an int
   * @throws IllegalArgumentException if s is null, or start or end have invalid values
   */
  void changeSize(ShapeWKey s, int newV, int newH,
                         int start, int end);


  /**
   * Changes the position of a Shape.
   * @param s a ShapeWKey
   * @param axis a Point
   * @param start an int
   * @param end an int
   * @throws IllegalArgumentException if s is null, axis is null, or start or end have invalid
   *     values
   */
 void changePosition(ShapeWKey s, Point axis, int start, int end);

  /**
   * Sets the background as a Rectangle with the same dimensions of the screen, of the desired
   * Color.
   * @param c a Color
   * @throws IllegalArgumentException if c is null
   */
 void setBackground(Color c);

  /**
   * Returns the width of the Animator's screen.
   * @return a int
   */
  int getScreenWidth();

  /**
   * Returns the height of the Animator's screen.
   * @return a int
   */
  int getScreenHeight();


  void addOriginal(ShapeWKey s);

  List<ShapeWKey> getOriginals();

  /**
   * Returns a List of ShapeWKey objects that are currently represented on the Animator's screen.
   * @return an ArrayList
   */
  List<ShapeWKey> getShapes();

  /**
   * Returns the total number of ShapeWKey objects at a given moment in time.
   * @return an ArrayList
   */
  List<Shape> getShapesAtTick(int currentTick);

  /**
   * Returns a text description of the Animation.
   * @return a String
   */
  String toString();

  List<Event> getEvents();

  Point getPosition();

  int getMaxTick();

  void setMaxTick(int tick);

}
