package panels;

import buttons.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class DiaryBoardPanel extends JPanel {
  private JPanel writingListPanel;
  private JButton writingContentButton;
  private JButton saveButton;
  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea writingTextArea;

  private List<Writing> writings = new ArrayList<>();


  public DiaryBoardPanel(Account account) {
    this.setLayout(new BorderLayout());


    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    this.add(buttonPanel, BorderLayout.PAGE_START);
    JButton button = new JButton("일기 쓰러 가기");
    buttonPanel.add(button);

    writingListPanel = new WritingListPanel(writings,writingContentButton);
    this.add(writingListPanel, BorderLayout.CENTER);


    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        writingFrame = new JFrame("오늘의 일기");
        writingFrame.setSize(400, 500);
        writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        writingFrame.setLocationRelativeTo(buttonPanel);


        JPanel framePanel = new JPanel();
        writingFrame.add(framePanel);

        framePanel.setLayout(new BorderLayout());
        titleTextField = new JTextField(10);

        framePanel.add(titleTextField, BorderLayout.PAGE_START);
        writingTextArea = new JTextArea(30, 10);
        framePanel.add(writingTextArea, BorderLayout.CENTER);
        saveButton = new JButton("저장하기");
        framePanel.add(saveButton, BorderLayout.PAGE_END);
        writingFrame.setVisible(true);

        saveButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String title = titleTextField.getText();
            String writingContent = writingTextArea.getText();
            //라이팅 생성
            Writing writing = new Writing(title,writingContent,"Original");
            writings.add(writing);

            writingContentButton = new WritingContentButton(writing);
            writingListPanel.add(writingContentButton);
            refreshDisplay();

            writingContentButton.addActionListener(event -> {
              writingFrame = new JFrame("오늘의 일기");
              writingFrame.setSize(400, 500);
              writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              writingFrame.setLocationRelativeTo(buttonPanel);


              JPanel framePanel = new JPanel();
              writingFrame.add(framePanel);
              framePanel.setLayout(new BorderLayout());
              titleTextField = new JTextField(10);
              framePanel.add(titleTextField, BorderLayout.PAGE_START);
              writingTextArea = new JTextArea(30, 10);
              framePanel.add(writingTextArea, BorderLayout.CENTER);
              titleTextField.setText(title);
              titleTextField.setEditable(false);
              writingTextArea.setText(writingContent);
              writingTextArea.setEditable(false);

              JPanel deleteModifyPanel = new JPanel();
              deleteModifyPanel.setLayout(new GridLayout(1,2));
              JButton deleteButton = new JButton("삭제하기");
              JButton modifyButton = new JButton("수정하기");
              deleteModifyPanel.add(deleteButton);
              deleteModifyPanel.add(modifyButton);
              framePanel.add(deleteModifyPanel, BorderLayout.PAGE_END);
              writingFrame.setVisible(true);

              deleteButton.addActionListener(event2 -> {
                 writing.deleted();
                 refreshDisplay();
              });
            });
          }
        });
      }
    });
  }

  private void refreshDisplay() {
    writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    writingFrame.setVisible(false);
    writingListPanel.setVisible((false));
    writingListPanel.setVisible(true);
  }
}
