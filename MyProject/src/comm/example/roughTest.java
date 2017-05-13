package comm.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class roughTest {
  JComboBox combo;
  JTextField txt;
  

  public roughTest(){
    String course[] = {"18x18cm (7x7inches)","18x20cm (7x8inches)",};
    JFrame frame = new JFrame("Cost Calculator");
    JPanel panel = new JPanel();
    combo = new JComboBox(course);
    combo.setBackground(Color.white);
    combo.setForeground(Color.black);
    txt = new JTextField(25);
    panel.add(combo);
    panel.add(txt);
    frame.add(panel);
    combo.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent ie){
        String str = (String)combo.getSelectedItem();
        txt.setText(str);
      }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,200);
    frame.setVisible(true);
  }
  public static void main(String[] args) {
	    roughTest b = new roughTest();
	  }
 
}