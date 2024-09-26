import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture +
                ", Color: " + color + ", Price: " + price + ", Registration Number: " + registrationNumber;
    }
}

public class CarInventory {
    private List<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void saveCarsByMake(String make, String filename) throws IOException {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, filename);
    }

    public void saveCarsByModelAndYearsInUse(String model, int yearsInUse, String filename) throws IOException {
        List<Car> filteredCars = new ArrayList<>();
        int currentYear = java.time.Year.now().getValue();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture() > yearsInUse)) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, filename);
    }

    public void saveCarsByYearAndPrice(int year, double price, String filename) throws IOException {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, filename);
    }

    private void saveToFile(List<Car> cars, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Car car : cars) {
                writer.write(car.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CarInventory inventory = new CarInventory();
        inventory.addCar(new Car(1, "Toyota", "Camry", 2015, "Blue", 15000, "ABC123"));
        inventory.addCar(new Car(2, "Honda", "Accord", 2017, "Red", 18000, "XYZ456"));
        inventory.addCar(new Car(3, "Toyota", "Corolla", 2010, "Black", 8000, "DEF789"));
        inventory.addCar(new Car(4, "BMW", "X5", 2020, "White", 45000, "GHI101"));

        // Save by brand
        inventory.saveCarsByMake("Toyota", "toyota_cars.txt");

        // Save by model and years in use
        inventory.saveCarsByModelAndYearsInUse("Camry", 5, "camry_over_5_years.txt");

        // Save by year and price
        inventory.saveCarsByYearAndPrice(2017, 12000, "cars_2017_above_12000.txt");
    }
}
