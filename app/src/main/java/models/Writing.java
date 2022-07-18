package models;

import utils.*;

public class Writing {
  private String title;
  private String writingContent;
  private String state;
  private SerialNumber serialNumber;
  public static final String ORIGINAL = "ORIGINAL";
  public static final String DELETED = "DELETED";
  public static final String MODIFIED = "MODIFIED";

  public Writing(String title, String writingContent, String state, SerialNumber serialNumber) {

    this.title = title;
    this.writingContent = writingContent;
    this.state = state;
    this.serialNumber = serialNumber;
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
    return "(" + title + ": "+ state + ")";
  }
}
