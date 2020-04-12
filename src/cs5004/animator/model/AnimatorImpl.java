package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation of the Animator interface.
 */
public class AnimatorImpl implements Animator {
  private int screenWidth;
  private int screenHeight;
  private Point position;
  private List<ShapeWKey> originalShapes;
  private List<ShapeWKey> shapes;
  private List<Event> events;
  private int maxTick;

  /**
   * Constructs an AnimatorImpl.
   */
  public AnimatorImpl() {
    this.shapes = new ArrayList<ShapeWKey>();
    this.events = new ArrayList<Event>();
    this.maxTick = 0;
    this.originalShapes = new ArrayList<ShapeWKey>();
  }

  @Override
  public void setBounds(Point position, int width, int height) {
    this.position = position;
    this.screenWidth = width;
    this.screenHeight = height;
  }

  public void addOriginal(ShapeWKey s) {
    this.originalShapes.add(s);

  }

  @Override
  public List<ShapeWKey> getOriginals() {
    return this.originalShapes;
  }

  @Override
  public void addShape(Shape s, String key) throws IllegalArgumentException {
    if (keyExists(key)) {
      throw new IllegalArgumentException("id already exists.");
    }
    ShapeWKey toReturn = new ShapeWKey(s, key);
    this.shapes.add(toReturn);
  }

