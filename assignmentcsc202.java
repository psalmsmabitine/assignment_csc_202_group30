import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
    abstract double calculateVolume();
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculateVolume() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculateVolume() {
        return 0;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculateVolume() {
        return 0;
    }
}

class Sphere extends Shape {
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Shape {
    double side;

    Cube(double side) {
        this.side = side;
    }

    @Override
    double calculateArea() {
        return 6 * side * side;
    }

    @Override
    double calculateVolume() {
        return side * side * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select a shape:");
            System.out.println("1. Triangle");
            System.out.println("2. Circle");
            System.out.println("3. Rectangle");
            System.out.println("4. Sphere");
            System.out.println("5. Cube");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            Shape shape = null;
            double area = 0;
            double volume = 0;

            switch (choice) {
                case 1:
                    System.out.print("Enter the base of the triangle: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height of the triangle: ");
                    double height = scanner.nextDouble();
                    shape = new Triangle(base, height);
                    break;
                case 2:
                    System.out.print("Enter the radius of the circle: ");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    break;
                case 3:
                    System.out.print("Enter the length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width);
                    break;
                case 4:
                    System.out.print("Enter the radius of the sphere: ");
                    radius = scanner.nextDouble();
                    shape = new Sphere(radius);
                    break;
                case 5:
                    System.out.print("Enter the side length of the cube: ");
                    double side = scanner.nextDouble();
                    shape = new Cube(side);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

            if (shape != null) {
                area = shape.calculateArea();
                volume = shape.calculateVolume();
                System.out.println("Area: " + area);
                if (volume != 0) {
                    System.out.println("Volume: " + volume);
                }
            }

            System.out.print("Do you want to calculate the area or volume of another shape? (yes/no): ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
