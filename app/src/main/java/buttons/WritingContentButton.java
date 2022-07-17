package buttons;

import models.*;

import javax.swing.*;

public class WritingContentButton extends JButton {
  private Writing writing;
  private String state;

  public WritingContentButton(Writing writing) {
    this.writing = writing;
    this.state = Writing.ORIGINAL;
    this.setText(writing.title());
  }

  public String state() {
    if (!writing.state().equals(state)) {
      return state = writing.state();
    } return null;
  }
}
