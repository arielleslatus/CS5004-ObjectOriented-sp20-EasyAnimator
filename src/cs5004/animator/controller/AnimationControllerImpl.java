package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cs5004.animator.model.Animator;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;

public class AnimationControllerImpl implements ActionListener, AnimationController {
  private Animator model;
  private EditorView view;
  int currentTick;
  Timer time;
  int speed;
  boolean looping;

  public AnimationControllerImpl(Animator model, EditorView view, int anim_speed) {
    this.model = model;
    this.view = view;
    this.currentTick = 0;
    this.speed = anim_speed;
    time = new Timer((int) (500.0 / this.speed), this);
    //time.start();
    this.view.getVisualView().setFrame(model.getShapesAtTick(0));
    this.view.setButtonListeners(this);
    looping = false;
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
    if (e.getActionCommand() != null) {
      switch (e.getActionCommand()) {
        case "Start":
          if (currentTick == 0) {
            time.start();
          }
          break;
        case "Restart":
          this.currentTick = 0;
          view.getVisualView().setFrame(model.getShapesAtTick(0));
          time.start();
          break;
        case "Pause":
          time.stop();
          break;
        case "Resume":
          if (currentTick > 0) {
            view.getVisualView().setFrame(model.getShapesAtTick(currentTick));
            time.start();
          }
          break;
        case "Increase Speed":
          time.stop();
          this.speed *= 2;
          time = new Timer((int) (500.0 / speed), this);
          time.start();
          break;

        case "Decrease Speed":
          time.stop();
          float currSpeed = (float) (this.speed / 2);
          this.speed = (int) currSpeed;
          time = new Timer((int) (500.0 / speed), this);
          time.start();
          break;

        case "Enable Looping":
          looping = true;
          break;

        case "Disable Looping":
          looping = false;
          break;

      }
    }

    if (currentTick == model.getMaxTick()) {
      ((Timer) e.getSource()).stop();
      return;
    }
    view.getVisualView().setFrame(model.getShapesAtTick(currentTick));
    view.getVisualView().refresh();
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
