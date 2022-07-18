package utils;

import models.*;

import java.io.*;
import java.util.*;

public class Fileloader {

  private List<Writing> writings;

  public Fileloader(List<Writing> writings) {
    this.writings = writings;
  }

  public List<Writing> loadWritings() throws FileNotFoundException {
    List<Writing> writings = new ArrayList<>();
    File file = new File("input.csv");
    Scanner scanner = new Scanner(file);

    String line = scanner.nextLine();

    Writing writing = parseLine(line);


    return null;
  }

  public void diaryWriter(List<Writing> writings) throws IOException {
    FileWriter fileWriter = new FileWriter("input.csv");

    for(Writing writing : writings) {
      String line = writing.toCsvRow();
      fileWriter.write(line + "\n");

    }
    fileWriter.close();

  }

  private Writing parseLine(String line) {
    String[] words = line.split(",");
    String title = words[0];
    String content = words[1];
    String state = words[2];
    return new Writing(title,content,state);
  }
}