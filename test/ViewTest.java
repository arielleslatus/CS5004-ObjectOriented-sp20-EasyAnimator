import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cs5004.animator.model.AnimationBuilderImpl;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.model.Animator;
import cs5004.animator.view.SVGAnimation;
import cs5004.animator.view.TextDescription;
import cs5004.animator.view.View;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Animator.
 */
public class ViewTest {

  @Test
  public void testTextView4() throws IOException {
    File f = new File("toh-3.txt");
    FileReader fr = new FileReader(f);
    Animator model = AnimationReader.parseFile(fr,  new AnimationBuilderImpl());
    Appendable app = new StringBuffer();
    View v = new TextDescription(model, app);
    ((TextDescription) v).setOutput();
    assertEquals("Shapes: \nName: disk1\nType: rectangle\nMin corner: (490, 180), "
            + "Width: 20, Height: 30, Color: (0, 255, 0)\nAppears at t=1\nDisappears at t=302\n"
            + "\nName: disk2\nType: rectangle\nMin corner: (467, 210), Width: 65, Height: 30, "
            + "Color: (0, 255, 0)\nAppears at t=1\n" +
            "Disappears at t=302\n\nName: disk3\nType: rectangle\nMin corner: (445, 240), Width: "
            + "110, Height: 30, Color: (0, 255, 0)\nAppears at t=1\nDisappears at t=302\n\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=1 to t=1\n"
            + "Shape disk1 moves from: (190, 180) to (190, 180) from t=1 to t=1\n"
            + "Shape disk1 scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=1 "
            + "to t=1\nShape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=1 to "
                    + "t=25\n"
            + "Shape disk1 moves from: (190, 180) to (190, 180) from t=1 to t=25\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=1 to t=25\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=1 to t=1\n"
            + "Shape disk2 moves from: (167, 210) to (167, 210) from t=1 to t=1\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=1 to t=1\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=1 to t=57\n"
            + "Shape disk2 moves from: (167, 210) to (167, 210) from t=1 to t=57\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=1 to t=57\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=1 to t=1\n"
            + "Shape disk3 moves from: (145, 240) to (145, 240) from t=1 to t=1\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=1 to t=1\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=1 to t=121\n"
            + "Shape disk3 moves from: (145, 240) to (145, 240) from t=1 to t=121\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=1 to t=121\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=25 to t=35\n"
            + "Shape disk1 moves from: (190, 180) to (190, 50) from t=25 to t=35\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=25 to t=35\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=35 to t=36\n"
            + "Shape disk1 moves from: (190, 50) to (190, 50) from t=35 to t=36\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=35 to t=36\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=36 to t=46\n"
            + "Shape disk1 moves from: (190, 50) to (490, 50) from t=36 to t=46\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=36 to t=46\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=46 to t=47\n"
            + "Shape disk1 moves from: (490, 50) to (490, 50) from t=46 to t=47\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=46 to t=47\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=47 to t=57\n"
            + "Shape disk1 moves from: (490, 50) to (490, 240) from t=47 to t=57\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=47 to t=57\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=57 to t=89\n"
            + "Shape disk1 moves from: (490, 240) to (490, 240) from t=57 to t=89\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=57 to t=89\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=57 to t=67\n"
            + "Shape disk2 moves from: (167, 210) to (167, 50) from t=57 to t=67\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=57 to t=67\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=67 to t=68\n"
            + "Shape disk2 moves from: (167, 50) to (167, 50) from t=67 to t=68\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=67 to t=68\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=68 to t=78\n"
            + "Shape disk2 moves from: (167, 50) to (317, 50) from t=68 to t=78\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=68 to t=78\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=78 to t=79\n"
            + "Shape disk2 moves from: (317, 50) to (317, 50) from t=78 to t=79\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=78 to t=79\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=79 to t=89\n"
            + "Shape disk2 moves from: (317, 50) to (317, 240) from t=79 to t=89\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=79 to t=89\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=89 to t=99\n"
            + "Shape disk1 moves from: (490, 240) to (490, 50) from t=89 to t=99\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=89 to t=99\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=89 to t=185\n"
            + "Shape disk2 moves from: (317, 240) to (317, 240) from t=89 to t=185\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=89 to t=185\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=99 to t=100\n"
            + "Shape disk1 moves from: (490, 50) to (490, 50) from t=99 to t=100\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=99 to t=100\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=100 to t=110\n"
            + "Shape disk1 moves from: (490, 50) to (340, 50) from t=100 to t=110\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=100 to t=110\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=110 to t=111\n"
            + "Shape disk1 moves from: (340, 50) to (340, 50) from t=110 to t=111\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=110 to t=111\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=111 to t=121\n"
            + "Shape disk1 moves from: (340, 50) to (340, 210) from t=111 to t=121\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=111 to t=121\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=121 to t=153\n"
            + "Shape disk1 moves from: (340, 210) to (340, 210) from t=121 to t=153\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=121 to t=153\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=121 to t=131\n"
            + "Shape disk3 moves from: (145, 240) to (145, 50) from t=121 to t=131\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=121 to t=131\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=131 to t=132\n"
            + "Shape disk3 moves from: (145, 50) to (145, 50) from t=131 to t=132\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=131 to t=132\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=132 to t=142\n"
            + "Shape disk3 moves from: (145, 50) to (445, 50) from t=132 to t=142\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=132 to t=142\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=142 to t=143\n"
            + "Shape disk3 moves from: (445, 50) to (445, 50) from t=142 to t=143\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=142 to t=143\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (11, 45, 175) from t=143 to t=153\n"
            + "Shape disk3 moves from: (445, 50) to (445, 240) from t=143 to t=153\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=143 to t=153\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=153 to t=163\n"
            + "Shape disk1 moves from: (340, 210) to (340, 50) from t=153 to t=163\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=153 to t=163\n"
            + "Shape disk3 changes color from: (11, 45, 175) to (0, 255, 0) from t=153 to t=161\n"
            + "Shape disk3 moves from: (445, 240) to (445, 240) from t=153 to t=161\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=153 to t=161\n"
            + "Shape disk3 changes color from: (0, 255, 0) to (0, 255, 0) from t=161 to t=302\n"
            + "Shape disk3 moves from: (445, 240) to (445, 240) from t=161 to t=302\nShape disk3 "
            + "scales from Width: 110, Height: 30 to Width: 110, Height: 30 from t=161 to t=302\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=163 to t=164\n"
            + "Shape disk1 moves from: (340, 50) to (340, 50) from t=163 to t=164\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=163 to t=164\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=164 to t=174\n"
            + "Shape disk1 moves from: (340, 50) to (190, 50) from t=164 to t=174\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=164 to t=174\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=174 to t=175\n"
            + "Shape disk1 moves from: (190, 50) to (190, 50) from t=174 to t=175\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=174 to t=175\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=175 to t=185\n"
            + "Shape disk1 moves from: (190, 50) to (190, 240) from t=175 to t=185\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=175 to t=185\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=185 to t=217\n"
            + "Shape disk1 moves from: (190, 240) to (190, 240) from t=185 to t=217\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=185 to t=217\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=185 to t=195\n"
            + "Shape disk2 moves from: (317, 240) to (317, 50) from t=185 to t=195\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=185 to t=195\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=195 to t=196\n"
            + "Shape disk2 moves from: (317, 50) to (317, 50) from t=195 to t=196\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=195 to t=196\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=196 to t=206\n"
            + "Shape disk2 moves from: (317, 50) to (467, 50) from t=196 to t=206\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=196 to t=206\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=206 to t=207\n"
            + "Shape disk2 moves from: (467, 50) to (467, 50) from t=206 to t=207\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=206 to t=207\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (6, 247, 41) from t=207 to t=217\n"
            + "Shape disk2 moves from: (467, 50) to (467, 210) from t=207 to t=217\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=207 to t=217\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=217 to t=227\n"
            + "Shape disk1 moves from: (190, 240) to (190, 50) from t=217 to t=227\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=217 to t=227\n"
            + "Shape disk2 changes color from: (6, 247, 41) to (0, 255, 0) from t=217 to t=225\n"
            + "Shape disk2 moves from: (467, 210) to (467, 210) from t=217 to t=225\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=217 to t=225\n"
            + "Shape disk2 changes color from: (0, 255, 0) to (0, 255, 0) from t=225 to t=302\n"
            + "Shape disk2 moves from: (467, 210) to (467, 210) from t=225 to t=302\nShape disk2 "
            + "scales from Width: 65, Height: 30 to Width: 65, Height: 30 from t=225 to t=302\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=227 to t=228\n"
            + "Shape disk1 moves from: (190, 50) to (190, 50) from t=227 to t=228\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=227 to t=228\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=228 to t=238\n"
            + "Shape disk1 moves from: (190, 50) to (490, 50) from t=228 to t=238\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=228 to t=238\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=238 to t=239\n"
            + "Shape disk1 moves from: (490, 50) to (490, 50) from t=238 to t=239\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=238 to t=239\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 49, 90) from t=239 to t=249\n"
            + "Shape disk1 moves from: (490, 50) to (490, 180) from t=239 to t=249\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=239 to t=249\n"
            + "Shape disk1 changes color from: (0, 49, 90) to (0, 255, 0) from t=249 to t=257\n"
            + "Shape disk1 moves from: (490, 180) to (490, 180) from t=249 to t=257\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=249 to t=257\n"
            + "Shape disk1 changes color from: (0, 255, 0) to (0, 255, 0) from t=257 to t=302\n"
            + "Shape disk1 moves from: (490, 180) to (490, 180) from t=257 to t=302\nShape disk1 "
            + "scales from Width: 20, Height: 30 to Width: 20, Height: 30 from t=257 to t=302\n",
            ((TextDescription) v).getAppendable().toString());
  }

