package com.transformer;

import java.util.ArrayList;
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
        int notIndex2 = string.indexOf("¬");
        int orIndex = string.indexOf("+");
        while (notIndex != -1) {
          string.replace(notIndex, notIndex + 1, "!");
          notIndex = string.indexOf("~");
        }
        while (notIndex2 != -1) {
          string.replace(notIndex2, notIndex2 + 1, "!");
          notIndex2 = string.indexOf("¬");
        }
        while(orIndex != -1) {
          string.replace(orIndex,orIndex + 1, "||");
          orIndex = string.indexOf("+");
        }
        String stringWithAnds = addAnds(string);
        System.out.print(stringWithAnds);
      }
      System.out.print(" ");
    }
    _scan.close();
  }

  private String addAnds(StringBuilder string) {
    char prevChar = string.charAt(0);
    ArrayList<Integer> whereToInsertAnds = new ArrayList<>();
    int howManyInserts = 0;
    for (int i = 1; i < string.length(); i++) {
      char currentChar = string.charAt(i);
      if ((Character.isLetter(prevChar) || prevChar == ')') && (Character.isLetter(currentChar) || currentChar == '!' || currentChar == '(')) {
        whereToInsertAnds.add(i);
      }
      prevChar = currentChar;
    }
    for (int g : whereToInsertAnds) {
      string.insert(g + (howManyInserts * 2), "&&");
      howManyInserts++;
    }
    return string.toString();
  }
}
