package pl.coderstrust.foobar;

public class FooBar {

    public static void fooBar() {

        for (int myCounter = 0; myCounter <= 100; myCounter++) {
            System.out.print(myCounter + " ");
            if (myCounter % 3 == 0 && myCounter != 0) {
                System.out.print("Foo");
            }
            if (myCounter % 5 == 0 && myCounter != 0) {
                System.out.print("Bar");
            }
            System.out.println();
        }
    }
}