  @Test
  public void testTextView5() throws IOException {
    File f = new File("smalldemo.txt");
    FileReader fr = new FileReader(f);
    Animator model = AnimationReader.parseFile(fr,  new AnimationBuilderImpl());
    Appendable app = new StringBuffer();
    View v = new TextDescription(model, app);
    ((TextDescription) v).setOutput();
    assertEquals("Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200, 200), Width: 25, Height: 100, Color: (255, 0, 0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (440, 370), X radius: 120, Y radius: 60, Color: (0, 255, 0)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R changes color from: (255, 0, 0) to (255, 0, 0) from t=1 to t=10\n"
            + "Shape R moves from: (200, 200) to (200, 200) from t=1 to t=10\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 50, Height: 100 from t=1 to "
            + "t=10\n" +
            "Shape C changes color from: (0, 0, 255) to (0, 0, 255) from t=6 to t=20\n"
            + "Shape C moves from: (440, 70) to (440, 70) from t=6 to t=20\n"
            + "Shape C scales from Width: 120, Height: 60 to Width: 120, Height: 60 from t=6 to "
            + "t=20\n"
            + "Shape R changes color from: (255, 0, 0) to (255, 0, 0) from t=10 to t=50\n"
            + "Shape R moves from: (200, 200) to (300, 300) from t=10 to t=50\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 50, Height: 100 from t=10 to "
            + "t=50\n"
            + "Shape C changes color from: (0, 0, 255) to (0, 0, 255) from t=20 to t=50\n"
            + "Shape C moves from: (440, 70) to (440, 250) from t=20 to t=50\n"
            + "Shape C scales from Width: 120, Height: 60 to Width: 120, Height: 60 from t=20 "
            + "to t=50\n"
            + "Shape R changes color from: (255, 0, 0) to (255, 0, 0) from t=50 to t=51\n"
            + "Shape R moves from: (300, 300) to (300, 300) from t=50 to t=51\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 50, Height: 100 from t=50 to "
            + "t=51\n"
            + "Shape C changes color from: (0, 0, 255) to (0, 170, 85) from t=50 to t=70\n"
            + "Shape C moves from: (440, 250) to (440, 370) from t=50 to t=70\n"
            + "Shape C scales from Width: 120, Height: 60 to Width: 120, Height: 60 from t=50 to "
            + "t=70\n"
            + "Shape R changes color from: (255, 0, 0) to (255, 0, 0) from t=51 to t=70\n"
            + "Shape R moves from: (300, 300) to (300, 300) from t=51 to t=70\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 25, Height: 100 from t=51 to "
            + "t=70\n"
            + "Shape R changes color from: (255, 0, 0) to (255, 0, 0) from t=70 to t=100\n"
            + "Shape R moves from: (300, 300) to (200, 200) from t=70 to t=100\n"
            + "Shape R scales from Width: 25, Height: 100 to Width: 25, Height: 100 from t=70 to "
            + "t=100\n"
            + "Shape C changes color from: (0, 170, 85) to (0, 255, 0) from t=70 to t=80\n"
            + "Shape C moves from: (440, 370) to (440, 370) from t=70 to t=80\n"
            + "Shape C scales from Width: 120, Height: 60 to Width: 120, Height: 60 from t=70 to "
            + "t=80\n"
            + "Shape C changes color from: (0, 255, 0) to (0, 255, 0) from t=80 to t=100\n"
            + "Shape C moves from: (440, 370) to (440, 370) from t=80 to t=100\n"
            + "Shape C scales from Width: 120, Height: 60 to Width: 120, Height: 60 from t=80 to "
            + "t=100\n", ((TextDescription) v).getAppendable().toString());
  }




