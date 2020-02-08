package ru.stqa.pft.sandbox;

/**
 * Created by Morkan on 08.02.2020.
 */
public class Rectangle {

  public  double a;
  public  double b;

  public Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double area() {
    return this.a * this.b;
  }
}
