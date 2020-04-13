package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import cs5004.animator.model.Animator;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.View;

/**
 * The EditorController implements the AnimationController for the EditorView. It also
 * implements ActionListener and creates a Timer to continually increase the value for currentTick
 * until it reaches the maxTicks. This class listens for ActionEvents and behaves appropriately
 * when buttons on the view are clicked.
 */
public class EditorController implements ActionListener, AnimationController {
  private Animator model;
  private EditorView view;
  int currentTick;
  Timer time;
  int speed;
  boolean looping;

  /**
   * Constructs an EditorController by taking a model, view, and speed as parameters. It
   * initializes looping to false and the currentTick to zero.
   * @param model an Animator
   * @param view an EditorView
   * @param anim_speed an int
   */
  public EditorController(Animator model, EditorView view, int anim_speed) {
    this.model = model;
    this.view = view;
    this.currentTick = 0;
    this.speed = anim_speed;
    this.time = new Timer((int) (500.0 / this.speed), this);
    this.view.getVisualView().setFrame(model.getShapesAtTick(0));
    this.view.setButtonListeners(this);
    this.looping = false;
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
          if (this.currentTick == 0) {
            this.time.start();
          }
          else {
            return;
          }
          break;
        case "Restart":
          this.currentTick = 0;
          this.view.getVisualView().setFrame(this.model.getShapesAtTick(0));
          this.time.start();
          break;
        case "Pause":
          this.time.stop();
          break;
        case "Resume":
          if (this.currentTick > 0) {
            this.view.getVisualView().setFrame(this.model.getShapesAtTick(this.currentTick));
            this.time.start();
          }
          break;
        case "Increase Speed":
          this.time.stop();
          this.speed += 10;
          this.time = new Timer((int) (500.0 / this.speed), this);
          this.time.start();
          break;

        case "Decrease Speed":
          this.time.stop();;
          if (this.speed > 10) {
            this.speed -= 10;
          }
          else  {
            JOptionPane.showMessageDialog(null,
                    "Could not decrease speed.", "Error", JOptionPane.ERROR_MESSAGE);
          }
          this.time = new Timer((int) (500.0 / this.speed), this);
          this.time.start();
          break;

        case "Enable Looping":
          this.looping = true;
          break;

        case "Disable Looping":
          this.looping = false;
          break;

        case "Save to TXT":
          try {
            this.view.saveTXT("Animator.txt");
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          break;

        case "Save to SVG":
          try {
            this.view.saveSVG("Animator.svg");
          } catch (IOException ex) {
            ex.printStackTrace();
          }

      }
    }

    if (this.currentTick == this.model.getMaxTick()) {
      if (this.looping) {
        if (this.currentTick == this.model.getMaxTick()) {
          this.currentTick = 0;
          this.view.getVisualView().setFrame(this.model.getShapesAtTick(0));
          this.time.start();
        }
      } else {
        ((Timer) e.getSource()).stop();
        return;
      }
    }
    this.view.getVisualView().setFrame(this.model.getShapesAtTick(this.currentTick));
    this.view.getVisualView().refresh();
    this.currentTick++;
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
