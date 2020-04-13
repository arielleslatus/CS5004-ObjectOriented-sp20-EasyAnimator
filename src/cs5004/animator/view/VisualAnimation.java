package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.Animator;
import cs5004.animator.model.Color;
import cs5004.animator.model.Event;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeWKey;


/**
 * This class implements the functionality of the VisualView interface, extended by the View
 * interface. It has a Panel with which it sets the size and layout of the frame.
 */
public class VisualAnimation extends JFrame implements VisualView {
  private Panel p;
  private Animator model;

  /**
   * Constructs a VisualAnimation object by taking in an Animator model as a parameter. The size
   * and layout of the JFrame are set up in the constructor using a Panel.
   * @param model an Animator
   */
  public VisualAnimation(Animator model) {
    this.model = model;
    this.setTitle("Animator");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.p = new Panel(model);
    this.p.setPreferredSize(new Dimension(1200, 900));
    this.add(p, BorderLayout.CENTER);
    JScrollPane scroll = new JScrollPane(this.p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scroll, BorderLayout.CENTER);
    this.setVisible(true);
    pack();
  }


  @Override
  public void setFrame(List<Shape> shapeList) {
    this.p.setCurrentFrame(shapeList);
  }

  @Override
  public void refresh() {
    p.repaint();
  }

  @Override
  public Panel getPanel() {
    return this.p;
  }

  @Override
  public void addShape(String name, String type) {
    if (type.equals("rectangle")) {
      this.model.addShape(new Rectangle(), name);
    }
    else if (type.equals("ellipse")) {
      this.model.addShape(new Oval(), name);
    }
  }

  @Override
  public void removeShape(String name) {
    this.model.removeShape(name);
  }

  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                                              int r1, int g1, int b1, int t2, int x2, int y2,
                                              int w2, int h2, int r2, int g2, int b2) {
    boolean n = false;
    if (t2 > this.model.getMaxTick()) {
      this.model.setMaxTick(t2);
    }
    ShapeWKey sh = this.model.getShapeWKey(name);
    if (!sh.isSet()) {
      n = true;
    }
    sh.getShape().setValues(new Point(x1, y1), new Color(r1, g1, b1), h1, w1);
    this.model.changeColor(sh, new Color(r2, g2, b2), t1, t2);
    this.model.changePosition(sh, new Point(x2, y2), t1, t2);
    this.model.changeSize(sh, h2, w2, t1, t2);
    sh.getShape().setDisappears(t2);

    if (n) {
      sh.getShape().setAppears(t1);
      Shape newShape = null;

      try {
        newShape = (Shape) sh.getShape().clone();
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
      assert newShape != null;
      newShape.setValues(new Point(x1, y1), new Color(r1, g1, b1), h1, w1);
      ShapeWKey toAdd = new ShapeWKey(newShape, name);
      this.model.addOriginal(toAdd);
    }

  }

  @Override
  public void saveTXT(String output) throws IOException {
    Appendable app = new PrintStream(output);
    NonVisualView toOutput = new TextDescription(this.model, app);
    System.setOut((PrintStream) app);
    toOutput.setOutput();
    System.out.println(app);
    /*System.setOut(console);
    System.out.println(app);*/
  }

  @Override
  public void saveSVG(String output) throws IOException {
    Appendable app = new PrintStream(output);
    NonVisualView toOutput = new SVGAnimation(this.model, app);
    System.setOut((PrintStream) app);
    toOutput.setOutput();
    System.out.println(app);
  }


}


