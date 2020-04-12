package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.*;

import cs5004.animator.model.Animator;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;

/**
 * The VisualController implements the AnimationController for the VisualAnimation view. It also
 * implements ActionListener and creates a Timer to continually increase the value for currentTick
 * until it reaches the maxTicks.
 */
public class VisualController implements ActionListener, AnimationController {
  private int currentTick;
  private VisualView view;
  private Animator model;
  private Timer time;

  /**
   * Constructs a VisualController object by taking in a VisualView and Animator object. The
   * VisualView's beginning tick is set to 0.
   * @param view a VisualView
   * @param model an Animator
   */
  public VisualController(Animator model, VisualView view, int anim_speed) {
    this.currentTick = 0;
    this.view = view;
    this.model = model;
    view.setFrame(model.getShapesAtTick(0));
    this.time = new Timer((int) (500.0 / anim_speed), this);
    time.start();
  }

  /**
   * Upon receiving an ActionEvent, this method tells the VisualView to set up the Shapes
   * required for the current frame, and repaint the image. Then it increases the current
   * ticks by one.
   * @param e an ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (currentTick == model.getMaxTick()) {
      time.stop();
      return;
    }
    view.setFrame(model.getShapesAtTick(currentTick));
    view.refresh();
    currentTick++;
  }

  /**
   * Returns the View.
   * @return a View
   */
  public View getV() {
    return this.view;
  }

  /**
   * Returns the Animator.
   * @return an Animator
   */
  public Animator getA() {
    return this.model;
  }
}
