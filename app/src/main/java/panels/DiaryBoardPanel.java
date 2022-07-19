package panels;

import buttons.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class DiaryBoardPanel extends JPanel {
  private List<Journal> journals = new ArrayList<>();
  private JPanel contentPanel;
  private JPanel writingListPanel;
  private openJournalButton openJournalButton;

  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea writingTextArea;
  private String title;
  private String writingContent;

  public DiaryBoardPanel(Account account, List<Journal> journals) {

    JButton letsGoWriteButton = new JButton("일기 쓰러 가기");

    this.setLayout(new BorderLayout());

    this.add(letsGoWriteButton, BorderLayout.PAGE_START);

    letsGoWriteButton.addActionListener(letsGoWriteButtonEvent -> {
      JButton saveButton = new JButton("저장하기");
      openWritingWindow(saveButton);

      saveButton.addActionListener(saveButtonEvent -> {
        title = titleTextField.getText();
        writingContent = writingTextArea.getText();

        Journal journal = new Journal(title, writingContent);
        journals.add(journal);
        writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        writingFrame.setVisible(false);

        if(contentPanel != null) {
          contentPanel.removeAll();
        }
        contentPanel = new WritingListPanel(journals);

        this.add(contentPanel);

        contentPanel.setVisible((false));
        contentPanel.setVisible(true);


        // refreshDisplay();
      });
    });
  }

  private void openWritingWindow(JButton button) {
    writingFrame = new JFrame("오늘의 일기");
    writingFrame.setSize(400, 500);
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    writingFrame.setLocationRelativeTo(this);

    JPanel framePanel = new JPanel();
    titleTextField = new JTextField(10);
    writingTextArea = new JTextArea(30, 10);

    framePanel.setLayout(new BorderLayout());

    framePanel.add(titleTextField, BorderLayout.PAGE_START);
    framePanel.add(writingTextArea, BorderLayout.CENTER);
    framePanel.add(button, BorderLayout.PAGE_END);
    writingFrame.add(framePanel);
    writingFrame.setVisible(true);
  }
}

  /*  writingContentButton.addActionListener(event -> {
      JButton deleteButton = new JButton("삭제하기");
      openWritingWindow(deleteButton);
      titleTextField.setText(title);
      writingTextArea.setText(writingContent);


      framePanel.add(deleteModifyPanel, BorderLayout.PAGE_END);
      writingFrame.setVisible(true);

      deleteButton.addActionListener(event2 -> {
        journal.delete();
        writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        writingFrame.setVisible(false);
        writingListPanel = new WritingListPanel();
        //패널 뉴 -> 버튼들 (패널1)-> 지운다 ,상태바꾼다 -> 셋비지블 보여라 (패널1)->
        refresh();
      });
      modifyButton.addActionListener(event3 -> {
        journal.modify();
        titleTextField.setEditable(true);
        writingTextArea.setEditable(true);
        deleteModifyPanel.setLayout(new GridLayout(1, 3));
        JButton modifySaveButton = new JButton("저장하기");
        deleteModifyPanel.add(modifySaveButton);
        writingFrame.setVisible(true);

        modifySaveButton.addActionListener(event4 -> {
          title = titleTextField.getText();
          titleTextField.setText(title);
          writingContent = writingTextArea.getText();
          writingTextArea.setText(writingContent);
          titleTextField.setEditable(false);
          writingTextArea.setEditable(false);
          //라이팅 생성

          writingListPanel = new WritingListPanel(DiaryBoardPanel.this.journals, writingContentButton);

          refresh();
        });

      });
    });
  }


}
*//*});

    });
  }
  private void refresh() {
    this.add(writingListPanel);
    writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    writingFrame.setVisible(false);
    writingListPanel.setVisible((false));
    writingListPanel.setVisible(true);
  }
  private void refreshDisplay() {
    writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    writingFrame.setVisible(false);
    writingListPanel.setVisible((false));
    writingListPanel.setVisible(true);
  }
}*//*
 */

