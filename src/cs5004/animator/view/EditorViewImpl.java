package cs5004.animator.view;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * The EditorViewImpl class implements the functionality of the EditorView interface, extended by
 * the View interface. It takes a VisualView as a parameter, adds a JPanel to the existing Panel
 * and JButtons to that panel. ActionListeners are added to the JButtons.
 */
public class EditorViewImpl extends JFrame implements EditorView {
  private VisualView vis;
  private JButton start;
  private JButton pause;
  private JButton resume;
  private JButton restart;
  private JButton incSpeed;
  private JButton decSpeed;
  private JButton enableLoop;
  private JButton disableLoop;

  /**
   * Constructs an EditorViewImpl by taking a VisualView as a parameter and adding interactive
   * functionality to it.
   * @param vis a VisualView
   */
  public EditorViewImpl(VisualView vis) {
    this.vis = vis;
    Panel mainPanel = vis.getPanel();
    mainPanel.setLayout(new BorderLayout());

    JPanel remotePanel = new JPanel();
    remotePanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 40));
    remotePanel.setBackground(new Color(255, 255, 255));
    this.start = new JButton("Start");
    this.start.setActionCommand("Start");
    remotePanel.add(this.start);

    this.pause = new JButton("Pause");
    this.pause.setActionCommand("Pause");
    remotePanel.add(this.pause);

    this.resume = new JButton("Resume");
    this.resume.setActionCommand("Resume");
    remotePanel.add(this.resume);

    this.restart = new JButton("Restart");
    this.restart.setActionCommand("Restart");
    remotePanel.add(this.restart);

    this.incSpeed = new JButton("Increase Speed");
    this.incSpeed.setActionCommand("Increase Speed");
    remotePanel.add(this.incSpeed);

    this.decSpeed = new JButton("Decrease Speed");
    this.decSpeed.setActionCommand("Decrease Speed");
    remotePanel.add(this.decSpeed);

    this.enableLoop = new JButton( "Enable Looping");
    this.enableLoop.setActionCommand("Enable Looping");
    remotePanel.add(this.enableLoop);

    this.disableLoop = new JButton( "Disable Looping");
    this.disableLoop.setActionCommand("Disable Looping");
    remotePanel.add(this.disableLoop);

    mainPanel.add(remotePanel, BorderLayout.BEFORE_FIRST_LINE);;

  }

  @Override
  public void setButtonListeners(ActionListener listener) {
    this.start.addActionListener(listener);
    this.pause.addActionListener(listener);
    this.restart.addActionListener(listener);
    this.resume.addActionListener(listener);
    this.incSpeed.addActionListener(listener);
    this.decSpeed.addActionListener(listener);
    this.enableLoop.addActionListener(listener);
    this.disableLoop.addActionListener(listener);
  }

  @Override
  public VisualView getVisualView() {
    return this.vis;
  }



}
