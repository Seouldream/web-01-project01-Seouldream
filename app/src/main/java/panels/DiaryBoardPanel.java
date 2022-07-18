package panels;

import buttons.*;
import models.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class DiaryBoardPanel extends JPanel {
  private JPanel buttonPanel;
  private JButton letsGoWriteButton;
  private JPanel writingFramePanel;
  private String title;
  private String writingContent;
  private JPanel deleteModifyPanel;
  private JButton deleteButton;
  private JButton modifyButton;
  private JButton modifySaveButton;


  private JPanel writingListPanel;
  private OpenWritingContentButton openWritingContentButton;
  private JButton saveButton;
  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea writingTextArea;
  private SerialNumber serialNumber;
  private Writing writing;
  private List<Writing> writings;


  public DiaryBoardPanel(Account account,List<Writing> writings) {
    this.writings = writings;
    serialNumber = new SerialNumber();
    this.setLayout(new BorderLayout());


    createMenuPanel();

    writingListPanel = new WritingListPanel(writings, openWritingContentButton);
    this.add(writingListPanel, BorderLayout.CENTER);

    letsGoWriteButtonActionListener();



  }

  private void createMenuPanel(){
    buttonPanel=new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    this.add(buttonPanel,BorderLayout.PAGE_START);
    letsGoWriteButton=new JButton("일기 쓰러 가기");
    buttonPanel.add(letsGoWriteButton);
  }

  private void letsGoWriteButtonActionListener() {
    letsGoWriteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        writingFrame = new JFrame("오늘의 일기");
        writingFrame.setSize(400, 500);
        writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        writingFrame.setLocationRelativeTo(buttonPanel);
        writingFramePanel = new JPanel();
        writingFrame.add(writingFramePanel);
        writingFramePanel.setLayout(new BorderLayout());

        titleTextField = new JTextField(10);
        writingFramePanel.add(titleTextField, BorderLayout.PAGE_START);
        writingTextArea = new JTextArea(30, 10);
        writingFramePanel.add(writingTextArea, BorderLayout.CENTER);
        saveButton = new JButton("저장하기");

        saveButtonActionListener();

        writingFramePanel.add(saveButton, BorderLayout.PAGE_END);
        writingFrame.setVisible(true);
      }
    });
  }
  // 버튼1 (글작성시 글 하나 생성)

  private void saveButtonActionListener() {
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        title = titleTextField.getText();
        writingContent = writingTextArea.getText();

        writing = new Writing(title, writingContent, "ORIGINAL");
        writings.add(writing);

        openWritingContentButton = new OpenWritingContentButton(writing);
        writingListPanel.add(openWritingContentButton);
        openWritingContentButtonActionListener(writing);
        refreshDisplay();

        System.out.println("리스트 현황: " + writings);
      }
    });
  }
  //저장하기 누르면 버튼만 생성되고 끝이 나야함

  public void openWritingContentButtonActionListener(Writing writing) {
    openWritingContentButton.addActionListener(event -> {
      writingFrame.removeAll();
      writingFramePanel.removeAll();
      writingFrame = new JFrame("오늘의 일기");
      writingFrame.setSize(400, 500);
      writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      writingFrame.setLocationRelativeTo(buttonPanel);

      writingFrame.add(writingFramePanel);
      writingFramePanel.setLayout(new BorderLayout());
      titleTextField = new JTextField(10);
      titleTextField.setText(title);
      writingFramePanel.add(titleTextField, BorderLayout.PAGE_START);
      writingTextArea = new JTextArea(30, 10);
      writingTextArea.setText(writingContent);
      writingFramePanel.add(writingTextArea, BorderLayout.CENTER);

      titleTextField.setEditable(false);
      writingTextArea.setEditable(false);

      deleteModifyPanel = new JPanel();
      deleteModifyPanel.setLayout(new GridLayout(1, 2));
      deleteButton = new JButton("삭제하기");
      modifyButton = new JButton("수정하기");
      deleteModifyPanel.add(deleteButton);
      deleteModifyPanel.add(modifyButton);
      writingFramePanel.add(deleteModifyPanel, BorderLayout.PAGE_END);
      writingFrame.setVisible(true);


      deleteButtonActionListener(writing);
     // modifyButtonActionListener();
    });
  }
  //삭제하기 수정하기의 버튼 의 정의

  public void deleteButtonActionListener(Writing writing) {
    deleteButton.addActionListener(event2 -> {
      writing.deleted();
      writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      writingFrame.setVisible(false);
      writingListPanel = new WritingListPanel(writings, openWritingContentButton);
      //패널 뉴 -> 버튼들 (패널1)-> 지운다 ,상태바꾼다 -> 셋비지블 보여라 (패널1)->
      refresh();
      System.out.println("리스트 현황: " + writings);
    });


  }

  public void modifyButtonActionListener() {
      modifyButton.addActionListener(event2 -> {
      deleteModifyPanel.removeAll();
      deleteModifyPanel.setLayout(new GridLayout(1, 3));
      modifySaveButton = new JButton("저장하기");
      deleteModifyPanel.add(deleteButton);
      deleteModifyPanel.add(modifyButton);
      deleteModifyPanel.add(modifySaveButton);

      titleTextField.setEditable(true);
      writingTextArea.setEditable(true);
      deleteModifyPanel.setVisible(true);

        modifySavaButtonActionListener();
    });
  }

  public void modifySavaButtonActionListener() {
    modifySaveButton.addActionListener(event3 -> {
    writing.modified();
    title = titleTextField.getText();
    writingContent = writingTextArea.getText();
    titleTextField.setText(title);
    writingTextArea.setText(writingContent);
    titleTextField.setEditable(false);
    writingTextArea.setEditable(false);

    writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    writingFrame.setVisible(false);
    writingListPanel.removeAll();
    writingListPanel = new WritingListPanel(writings, openWritingContentButton);

    refresh();
  });
  }

public void refresh(){
  this.add(writingListPanel);
  writingListPanel.setVisible((false));
  writingListPanel.setVisible(true);
    }

private void refreshDisplay(){
    writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    writingFrame.setVisible(false);
    writingListPanel.setVisible((false));
    writingListPanel.setVisible(true);
    }
}

