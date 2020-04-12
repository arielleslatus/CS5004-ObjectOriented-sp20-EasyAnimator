package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The EditorView interface represents the possible functionality for the the visual editor output
 * of an Animation. It is an extension of the View interface.
 */
public interface EditorView extends View {

  void setButtonListeners(ActionListener listener);

  VisualView getVisualView();

  void addShape(String name, String type);

  void removeShape(String name);

  void addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                 int r1, int g1, int b1, int t2, int x2, int y2, int w2,
                 int h2, int r2, int g2, int b2);

  void saveTXT(String output) throws IOException;

  void saveSVG(String output) throws IOException;
}
