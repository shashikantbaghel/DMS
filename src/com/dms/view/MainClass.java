package com.dms.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.FileOutputStream;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import com.dms.model.TreatmentMasterModel;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class MainClass {

  int inch = Toolkit.getDefaultToolkit().getScreenResolution();

  float pixelToPoint = (float) 72 / (float) inch;

  JTextPane textPane;

  public MainClass() {
    JFrame frame = new JFrame();
    textPane = new JTextPane();
    JScrollPane scrollPane = new JScrollPane(textPane);

    JPanel north = new JPanel();
    JButton print = new JButton("Print");
    print.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
       TreatmentMasterModel masterModel=null;
    	  paintToPDF(textPane,masterModel);
      }
    });
    JMenuBar menu = new JMenuBar();
    JMenu styleMenu = new JMenu();
    styleMenu.setText("Style");

    Action boldAction = new BoldAction();
    boldAction.putValue(Action.NAME, "Bold");
    styleMenu.add(boldAction);

    Action italicAction = new ItalicAction();
    italicAction.putValue(Action.NAME, "Italic");
    styleMenu.add(italicAction);

    menu.add(styleMenu);

    north.add(menu);
    north.add(print);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(north, BorderLayout.NORTH);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(false);
  }

  public static void main(String[] args) {
    new MainClass();
  }

  public void paintToPDF(JTextPane ta,TreatmentMasterModel masterModel) {
    try {
    	
    	
    //  ta.setBounds(0, 0, (int) convertToPixels(612 - 58), (int) convertToPixels(792 - 60));
    	  ta.setBounds(0, 0, (int) convertToPixels(612 - 58), (int) convertToPixels(792 - 60));
      Document document = new Document();
      FileOutputStream fos = null;
      if(masterModel!=null)
      {
       fos = new FileOutputStream(masterModel.getPatientName()+".pdf");
      }
      else
      {
    	  fos = new FileOutputStream("farzi.pdf");
      }
      PdfWriter writer = PdfWriter.getInstance(document, fos);

      document.setPageSize(new com.lowagie.text.Rectangle(612, 792));
      document.open();
      PdfContentByte cb = writer.getDirectContent();

      cb.saveState();
      cb.concatCTM(1, 0, 0, 1, 0, 0);

      DefaultFontMapper mapper = new DefaultFontMapper();
      mapper.insertDirectory("c:/windows/fonts");

      Graphics2D g2 = cb.createGraphics(612, 792, mapper, true, .95f);

      AffineTransform at = new AffineTransform();
      at.translate(convertToPixels(20), convertToPixels(20));
      at.scale(pixelToPoint, pixelToPoint);

      g2.transform(at);

      g2.setColor(Color.WHITE);
      g2.fill(ta.getBounds());

      Rectangle alloc = getVisibleEditorRect(ta);
      ta.getUI().getRootView(ta).paint(g2, alloc);

      g2.setColor(Color.BLACK);
      g2.draw(ta.getBounds());

      g2.dispose();
      cb.restoreState();
      document.close();
      fos.flush();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public float convertToPoints(int pixels) {
    return (float) (pixels * pixelToPoint);
  }

  public float convertToPixels(int points) {
    return (float) (points / pixelToPoint);
  }

  protected Rectangle getVisibleEditorRect(JTextPane ta) {
    Rectangle alloc = ta.getBounds();
    if ((alloc.width > 0) && (alloc.height > 0)) {
      alloc.x = alloc.y = 0;
      Insets insets = ta.getInsets();
      alloc.x += insets.left;
      alloc.y += insets.top;
      alloc.width -= insets.left + insets.right;
      alloc.height -= insets.top + insets.bottom;
      return alloc;
    }
    return null;
  }

}

class BoldAction extends StyledEditorKit.StyledTextAction {
  private static final long serialVersionUID = 9174670038684056758L;

  public BoldAction() {
    super("font-bold");
  }

  public String toString() {
    return "Bold";
  }

  public void actionPerformed(ActionEvent e) {
    JEditorPane editor = getEditor(e);
    if (editor != null) {
      StyledEditorKit kit = getStyledEditorKit(editor);
      MutableAttributeSet attr = kit.getInputAttributes();
      boolean bold = (StyleConstants.isBold(attr)) ? false : true;
      SimpleAttributeSet sas = new SimpleAttributeSet();
      StyleConstants.setBold(sas, bold);
      setCharacterAttributes(editor, sas, false);

    }
  }
}

class ItalicAction extends StyledEditorKit.StyledTextAction {

  private static final long serialVersionUID = -1428340091100055456L;

  public ItalicAction() {
    super("font-italic");
  }

  public String toString() {
    return "Italic";
  }

  public void actionPerformed(ActionEvent e) {
    JEditorPane editor = getEditor(e);
    if (editor != null) {
      StyledEditorKit kit = getStyledEditorKit(editor);
      MutableAttributeSet attr = kit.getInputAttributes();
      boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
      SimpleAttributeSet sas = new SimpleAttributeSet();
      StyleConstants.setItalic(sas, italic);
      setCharacterAttributes(editor, sas, false);
    }
  }
}