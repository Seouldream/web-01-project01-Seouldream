package utils;

import models.*;

import java.io.*;
import java.util.*;

public class Fileloader {


  public List<Journal> loadWritings(List<Journal> journals) throws FileNotFoundException {


    File file = new File("input.csv");
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Journal journal = parseLine(line);
      journals.add(journal);
    }

    return journals;
  }

  public void diaryWriter(List<Journal> journals) throws IOException {
    FileWriter fileWriter = new FileWriter("input.csv");

    for(Journal journal : journals) {
      String line = journal.toCsvRow();
      fileWriter.write(line + "\n");
    }
    fileWriter.close();

  }

  private Journal parseLine(String line) {
    String[] words = line.split(",");
    String title = words[0];
    String content = words[1];
    String state = words[2];
    return new Journal(title,content);
  }
}

