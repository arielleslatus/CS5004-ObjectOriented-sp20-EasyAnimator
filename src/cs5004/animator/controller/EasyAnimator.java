package cs5004.animator.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;
import cs5004.animator.model.AnimationBuilderImpl;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.model.Animator;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.EditorViewImpl;
import cs5004.animator.view.NonVisualView;
import cs5004.animator.view.SVGAnimation;
import cs5004.animator.view.TextDescription;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualAnimation;
import cs5004.animator.view.VisualView;

/**
 * Interprets the terminal commands, creates a model, and view to pass into a controller.
 */
public final class EasyAnimator {

  /**
   * The driver for the Animator program.
   * @param args a String[]
   * @throws IOException if improper input is received
   */
  public static void main(String[] args) throws IOException {
    boolean in = false;
    boolean view = false;
    boolean speed = false;
    String in_file = null;
    String out_file = null;
    String view_type = "text";
    String[] commands = {"-in", "-view", "-out", "-speed"};
    String[] view_types = {"text", "visual", "svg", "playback"};
    int anim_speed = 1;
    if (args.length <= 1) {
      JOptionPane.showMessageDialog(null, "Invalid input.",
              "Error", JOptionPane.ERROR_MESSAGE);
    }
    for (String a: args) {
      String[] split = a.split("\\s+");
      if (split[0].equals(commands[0])) {
        in = true;
        in_file = split[1];
      }
      else if (split[0].equals(commands[1])) {
        view = true;
        boolean valid = false;
        for (String v: view_types) {
          if (split[1].equals(v)) {
            view_type = v;
            valid = true;
            break;
          }
        }
        if (!valid) {
          JOptionPane.showMessageDialog(null, "Invalid view type.",
                  "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
      else if (split[0].equals(commands[2])) {
        out_file = split[1];
      }
      else if (split[0].equals(commands[3])) {
         speed = true;
        int s = Integer.parseInt(split[1]);
        if (s <= 0) {
          JOptionPane.showMessageDialog(null, "Invalid speed.",
                  "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
          anim_speed = s;
        }
      }
      else {
        JOptionPane.showMessageDialog(null, "Invalid argument.",
                "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    if (!in || !view) {
      JOptionPane.showMessageDialog(null, "Invalid arguments.",
              "Error", JOptionPane.ERROR_MESSAGE);
    }
    assert in_file != null;
    File f = new File(in_file);
    FileReader fr = new FileReader(f);
    Animator model = AnimationReader.parseFile(fr,  new AnimationBuilderImpl());
    View v;
    switch (view_type) {
      case "text": {
        assert out_file != null;
        Appendable app = new PrintStream(out_file);
        v = new TextDescription(model, app);
        AnimationController controller = new TextController((NonVisualView) v);
        break;
      }
      case "visual": {
        v = new VisualAnimation(model);
        ((VisualView) v).addShape("square", "rectangle");
        ((VisualView) v).addMotion("square", 1, 0, 0, 100, 100,
                250, 0, 0, model.getMaxTick(), 900, 900, 10,
                10, 250, 0, 0);
        /*((VisualView) v).saveTXT("test123.txt");*/
        ((VisualView) v).saveSVG("test321.svg");
        AnimationController controller =
                new VisualController(model, (VisualView) v, anim_speed);
        break;
      }
      case "playback": {
        v = new EditorViewImpl(new VisualAnimation(model));
        ((EditorView) v).addShape("square", "rectangle");
        ((EditorView) v).addMotion("square", 1, 0, 0, 100, 100,
                250, 0, 0, model.getMaxTick(), 900, 900, 10,
                10, 250, 0, 0);
        AnimationController controller =
                new EditorController(model,
                        (EditorViewImpl) v, anim_speed);
        break;
      }
      case "svg": {
        assert out_file != null;
        Appendable app = new PrintStream(out_file);
        v = new SVGAnimation(model, app);
        AnimationController controller = new TextController((NonVisualView) v);
        break;
      }
      default:
        throw new IllegalArgumentException("Unexpected value: " + view_type);
    }

  }
}
