package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args) {
        printFooBar(100);
    }

    public static String[] printFooBar(int number) {
        if (number < 0) {
            return new String[]{};
        }
        String[] result = new String[number + 1];
        String line;
        for (int i = 0; i <= number; i++) {
            System.out.print(i + " ");
            line = i + " ";
            if (i % 3 == 0) {
                System.out.print("Foo");
                line += "Foo";
            }
            if (i % 5 == 0) {
                System.out.print("Bar");
                line += "Bar";
            }
            System.out.println();
            result[i] = line;
        }
        return result;
    }
}
