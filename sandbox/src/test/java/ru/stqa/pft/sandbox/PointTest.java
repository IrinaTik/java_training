package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  //если точки идентичны
  @Test
  public void testDistanceZero() {
    Point p1 = new Point(-12, 12);
    Point p2 = new Point(-12, 12);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }

  //если точки идентичны и являются началом координат
  @Test
  public void testDistanceBeginning() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }
  //рандомные точки
  @Test
  public void testDistanceRandom() {
    Point p1 = new Point(13, 8);
    Point p2 = new Point(6, 77);
    Assert.assertEquals(p1.distance(p2), 69.35416353759881);
  }

  //точки по оси Y имеют одинаковые координаты
  @Test
  public void testDistanceOnX() {
    Point p1 = new Point(13, 8);
    Point p2 = new Point(6, 8);
    Assert.assertEquals(p1.distance(p2), 7.0);
  }

  //точки по оси X имеют одинаковые координаты
  @Test
  public void testDistanceOnY() {
    Point p1 = new Point(13, 8);
    Point p2 = new Point(13, 77);
    Assert.assertEquals(p1.distance(p2), 69.0);
  }

}
