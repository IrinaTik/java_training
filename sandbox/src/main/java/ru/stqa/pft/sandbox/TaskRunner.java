package ru.stqa.pft.sandbox;

public class TaskRunner {

  public static void main (String[] args) {
    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 4;
    p1.y = 5;
    p2.x = 6;
    p2.y = 7;
    System.out.println("Расстояние между точками (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    //  return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    return  Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
