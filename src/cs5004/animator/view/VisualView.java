package cs5004.animator.view;

import java.awt.event.ActionListener;
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


}
