package buttons;

import com.mommoo.flat.component.*;
import models.*;
import panels.*;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class DeleteButton extends JButton {
  private JFrame writingFrame;
  private JPanel writingListPanel;
  private JTextField titleTextField;
  private JTextArea writingTextArea;
  private JPanel contentPanel;

  public DeleteButton(JFrame writingFrame, JPanel writingListPanel, Journal journal, List<Journal> journals, List<Comment> comments) {
    this.writingFrame = writingFrame;
    this.writingListPanel = writingListPanel;
    this.setText("삭제하기");

    this.addActionListener(deleteButtonEvent -> {
      journal.delete();

      this.writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.writingFrame.setVisible(false);

      try {
        showContentPanel(journals);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
  private void showContentPanel(List<Journal> privateJournals) throws IOException {
    if (contentPanel != null) {
      contentPanel.removeAll();
    }
    contentPanel = new WritingListPanel(privateJournals);

    writingFrame.add(contentPanel);

    contentPanel.setVisible((false));
    contentPanel.setVisible(true);
  }

}