  @Test
  public void testSVGView2() throws IOException {
    File f = new File("toh-3.txt");
    FileReader fr = new FileReader(f);
    Animator model = AnimationReader.parseFile(fr,  new AnimationBuilderImpl());
    Appendable app = new StringBuffer();
    View v = new SVGAnimation(model, app);
    ((SVGAnimation) v).setOutput();
    assertEquals("<!--the overall svg width is 615.0 and height is 330.0By default "
            + "anything\n" +
            "drawn between (0,0) and (width,heightwill be visible -->\n" +
            "<svg width=\"615.0\" height=\"330.0\" version=\"1.1\"\n" +
            "     xmlsn=\"http://www.w3.org/2000/svg\">\n" +
            "<!--A (0, 49, 90) rectangle named disk1 with lower left corner (190, 180), "
            + "width 20 and height 30 -->\n" +
            "<rect id =\"disk1\" x =\"190\" y=\"180\" width=\"20\" height =\"30\" "
            + "fill=\"rgb(0, 49, 90)\" visibility=\"visible\" >\n"
            + "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"0ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"1200ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"1250ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"1250ms\" dur=\"500ms\" "
            + "attributeName=\"y\" from=\"180\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1750ms\" dur=\"50ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1800ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1800ms\" dur=\"500ms\" "
            + "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2300ms\" dur=\"50ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2350ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2350ms\" dur=\"500ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2850ms\" dur=\"1600ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"4450ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"4450ms\" dur=\"500ms\" "
            + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"4950ms\" dur=\"50ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"500ms\" "
            + "attributeName=\"x\" from=\"490\" to=\"340\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5500ms\" dur=\"50ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5550ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5550ms\" dur=\"500ms\" "
            + "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6050ms\" dur=\"1600ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7650ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7650ms\" dur=\"500ms\" "
            + "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8150ms\" dur=\"50ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" "
            + "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8200ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8200ms\" dur=\"500ms\" " +
            "attributeName=\"x\" from=\"340\" to=\"190\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8700ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8750ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8750ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9250ms\" dur=\"1600ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10850ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10850ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11350ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11400ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11400ms\" dur=\"500ms\" " +
            "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11900ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11950ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 49, 90)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11950ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"50\" to=\"180\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"12450ms\" dur=\"400ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"12850ms\" dur=\"2250ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 255, 0)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "</rect>\n" +
            "\n" +
            "<!--A (6, 247, 41) rectangle named disk2 with lower left corner (167, 210), " +
            "width 65 and height 30 -->\n" +
            "<rect id =\"disk2\" x =\"167\" y=\"210\" width=\"65\" height =\"30\" " +
            "fill=\"rgb(6, 247, 41)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"0ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"2800ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2850ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2850ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3350ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3400ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3400ms\" dur=\"500ms\" " +
            "attributeName=\"x\" from=\"167\" to=\"317\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3900ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3950ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3950ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"4450ms\" dur=\"4800ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9250ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9250ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9750ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9800ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"9800ms\" dur=\"500ms\" " +
            "attributeName=\"x\" from=\"317\" to=\"467\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10300ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10350ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(6, 247, 41)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10350ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10850ms\" dur=\"400ms\" " +
            "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"11250ms\" dur=\"3850ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 255, 0)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "</rect>\n" +
            "\n" +
            "<!--A (11, 45, 175) rectangle named disk3 with lower left corner (145, 240), " +
            "width 110 and height 30 -->\n" +
            "<rect id =\"disk3\" x =\"145\" y=\"240\" width=\"110\" height =\"30\" " +
            "fill=\"rgb(11, 45, 175)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"0ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"6000ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6050ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6050ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6550ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6600ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"6600ms\" dur=\"500ms\" " +
            "attributeName=\"x\" from=\"145\" to=\"445\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7100ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7150ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(11, 45, 175)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7150ms\" dur=\"500ms\" " +
            "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7650ms\" dur=\"400ms\" " +
            "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8050ms\" dur=\"7050ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 255, 0)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "</rect>\n" +
            "\n" +
            "</svg>", ((SVGAnimation) v).getAppendable().toString());
  }

