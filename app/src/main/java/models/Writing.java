package models;

import utils.*;

public class Writing {
  private String title;
  private String writingContent;
  private String state;

  public static final String ORIGINAL = "ORIGINAL";
  public static final String DELETED = "DELETED";
  public static final String MODIFIED = "MODIFIED";

  public Writing(String title, String writingContent, String state) {

    this.title = title;
    this.writingContent = writingContent;
    this.state = state;

  }


  public String state() {
    return state;
  }

  public void original() {
    state = Writing.ORIGINAL;
  }

  public  void deleted() {
    state = Writing.DELETED;
  }

  public void modified() {
    state = Writing.MODIFIED;
  }

  public String title() {
    return title;
  }

  @Override
  public String toString() {
    return "(" + title + ": "+ writingContent+ ", 상태: "+ state + ")";
  }

  public String toCsvRow() {
    return title + "," + writingContent + "," + state;
  }
}
