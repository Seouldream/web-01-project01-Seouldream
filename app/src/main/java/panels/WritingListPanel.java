package panels;

import buttons.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritingListPanel extends JPanel {

  private List<Writing> writings;
  private JButton openWritingContentButton;
  private DiaryBoardPanel diaryBoardPanel;

  public WritingListPanel(List<Writing> writings, JButton openWritingContentButton) {
    this.writings = writings;


    this.openWritingContentButton = openWritingContentButton;
    this.setLayout(new GridLayout(5, 1));
    for(Writing writing : writings) {
      if(writing.state().equals("DELETED")) {
        continue;
      }

     /* if(writing.state().equals("MODIFIED")) {

      }*/
      JButton button = new WritingContentButton(writing);
      this.add(button);


    }

    this.setVisible(true);
  }


}
