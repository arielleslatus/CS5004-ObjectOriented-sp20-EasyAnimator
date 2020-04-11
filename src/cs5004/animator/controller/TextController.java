package cs5004.animator.controller;

import java.io.IOException;
import java.io.PrintStream;

import cs5004.animator.view.NonVisualView;


public class TextController implements AnimationController {


  public TextController(NonVisualView view) throws IOException {
    PrintStream console = System.out;
    System.setOut((PrintStream) view.getAppendable());
    view.setOutput();
    System.out.println(view.getAppendable());
    System.setOut(console);
    System.out.println(view.getAppendable());
  }
}
