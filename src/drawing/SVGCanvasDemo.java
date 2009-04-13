package drawing;
import org.apache.batik.swing.svg.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Event.*;

public class SVGCanvasDemo {

  JSVGCanvas svgCanvas = new JSVGCanvas();

  public static void main(String args[]) {
    JFrame frame = new JFrame("JSVGCanvas Demo");
    frame.setSize(400, 400);

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev) {
        System.exit(0);
      }
    });

    new SVGCanvasDemo(frame);
  }

  public SVGCanvasDemo(JFrame frame) {
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", svgCanvas);
    frame.setVisible(true);
    svgCanvas.setURI("file:/c:/files/hungryminds/rectangles.svg");
  }
}