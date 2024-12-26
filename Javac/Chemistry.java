import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CombiningRatio {
    // Mapping atomic numbers to elements and valencies
    private static final Map<Integer, Element> ELEMENTS = new HashMap<>();

    static {
        ELEMENTS.put(1, new Element("Hydrogen", 1));
        ELEMENTS.put(2, new Element("Helium", 0));
        ELEMENTS.put(3, new Element("Lithium", 1));
        ELEMENTS.put(4, new Element("Beryllium", 2));
        ELEMENTS.put(5, new Element("Boron", 3));
        ELEMENTS.put(6, new Element("Carbon", 4));
        ELEMENTS.put(7, new Element("Nitrogen", 3));
        ELEMENTS.put(8, new Element("Oxygen", 2));
        ELEMENTS.put(9, new Element("Fluorine", 1));
        ELEMENTS.put(10, new Element("Neon", 0));
        ELEMENTS.put(11, new Element("Sodium", 1));
        ELEMENTS.put(12, new Element("Magnesium", 2));
        ELEMENTS.put(13, new Element("Aluminium", 3));
        ELEMENTS.put(14, new Element("Silicon", 4));
        ELEMENTS.put(15, new Element("Phosphorus", 3));
        ELEMENTS.put(16, new Element("Sulfur", 2));
        ELEMENTS.put(17, new Element("Chlorine", 1));
        ELEMENTS.put(18, new Element("Argon", 0));
        ELEMENTS.put(19, new Element("Potassium", 1));
        ELEMENTS.put(20, new Element("Calcium", 2));
        ELEMENTS.put(26, new Element("Iron", 2));
        ELEMENTS.put(29, new Element("Copper", 2));
        ELEMENTS.put(35, new Element("Bromine", 1));
        ELEMENTS.put(36, new Element("Krypton", 0));
        ELEMENTS.put(47, new Element("Silver", 1));
        ELEMENTS.put(53, new Element("Iodine", 1));
        ELEMENTS.put(56, new Element("Barium", 2));
        ELEMENTS.put(82, new Element("Lead", 2));
        ELEMENTS.put(92, new Element("Uranium", 6));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the atomic numbers of two elements to find their combining ratio:");

        try {
            // Input atomic numbers
            System.out.print("Enter atomic number of first element: ");
            int atomicNumber1 = scanner.nextInt();

            System.out.print("Enter atomic number of second element: ");
            int atomicNumber2 = scanner.nextInt();

            // Get element information
            Element element1 = ELEMENTS.get(atomicNumber1);
            Element element2 = ELEMENTS.get(atomicNumber2);

            // Validate input
            if (element1 == null || element2 == null) {
                System.out.println("Error: One or both atomic numbers are not in the database.");
                return;
            }

            System.out.println("First Element: " + element1.name + " (Valency: " + element1.valency + ")");
            System.out.println("Second Element: " + element2.name + " (Valency: " + element2.valency + ")");

            // Calculate combining ratio
            int ratio1 = element2.valency;
            int ratio2 = element1.valency;
            System.out.println("\nCombining Ratio: " + element1.name + ":" + ratio1 + " - " + element2.name + ":" + ratio2);

            // Connection explanation
            System.out.println(element1.name + " atoms combine with " + element2.name + " atoms in a ratio of " + ratio1 + ":" + ratio2 + " to form a stable compound.");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid atomic numbers.");
        } finally {
            scanner.close();
        }
    }

    // Helper class to store element information
    static class Element {
        String name;
        int valency;

        Element(String name, int valency) {
            this.name = name;
            this.valency = valency;
        }
    }
}
