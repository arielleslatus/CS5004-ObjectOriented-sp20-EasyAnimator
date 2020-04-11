package cs5004.animator.controller;

import java.io.IOException;
import java.io.PrintStream;

import cs5004.animator.view.NonVisualView;

/**
 * The TextController implements the AnimationController for the TextDescription view and
 * SVGAnimation view.
 */
public class TextController implements AnimationController {
  private Appendable app;

  /**
   * Constructs a TextController, which creates a PrintStream that writes to an Appendable.
   * @param view a NonVisualView
   * @throws IOException if an error occurs while appending to the appendable
   */
  public TextController(NonVisualView view) throws IOException {
    this.app = view.getAppendable();
    PrintStream console = System.out;
    System.setOut((PrintStream) this.app);
    view.setOutput();
    System.out.println(this.app);
    System.setOut(console);
    System.out.println(this.app);
  }

  /**
   * Getter for the view's appendable object
   * @return an Appendable
   */
  public Appendable getApp() {
    return this.app;
  }
}
