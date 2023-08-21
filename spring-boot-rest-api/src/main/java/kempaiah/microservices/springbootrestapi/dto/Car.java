package kempaiah.microservices.springbootrestapi.dto;

public class Car extends Vehicle{
  public static void main(String[] args) {
    Vehicle v = null;
    Car c = new Car();
    v = c;
    c = (Car) v;
  }
}
