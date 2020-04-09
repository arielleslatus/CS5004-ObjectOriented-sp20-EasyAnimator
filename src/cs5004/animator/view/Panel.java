package cs5004.animator.view;


import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import cs5004.animator.model.Animator;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

/**
 * A Panel extends JPanel and represents the main window in which an Animation is illustrated.
 * It takes an Animator model as its parameter and gets its List of Shapes to decipher what
 * needs to be displayed on it.
 */
public class Panel extends JPanel {
  private List<Shape> listOfShapes;

  /**
   * Constructs a Panel by taking in an Animator model object.
   * @param a an Animator
   */
  public Panel(Animator a) {
    super();
  }


  /**
   * Updates the current frame's list of Shapes.
   * @param listOfShapes a list of shapes
   */
  public void setCurrentFrame(List<Shape> listOfShapes) {
    this.listOfShapes = listOfShapes;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if ((this.listOfShapes != null) && !this.listOfShapes.isEmpty()) {
      for (Shape s : this.listOfShapes) {
        if (s instanceof Rectangle) {
          g.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
          g.fillRect(s.getAxis().getX(), s.getAxis().getY(), s.getH(), s.getV());
        }
        else if (s instanceof Oval) {
          g.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
          g.fillOval(s.getAxis().getX(), s.getAxis().getY(), s.getH(), s.getV());

        }
      }
    }
  }



}
