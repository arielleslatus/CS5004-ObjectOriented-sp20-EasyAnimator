package cs5004.animator.view;

import java.awt.event.ActionListener;

public interface EditorView extends View {

  void setButtonListeners(ActionListener listener);

/*  void start();

  void pause();

  void resume();

  void restart();

  void enableLooping();

  void disableLooping();

  void increaseSpeed();

  void decreaseSpeed();*/

  VisualView getVisualView();
}
