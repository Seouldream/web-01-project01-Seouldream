package buttons;

import models.*;

import javax.swing.*;

public class WritingContentButton extends JButton {
  private Writing writing;
  private String state;

  public WritingContentButton(Writing writing) {
    this.writing = writing;
    this.state = writing.state();
    this.setText(writing.title());
  }
}
