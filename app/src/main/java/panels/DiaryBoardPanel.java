package panels;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class DiaryBoardPanel extends JPanel {
  private JButton saveButton;
  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea writingTextArea;

  private List<Writing> writings = new ArrayList<>();


  public DiaryBoardPanel(Account account) {
    this.setLayout(new BorderLayout());


    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    this.add(buttonPanel,BorderLayout.PAGE_START);
    JButton button = new JButton("일기 쓰러 가기");
    buttonPanel.add(button);

    JPanel writingListPanel = new JPanel();
    this.add(writingListPanel,BorderLayout.CENTER);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        writingFrame = new JFrame("오늘의 일기");
        writingFrame.setSize(400,500);
        writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        writingFrame.setLocationRelativeTo(buttonPanel);



        JPanel framePanel = new JPanel();
        writingFrame.add(framePanel);

        framePanel.setLayout(new BorderLayout());
        titleTextField = new JTextField(10);

        framePanel.add(titleTextField,BorderLayout.PAGE_START);
        writingTextArea = new JTextArea(30,10);
        framePanel.add(writingTextArea,BorderLayout.CENTER);
        saveButton = new JButton("저장하기");
        framePanel.add(saveButton,BorderLayout.PAGE_END);
        writingFrame.setVisible(true);
      ;}
    });


   /* saveButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String title = titleTextField.getText();
      String writingContent = writingTextArea.getText();
      writings.add(new Writing(title,writingContent));
      JButton writingContentButton = new JButton(title);
      writingListPanel.add(writingContentButton);
      writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
  });*/
  }
}
