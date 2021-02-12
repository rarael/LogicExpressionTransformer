package com.transformer;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter logic expression: ");
    Transformer transform = new Transformer(scan);
    transform.transformLogic();
  }
}