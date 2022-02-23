import java.util.ArrayList;
/**
 * The Club class stores the array list of players and allows for new player objects to be added, deleted and listed.
 *
 * @author Conor Gleeson
 * @version 1.0
 */

/**fields**/
public class Club {
    private String name;
    private String headCoach;
    private int members;
    private ArrayList<Player> players; /*declares arrayList for players*/

    /**
     *
     * @param name a string that contains the name of the club
     * @param headCoach a string that contains the name of the head coach of the club
     * @param members an int that contains the number of members in a club
     */
    public Club(String name, String headCoach, int members) {
        if (Utilities.max30Chars(name)) {
            this.name = name;
        } else {
            this.name = name.substring(0, 30);
        }
        if (Utilities.max30Chars(headCoach)) {
            this.headCoach = headCoach;
        } else {
            this.headCoach = headCoach.substring(0, 30);
        }
        if (Utilities.validNonNegative(members)) {
            this.members = members;
        } else {
            this.members = 0;
        }
        this.players = new ArrayList<Player>();
    }

    /**setters and getters**/


    /**
     * gets the name for club
     *
     * @return returns a name of type string
     */
    public String getName() {
        return name;
    }

    /**
     * sets name for club with a max length of 30 characters
     *
     * @param name
     */
    public void setName(String name) {
        if (Utilities.max30Chars(name)) {
            this.name = name;
        }
    }

    /**
     * gets head coach string for club
     *
     * @return head coach string
     */
    public String getHeadCoach() {
        return headCoach;
    }

    /**
     *sets head coach string for club
     *
     * @param headCoach string
     */
    public void setHeadCoach(String headCoach) {
        if (Utilities.max30Chars(headCoach)) {
            this.headCoach = headCoach;
        }
    }

    /**
     * gets the number of members in club
     *
     * @return members int
     */
    public int getMembers() {
        return members;
    }

    /**
     * Sets members if the value is greater than or equal to zero
     *
     * @param members number of members
     */
    public void setMembers(int members) {
        if (Utilities.validNonNegative(members)) {
            this.members = members;
        }
    }

    /**
     * gets players from array list
     *
     * @return players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * sets the players
     *
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Club: " + "Club Name: " + name + '\'' +
                " Head Coach Name: " + headCoach + '\'' +                /*toString method to show the object in user friendly*/
                "Number of Members: " + members +
                " Club Players: " + players
                ;
    }

    /**
     *adds a new player object to the arraylist
     *
     * @param player a player object
     * @return true
     */
    public boolean addPlayer(Player player) {
        players.add(player);
        return true;

    }

    /**
     * removes a player object from the array list.  if the index conditions are made then a deletedPlayer object is made and made to equal the player object at the chosen index
     * the object is then removed and then returned.
     *
     * @param index index value of the player object
     * @return returns the deletedPlayer object or null.
     */
    public Player deletePlayer(int index) {
        if ((index >= 0) && (index < players.size())) {  /*ensures that the number is within the numbers available in the array*/

            Player deletedPlayer = players.get(index);
            players.remove(index);
            return deletedPlayer;                                               /*removes player at the index*/

        }
        return null; /*returns null if there is no player at provided index*/


    }

    /**
     * String method the lists the player objects in the player arraylist if the size is not equal to zero
     *
     * @return returns list player string that includes the index of the array list and the player fields
     */
    public String listOfPlayers() {
        if (players.size() == 0) {
            return "There are no players registered in this club";     /*prints statement if there are no players entered in*/
        } else {
            String listOfPlayers = " ";     //creates basic string
            for (int i = 0; i < players.size(); i++) {
                listOfPlayers = listOfPlayers + i + ": " + players.get(i) + "\n";        /*cycles through the array and creates a string from the parameters*/
            }
            return listOfPlayers;
        }
    }

    /**
     * Boolean helper method to check if the player object is stored in a valid club. Makes a boolean variable false. Varaible is passed through for loop testing if the player value "i
     * is equal to the player in the loop and if so makes boolean true and then returns the inClub boolean
     *
     * @param player player object inside array list
     * @return inClub boolean variable
     */
    public boolean isPlayerInClub(Player player) {
        boolean inClub = false;                         /*creates local variable and makes it false*/
        for (int i = 0; i < players.size(); i++) {        /*loop to cycle through loop and chek for equality between objects and make true*/
            if (player.equals(players.get(i))) {
                inClub = true;

            }
        }
        return inClub;                      /*returns the variable as true or false*/
    }

}


