// Car.java (Abstract Class)
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

// LuxuryCar.java (Concrete Class)
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

// EconomyCar.java (Concrete Class)
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

// CarWash.java (Interface)
interface CarWash {
  void washCar();
}

// LuxuryCarWash.java (Concrete Class)
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

// EconomyCarWash.java (Concrete Class)
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

// CarRentalSystem.java (Main Class)
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