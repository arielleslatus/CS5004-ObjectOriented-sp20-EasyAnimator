package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import cs5004.animator.model.Shape;

/**
 * The VisualView interface represents the possible functionality for the the GUI visual output
 * of an Animation. It is an extension of the View interface.
 */
public interface VisualView extends View {

  /**
   * Adds all of the appropriate Shapes to the Panel for the given frame.
   * @param shapeList a List of Shapes
   */
  void setFrame(List<Shape> shapeList);

  /**
   * Tells the GUI to repaint its image, now that the frame has been set.
   */
  void refresh();

  /**
   * Gets the Panel object from the view
   * @return a Panel
   */
  Panel getPanel();

  void addShape(String name, String type);

  void removeShape(String name);

  void addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                 int r1, int g1, int b1, int t2, int x2, int y2, int w2,
                 int h2, int r2, int g2, int b2);

  void saveTXT(String output) throws IOException;

  void saveSVG(String output) throws IOException;



}
