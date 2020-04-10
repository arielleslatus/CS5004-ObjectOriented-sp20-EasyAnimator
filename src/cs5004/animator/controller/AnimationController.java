package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cs5004.animator.model.Animator;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;

public class AnimationController implements ActionListener {
  private Animator model;
  private VisualView view;
  int currentTick;

  public AnimationController(Animator model, VisualView view) {
    this.model = model;
    this.view = view;
    this.currentTick = 0;
    view.setFrame(model.getShapesAtTick(0));
  }

  protected void setCurrentTick(int newTick) {
    this.currentTick = newTick;
  }

  /**
   * Determines if the Animation has ended.
   * @return an int
   */
  protected int end()  {
    if (model.getShapesAtTick(currentTick).isEmpty()) {
      return 1;
    }
    else {
      return 0;
    }
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
      ((Timer) e.getSource()).stop();
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
