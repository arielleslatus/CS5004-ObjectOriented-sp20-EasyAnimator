  Our Controller is represented by an AnimationController interface. It is implemented for the
EditorView within the EditorController concrete class, which takes a model, VisualView, and
animation speed as parameters. The primary method in the AnimationControllerImpl is
actionPerformed(), which is called anytime an ActionEvent is no longer null. It uses a switch
statement to determine what type of action has occurred based on the ActionCommand. It is
programmed to react appropriately when any of the buttons in the EditorView are pushed.
  The EditorController also scans for increases in the animation's currentTick, which when
initialized begins at zero. It also recognizes when the animation is over by checking if the
currentTick is equal to the maxTick, stored in the model. The controller continually increases the
value of currentTick as the animation plays, halts the tick increases when the animation is paused,
and resets the currentTick to 0 if the animation is restarted or looping is enabled.
  The EditorView interface, implemented by the EditorViewImpl concrete class takes an existing
VisualView as a parameter in its constructor. It adds a thin button panel at the top of the
existing panel in the VisualView. The JButtons on this panel includes Start, Pause, Resume,
Restart, Increase Speed, Decrease Speed, Enable Looping, and Disable Looping. All of these buttons
then are assigned ActionListeners.
  The AnimationController interface is implemented for the VisualAnimation within the
VisualController, which takes a model, VisualView, and animation speed as parameters. The
constructor sets frame and currentTicks to zero and starts the animation. The actionPerformed()
method continually increases the value of currentTick, and when the value of currentTick reaches
the maxTick, this method stops the Timer.
  The TextController is the final concrete class that implements the AnimationController. It does
so for both the TextDescription and the SVGAnimation views. It takes a NonVisualView as a parameter
in the constructor. The constructor creates a PrintStream and writes to the view's appendable.




