
import java.util.ArrayList;
/**
 * This class creates the country objects and contains methods for use on the country, player and club arraylists
 *
 * @author Conor Gleeson
 *  @version 1.0
 */

/**
 * fields
 **/

public class Country {
    private String name;
    private String manager;
    private int maxNumOfClubs;
    private ArrayList<Player> nationalPlayers;
    private ArrayList<Club> clubs;


    /**
     * Constructor
     **/

    /**
     *
     * @param name a string that contains the name of the country
     * @param manager a string that contains the name of the country manager
     * @param maxNumberOfClubs an int that contains how many clubs are allowed in a country
     */

    public Country(String name, String manager, int maxNumberOfClubs) {
        if (Utilities.max30Chars(name)) {
            this.name = name;
        } else {
            this.name = name.substring(0, 30);
        }
        if (Utilities.max30Chars(manager)) {
            this.manager = manager;
        } else {
            this.manager = manager.substring(0, 30);
        }
        if (Utilities.Positive(maxNumberOfClubs)) {
            this.maxNumOfClubs = maxNumberOfClubs;
        } else {
            this.maxNumOfClubs = 10;
        }
        this.nationalPlayers = new ArrayList<Player>();
        this.clubs = new ArrayList<Club>();
    }

    /**
     * Setters and Getters
     **/

    /**
     *gets name for country
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name for country if it is less than 30 characters
     * @param name String type
     */
    public void setName(String name) {
        if (Utilities.max30Chars(name)) {
            this.name = name;
        }
    }

    /**
     * gets manager string for country
     *
     * @return manager string
     */
    public String getManager() {
        return manager;
    }

    /**
     * sets the manager string if it is below 30 characters
     *
     * @param manager string
     */
    public void setManager(String manager) {
        if (Utilities.max30Chars(manager)) {
            this.manager = manager;
        }
    }

    /**
     * gets the max number of clubs
     *
     * @return int value max number of clubs
     */
    public int getMaxNumOfClubs() {
        return maxNumOfClubs;
    }

    /**
     * sets the max number of clubs if it is only a positive value
     *
     * @param maxNumberOfClubs positive int value
     */
    public void setMaxNumOfClubs(int maxNumberOfClubs) {
        if (Utilities.Positive(maxNumberOfClubs)) {


            this.maxNumOfClubs = maxNumberOfClubs;
        }
    }

    /**
     *gets the array list of nationalPlayers
     *
     * @return nationalPlayers arraylist
     */

    public ArrayList<Player> getNationalPlayers() {
        return nationalPlayers;
    }


    /**
     * gets club array list
     *
     * @return clubs array list
     */
    public ArrayList<Club> getClubs() {
        return clubs;
    }

    /**
     * sets the club array list
     *
     * @param clubs
     */
    public void setClubs(ArrayList<Club> clubs) {
        this.clubs = clubs;
    }

    /**
     * To String method to present the class in a user friendly way
     **/
    @Override
    public String toString() {
            if(nationalPlayers.size() == 0 && clubs.size() ==0){
                return "Country: " +
                        "Country Name: " + name + '\'' +
                        "Manager Name: " + manager + '\'' +
                        "Maximum Number of Clubs: " + maxNumOfClubs +'\'' +
                        "National Players: " + "No national players registered" +
                        "Clubs: " + "No clubs registered" ;
            }
            else if
                (clubs.size() == 0){
                return "Country: " +
                        "Country Name: " + name + '\'' +
                        "Manager Name: " + manager + '\'' +
                        "Maximum Number of Clubs: " + maxNumOfClubs +'\'' +
                        "National Players: " + nationalPlayers +
                        "Clubs: " + "No clubs registered" ;
        }
            else if(nationalPlayers.size() == 0){
                return "Country: " +
                        "Country Name: " + name + '\'' +
                        "Manager Name: " + manager + '\'' +
                        "Maximum Number of Clubs: " + maxNumOfClubs +'\'' +
                        "National Players: " + "No national players registered" +
                        "Clubs: " + clubs ;
            }
            else {
                return "Country: " +
                        "name: " + name + '\'' +
                        " manager: " + manager + '\'' +
                        " maxNumberOfClubs: " + maxNumOfClubs +
                        " nationalPlayers: " + nationalPlayers +
                        " clubs: " + clubs ;
            }

    } //  need to add logic to this

    /**
     * Method to check is player is in club to see if is eligible to be on national team
     * local boolean method is set as false. For loop cycles through clubs array list and uses is player in club method
     * to see if player is eligible. Then returns the local boolean as true and returns the variable
     *
     * @param player player object in player array list
     * @return returns eligible variable as true or false
     */
    public boolean isEligible(Player player) {
        boolean eligible = false;
        for (int i = 0; i < clubs.size(); i++) {
            if (clubs.get(i).isPlayerInClub(player)) {
                eligible = true;
            }
        }
        return eligible;
    }

    /**
     * gets national player at position in array list
     *
     * @param index index is an int value that represents the objects position in array list
     * @return returns the index of the national player object
     */
    public Player getNationalPlayer(int index) {
        return nationalPlayers.get(index);
    }

    /**
     * Method on ArrayList Player that makes the eligible boolean false and if
     * the for loop and if statement conditions are made declares it true.
     * If it returns false the break ends the for loop
     *
     * @param nationalPlayers array list of national players array list
     * @return
     */
    public boolean setNationalPlayers(ArrayList<Player> nationalPlayers) {
        boolean eligiblePlayer = false;
        for (int i = 0; i < nationalPlayers.size(); i++) {
            if (isEligible(nationalPlayers.get(i))) {
                eligiblePlayer = true;
                this.nationalPlayers = nationalPlayers;
            } else {
                eligiblePlayer = false;
                break; //reference for use of "break"https://stackoverflow.com/questions/15275195/breaking-out-of-a-for-loop-in-java
            }
        }
        return eligiblePlayer;
    }

