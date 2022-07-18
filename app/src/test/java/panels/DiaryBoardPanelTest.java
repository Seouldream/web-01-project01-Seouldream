package panels;

import models.*;
import org.checkerframework.checker.units.qual.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DiaryBoardPanelTest {
  @Test
  void List() {
    Account account = new Account("1123");
    DiaryBoardPanel diaryBoardPanel = new DiaryBoardPanel(account);

    assertEquals("",diaryBoardPanel.writings());


  }

}