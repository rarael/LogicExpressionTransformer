package com.transformer;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Transformer transform = new Transformer(scan);
    transform.transformLogic();
  }
}