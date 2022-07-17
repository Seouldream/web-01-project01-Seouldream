package models;

public class Writing {
  private String title;
  private String writingContent;
  private String state;
  private static final String ORIGINAL = "ORIGINAL";
  private static final String DELETED = "DELETED";
  private static final String MODIFIED = "MODIFIED";

  public Writing(String title, String writingContent,String state) {

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

}
