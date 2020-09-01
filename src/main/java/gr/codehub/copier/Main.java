package gr.codehub.copier;

import gr.codehub.copier.exceptions.BusinessException;
import gr.codehub.copier.exceptions.InvalidAgeException;
import gr.codehub.copier.io.*;
import gr.codehub.copier.model.Car;
import gr.codehub.copier.model.Person;

import java.io.*;
import java.util.List;

public class Main {

    private static final String ROOT = "C:\\Users\\User\\Documents\\java_examples\\";

    private static void testByteIO() {
        System.out.println("Start copying file");
        try {
            ByteIO.copyFile(ROOT + "source_file.jpg",
                    ROOT + "target_file.jpg");
        } catch (IOException e) {
            System.out.println("Error: It was not possible to copy the file.");
        }
        System.out.println("Finished copying file");
    }

    private static void testDataIO() {
        System.out.println("Start saving file");
        try {
            DataIO.saveData(ROOT + "data_io.txt");
        } catch (IOException e) {
            System.out.println("Error: It was not possible to save the file.");
        }
        System.out.println("Finished saving file");
    }

    private static void testLineIO() {
        System.out.println("Start reading file");
        List<String> bookLines = null;
        try {
            bookLines = LineIO.readFile(ROOT + "my_text_file.txt");
        } catch (IOException e) {
            System.out.println("Error: It was not possible to read the file.");
        }
        System.out.println("Finished saving file");
        if (bookLines != null) {
            bookLines.forEach(System.out::println);
        }
    }

    private static void testObjectIO() {
        System.out.println("Copying an object to a new object using files");
        try {
            Person p1 = new Person("John", 24);
            ObjectIO.saveObject(ROOT + "object_io.txt", p1);
            Person p2 = (Person) ObjectIO.readObject(ROOT + "object_io.txt");
            System.out.println(p2.getName() + " is " + p2.getAge() + " years old");
        } catch (Exception e) {
            System.out.println("Error: It was not possible to copy the object.");
        }
    }

    private static void testMemoryIO() {
        System.out.println("Copying an object to a new object in memory");
        try {
            MemoryIO<Car> mio = new MemoryIO<>();
            Car c1 = new Car("Ford Model T", 999999);
            Car c2 = mio.copyObject(c1);
            System.out.println(c2.getModel() + " costs $" + c2.getPrice() + "");
        } catch (Exception e) {
            System.out.println("Error: It was not possible to copy the object.");
        }
    }

    private static void showAgeWithException(int age) throws BusinessException, InvalidAgeException {
        System.out.println("Trying to set the age to " + age);
        if (age < 1 || age > 122)
            throw new InvalidAgeException();
        if (Math.random() > 0.5)
            throw new BusinessException(43, "Unlucky exception");
        System.out.println("The age is " + age);
    }

    private static int setAgeHandleException() {
        try {
            showAgeWithException(134);
            return 0;
        } catch (BusinessException e) {
            System.out.println("Bad luck in setting age");
            return 1;
        } catch (InvalidAgeException e) {
            System.out.println("Bad business in setting age");
            return 2;
        } finally {
            System.out.println("Finished setting age");
        }
    }

    public static void main(String[] args) {

        System.out.println("\n==== TESTING BYTE IO ====");
        testByteIO();

        System.out.println("\n==== TESTING DATA IO ====");
        testDataIO();

        System.out.println("\n==== TESTING LINE IO ====");
        testLineIO();

        System.out.println("\n==== TESTING OBJECT IO ====");
        testObjectIO();

        System.out.println("\n==== TESTING MEMORY IO ====");
        testMemoryIO();

        System.out.println("\n==== TESTING SET AGE ====");
        int result = setAgeHandleException();
        System.out.println("The result is " + result);

    }


}
