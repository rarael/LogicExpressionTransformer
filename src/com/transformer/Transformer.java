package com.transformer;

import java.util.Scanner;

public class Transformer {
  private Scanner _scan;

  public Transformer(Scanner scan) {
    _scan = scan;
  }

  public void transformLogic() {
    while (_scan.hasNext()) {
      String currentString = _scan.next();
      if (currentString.equals("+")) { // Changes + symbol to ||
        System.out.print("||");
      } else {
        StringBuilder string = new StringBuilder(currentString);
        int notIndex = string.indexOf("~");
        int orIndex = string.indexOf("+");
        while (notIndex != -1) {
          string.replace(notIndex, notIndex + 1, "!");
          notIndex = string.indexOf("~");
        }
        if(orIndex != -1) {
          string.replace(orIndex,orIndex + 1, "||");
        }
        addAnds(string);
        System.out.print(string.toString());
      }
      System.out.print(" ");
    }
  }

  private void addAnds(StringBuilder string) {

  }
}
