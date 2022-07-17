package panels;

import buttons.*;
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
        continue;

        //글쓴 내용을 담은 버튼들을 담은 패널
        //   저장하기 누르면 -> 리스트 패널 add
        // 완성된 글 삭제하기 클릭 -> 삭제 상태로 변경
        // 현재보고 잇는패널 리스트패널 -> 삭제된것을 제외하고 보여줘 <----
      }
     /* if(writing.state().equals("MODIFIED")) {

      }*/
      JButton button = new WritingContentButton(writing);
      this.add(button);

    }
    this.setVisible(false);
    this.setVisible(true);
  }


}
