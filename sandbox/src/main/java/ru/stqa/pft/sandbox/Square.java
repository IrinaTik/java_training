package ru.stqa.pft.sandbox;

/**
 * Created by Morkan on 08.02.2020.
 */
public class Square {

  public double length;

  public Square(double length) {
    this.length = length;
  }

  public double area() {
    return this.length * this.length;
  }
}
