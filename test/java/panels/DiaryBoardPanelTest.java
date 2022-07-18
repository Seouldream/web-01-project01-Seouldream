package panels;

import models.*;
import org.checkerframework.checker.units.qual.*;
import org.junit.jupiter.api.*;
import utils.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DiaryBoardPanelTest {
  @Test
  void StatePrintoutTest() {

    List<Writing> writings = new ArrayList<>();
    Account account = new Account("1123");
    DiaryBoardPanel diaryBoardPanel = new DiaryBoardPanel(account);
    Writing writing = new Writing("원본1","원본1","ORIGINAL");
    Writing writing2 = new Writing("원본1","원본1","DELETED");
    writings.add(writing);
    writings.add(writing2);

    assertEquals("",writings);


  }

}