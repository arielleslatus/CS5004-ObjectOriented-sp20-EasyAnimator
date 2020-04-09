package cs5004.animator.view;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import cs5004.animator.model.Animator;
import cs5004.animator.model.Event;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ShapeWKey;

/**
 * This class implements the functionality of the NonVisualView interface, extended by the View
 * interface. It has an Animator model with which gets data and outputs a textual description
 * of an Animation.
 */
public class TextDescription implements NonVisualView {
  private Animator animator;
  private Appendable app;

  static class TimeComparator implements Comparator<Event> {

    @Override
    public int compare(Event event1, Event event2) {
      return event1.compareTo(event2);
    }

  }

  /**
   * Constructs a TextDescription object by taking in an Animator model.
   * @param a an Animator
   */
  public TextDescription(Animator a, Appendable app) {
    this.animator = a;
    this.app = app;
  }

  @Override
  public void setOutput() throws IOException {
    String toReturn = "Shapes: \n";
    for (ShapeWKey s : this.animator.getShapes()) {
      String toAdd = "";
      toAdd += "Name: " + s.getKey() + "\nType: ";
      if (s.getShape() instanceof Rectangle) {
        toAdd += "rectangle\nMin corner: " + s.getShape().getAxis().toString() +
                ", Width: " + s.getShape().getH() + ", Height: " +
                s.getShape().getV() + ", Color: " + s.getShape().getColor().toString() + "\n";
      }
      if (s.getShape() instanceof Oval) {
        toAdd += "oval\nCenter: " + s.getShape().getAxis().toString() +
                ", X radius: " + s.getShape().getH() + ", Y radius: " + s.getShape().getV() +
                ", Color: " + s.getShape().getColor().toString() + "\n";
      }
      toAdd += "Appears at t=" + s.getShape().getAppears() + "\nDisappears at t=" +
              s.getShape().getDisappears() + "\n\n";
      toReturn += toAdd;
    }
    List<Event> eventList = this.animator.getEvents();
    eventList.sort(new TimeComparator());
    for (Event e : eventList) {
      toReturn += e.toString() + "\n";
    }

    this.app.append(toReturn);

  }

  @Override
  public Appendable getAppendable() {
    return this.app;
  }


}

