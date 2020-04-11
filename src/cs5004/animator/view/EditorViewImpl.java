package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;

import cs5004.animator.model.Animator;

public class EditorViewImpl extends JFrame implements EditorView, ActionListener {
  private VisualView vis;
  private Panel mainPanel;
  private JButton start;
  private JButton pause;
  private JButton resume;
  private JButton restart;
  private JButton incSpeed;
  private JButton decSpeed;
  private JButton enableLoop;
  private JButton disableLoop;

  public EditorViewImpl(VisualView vis) {

    this.vis = vis;
    this.mainPanel = vis.getPanel();
    this.mainPanel.setLayout(new BorderLayout());



    JPanel remotePanel = new JPanel();
    remotePanel.setPreferredSize(new Dimension(this.mainPanel.getWidth(), 40));
    remotePanel.setBackground(new Color(255, 255, 255));
    this.start = new JButton("Start");
    this.start.setActionCommand("Start");
    //this.start.addActionListener(this);
    remotePanel.add(this.start);

    this.pause = new JButton("Pause");
    this.pause.setActionCommand("Pause");
    //this.pause.addActionListener(this);
    remotePanel.add(this.pause);

    this.resume = new JButton("Resume");
    this.resume.setActionCommand("Resume");
    //this.resume.addActionListener(this);
    remotePanel.add(this.resume);

    this.restart = new JButton("Restart");
    this.restart.setActionCommand("Restart");
    //this.restart.addActionListener(this);
    remotePanel.add(this.restart);

    this.incSpeed = new JButton("Increase Speed");
    this.incSpeed.setActionCommand("Increase Speed");
    //this.incSpeed.addActionListener(this);
    remotePanel.add(this.incSpeed);

    this.decSpeed = new JButton("Decrease Speed");
    this.decSpeed.setActionCommand("Decrease Speed");
    //this.decSpeed.addActionListener(this);
    remotePanel.add(this.decSpeed);

    this.enableLoop = new JButton( "Enable Looping");
    this.enableLoop.setActionCommand("Enable Looping");
    //this.enableLoop.addActionListener(this);
    remotePanel.add(this.enableLoop);

    this.disableLoop = new JButton( "Disable Looping");
    this.disableLoop.setActionCommand("Disable Looping");
    //this.disableLoop.addActionListener(this);
    remotePanel.add(this.disableLoop);

    /*GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.SOUTH;
    constraints.anchor = GridBagConstraints.SOUTH;*/

    //constraints2.fill = GridBagConstraints.BOTH;
    //constraints2.weightx = 0;
    //constraints2.weighty = 0;
    //this.mainPanel.add(Box.createGlue(), constraints2);

    //this.mainPanel.add(remotePanel, constraints);
    //this.add(remotePanel, constraints);

    this.mainPanel.add(remotePanel, BorderLayout.BEFORE_FIRST_LINE);;

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

  @Override
  public void actionPerformed(ActionEvent actionEvent) {

  }
}
