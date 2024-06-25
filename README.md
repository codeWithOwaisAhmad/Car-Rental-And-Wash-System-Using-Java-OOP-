# Car-Rental-And-Wash-System-Using-Java-OOP-
 Here is a README file for Car Rental System project in Java.


# Car Rental System

This project is a simple Car Rental System implemented in Java using Object-Oriented Programming principles. The system includes various types of cars (Luxury and Economy) and car wash services, demonstrating the use of abstract classes, concrete classes, and interfaces.

## Table of Contents

- [Overview](#overview)
- [Classes and Interfaces](#classes-and-interfaces)
  - [Abstract Class: Car](#abstract-class-car)
  - [Concrete Classes: LuxuryCar and EconomyCar](#concrete-classes-luxurycar-and-economycar)
  - [Interface: CarWash](#interface-carwash)
  - [Concrete Classes: LuxuryCarWash and EconomyCarWash](#concrete-classes-luxurycarwash-and-economycarwash)
- [Main Class: CarRentalSystem](#main-class-carrentalsystem)
- [How to Run](#how-to-run)
- [Example Output](#example-output)

## Overview

The Car Rental System is designed to manage car rentals and associated car wash services. It consists of different types of cars and corresponding car wash services. The system can display car details, rental costs, and car wash prices.

## Classes and Interfaces

### Abstract Class: Car

The Car class is an abstract class that represents a general car. It contains:

- Private attributes: carName, carYear, and dailyRate.
- A constructor to initialize these attributes.
- Abstract method displayCarDetails().
- Getter methods for the attributes.

java
abstract class Car {
    private String carName;
    private int carYear;
    private double dailyRate;

    public Car(String carName, int carYear, double dailyRate) {
        this.carName = carName;
        this.carYear = carYear;
        this.dailyRate = dailyRate;
    }

    public abstract void displayCarDetails();

    public double getDailyRate() {
        return dailyRate;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarYear() {
        return carYear;
    }
}


### Concrete Classes: LuxuryCar and EconomyCar

LuxuryCar and EconomyCar are concrete classes that extend the Car class.

- LuxuryCar has an additional attribute luxuryFeatures.
- EconomyCar has an additional attribute fuelEfficiency.

Both classes implement the displayCarDetails() method to display specific details about the cars.

java
class LuxuryCar extends Car {
    private int luxuryFeatures;

    public LuxuryCar(String carName, int carYear, double dailyRate, int luxuryFeatures) {
        super(carName, carYear, dailyRate);
        this.luxuryFeatures = luxuryFeatures;
    }

    @Override
    public void displayCarDetails() {
        System.out.println("Luxury Car: " + getCarName() + " (" + getCarYear() + ")");
        System.out.println("Daily Rate: $" + getDailyRate());
        System.out.println("Luxury Features: " + luxuryFeatures);
    }
}

class EconomyCar extends Car {
    private int fuelEfficiency;

    public EconomyCar(String carName, int carYear, double dailyRate, int fuelEfficiency) {
        super(carName, carYear, dailyRate);
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public void displayCarDetails() {
        System.out.println("Economy Car: " + getCarName() + " (" + getCarYear() + ")");
        System.out.println("Daily Rate: $" + getDailyRate());
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/L");
    }
}


### Interface: CarWash

The CarWash interface defines a method washCar() for washing cars.

java
interface CarWash {
    void washCar();
}


### Concrete Classes: LuxuryCarWash and EconomyCarWash

LuxuryCarWash and EconomyCarWash are concrete classes that implement the CarWash interface.

- Both classes have a washPrice attribute.
- They implement the washCar() method to display the car wash price.

java
class LuxuryCarWash implements CarWash {
    private double washPrice;

    public LuxuryCarWash(double washPrice) {
        this.washPrice = washPrice;
    }

    @Override
    public void washCar() {
        System.out.println("Luxury Car Wash: $" + washPrice);
    }
}

class EconomyCarWash implements CarWash {
    private double washPrice;

    public EconomyCarWash(double washPrice) {
        this.washPrice = washPrice;
    }

    @Override
    public void washCar() {
        System.out.println("Economy Car Wash: $" + washPrice);
    }
}


## Main Class: CarRentalSystem

The CarRentalSystem class integrates the car and car wash services. It has methods to rent a car and display the total cost along with car wash details.

java
public class CarRentalSystem {
    private Car car;
    private CarWash carWash;

    public CarRentalSystem(Car car, CarWash carWash) {
        this.car = car;
        this.carWash = carWash;
    }

    public void rentCar() {
        car.displayCarDetails();
        System.out.println("Rental Period: 1 day");
        System.out.println("Total Cost: $" + car.getDailyRate());
        carWash.washCar();
    }

    public static void main(String[] args) {
        CarRentalSystem crs1 = new CarRentalSystem(new LuxuryCar("Mercedes", 2020, 150.0, 5), new LuxuryCarWash(20.0));
        crs1.rentCar();

        System.out.println();

        CarRentalSystem crs2 = new CarRentalSystem(new EconomyCar("Toyota", 2018, 80.0, 20), new EconomyCarWash(10.0));
        crs2.rentCar();
    }
}


## How to Run

1. Compile the Java files:
   sh
   javac Car.java LuxuryCar.java EconomyCar.java CarWash.java LuxuryCarWash.java EconomyCarWash.java CarRentalSystem.java
   

2. Run the main class:
   sh
   java CarRentalSystem
   

## Example Output


Luxury Car: Mercedes (2020)
Daily Rate: $150.0
Luxury Features: 5
Rental Period: 1 day
Total Cost: $150.0
Luxury Car Wash: $20.0

Economy Car: Toyota (2018)
Daily Rate: $80.0
Fuel Efficiency: 20 km/L
Rental Period: 1 day
Total Cost: $80.0
Economy Car Wash: $10.0


