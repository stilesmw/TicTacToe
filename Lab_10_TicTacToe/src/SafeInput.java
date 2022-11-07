import java.util.Scanner;

public class SafeInput {
    /**
     * Return a user supplied int within the specified range
     *
     * @param pipe   The Scanner instance to use for the console input
     * @param prompt A String that tells the user what to input
     * @param low    The lower bound for the range of valid values
     * @param high   The upper bound for the range of valid values
     * @return and intenger within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    System.out.println("\nYou said your return value is " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your return value is " + retVal + " but this is out of range. [" + low + " - " + high + "]: ");
                }

            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer not " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Returns a user supplied int of arbitrary value
     *
     * @param pipe   The Scanner to use for the input
     * @param prompt The String prompt telling the user what to input
     * @return an arbitrary integer of any value
     */

    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer not " + trash);
            }


        } while (!done);
        return retVal;
    }


    /**
     * Returns a user supplied double of arbitrary value
     *
     * @param pipe   The Scanner to use for the input
     * @param prompt The String prompt telling the user what to input
     * @return an arbitrary double of any value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double not " + trash);
            }


        } while (!done);
        return retVal;
    }

    /**
     * Get a double value with a specified inclusive range
     *
     * @param pipe   Scanner to read the console
     * @param prompt The prompt to tell the user what to input
     * @param low    The lower bound for the range of valid values
     * @param high   The upper bound for the range of valid values
     * @return a double within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You said your return value is " + retVal + " but this is out of range. [" + low + " - " + high + "]: ");
                }

            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double not " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets a string with at least one character
     *
     * @param pipe   Scanner to use for inputs
     * @param prompt String prompt to tell the user what to input
     * @return a non zero length string
     */
    public static String getNonZeroLengthString(Scanner pipe, String prompt) {
        String retVal = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.length() != 0) {
                done = true;
            } else {
                System.out.println("You must enter at lest one character.");
            }

        } while (!done);
        return retVal;
    }

    /**
     * Gets a string that matches a regular expression pattern Like ###-##-#### \d{3}-\d{2}-\d{4}
     *
     * @param pipe    Scanner to use for input
     * @param prompt  String prompt to tell the user what to input
     * @param pattern
     * @return a String that matches the RegEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String pattern) {
        String retVal = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern)) {
                done = true;
            } else {
                System.out.println("What you entered does not match the pattern. " + pattern);
            }

        } while (!done);
        return retVal;
    }

    /**
     * Takes a Y or an N and returns true or false respectively
     *
     * @param pipe   Scanner to use for console input
     * @param prompt String that indicates what to input
     * @return A boolean true or false based on the Y or N input
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = false;
        boolean done = false;
        String inputYN = "";

        do {
            System.out.print(prompt + "[Y/N]: ");
            inputYN = pipe.nextLine();

            if (inputYN.equalsIgnoreCase("Y")) {
                done = true;
                retVal = true;
            } else if (inputYN.equalsIgnoreCase("N")) {
                done = true;
                retVal = false;
            } else {
                System.out.println("You must enter Y or N");
            }

        } while (!done);

        return retVal;
    }

    public static String prettyHeader(Scanner pipe, String msg) {

        Scanner in = new Scanner(System.in);
        int whiteSpace;


        System.out.println("Enter your message: ");
        msg = in.nextLine();

        if (msg.length() < 54) {

            for (int x = 0; x <= 60; x++) {
                System.out.print("*");
            }
            System.out.println("\n***");


            whiteSpace = (54 - (msg.length()) / 2);
            for (int x = 0; x <= whiteSpace; x++) {
                System.out.print(" ");
            }

            System.out.print(msg);

            for (int x = 0; x <= whiteSpace; x++) {
                System.out.print(" ");
            }

            System.out.print("\n***");

            for (int x = 0; x <= 60; x++) {
                System.out.print("*");
            }
            System.out.println("");

        }
        return msg;
    }
}
