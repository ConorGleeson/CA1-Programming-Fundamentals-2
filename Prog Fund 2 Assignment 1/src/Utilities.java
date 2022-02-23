
public class Utilities {

    /**
     * this method makes sure that the text entered into the string contains only numbers
     *
     * @param text this is an object of type string
     * @return returns the text only if the string contains numbers between 0 and 9
     */
    public static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    /**
     * this method takes in the string and ensures that it is only 30 characters in length
     *
     * @param string this is a string onject
     * @return returns the string entered and checks to see if it is above or below 30 characters  in length
     */
    public static boolean max30Chars(String string) {
        return (string.length() <= 30) ? true : false;
    }

    /**
     * this method ensures that the email string entered contains the correct symbols for this to be a valid email address
     *
     *
     * @param email this is the string entered by the user
     * @return returns the email string presented by the user only if it contains an "@" symbol and a "."
     */
    public static boolean validEmail(String email) {
        return (email.contains("@") && email.contains("."));
    }

    /**
     * This method checks to ensure an int entered is greater than or equal to zero
     *
     * @param members an object of type int
     * @return returns the int object and checks to see if it is greater than zero
     */
    public static boolean validNonNegative(int members) {
        return (members >= 0);
    }

    /**
     * This method checks to ensure that the int entered is greater than zero
     *
     * @param maxNumOfClubs an object of type int
     * @return returns the int object and checks that it is greater than zero
     */
    public static boolean Positive(int maxNumOfClubs) {
        return (maxNumOfClubs > 0);
    }


}