  /**
   * Helper method that determines whether a key exists.
   */
  private boolean keyExists(String id) {
    if (!this.shapes.isEmpty()) {
      int i;
      for (i = 0; i < this.shapes.size(); i++) {
        if (this.shapes.get(i).getKey().equals(id)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void removeShape(String id)
          throws IllegalArgumentException, NoSuchElementException {
    if (id == null  || id.isEmpty()) {
      throw new IllegalArgumentException("id can't be null or empty.");
    }
    if (!this.shapes.isEmpty()) {
      int i;
      for (i = 0; i < this.shapes.size(); i++) {
        if (this.shapes.get(i).getKey().equals(id)) {
          this.shapes.remove(i);
          this.events.removeIf(e -> e.getS().getKey().equals(id));
          return;
        }
      }
    }
    throw new NoSuchElementException("shape doesn't exist!");

  }

  @Override
  public ShapeWKey getShapeWKey(String id)
          throws NoSuchElementException, IllegalArgumentException {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("id can't be null or empty.");
    }
    if (!this.shapes.isEmpty()) {
      int i;
      for (i = 0; i < this.shapes.size(); i++) {
        if (this.shapes.get(i).getKey().equals(id)) {
          return this.shapes.get(i);
        }
      }
    }
    throw new NoSuchElementException("shape doesn't exist!");
  }

  @Override
  public void changeColor(ShapeWKey s, Color newColor, int start, int end)
          throws IllegalArgumentException {
    if (s == null || newColor == null) {
      throw new IllegalArgumentException("parameters can't be null.");
    }
    Color oldC = s.getShape().getColor();
    s.getShape().changeColor(newColor);
    this.events.add(new ChangeColor(s, start, end, oldC, newColor));

  }

  @Override
  public void changeSize(ShapeWKey s, int newV, int newH,
                         int start, int end)
          throws IllegalArgumentException {
    if (s == null) {
      throw new IllegalArgumentException("parameters can't be null.");
    }
    int oldV = s.getShape().getV();
    int oldH = s.getShape().getH();
    s.getShape().changeSize(newV, newH);
    this.events.add(new Scale(s, start, end, oldV, oldH,
            newV, newH));
  }

  @Override
  public void changePosition(ShapeWKey s, Point axis, int start, int end)
          throws IllegalArgumentException {
    if (s == null || axis == null) {
      throw new IllegalArgumentException("parameters can't be null.");
    }
    Point oldAxis = s.getShape().getAxis();
    s.getShape().changePosition(axis);
    this.events.add(new Move(s, start, end, oldAxis, axis));
  }

  @Override
  public void setBackground(Color c) {
    if (c == null) {
      throw new IllegalArgumentException("parameters can't be null.");
    }
    Point p = new Point(0, 0);
    Rectangle background = new Rectangle();
    background.setValues(p, c, this.screenHeight, this.screenWidth);
    ShapeWKey toAdd = new ShapeWKey(background, "bg");
    this.shapes.add(toAdd);
  }

  @Override
  public int getScreenWidth() {
    return this.screenWidth;
  }

  @Override
  public int getScreenHeight() {
    return this.screenHeight;
  }

  @Override
  public List<ShapeWKey> getShapes() {
    return this.shapes;
  }

  @Override
  public List<Shape> getShapesAtTick(int currentTick) {

    List<Shape> toReturn = new ArrayList<Shape>();
    for (Event e: this.getEvents()) {
      int start = e.getStart();
      int end = e.getEnd();
      if (currentTick >= start && currentTick <= end) {

        if (e instanceof ChangeColor) {
          Color oldC = ((ChangeColor) e).getOldC();
          Color newC = ((ChangeColor) e).getNewC();
          if (end != start && !oldC.toString().equals(newC.toString())) {
            float newR = (oldC.getR() * ((float)(end - currentTick) / (end - start))) +
                    (newC.getR() * ((float)(currentTick - start) / (end - start)));

            float newG = (oldC.getG() * ((float)(end - currentTick) / (end - start))) +
                    (newC.getG() * ((float)(currentTick - start) / (end - start)));

            float newB = (oldC.getB() * ((float)(end - currentTick) / (end - start))) +
                    (newC.getB() * ((float)(currentTick - start) / (end - start)));
            Color newColor = new Color((int)newR, (int)newG, (int)newB);
            Shape toAdd = e.getS().getShape();
            toAdd.changeColor(newColor);
            toReturn.add(toAdd);
          }

          else {
            Shape toAdd = e.getS().getShape();
            toAdd.changeColor(newC);
            toReturn.add(toAdd);
          }

        }

        else if (e instanceof Move) {
          Point oldP = ((Move) e).getOldP();
          Point newP = ((Move) e).getNewP();
          if (newP.toString().equals(oldP.toString())) {
            Shape toAdd = e.getS().getShape();
            toAdd.changePosition(newP);
            toReturn.add(toAdd);
          }

          else if (end != start) {
            float newX = (oldP.getX() * ((float)(end - currentTick) / (end - start))) +
                    (newP.getX() * ((float)(currentTick - start) / (end - start)));

            float newY = (oldP.getY() *
                    ((float)(end - currentTick) / (end - start))) + ((float)newP.getY() *
                    ((float)(currentTick - start) /
                    (end - start)));

            Point newPoint = new Point((int)newX, (int)newY);
            Shape toAdd = e.getS().getShape();
            toAdd.changePosition(newPoint);
            toReturn.add(toAdd);
          }
          else {
            Shape toAdd = e.getS().getShape();
            toAdd.changePosition(newP);
            toReturn.add(toAdd);
          }
        }

        else if (e instanceof Scale) {
          int oldHeight = ((Scale) e).getStartHeight();
          int oldWidth = ((Scale) e).getStartWidth();
          int newHeight = ((Scale) e).getEndHeight();
          int newWidth = ((Scale) e).getEndWidth();

          if (oldHeight == newHeight && oldWidth == newWidth) {
            Shape toAdd = e.getS().getShape();
            toAdd.changeSize(newHeight, newWidth);
            toReturn.add(toAdd);
          }
          else if (end != start) {
            float currentHeight = (oldHeight * ((float)(end - currentTick) / (end - start))) +
                    (newHeight * ((float)(currentTick - start) / (end - start)));
            float currentWidth = (oldWidth * ((float)(end - currentTick) / (end - start))) +
                    (newWidth * ((float)(currentTick - start) / (end - start)));
            Shape toAdd = e.getS().getShape();
            toAdd.changeSize((int)currentHeight, (int)currentWidth);
            toReturn.add(toAdd);
          }
          else {
            Shape toAdd = e.getS().getShape();
            toAdd.changeSize(newHeight, newWidth);
            toReturn.add(toAdd);
          }
        }
      }
    }


    return toReturn;
  }

  @Override
  public List<Event> getEvents() {
    return this.events;
  }

  @Override
  public Point getPosition() {
    return this.position;
  }

  @Override
  public int getMaxTick() {
    return this.maxTick;
  }

  @Override
  public void setMaxTick(int tick) {
    this.maxTick = tick;
  }

  @Override
  public String toString() {
    String toReturn = "Shapes: \n";
    for (ShapeWKey s : this.getShapes()) {
      String toAdd = "";
      toAdd += "Name: " + s.getKey() + "\nType: ";
      if (s.getShape() instanceof Rectangle) {
        toAdd += "rectangle\nMin corner: " + s.getShape().getAxis().toString() +
                ", Width: " + s.getShape().getH() + ", Height: " +
                s.getShape().getV() + ", Color: " + s.getShape().getColor().toString() + "\n";
      }
      if (s.getShape() instanceof Oval) {
        toAdd += "oval\nCenter: " + s.getShape().getAxis().toString() +
                ", X radius: " + s.getShape().getH() + ", Y radius: " + s.getShape().getV() +
                ", Color: " + s.getShape().getColor().toString() + "\n";
      }
      toAdd += "Appears at t=" + s.getShape().getAppears() + "\nDisappears at t=" +
              s.getShape().getDisappears() + "\n\n";
      toReturn += toAdd;
    }

    for (Event e : this.getEvents()) {
      toReturn += e.toString() + "\n";
    }

    return toReturn;

  }
}
