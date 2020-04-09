package cs5004.animator.view;

public interface EditorView extends View {

  void start();

  void pause();

  void resume();

  void restart();

  void enableLooping();

  void disableLooping();

  void increaseSpeed();

  void decreaseSpeed();

  VisualView getVisualView();
}
