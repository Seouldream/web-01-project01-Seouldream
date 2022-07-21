package buttons;

import com.mommoo.flat.button.*;
import models.*;
import panels.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class OpenJournalButton extends FlatButton {
  private String title;
  private String writingContent;
  private Journal journal;
  private List<Journal> journals;
  private String state;
  private JFrame writingFrame;
  private JPanel framePanel;
  private JPanel contentPanel;
  private JTextField titleTextField;
  private JTextArea writingTextArea;
  private List<Comment> comments;


  public OpenJournalButton(Journal journal, List<Journal> journals) throws IOException {
    this.journal = journal;
    this.journals = journals;
    this.state = Journal.PUBLISHED;
    this.setText(journal.title());
    this.setBackground(Color.getHSBColor(1,2,3));
    this.setForeground(Color.BLACK);
    JPanel diaryBoardPanel = (JPanel)getTopLevelAncestor();

    Fileloader fileloader = new Fileloader();
    String commentsFile = "comments.csv";

    comments = fileloader.loadComments(commentsFile);

    this.addActionListener(event -> {

      openWritingFrame(journal);

      FlatButton deleteButton = new DeleteButton(journal);

      framePanel.add(deleteButton, BorderLayout.PAGE_END);
      writingFrame.add(framePanel);
      writingFrame.setVisible(true);

    });
  }

  public OpenJournalButton(Journal journal,String onlyForMe) throws IOException {
    this.journal = journal;
    this.state = Journal.PUBLISHED;
    this.setText(journal.title());
    this.setBackground(Color.ORANGE);

    Fileloader fileloader = new Fileloader();
    String commentsFile = "commentsForMyself.csv";

    comments = fileloader.loadComments(commentsFile);

    this.addActionListener(event -> {
      openWritingFrame(journal);
    //  FlatButton deleteButton = new DeleteButton(journal,journals);

      FlatButton modifyButton = new ModifyButton(writingFrame,
          titleTextField,writingTextArea,journal, comments);

      FlatButton goLeaveACommentButton = new GoLeaveACommentButton(journal, comments);

      contentPanel.add(goLeaveACommentButton, BorderLayout.PAGE_END);
      framePanel.add(modifyButton, BorderLayout.PAGE_END);

      writingFrame.add(framePanel);
      writingFrame.setVisible(true);
    });
  }

  private void openWritingFrame(Journal journal) {
    writingFrame = new JFrame("오늘의 일기");
    writingFrame.setSize(400, 500);
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    writingFrame.setLocationRelativeTo(this);

    titleTextField = new JTextField(10);
    writingTextArea = new JTextArea(30, 10);
    framePanel = new JPanel();
    contentPanel = new JPanel();

    framePanel.setLayout(new BorderLayout());
    contentPanel.setLayout(new BorderLayout());

    framePanel.add(titleTextField, BorderLayout.PAGE_START);
    framePanel.add(contentPanel, BorderLayout.CENTER);
    contentPanel.add(writingTextArea, BorderLayout.CENTER);

    titleTextField.setText(journal.title());
    writingTextArea.setText(journal.content());
    titleTextField.setEditable(false);
    writingTextArea.setEditable((false));
  }

  public String state() {
    if (!journal.state().equals(state)) {
      return state = journal.state();
    }
    return null;
  }
}
