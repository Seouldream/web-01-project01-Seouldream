package panels;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritingListPanel extends JPanel {
  private List<Writing> writings;
  private JButton writingContentButton;

  public WritingListPanel(List<Writing> writings, JButton writingContentButton) {
    this.writings = writings;
    this.writingContentButton = writingContentButton;
    this.setLayout(new GridLayout(0, 1));

    for(Writing writing : writings) {
      if(writing.state().equals("DELETED")) {
        writings.remove(writing);
      }
    }
  }


}
