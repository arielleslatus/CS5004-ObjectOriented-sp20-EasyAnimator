package cs5004.animator.view;

import java.io.IOException;

/**
 * The NonVisualView interface represents the possible functionality for the the non visual output
 * types of an Animation. It is an extension of the View interface.
 */
public interface NonVisualView extends View {

  /**
   * Populates the textual output for the appropriate file type.
   */
  void setOutput() throws IOException;

  Appendable getAppendable();

}
