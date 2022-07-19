package buttons;

import models.*;
import panels.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class openJournalButton extends JButton {
  private Journal journal;
  private String state;
  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea writingTextArea;

  public openJournalButton(Journal journal, List<Journal> journals, WritingListPanel writingListPanel) {
    this.journal = journal;
    this.state = Journal.PUBLISHED;
    this.setText(journal.title());

    this.addActionListener(event -> {
      JButton deleteButton = new JButton("삭제하기");

      openWritingWindow(journal, deleteButton);

      deleteButton.addActionListener(deleteButtonEvent -> {
        journal.delete();
        writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        writingFrame.setVisible(false);

        writingListPanel.removeAll();
        writingListPanel.setVisible(false);
        writingListPanel.add(new WritingListPanel(journals));
        writingListPanel.setVisible(true);
      });
    });
  }
  public void openWritingWindow(Journal journal, JButton button) {
    writingFrame = new JFrame("오늘의 일기");
    writingFrame.setSize(400, 500);
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    writingFrame.setLocationRelativeTo(this);

    JPanel framePanel = new JPanel();
    titleTextField = new JTextField(10);
    writingTextArea = new JTextArea(30, 10);

    titleTextField.setText(journal.title());
    writingTextArea.setText(journal.content());
    titleTextField.setEditable(false);
    writingTextArea.setEditable((false));

    framePanel.setLayout(new BorderLayout());

    framePanel.add(titleTextField, BorderLayout.PAGE_START);
    framePanel.add(writingTextArea, BorderLayout.CENTER);
    framePanel.add(button, BorderLayout.PAGE_END);
    writingFrame.add(framePanel);
    writingFrame.setVisible(true);
  }

  public String state() {
    if (!journal.state().equals(state)) {
      return state = journal.state();
    } return null;
  }
}
