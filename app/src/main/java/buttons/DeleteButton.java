package buttons;

import models.*;
import panels.*;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class DeleteButton extends JButton {
  public static final String INACTIVE = "INACTIVE";
  public static final String ACTIVE = "ACTIVE";
  private String state;
  private JFrame writingFrame;
  private List<Journal> journals;

  public DeleteButton(Journal journal, List<Journal> journals) {
    this.journals = journals;
    this.setText("삭제하기");
    this.state = DeleteButton.INACTIVE;

    this.addActionListener(deleteButtonEvent -> {
      journal.delete();
      activate();

      writingFrame = (JFrame)getTopLevelAncestor();
      writingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      writingFrame.setVisible(false);
    });
  }

  public void activate() {
    state = DeleteButton.ACTIVE;
  }

  public void inactivate() {
    state = DeleteButton.INACTIVE;
  }



}

