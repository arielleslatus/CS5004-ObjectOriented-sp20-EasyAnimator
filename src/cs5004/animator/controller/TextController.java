package cs5004.animator.controller;

import java.io.IOException;
import java.io.PrintStream;

import cs5004.animator.view.NonVisualView;

/**
 * The TextController implements the AnimationController for the TextDescription view and
 * SVGAnimation view.
 */
public class TextController implements AnimationController {

  /**
   * Constructs a TextController, which creates a PrintStream that writes to an Appendable.
   * @param view a NonVisualView
   * @throws IOException if an error occurs while appending to the appendable
   */
  public TextController(NonVisualView view) throws IOException {
    PrintStream console = System.out;
    System.setOut((PrintStream) view.getAppendable());
    view.setOutput();
    System.out.println(view.getAppendable());
    System.setOut(console);
    System.out.println(view.getAppendable());
  }
}