    /**
     * method that returns add player as true if the isEligible method is true and adds player to array list
     *
     * @param player player object in array list
     * @return returns true or false boolean
     */
    public boolean addNationalPlayer(Player player) {
        if (isEligible(player) == true) {
            nationalPlayers.add(player);
            return true;
        } else {
            return false;
        }
    }

    /**
     * delete method that removes player and returns true if the if statement parameters are met. Else False
     *
     * @param index int location of object in array list
     * @return returns true or false
     */
    public boolean deleteNationalPlayer(int index) {

        if ((index >= 0) && (index < nationalPlayers.size())) {

            nationalPlayers.remove(index);
            return true;
        } else {
            return
                    false;
        }
    }

    /**
     * Method that prints a string containing the toString of every Player object if there are more than 0 objects
     *
     * @return returns the list of national players string
     */
    public String listOfNationalPlayers() {
        if (nationalPlayers.size() == 0) {
            return "There are no players registered for the country";
        } else {
            String listOfNationalPlayers = " ";
            for (int i = 0; i < nationalPlayers.size(); i++) {
                listOfNationalPlayers = listOfNationalPlayers + i + ": " + nationalPlayers.get(i) + "\n";
            }
            return listOfNationalPlayers;
        }
    }

    /**
     * returns true for adding a club to Club object if there are less then the max num of clubs allowed
     *
     * @param club club object in club array list
     * @return returns true or false
     */
    public boolean addClub(Club club) {

        if (clubs.size() < maxNumOfClubs) {
            clubs.add(club);
            return true;
        } else {
            return false;
        }
    }

    /**
     * method to delete club at index. delete variable allows to test if object is removed.
     * Otherwise null is returned. puts club to be deleted into a variable deletes it and then returns the variable
     *
     * @param index int value for object location in array list
     * @return returns the local club object or null
     */
    public Club deleteClub(int index) {

        if ((index >= 0) && (index < clubs.size())) {
            Club delete = clubs.get(index);
            clubs.remove(index);
            return delete;
        } else {
            return null;
        }
    }

    /**
     * returns the number of clubs
     *
     * @return returns the size of th club array
     */
    public int numberOfClubs() {
        return clubs.size();
    }


    /**
     *  returns which club contains the most members if club is not empty. LargestClub variable is declared as zero.
     *      for each loop contains if statement to verify if a clubs members is greater than the current largestClub.
     *      It is then returned. Default is zero
     *
     * @return returns the largest club object or null
     */
    public Club largestClubInCountry() {
        if (!clubs.isEmpty()) {
            Club largestClub = clubs.get(0);
            for (Club club : clubs) {
                if (club.getMembers() > largestClub.getMembers())
                    largestClub = club;
            }
            return largestClub;
        } else {
            return null;
        }
    }

    /**
     * if clubs are not zero. A string is produced containing the to String of every club object
     *
     * @return returns the list of clubs string
     */
    public String listOfClubs() {
        if (clubs.size() == 0) {
            return "There are no clubs registered for the country";
        } else {
            String listOfClubs = " ";
            for (int i = 0; i < clubs.size(); i++) {
                listOfClubs = listOfClubs + i + ": " + clubs.get(i) + "\n ";
            }
            return listOfClubs;
        }

    }

    /**
     *  two for loops cycle through the objects within both arraylists and uses the is player in club method
     *      to check that the player is in the club and then returns it as a string
     *
     * @return returns the list of national players string
     */
    public String listOfNationalPlayersByClub() {

        if (nationalPlayers.size() == 0) {
            return "There are no players registered for the national team";
        } else {
            String listOfNationalPlayersByClub = "";
            for (int i = 0; i < nationalPlayers.size(); i++) {
                for (int j = 0; j < clubs.size(); j++) {
                    if (clubs.get(j).isPlayerInClub(nationalPlayers.get(i))) {
                        listOfNationalPlayersByClub = listOfNationalPlayersByClub + "Club: " + clubs.get(j) + "Player:" + nationalPlayers.get(i) + "\n";
                    }
                }
            }
            return listOfNationalPlayersByClub;
        }

    }

    /**
     * method that uses is player in club and contains club to ensure that players and clubs are valid
     *      and then adds 1 to counter
     *
     * @param club club object in club array list
     * @return returns int value of number of national players by club or -1 in event of failure
     */
    public int noOfNationalPlayersByClub(Club club) {
        int noOfNationalPlayers = 0;
        for (int i = 0; i < nationalPlayers.size(); i++) {
            if ((club.isPlayerInClub(nationalPlayers.get(i))) && clubIsInClub(club)) {  // do using Utilities?
                noOfNationalPlayers = noOfNationalPlayers + 1;
            }
        }
        if (noOfNationalPlayers > 0) {
            return noOfNationalPlayers;

        } else {
            return -1;
        }
    }


    /**
     * helper method to ensure that the Club array contains the chosen club
     * uses for loop to cycle through the club array list and uses equals method to determine true or false
     *
     * @param club
     * @return
     */
    public boolean clubIsInClub(Club club) {
        boolean clubInClub = false;
        for (int i = 0; i < clubs.size(); i++) {
            if (club.equals(clubs.get(i))) {
                clubInClub = true;
            }
        }
        return clubInClub;

    }

    /**
     * equals method to check if one country is equal to another
     *
     * @param otherCountry
     * @return
     */
    public boolean equals(Country otherCountry) {
        return (this.name.equals(otherCountry.getName()) &&
                this.manager.equals(otherCountry.getManager())

        );
    }


}

