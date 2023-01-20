package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/shapes";
        String username = "root";
        String password = "toor";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "TRUNCATE TABLE triangles";
            String sql2 = "TRUNCATE TABLE circles";
            String sql3 = "TRUNCATE TABLE rectangles";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            System.out.println("Table truncated successfully!");
        } catch (SQLException e) {
            System.out.println("Truncate failed!");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        ArrayList<Rectangle> rectangles = new ArrayList<>();

        LinkedList<Circle> circles = new LinkedList<>();

        LinkedList<Triangle> triangles = new LinkedList<>();

        while (true) {
            System.out.print("Enter shape type (rectangle, circle, triangle, or exit): ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("exit")) {
                break;
            } else if (type.equalsIgnoreCase("rectangle")) {
                try {
                    System.out.print("Enter width: ");
                    String widthInput = scanner.nextLine();
                    double width = Double.parseDouble(widthInput);
                    if (width <= 0) {
                        throw new IllegalArgumentException("Width must be a positive value");
                    }
                    System.out.print("Enter height: ");
                    String heightInput = scanner.nextLine();
                    double height = Double.parseDouble(heightInput);
                    if (height <= 0) {
                        throw new IllegalArgumentException("Height must be a positive value");
                    }
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    Shape rectangle = new Rectangle(width, height, color);
                    rectangles.add((Rectangle) rectangle);
                    System.out.println("Created a rectangle with width " + width + ", height " + height + ", and color " + color);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: width and height must be numeric values");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: width and height must be numeric values");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (type.equalsIgnoreCase("circle")) {
                try {
                    System.out.print("Enter radius: ");
                    String radiusInput = scanner.nextLine();
                    double radius = Double.parseDouble(radiusInput);
                    if (radius <= 0) {
                        throw new IllegalArgumentException("Radius must be a positive value");
                    }
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    Circle circle = new Circle(radius, color);
                    circles.add(circle);
                    System.out.println("Created a circle with radius " + radius + " and color " + color);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: radius must be a numeric value");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: radius must be a numeric value");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (type.equalsIgnoreCase("triangle")) {
                try {
                    System.out.print("Enter side 1: ");
                    String side1Input = scanner.nextLine();
                    double side1 = Double.parseDouble(side1Input);
                    if (side1 <= 0) {
                        throw new IllegalArgumentException("Sides must be positive values");
                    }
                    System.out.print("Enter side 2: ");
                    String side2Input = scanner.nextLine();
                    double side2 = Double.parseDouble(side2Input);
                    if (side2 <= 0) {
                        throw new IllegalArgumentException("Sides must be positive values");
                    }
                    System.out.print("Enter side 3: ");
                    String side3Input = scanner.nextLine();
                    double side3 = Double.parseDouble(side3Input);
                    if (side3 <= 0) {
                        throw new IllegalArgumentException("Sides must be positive values");
                    }
                    Shape triangle = new Triangle(side1, side2, side3);
                    triangles.add((Triangle) triangle);
                    System.out.println("Created a triangle with sides of length " + side1 + ", " + side2 + ", and " + side3);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: sides must be numeric values");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: sides must be numeric values");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid shape type");
            }
        }

        int i = 0;
        for (Triangle object : triangles) {
            i++;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO triangles (idtriangles, area, perimeter) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                System.out.println(i);
                statement.setString(1, String.valueOf(i));
                System.out.println(object.getArea());
                statement.setString(2, String.valueOf(object.getArea()));
                System.out.println(object.getPerimeter());
                statement.setString(3, String.valueOf(object.getPerimeter()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row was inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Insert failed!");
                e.printStackTrace();
            }
        }

         i = 0;
        for (Circle object : circles) {
            i++;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO circles (idcircles, area, perimeter, color) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                System.out.println(i);
                statement.setString(1, String.valueOf(i));
                System.out.println(object.getArea());
                statement.setString(2, String.valueOf(object.getArea()));
                System.out.println(object.getPerimeter());
                statement.setString(3, String.valueOf(object.getPerimeter()));
                statement.setString(4, object.getColor());
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row was inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Insert failed!");
                e.printStackTrace();
            }
        }

         i = 0;
        for (Rectangle object : rectangles) {
            i++;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO rectangles (idrectangles, area, perimeter, color) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                System.out.println(i);
                statement.setString(1, String.valueOf(i));
                System.out.println(object.getArea());
                statement.setString(2, String.valueOf(object.getArea()));
                System.out.println(object.getPerimeter());
                statement.setString(3, String.valueOf(object.getPerimeter()));
                statement.setString(4, object.getColor());
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row was inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Insert failed!");
                e.printStackTrace();
            }
        }
    }

}




