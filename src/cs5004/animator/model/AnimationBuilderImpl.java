package cs5004.animator.model;

/**
 * This class represents the implementation of the AnimationBuilder interface. It creates a new
 * Animator model, sets its bound, adds the appropriate Shapes, and Events.
 */
public class AnimationBuilderImpl implements AnimationBuilder<Animator> {
  private Animator model;

  /**
   * Constructs an AnimationBuilderImpl. Creates a new Animator model in the constructor.
   */
  public AnimationBuilderImpl() {
    this.model = new AnimatorImpl();
  }

  @Override
  public Animator build() {
    // assemble all things
    // iterate over maps, addShape/addTransform
    // return model;
    //System.out.print(this.model.toString());

    //System.out.println(this.model.toString());

    return this.model;
  }

  @Override
  public AnimationBuilder<Animator> setBounds(int x, int y, int width, int height) {
    Point position = new Point(x, y);
    this.model.setBounds(position, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<Animator> declareShape(String name, String type) {
    if (type.equals("rectangle")) {
      this.model.addShape(new Rectangle(), name);
    }
    else if (type.equals("ellipse")) {
      this.model.addShape(new Oval(), name);
    }

    return this;
  }

  @Override
  public AnimationBuilder<Animator> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                                         int r1, int g1, int b1, int t2, int x2, int y2, int w2,
                                         int h2, int r2, int g2, int b2) {
    boolean n = false;
    if (t2 > this.model.getMaxTick()) {
      this.model.setMaxTick(t2);
    }
    ShapeWKey sh = this.model.getShapeWKey(name);
    if (!sh.isSet()) {
      n = true;
    }
    sh.getShape().setValues(new Point(x1, y1), new Color(r1, g1, b1), h1, w1);
    this.model.changeColor(sh, new Color(r2, g2, b2), t1, t2);
    this.model.changePosition(sh, new Point(x2, y2), t1, t2);
    this.model.changeSize(sh, h2, w2, t1, t2);
    sh.getShape().setDisappears(t2);

    if (n) {
      sh.getShape().setAppears(t1);
      Shape newShape = null;

      try {
        newShape = (Shape) sh.getShape().clone();
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
      assert newShape != null;
      newShape.setValues(new Point(x1, y1), new Color(r1, g1, b1), h1, w1);
      ShapeWKey toAdd = new ShapeWKey(newShape, name);
      this.model.addOriginal(toAdd);
    }

    //deal with appears and disappears

    return this;
  }
}
