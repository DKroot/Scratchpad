package org.houseofsoft;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsDemo {

  public static void main(String[] args) throws Exception {
    MyBean b = new MyBean();
    b.setTeam("Dynamo Kiev");
    b.setPoints(100);

    System.out.println("Converting a bean to the Map...");

    System.out.println(PropertyUtils.describe(b));
  }

  public static class MyBean {

    private String team;
    private int points;

    public String getTeam() {
      return team;
    }

    public void setTeam(String team) {
      this.team = team;
    }

    public int getPoints() {
      return points;
    }

    public void setPoints(int points) {
      this.points = points;
    }

    public int points() {
      return points;
    }
  }
}
