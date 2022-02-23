/**
 * The player class creates the player object and specifies its variables and some helper methods
 *
 * @author Conor Gleeson
 * @version 1.0
 */

/**
 * fields for player class
 **/
public class Player {
    private String name;
    private String email;
    private String phone;

/**constructor**/

    /**
     * @param name a string that contains the name of a player
     * @param email a string that contains the email of the player
     * @param phone a String that contains the phone number of the player
     */
    public Player(String name, String email, String phone) {
        if (Utilities.validEmail(email)) {  /*checks to make sure the email string entered contains an "@" symbol and "." If false Invalid Format is printed.**/
            this.email = email;
        } else {
            this.email = "Invalid format email"; /*If the email is invalid this string is printed**/
        }
        if (Utilities.max30Chars(name)) {  /*checks to make sure that the name is not longer than 30 characters. If it is it will be shortened by a substring**/
            this.name = name;
        } else {
            this.name = name.substring(0, 30); /* if the name entered is too long it will be cut down **/
        }
        if (Utilities.onlyContainsNumbers(phone)) { /*Checks to ensure only numbers are in the phone. If false then returns Unknown.**/
            this.phone = phone;
        } else {
            this.phone = "Unknown";  /* if the phone entered it invalid or not entered then this string will be returned **/
        }
    }


    /** getters and setters**/


    /**
     * gets the player name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the player name if it is below 30 characters
     *
     * @param name string of playr name
     */
    public void setName(String name) {
        if (Utilities.max30Chars(name)) {
            this.name = name;
        }

    }

    /**
     * gets the player email
     *
     * @return email string of player email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the player email if it contains an @ and a .
     *
     * @param email
     */
    public void setEmail(String email) {
        if (Utilities.validEmail(email)) {
            this.email = email;
        }
    }

    /**
     * gets the player phone
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * sets the player phone if it contains only numbers
     *
     * @param phone
     */
    public void setPhone(String phone) {
        if (Utilities.onlyContainsNumbers(phone)) {
            this.phone = phone;
        }
    }


    /**
     * helper method to check if one player object is the same as another
     *
     * @param otherPlayer
     * @return
     */
    public boolean equals(Player otherPlayer) {
        return (this.name.equals(otherPlayer.getName()) &&
                this.email.equals(otherPlayer.getEmail()) &&
                this.phone.equals(otherPlayer.getPhone()));
    }

    /**
     * too string method presents the object in a user friendly way
     **/
    @Override
    public String toString() {
        return "Player: " +
                "Player Name: " + name + '\'' +
                "Player Email: " + email + '\'' +
                " Player Phone Number: " + phone + '\''
                ;
    }
}

