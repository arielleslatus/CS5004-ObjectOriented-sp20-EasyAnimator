package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import cs5004.animator.model.Animator;
import cs5004.animator.model.Shape;


/**
 * This class implements the functionality of the VisualView interface, extended byt the View
 * interface. It has a Panel with which it sets the size and layout of the frame.
 */
public class VisualAnimation extends JFrame implements VisualView {
  private Panel p;

  /**
   * Constructs a VisualAnimation object by taking in an Animator model as a parameter. The size
   * and layout of the JFrame are set up in the constructor using a Panel.
   * @param model an Animator
   */
  public VisualAnimation(Animator model) {

    this.setTitle("Animator");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.p = new Panel(model);
    this.p.setPreferredSize(new Dimension(900, 900));
    this.add(p, BorderLayout.CENTER);
    JScrollPane scroll = new JScrollPane(this.p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scroll, BorderLayout.CENTER);
    //this.setVisible(true);
    pack();
  }


  @Override
  public void setFrame(List<Shape> shapeList) {
    this.p.setCurrentFrame(shapeList);
  }

  @Override
  public void refresh() {
    p.repaint();
  }

  @Override
  public Panel getPanel() {
    return this.p;
  }


}