  @Test
  public void SVGViewTest3() throws IOException {
    File f = new File("smalldemo.txt");
    FileReader fr = new FileReader(f);
    Animator model = AnimationReader.parseFile(fr,  new AnimationBuilderImpl());
    Appendable app = new StringBuffer();
    View v = new SVGAnimation(model, app);
    ((SVGAnimation) v).setOutput();
    assertEquals("<!--the overall svg width is 540.0 and height is 540.0By default " +
            "anything\n" +
            "drawn between (0,0) and (width,heightwill be visible -->\n" +
            "<svg width=\"540.0\" height=\"540.0\" version=\"1.1\"\n" +
            "     xmlsn=\"http://www.w3.org/2000/svg\">\n" +
            "<!--A (255, 0, 0) rectangle named R with lower left corner (200, 200), width 50 " +
            "and height 100 -->\n" +
            "<rect id =\"R\" x =\"200\" y=\"200\" width=\"50\" height =\"100\" fill=\"rgb(255, " +
            "0, 0)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"50ms\" dur=\"450ms\" " +
            "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(255, 0, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(255, 0, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2500ms\" dur=\"50ms\" " +
            "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(255, 0, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2550ms\" dur=\"950ms\" " +
            "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(255, 0, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2550ms\" dur=\"950ms\" " +
            "attributeName=\"width\" from=\"50\" to=\"50\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\" " +
            "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(255, 0, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\" " +
            "attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\" " +
            "attributeName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<!--An (0, 0, 255) ellipse named C with center at (440, 70), x-radius " +
            "120 and y-radius 60 -->\n" +
            "<ellipse id =\"C\" cx=\"440\" cy=\"70\" rx=\"120\" ry=\"60\" " +
            "fill=\"rgb(0, 0, 255)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"300.0ms\" dur=\"700ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 0, 255)\" to=\"rgb(0, 0, 255)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"1500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 0, 255)\" to=\"rgb(0, 0, 255)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000.0ms\" dur=\"1500ms\" " +
            "attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2500.0ms\" dur=\"1000ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 0, 255)\" to=\"rgb(0, 170, 85)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2500.0ms\" dur=\"1000ms\" " +
            "attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500.0ms\" dur=\"500ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 170, 85)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"4000.0ms\" dur=\"1000ms\" " +
            "attributeName=\"fill\" from=\"rgb(0, 255, 0)\" to=\"rgb(0, 255, 0)\" " +
            "fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>", ((SVGAnimation) v).getAppendable().toString());
  }





}
