package cs5004.animator.view;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;

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
  private JButton saveTXT;
  private JButton saveSVG;

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

    this.saveTXT = new JButton("Save to TXT");
    this.saveTXT.setActionCommand("Save to TXT");
    remotePanel.add(this.saveTXT);

    this.saveSVG = new JButton("Save to SVG");
    this.saveSVG.setActionCommand("Save to SVG");
    remotePanel.add(this.saveSVG);

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
    this.saveTXT.addActionListener(listener);
    this.saveSVG.addActionListener(listener);
  }

  @Override
  public VisualView getVisualView() {
    return this.vis;
  }

  @Override
  public void addShape(String name, String type) {
    this.vis.addShape(name, type);
  }

  @Override
  public void removeShape(String name) {
    this.vis.removeShape(name);
  }

  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                        int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.vis.addMotion(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
  }

  @Override
  public void saveTXT(String output) throws IOException {
    this.vis.saveTXT(output);
  }

  @Override
  public void saveSVG(String output) throws IOException {
    this.vis.saveSVG(output);
  }


}
