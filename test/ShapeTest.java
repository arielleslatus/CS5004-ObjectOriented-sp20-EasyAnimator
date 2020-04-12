import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Color;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point;
import cs5004.animator.model.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * Junit test suite for the Shape class.
 */
public class ShapeTest {
  private Rectangle redRec;
  private Oval blueOval;
  private Point p1;
  private Point p2;
  private Point p3;
  private Point p4;
  private Point p5;
  private Color red;

  /**
   * Initializes a red rectangle at (10, 10) with a height of 5, and width of 10,
   * on layer 1, and a blue oval at (5, 20) with a vertical radius of 8 and a horizontal
   * radius of 4, on layer 1.
   */
  @Before
  public void setUp() {
    p1 = new Point(10, 10);
    p2 = new Point(5, 20);
    p3 = new Point(5, 10);
    p4 = new Point(10, 5);
    p5 = new Point(10, 20);


    redRec = new Rectangle();
    blueOval = new Oval();
    red = new Color(1, 0, 0);

  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorNegRed() {
    Color c = new Color(-2, 0, 1);

  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorNegBlue() {
    Color c = new Color(0, -2, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorNegGreen() {
    Color c = new Color(1, 0, -2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorOver1Red() {
    Color c = new Color(10, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorOver1Blue() {
    Color c = new Color(0, 200, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakeColorOver1Green() {
    Color c = new Color(0, 0, 12);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakePointNegX() {
    Point p = new Point(-5, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMakePointNegY() {
    Point p = new Point(10, -5);
  }

  @Test
  public void testGetAxisRec() {
    Point axis = redRec.getAxis();
    assertEquals("(10.0, 10.0)", axis.toString());
  }

  @Test
  public void testGetAxisOval() {
    Point axis = blueOval.getAxis();
    assertEquals("(5.0, 20.0)", axis.toString());
  }

  @Test
  public void testGetColorRec() {
    Color c = redRec.getColor();
    assertEquals("(1.0), (0.0), (0.0)", c.toString());
  }

  @Test
  public void testGetColorOval() {
    Color c = blueOval.getColor();
    assertEquals("(0.0), (1.0), (0.0)", c.toString());
  }

  @Test
  public void testGetVRec() {
    assertEquals(5, redRec.getV(), 0.01);
  }

  @Test
  public void testGetHRec() {
    assertEquals(10, redRec.getH(), 0.01);
  }

  @Test
  public void testGetVOval() {
    assertEquals(8, blueOval.getV(), 0.01);
  }

  @Test
  public void testGetHOval() {
    assertEquals(4, blueOval.getH(), 0.01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRecInvalidHeight() {
    Rectangle test = new Rectangle();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRecInvalidWidth() {
    Rectangle test = new Rectangle();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRecInvalidLayer() {
    Rectangle test = new Rectangle();
  }

  @Test
  public void testChangeColorRec() {
    assertEquals("(1.0), (0.0), (0.0)", redRec.getColor().toString());
    Color green = new Color(0, 0, 1);
    redRec.changeColor(green);
    assertEquals("(0.0), (0.0), (1.0)", redRec.getColor().toString());

  }

  @Test
  public void testChangeColorOval() {
    assertEquals("(0.0), (1.0), (0.0)", blueOval.getColor().toString());
    Color red = new Color(1, 0, 0);
    blueOval.changeColor(red);
    assertEquals("(1.0), (0.0), (0.0)", blueOval.getColor().toString());

  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorSameColor() {
    Color red = new Color(1, 0, 0);
    redRec.changeColor(red);
  }

  @Test
  public void testChangeWidthRec() {
    assertEquals(5, redRec.getV(), 0.01);
    assertEquals(10, redRec.getH(), 0.01);
    redRec.changeSize(5, 7);
    assertEquals(7, redRec.getH(), 0.01);
    assertEquals(5, redRec.getV(), 0.01);
  }

  @Test
  public void testChangeHeightRec() {
    assertEquals(5, redRec.getV(), 0.01);
    assertEquals(10, redRec.getH(), 0.01);
    redRec.changeSize(8, 10);
    assertEquals(10, redRec.getH(), 0.01);
    assertEquals(8, redRec.getV(), 0.01);
  }

  @Test
  public void testChangeWidthAndHeightRec() {
    assertEquals(5, redRec.getV(), 0.01);
    assertEquals(10, redRec.getH(), 0.01);
    redRec.changeSize(12, 9);
    assertEquals(9, redRec.getH(), 0.01);
    assertEquals(12, redRec.getV(), 0.01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeRecNoChange() {
    redRec.changeSize(5, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeNegWidthRec() {
    redRec.changeSize(7, -9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeNegHeightRec() {
    redRec.changeSize(-2, 6);
  }

  @Test
  public void testChangeHRadiusOval() {
    assertEquals(8, blueOval.getV(), 0.01);
    assertEquals(4, blueOval.getH(), 0.01);
    blueOval.changeSize(8, 2);
    assertEquals(2, blueOval.getH(), 0.01);
    assertEquals(8, blueOval.getV(), 0.01);
  }

  @Test
  public void testChangeVRadiusOval() {
    assertEquals(8, blueOval.getV(), 0.01);
    assertEquals(4, blueOval.getH(), 0.01);
    blueOval.changeSize(12, 4);
    assertEquals(4, blueOval.getH(), 0.01);
    assertEquals(12, blueOval.getV(), 0.01);
  }

  @Test
  public void testChangeVAndHRadiusOval() {
    assertEquals(8, blueOval.getV(), 0.01);
    assertEquals(4, blueOval.getH(), 0.01);
    blueOval.changeSize(5, 3);
    assertEquals(3, blueOval.getH(), 0.01);
    assertEquals(5, blueOval.getV(), 0.01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeOvalNoChange() {
    blueOval.changeSize(8, 4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeNegHRadiusOval() {
    blueOval.changeSize(3, -5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeNegVRadiusOval() {
    blueOval.changeSize(-1, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangePositionRecNoChange() {
    redRec.changePosition(p1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangePositionOvalNoChange() {
    blueOval.changePosition(p2);
  }

  @Test
  public void testChangePositionXRec() {
    assertEquals(10, redRec.getAxis().getX(), 0.01);
    assertEquals(10, redRec.getAxis().getY(), 0.01);
    redRec.changePosition(p3);
    assertEquals(5, redRec.getAxis().getX(), 0.01);
    assertEquals(10, redRec.getAxis().getY(), 0.01);
  }

  @Test
  public void testChangePositionYRec() {
    assertEquals(10, redRec.getAxis().getX(), 0.01);
    assertEquals(10, redRec.getAxis().getY(), 0.01);
    redRec.changePosition(p4);
    assertEquals(10, redRec.getAxis().getX(), 0.01);
    assertEquals(5, redRec.getAxis().getY(), 0.01);
  }

  @Test
  public void testChangePositionXAndYRec() {
    assertEquals(10, redRec.getAxis().getX(), 0.01);
    assertEquals(10, redRec.getAxis().getY(), 0.01);
    redRec.changePosition(p2);
    assertEquals(5, redRec.getAxis().getX(), 0.01);
    assertEquals(20, redRec.getAxis().getY(), 0.01);
  }

  @Test
  public void testChangePositionXOval() {
    assertEquals(5, blueOval.getAxis().getX(), 0.01);
    assertEquals(20, blueOval.getAxis().getY(), 0.01);
    blueOval.changePosition(p3);
    assertEquals(5, blueOval.getAxis().getX(), 0.01);
    assertEquals(10, blueOval.getAxis().getY(), 0.01);
  }

  @Test
  public void testChangePositionYOval() {
    assertEquals(5, blueOval.getAxis().getX(), 0.01);
    assertEquals(20, blueOval.getAxis().getY(), 0.01);
    blueOval.changePosition(p5);
    assertEquals(10, blueOval.getAxis().getX(), 0.01);
    assertEquals(20, blueOval.getAxis().getY(), 0.01);
  }

  @Test
  public void testChangePositionXAndYOval() {
    assertEquals(5, blueOval.getAxis().getX(), 0.01);
    assertEquals(20, blueOval.getAxis().getY(), 0.01);
    blueOval.changePosition(p1);
    assertEquals(10, blueOval.getAxis().getX(), 0.01);
    assertEquals(10, blueOval.getAxis().getY(), 0.01);
  }

  @Test
  public void testTopLeftCornerRec() {
    Point lTop = new Point(10, 15);
    Point rTop = new Point(20, 15);
    assertEquals(lTop.getX(), redRec.getTopLeft().getX(), 0.01);
    assertEquals(lTop.getY(), redRec.getTopRight().getY(), 0.01);
  }

  @Test
  public void testTopRightCornerRec() {
    Point rTop = new Point(20, 15);
    assertEquals(rTop.getX(), redRec.getTopRight().getX(), 0.01);
    assertEquals(rTop.getY(), redRec.getTopRight().getY(), 0.01);
  }

  @Test
  public void testBottomRightCornerRec() {
    Point rBot = new Point(20, 10);
    assertEquals(rBot.getX(), redRec.getBottomRight().getX(), 0.01);
    assertEquals(rBot.getY(), redRec.getBottomRight().getY(), 0.01);
  }


}
