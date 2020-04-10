package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import cs5004.animator.model.Animator;

/**
 * The TickActionListener is a class that scans for actions performed and signals that an
 * ActionEvent has occurred. In this Animator, a tick increase constitutes an ActionEvent.
 * For each tick increase, the TickActionListener tells the view to set its frame to the
 * current lineup of Shapes, to refresh the image on the GUI, and then increments the current
 * ticks by 1.
 */
public class TickActionListener implements ActionListener {
  private int currentTick;
  private VisualView v;
  private Animator a;

  /**
   * Constructs a TickActionListener object by taking in a VisualView and Animator object. The
   * VisualView's beginning tick is set to 0.
   * @param v a VisualView
   * @param a an Animator
   */
  public TickActionListener(VisualView v, Animator a) {
    this.currentTick = 0;
    this.v = v;
    this.a = a;
    v.setFrame(a.getShapesAtTick(0));
  }

  protected void setCurrentTick(int newTick) {
    this.currentTick = newTick;
  }

  /**
   * Determines if the Animation has ended.
   * @return an int
   */
  protected int end()  {
    if (a.getShapesAtTick(currentTick).isEmpty()) {
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
    if (currentTick == a.getMaxTick()) {
      ((Timer) e.getSource()).stop();
      return;
    }
    v.setFrame(a.getShapesAtTick(currentTick));
    v.refresh();
    currentTick++;
  }

  /**
   * Returns the View.
   * @return a View
   */
  public View getV() {
    return this.v;
  }

  /**
   * Returns the Animator.
   * @return an Animator
   */
  public Animator getA() {
    return this.a;
  }
}