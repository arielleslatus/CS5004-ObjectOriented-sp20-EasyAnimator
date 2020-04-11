package cs5004.animator.view;

import java.awt.event.ActionListener;

/**
 * The EditorView interface represents the possible functionality for the the visual editor output
 * of an Animation. It is an extension of the View interface.
 */
public interface EditorView extends View {

  void setButtonListeners(ActionListener listener);

  VisualView getVisualView();
}
