import java.util.Scanner;
/*Клас «вектор», який описує вектор у 3-вимірному декартовому просторі:
- вектор задається трьома координатами;
- методи класу дозволяють знаходити модуль вектора, множити вектор на
число,
- додавати вектори, множити скалярно і векторно на інший вектор.
 */

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    //довжина вектора
    public double vectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector multiplyScalar(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector crossProduct(Vector other) {
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;
        return new Vector(crossX, crossY, crossZ);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vector 1 (x, y, z):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double z1 = scanner.nextDouble();
        Vector vector1 = new Vector(x1, y1, z1);

        System.out.println("Enter vector 2 (x, y, z):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double z2 = scanner.nextDouble();
        Vector vector2 = new Vector(x2, y2, z2);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Length of Vector 1: " + vector1.vectorLength());

        System.out.println("Vector 2: " + vector2);
        System.out.println("Length of Vector 2: " + vector2.vectorLength());

        //додавання 
        Vector sumVector = vector1.add(vector2);
        System.out.println("Sum of Vector 1 and Vector 2: " + sumVector);

        // Скалярний добуток векторів 
        double dotProduct = vector1.dotProduct(vector2);
        System.out.println("Dot Product of Vector 1 and Vector 2: " + dotProduct);

        // Векторний добуток 
        Vector crossProduct = vector1.crossProduct(vector2);
        System.out.println("Cross Product of Vector 1 and Vector 2: " + crossProduct);

        scanner.close();
    }
}
