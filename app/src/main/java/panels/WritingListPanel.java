package panels;

import buttons.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritingListPanel extends JPanel {
  private List<Journal> journals;
  private JButton writingContentButton;

  public WritingListPanel(List<Journal> journals, JButton writingContentButton) {
    this.journals = journals;
    this.writingContentButton = writingContentButton;
    this.setLayout(new GridLayout(0, 1));

    for(Journal journal : journals) {
      if(journal.state().equals("DELETED")) {
        continue;

        //글쓴 내용을 담은 버튼들을 담은 패널
        //   저장하기 누르면 -> 리스트 패널 add
        // 완성된 글 삭제하기 클릭 -> 삭제 상태로 변경
        // 현재보고 잇는패널 리스트패널 -> 삭제된것을 제외하고 보여줘 <----
      }
      JButton button = new WritingContentButton(journal);
      this.add(button);

    }
    this.setVisible(false);
    this.setVisible(true);
  }


}
