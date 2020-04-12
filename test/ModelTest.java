import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import cs5004.animator.model.Animator;
import cs5004.animator.model.AnimatorImpl;
import cs5004.animator.model.Color;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

import static org.junit.Assert.assertEquals;

/**
 * Junit test suite for the Animator class.
 */
public class ModelTest {

  private Animator a;
  private Color blue;
  private Color red;
  private Point p;
  private Shape greenRec;
  private Shape redOval;
  private Shape blueRec1;
  private Shape blueRec2;
  private Shape blueRec3;

  @Before
  public void setUp() {
    a = new AnimatorImpl();
    blue = new Color(0, 1, 0);
    red = new Color(1, 0, 0);
    p = new Point(0, 0);
    greenRec = new Rectangle();
    redOval = new Oval();
    blueRec1 = new Rectangle();
    blueRec2 = new Rectangle();
    blueRec3 = new Rectangle();
  }

  @Test
  public void testToString1() {
    a.addShape(greenRec, "greenRec");
    a.addShape(redOval, "redOval");
    a.addShape(blueRec3, "blueRec");

    a.changeColor(a.getShapeWKey("greenRec"), blue, 10, 15);
    a.changeColor(a.getShapeWKey("redOval"), blue, 5, 8);

    assertEquals("Shapes: \n" +
            "Name: greenRec\n" +
            "Type: rectangle\n" +
            "Min corner: (5.0, 10.0), Width: 20.0, Height: 10.0\n" +
            "Appears at t=0\n" +
            "Disappears at t=10\n" +
            "\n" +
            "Name: redOval\n" +
            "Type: oval\n" +
            "Center: (10.0, 10.0), X radius: 3.0, Y radius: 2.0\n" +
            "Appears at t=0\n" +
            "Disappears at t=10\n" +
            "\n" +
            "Name: blueRec\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0, 0.0), Width: 200.0, Height: 100.0\n" +
            "Appears at t=5\n" +
            "Disappears at t=8\n" +
            "\n" +
            "Shape greenRec changes color from: (0.0), (0.0), (1.0) to (0.0), (1.0), (0.0) " +
            "from t=10 to t=15\n" +
            "Shape redOval changes color from: (1.0), (0.0), (0.0) to (0.0), (1.0), (0.0) " +
            "from t=5 to t=8\n", a.toString());
  }

  @Test
  public void testToString2() {
    a.addShape(greenRec, "greenRec");
    a.addShape(redOval, "redOval");
    a.addShape(blueRec3, "blueRec");

    a.changePosition(a.getShapeWKey("greenRec"), p, 10, 15);
    a.changeSize(a.getShapeWKey("redOval"), 10, 30, 5, 8);

    assertEquals("Shapes: \n" +
            "Name: greenRec\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0, 0.0), Width: 20.0, Height: 10.0\n" +
            "Appears at t=0\n" +
            "Disappears at t=10\n" +
            "\n" +
            "Name: redOval\n" +
            "Type: oval\n" +
            "Center: (10.0, 10.0), X radius: 30.0, Y radius: 10.0\n" +
            "Appears at t=0\n" +
            "Disappears at t=10\n" +
            "\n" +
            "Name: blueRec\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0, 0.0), Width: 200.0, Height: 100.0\n" +
            "Appears at t=5\n" +
            "Disappears at t=8\n" +
            "\n" +
            "Shape greenRec moves from: (5.0, 10.0) to (0.0, 0.0) from t=10 to t=15\n" +
            "Shape redOval scales from Width: 3.0, Height: 2.0 to Width: 10.0, Height:" +
            " 30.0 from t=5 to t=8\n", a.toString());

  }

  @Test
  public void testAddShapeRectangle() {
    a.addShape(greenRec, "greenRec");
    assertEquals(5, a.getShapes().get(0).getShape().getAxis().getX(), 0.01);
    assertEquals(10, a.getShapes().get(0).getShape().getAxis().getY(), 0.01);
    assertEquals(10, a.getShapes().get(0).getShape().getV(), 0.01);
    assertEquals(20, a.getShapes().get(0).getShape().getH(), 0.01);
  }

  @Test
  public void testAddShapeOval() {
    a.addShape(redOval, "redOval");
    assertEquals(10, a.getShapes().get(0).getShape().getAxis().getX(), 0.01);
    assertEquals(10, a.getShapes().get(0).getShape().getAxis().getY(), 0.01);
    assertEquals(2, a.getShapes().get(0).getShape().getV(), 0.01);
    assertEquals(3, a.getShapes().get(0).getShape().getH(), 0.01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeOutOfBoundsRight() {
    a.addShape(blueRec1, "blueRec1");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeOutOfBoundsTop() {
    a.addShape(blueRec2, "blueRec2");
  }

  @Test
  public void testRemoveShape() {
    assertEquals(0, a.getShapes().size());
    a.addShape(greenRec, "greenRec");
    a.addShape(redOval, "redOval");
    assertEquals(2, a.getShapes().size());
  }

  @Test (expected = NoSuchElementException.class)
  public void testRemoveShapeDoesntExist() {
    a.removeShape(greenRec.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeNegStart() {
    a.addShape(greenRec, "greenRec");
    a.changeColor(a.getShapeWKey("greenRec"), blue, -1, 15);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSize0End() {
    a.addShape(greenRec, "greenRec");
    a.changeColor(a.getShapeWKey("greenRec"), blue, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeStartAfterEnd() {
    a.addShape(greenRec, "greenRec");
    a.changeColor(a.getShapeWKey("greenRec"), blue, 100, 100);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeEndAfterEnd() {
    a.addShape(greenRec, "greenRec");
    a.changeColor(a.getShapeWKey("greenRec"), blue, 4, 101);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangePositionNullAxis() {
    Point test = null;
    a.addShape(greenRec, "greenRec");
    a.changePosition(a.getShapeWKey("greenRec"), test, 2, 10);
  }

  @Test
  public void testSetBackground() {
    a.setBackground(blue);
    assertEquals("(0.0), (1.0), (0.0)",
            a.getShapes().get(0).getShape().getColor().toString());
  }
}