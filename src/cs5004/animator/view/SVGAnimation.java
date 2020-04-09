package cs5004.animator.view;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import cs5004.animator.model.Animator;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Event;
import cs5004.animator.model.Move;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;
import cs5004.animator.model.ShapeWKey;


/**
 * This class implements the functionality of the NonVisualView interface, extended by the View
 * interface. It has an Animator model with which gets data and outputs an SVG Animation.
 */
public class SVGAnimation implements NonVisualView {
  private Animator a;
  private Appendable app;

  static class TimeComparator implements Comparator<Event> {

    @Override
    public int compare(Event event1, Event event2) {
      return event1.compareTo(event2);
    }

  }


  /**
   * Constructs an SVGAnimation object by taking in an Animator model.
   * @param a an Animator
   */
  public SVGAnimation(Animator a, Appendable app) {
    this.a = a;
    this.app = app;
  }


  @Override
  public void setOutput() throws IOException {
    String toReturn = "<!--the overall svg width is " + a.getScreenWidth() * 1.5 +
            " and height is " + a.getScreenHeight() * 1.5 +
            ". By default anything\ndrawn between (0,0) and (width,height" +
            "will be visible -->\n<svg width=\"" + a.getScreenWidth() * 1.5 + "\" height=\"" +
            a.getScreenHeight() * 1.5 + "\" version=\"1.1\"\n" +
            "     xmlsn=\"http://www.w3.org/2000/svg\">";

    for (ShapeWKey s : a.getOriginals()) {
      if (s.getShape() instanceof Rectangle) {
        toReturn += "\n<!--A " + s.getShape().getColor().toString() + " rectangle named " +
                s.getKey() + " with lower left corner " + s.getShape().getAxis().toString() +
                ", width " + s.getShape().getH() + " and height " + s.getShape().getV() +
                " -->\n<rect id =\"" + s.getKey() + "\" x =\"" + s.getShape().getAxis().getX() +
                "\" y=\"" + s.getShape().getAxis().getY() + "\" width=\"" + s.getShape().getH() +
                "\" height =\"" + s.getShape().getV() + "\" fill=\"rgb" +
                s.getShape().getColor().toString() + "\" visibility=\"visible\" >\n";

        List<Event> eventList = this.a.getEvents();
        eventList.sort(new TimeComparator());
        for (Event e : eventList) {
          if (e.getS().getKey().equals(s.getKey())) {
            if (e instanceof Move) {
              if (((Move) e).getNewP().getX() != ((Move) e).getOldP().getX()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" +
                        50 * Math.round((float) e.getStart()) + "ms\" dur=\"" +
                        50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" attributeName=\"x\" from=\"" + ((Move) e).getOldP().getX() +
                        "\" to=\"" + ((Move) e).getNewP().getX() + "\" fill=\"freeze\" />\n";
              }
              if ((((Move) e).getNewP().getY() != ((Move) e).getOldP().getY())) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" +
                        50 * Math.round((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\"" +
                        " attributeName=\"y\" from=\"" + ((Move) e).getOldP().getY() +
                        "\" to=\"" + ((Move) e).getNewP().getY() + "\" fill=\"freeze\" />\n";
              }
            } else if (e instanceof Scale) {
              if (((Scale) e).getStartHeight() != ((Scale) e).getEndHeight()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" +
                        50 * Math.round((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart())
                        + "ms\" " +
                        "attributeName=\"height\" from=\"" + ((Scale) e).getStartHeight() +
                        "\" to=\"" + ((Scale) e).getStartHeight() + "\" fill=\"freeze\" />\n";
              }
              if (((Scale) e).getStartWidth() != ((Scale) e).getEndWidth()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" +
                        50 * Math.round((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" attributeName=\"width\" from=\"" + ((Scale) e).getStartWidth() +
                        "\" to=\"" + ((Scale) e).getStartWidth() + "\" fill=\"freeze\" />\n";
              }
            } else if (e instanceof ChangeColor) {
              if (((ChangeColor) e).getNewC().toString() != ((ChangeColor) e)
                      .getOldC().toString()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" +
                        50 * Math.round((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" " +
                        "attributeName=\"fill\" from=\"rgb" +
                        ((ChangeColor) e).getOldC().toString() +
                        "\" to=\"rgb" + ((ChangeColor) e).getNewC().toString() +
                        "\" fill=\"freeze\" />\n";
              }
            }
          }
        }
        toReturn += "</rect>\n";
      } else if (s.getShape() instanceof Oval) {
        toReturn += "<!--An " + s.getShape().getColor().toString() + " ellipse named "
                + s.getKey() + " with center at " + s.getShape().getAxis().toString() +
                ", x-radius " + s.getShape().getH() + " and y-radius " + s.getShape().getV() +
                " -->\n<ellipse id =\"" + s.getKey() + "\" cx=\"" +
                s.getShape().getAxis().getX() + "\" cy=\"" + s.getShape().getAxis().getY() +
                "\" rx=\"" + s.getShape().getH() + "\" ry=\"" + s.getShape().getV() +
                "\" fill=\"rgb" + s.getShape().getColor().toString() +
                "\" visibility=\"visible\" >\n";

        List<Event> eventList = this.a.getEvents();
        eventList.sort(new TimeComparator());

        for (Event e : eventList) {
          if (e.getS().getKey().equals(s.getKey())) {
            if (e instanceof Move) {
              if (((Move) e).getNewP().getX() != ((Move) e).getOldP().getX()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" + 50 *
                        ((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" " +
                        "attributeName=\"cx\" from=\"" + ((Move) e).getOldP().getX() +
                        "\" to=\"" + ((Move) e).getNewP().getX() + "\" fill=\"freeze\" />\n";
              }
              if (((Move) e).getNewP().getY() != ((Move) e).getOldP().getY()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" + 50 *
                        ((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" " +
                        "attributeName=\"cy\" from=\"" + ((Move) e).getOldP().getY() +
                        "\" to=\"" + ((Move) e).getNewP().getY() + "\" fill=\"freeze\" />\n";
              }
            } else if (e instanceof Scale) {
              if (((Scale) e).getStartHeight() != ((Scale) e).getEndHeight()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" + 50 *
                        (float) e.getStart() + "ms\" dur=\"" + 50 * Math.round(e.getEnd() -
                        (float) e.getStart()) + "ms\" attributeName=\"ry\" from=\"" +
                        ((Scale) e).getStartHeight() + "\" to=\"" + ((Scale) e).getStartHeight() +
                        "\" fill=\"freeze\" />\n";
              }
              if (((Scale) e).getStartWidth() != ((Scale) e).getEndWidth()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" + 50 *
                        ((float) e.getStart()) + "ms\" dur=\"" + 50 * Math.round(e.getEnd() -
                        (float) e.getStart()) + "ms\" attributeName=\"rx\" from=\"" +
                        ((Scale) e).getStartWidth() + "\" to=\"" + ((Scale) e).getStartWidth() +
                        "\" fill=\"freeze\" />\n";
              }

            } else if (e instanceof ChangeColor) {
              if (((ChangeColor) e).getOldC().toString() !=
                      ((ChangeColor) e).getNewC().toString()) {
                toReturn += "    <animate attributeType=\"xml\" begin=\"" + 50 *
                        ((float) e.getStart()) +
                        "ms\" dur=\"" + 50 * Math.round(e.getEnd() - (float) e.getStart()) +
                        "ms\" attributeName=\"fill\" from=\"rgb" +
                        ((ChangeColor) e).getOldC().toString() +
                        "\" to=\"rgb" + ((ChangeColor) e).getNewC().toString() +
                        "\" fill=\"freeze\" />\n";
              }
            }
          }
        }

        toReturn += "</ellipse>\n";
      }
    }
    toReturn += "\n</svg>";
    this.app.append(toReturn);
  }

  @Override
  public Appendable getAppendable() {
    return this.app;
  }




}
