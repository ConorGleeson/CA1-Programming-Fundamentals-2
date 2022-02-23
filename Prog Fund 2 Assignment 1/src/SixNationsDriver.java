
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The driver class is where the main menu is presented from. It uses all the previously defined methods to allow the user to preform tasks
 *
 * @author Conor Gleeson
 *   @version 1.0
 */
public class SixNationsDriver {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Country> countries;

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public SixNationsDriver(int x) {
        countries = new ArrayList<Country>();

    }


    public static void main(String[] args) {
        new SixNationsDriver();
    }

    public SixNationsDriver() {
        countries = new ArrayList<Country>();

        runMenu();
    }


    /**
     * Presents the menu in the console in a user friendly format.
     *
     * @return returns the next line
     */
    public int mainMenu() {
        System.out.println("Six Nations Rugby Menu");
        System.out.println("----------");
        System.out.println(" 1) Add a country to Six Nations");
        System.out.println(" 2) Remove a country from the Six Nations");
        System.out.println(" 3) Update a Six Nations country's information (manager only) ");
        System.out.println("----------");
        System.out.println("Country Menu");
        System.out.println(" 4) Add a player to a country (must already be a member of a club in that country) ");
        System.out.println(" 5) Delete a player from a country ");
        System.out.println(" 6) Update a player from a country (phone number only) ");
        System.out.println("----------");
        System.out.println("Club Menu");
        System.out.println(" 7) Add a New CLub to a country");
        System.out.println(" 8) Delete a Club from a country");
        System.out.println(" 9) Update a Club's Information (head coach only) ");
        System.out.println("----------");
        System.out.println("Player Menu");
        System.out.println(" 10) Add a player to a given Club");
        System.out.println(" 11) Delete a player from a given Club");
        System.out.println(" 12) Update the information on a club player (phone number only)");
        System.out.println("----------");
        System.out.println("Report Menu");
        System.out.println(" 13) List all the Six Nations Countries");
        System.out.println(" 14) List all clubs of a given country");
        System.out.println(" 15) List all players of a given country");
        System.out.println(" 16) List all players of a given club");
        System.out.println(" 17) List all players in the system (club players)");
        System.out.println(" 18) Calculate and print the club with the most members");
        System.out.println(" 19) Calculate and print the country with the most national players");
        System.out.println("----------");
        System.out.println(" 20) Save to XML");
        System.out.println(" 21) Load from XML ");
        System.out.println("----------");
        System.out.println(" 0) Exit");
        System.out.println("====>>>");
        return ScannerInput.readNextInt("==>>");
    }

    /**
     * allows the menu to be presented to the user and for the methods to be called through the menu
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    try {
                        addCountry();
                    } catch (Exception e) {
                        System.err.println("Error adding country: " + e);
                    }
                    break;
                case 2:
                    try {
                        deleteCountry();
                    } catch (Exception e) {
                        System.err.println("Error deleting country: " + e);
                    }
                    break;
                case 3:
                    try {
                        updateCountry();
                    } catch (Exception e) {
                        System.err.println("Error updating country: " + e);
                    }
                    break;
                case 4:
                    try {
                        addPlayerToCountry();
                    } catch (Exception e) {
                        System.err.println("Error adding player to country: " + e);
                    }
                    break;
                case 5:
                    try {
                        deletePlayerFromCountry();
                    } catch (Exception e) {
                        System.err.println("Error deleting player from country: " + e);
                    }
                    break;
                case 6:
                    try {
                        updatePlayerByCountry();
                    } catch (Exception e) {
                        System.err.println("Error updating player in country: " + e); // currently doesnt do anything after picking player fixed.
                    }
                    break;
                case 7:
                    try {
                        addNewClub();
                    } catch (Exception e) {
                        System.err.println("Error adding new country: " + e);
                    }
                    break;
                case 8:
                    try {
                        deleteClub();
                    } catch (Exception e) {
                        System.err.println("Error deleting club: " + e);
                    }
                    break;
                case 9:
                    try {
                        updateClub();
                    } catch (Exception e) {
                        System.err.println("Error updating club information: " + e);
                    }
                    break;
                case 10:
                    try {
                        addPlayerToClub();
                    } catch (Exception e) {
                        System.err.println("Error adding player to club: " + e);
                    }
                    break;
                case 11:
                    try {
                        deletePlayerFromClub();
                    } catch (Exception e) {
                        System.err.println("Error deleting player from club: " + e);
                    }
                    break;
                case 12:
                    try {
                        updatePlayerByClub();
                    } catch (Exception e) {
                        System.err.println("Error updating the player: " + e);
                    }
                    break;
                case 13:
                    try {
                        System.out.println(listCountries());
                    } catch (Exception e) {
                        System.err.println("Error listing countries: " + e);
                    }
                    break;
                case 14:
                    try {
                        listClubByCountry();  // doesnt list clubs? Fixed
                    } catch (Exception e) {
                        System.err.println("Error listing clubs by country: " + e);
                    }
                    break;
                case 15:
                    try {
                        listPlayersOfCountry(); // doesnt list players? Fixed
                    } catch (Exception e) {
                        System.err.println("Error listing players of the country: " + e);
                    }
                    break;
                case 16:
                    try {
                        listPlayersByClub();  //   some kind of loop? not going to clubs keeps asking for country Fixed // now loops goes back to looking for country after listing players. loops method? Fixed
                    } catch (Exception e) {
                        System.err.println("Error listing the players of the club: " + e);
                    }
                    break;
                case 17:
                    try {
                        System.out.println(listAllClubPlayers()); // doesnt do anything ? Fixed // Prints something now but too many times ? Fixed
                    } catch (Exception e) {
                        System.err.println("Error listing all club players: " + e);
                    }

                    break;
                case 18:
                    try {
                        System.out.println(largestClub()); //  huge error  line 511?  stackoverflowError Fixed. // Now it just prints no clubs registered multiple times ? Adds one each time need to get it to jump to the end
                    } catch (Exception e) {
                        System.err.println("Error calculating largest club: " + e);
                    }
                    break;
                case 19:
                    try {
                        System.out.println(countryWithMostPlayers()); // doesnt print anything? Fixed
                    } catch (Exception e) {
                        System.out.println("Error calculating county with most players: " + e);
                    }
                    break;
                case 20:
                    try {
                        save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 21:
                    try {
                        load();
                    } catch (Exception e) {
                        System.err.println("Error loading from this file:  " + e);
                    }
                    break;


                default:
                    System.out.println("Invalid option entered" + option);
                    break;
            }
            System.out.println("\n Press the enter key to continue");
            input.nextLine();

            option = mainMenu();


        }
        System.out.println("Exiting ....");
        System.exit(0);
    }

    /**
     * Asks user to input name, manager name and max number of clubs for new country using scanner input
     * A new object is then added to the country array list
     */
    public void addCountry() {
        String name = ScannerInput.readNextLine("Enter the Country name: ");

        String manager = ScannerInput.readNextLine("Enter the manager name: ");

        int maxNumberOfClubs = ScannerInput.readNextInt("Enter the maximum number of clubs: ");

        countries.add(new Country(name, manager, maxNumberOfClubs));
    }

    /**
     * prints the list of countries then asks the user to choose one based on the index
     * if the if statement requirements are met the country at the index is removed
     */
    public void deleteCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of the Country to be deleted: ");

            if ((index >= 0) && (index < countries.size())) {
                countries.remove(index);
                System.out.println("Country deleted");
            } else {
                System.out.println("There is no Country for this index number");
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * creates a new blank string. Then cycles through the countries array and adds the index to the toString
     *
     * @return returns the listCountries string
     */
    public String listCountries() {
        if (countries.size() == 0) {
            return "There are no Countries registered";
        }
        String listCountries = " ";                              // put method and system.out.println in switch
        for (int i = 0; i < countries.size(); i++) {
            listCountries = listCountries + i + countries.get(i) + "\n";
        }
        return listCountries;
    }


    /**
     * lists countries and asks the user to pick one based on the array.
     * Then user is asked to input the new string for the manager name.
     * Then uses set manager to use the new string as the manager name.
     */
    public void updateCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of the country to be updated: ");

            if ((index >= 0) && (index < countries.size())) {

                String manager = ScannerInput.readNextLine("Enter the new name of the manager: ");

                Country country = countries.get(index);
                country.setManager(manager);
            } else {
                System.out.println("This country is not recognised");


            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * lists countries and asks the user to pick one based on index
     * They then input the name, email and number of the new player.
     * This player is then added to the national player arraylist using the add national player method from the country class.
     */
    public void addPlayerToCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());

            int index = ScannerInput.readNextInt("Enter the index of the country to add a player: ");

            if ((index >= 0) && (index < countries.size())) {
                String name = ScannerInput.readNextLine("Enter the new player name: ");
                String email = ScannerInput.readNextLine("Enter new player email: ");
                String phone = ScannerInput.readNextLine("Enter new player number: ");


                countries.get(index).addNationalPlayer(new Player(name, email, phone));         // national player already has is eligible.

            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * asks user to pick a country based on index this then lists the national players in that country.
     * The user picks a player based on index and is removed using the delete method from country.
     */
    public void deletePlayerFromCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of the country to delete a player: ");

            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfNationalPlayers());
                int index2 = ScannerInput.readNextInt("Enter the index of the player to delete: ");  // using index means it refers to a specific country
                if ((index2 >= 0) && (index < countries.get(index).getNationalPlayers().size())) {
                    countries.get(index).deleteNationalPlayer(index2);
                    System.out.println("National Player deleted");
                } else {
                    System.out.println("There is no player for this index number: ");
                }
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * asks user to pick a country and a national player based on index.
     * User then enters new phone number for the player and it is added to the player object
     */
    public void updatePlayerByCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of the country to update a player: ");

            if ((index >= 0) && (index < countries.size())) {

                System.out.println(countries.get(index).listOfNationalPlayers());
                int index2 = ScannerInput.readNextInt("Enter the index of the player to update: ");
                if ((index2 >= 0 ) && index < countries.get(index).getNationalPlayers().size()) {
                    String phone = ScannerInput.readNextLine("Enter the new player phone number: ");
                    Player player = countries.get(index).getNationalPlayers().get(index);
                    player.setPhone(phone);
                }
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * user selects country using index.
     * Asks user to enter the required fields for a new club and then adds it to the club array list
     */
    public void addNewClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to add a club: ");
            if ((index >= 0) && (index < countries.size())) {
                if (countries.get(index).getClubs().size() < countries.get(index).getMaxNumOfClubs()) {
                    String name = ScannerInput.readNextLine("Enter the name of the new club: ");
                    String headCoach = ScannerInput.readNextLine("Enter the name of the head coach: ");
                    int members = ScannerInput.readNextInt("Enter the number of members: ");

                    countries.get(index).addClub(new Club(name, headCoach, members));

                }else System.out.println("Club cannot be added as the maximum number of clubs has been reached");
            }
        } else {
            System.out.println("There are no countries registered");
        }

    }

    /**
     * asks user to choose a country and then a club within that country using indexes
     * Chosen club is then removed using the delete club method from country
     */
    public void deleteClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to delete a club: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());

                int index2 = ScannerInput.readNextInt("Enter the index of the club to be deleted: ");
                if ((index2 >= 0) && (index2 < countries.get(index).getClubs().size())) {
                    countries.get(index).deleteClub(index2);
                    System.out.println("Club deleted");
                }
            } else {
                System.out.println("There is no club for this index");
            }
        }


    }

    /**
     * uses index to get the user to choose a country and a club within that country
     * the user then enters a new string for the head coach name and is updated using the setter
     */
    public void updateClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to update a club: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());

                int index2 = ScannerInput.readNextInt("Enter the index of the club to be updated: ");
                if ((index2 >= 0) && (index2 < countries.get(index).getClubs().size())) {
                    String headCoach = ScannerInput.readNextLine("Enter the new Head Coach name: ");
                    Club club = countries.get(index).getClubs().get(index);
                    club.setHeadCoach(headCoach);
                    System.out.println("Coach updated");
                }
            } else {
                System.out.println("Invalid Index");
            }
        } else {
            System.out.println("There is no club for this index");
        }
    }

    /**
     * asks user to choose a country and then a club within that country
     * the user enters the necessary fields for a new player object
     * A new player is then added to the array list withing the club class
     */
    public void addPlayerToClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to add a player: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());
                int index2 = ScannerInput.readNextInt("Enter the index of the club to add player: ");
                if ((index2 >= 0) && (index2 < countries.get(index).getClubs().size())) {
                    String name = ScannerInput.readNextLine("Enter the name of the new player: ");
                    String email = ScannerInput.readNextLine("Enter the email of the new player: ");
                    String number = ScannerInput.readNextLine("Enter the number of the new player: ");

                    countries.get(index).getClubs().get(index2).addPlayer(new Player(name, email, number));
                    System.out.println("Player added");

                } else {
                    System.out.println("There is no club at this index");
                }


            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * asks a user to choose a country and a club within that country and finally a player within that club
     * The specified player is then removed using the delete player method from club
     */
    public void deletePlayerFromClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to delete a club: ");
            if ((index >= 0) && index < countries.size()) {
                System.out.println(countries.get(index).listOfClubs());
                int index2 = ScannerInput.readNextInt("Enter the index of the club to be deleted: ");
                if ((index2 >= 0) && (index < countries.get(index).getClubs().size())) {
                    System.out.println(countries.get(index).getClubs().get(index2).listOfPlayers());
                    int playerIndex = ScannerInput.readNextInt("Enter the index of the player to be deleted: ");
                    if ((playerIndex >= 0) && (playerIndex < countries.get(index).getClubs().get(index2).getPlayers().size())) {   //index out of bounds error fix tomorrow fixed
                        countries.get(index).getClubs().get(index2).deletePlayer(playerIndex);
                        System.out.println("Player deleted from club");
                    }
                } else {
                    System.out.println("This is an invalid index");
                }
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * asks the user to specify a country club and player
     * then enter a new string of numbers that is updated to the player object using the setter
     */
    public void updatePlayerByClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of the country to update a player: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());
                int index2 = ScannerInput.readNextInt("Enter the index of the club to be updated: ");
                if ((index2 >= 0) && (index < countries.get(index).getClubs().size())) {
                    System.out.println(countries.get(index).getClubs().get(index2).listOfPlayers());
                    int playerIndex = ScannerInput.readNextInt("Enter the index of the player to be updated: ");
                    if ((playerIndex >= 0) && (playerIndex < countries.get(index).getClubs().get(index2).getPlayers().size())) {
                        String number = ScannerInput.readNextLine("Enter the new phone number: ");
                        Player player = countries.get(index).getClubs().get(index2).getPlayers().get(playerIndex);
                        player.setPhone(number);
                        System.out.println("Phone number updated");
                    }
                } else {
                    System.out.println("Update Failed");
                }
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }


    /**
     * the user is asked to specify a country and then the clubs of that country are listed
     * using the method from the country class
     */
    public void listClubByCountry() {
        if (countries.size() > 0) {
            System.out.println(listCountries());

            int index = ScannerInput.readNextInt("Enter the index of the country to list its clubs: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * asks user to specify a county and then use the list national players from country class to print all players
     */
    public void listPlayersOfCountry() {
        System.out.println(listCountries());
        if (countries.size() > 0) {

            int index = ScannerInput.readNextInt("Enter the index of the country to list its players: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfNationalPlayers());
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("There are no countries registered");
        }
    }

    /**
     * Asks player to use index to specify a country and a club
     * a blank string is created and then the list of players is called from the club class
     *
     * @return the string is returned with the list of clubs added into it
     */
    public String listPlayersByClub() {
        if (countries.size() > 0) {
            System.out.println(listCountries());


            int index = ScannerInput.readNextInt("Enter the index of a country to list its clubs: ");
            if ((index >= 0) && (index < countries.size())) {
                System.out.println(countries.get(index).listOfClubs());


                int index2 = ScannerInput.readNextInt("Enter the index of the a club to list its players: ");
                if (index2 >= 0 && index2 < countries.get(index).getClubs().size()) {
                    String listPlayerByClub = " ";
                    listPlayerByClub = listPlayerByClub + countries.get(index).getClubs().get(index2).listOfPlayers();
                    System.out.println(listPlayerByClub);

                } else {
                    System.out.println("Invalid Index");
                }


            } else {
                System.out.println("Invalid Index");
            }
        } else {
            System.out.println("There are no countries registered");
        }
        return null;


    }

    /**
     * creates a blank string and then uses a nested set of for loops to cycle through the countries and clubs array
     * then adds the list of players from each club in  each country to the string
     *
     * @return returns the string with the players added to it
     */
    public String listAllClubPlayers() {
        String listAllPlayers = " ";
        if (countries.size() > 0) {
            for (int i = 0; i < countries.size(); i++) {
                for (int j = 0; j < countries.get(i).getClubs().size(); j++) {
                    listAllPlayers = listAllPlayers + countries.get(i).getClubs().get(j).listOfPlayers();

                }
            }
        } else {
            listAllPlayers = "There are no registered players";
        }
        return listAllPlayers;
    }

  /* public Club  largestClub(){

        if(!countries.isEmpty()) {
            Club largestClub = countries.get(0).getClubs().get(0);
            for (int i = 0; i < countries.size(); i++) {
                for (int j = 0; j < countries.get(i).getClubs().size(); j++) {
                    if (countries.get(i).getClubs().get(j).getMembers() > largestClub.getMembers()) {
                        largestClub = countries.get(i).getClubs().get(j);

                    } else {
                        System.out.println("There are no countries registered");
                    }
                }

            }
            return largestClub;

        } else{
            return null;
            }

        }

   */

    /**
     * sets a club object to the first club in the array. Uses nested for each loops to cycle through each club in country.
     * Tests to see if the number of members is larger than the current club members.
     * makes the club variable into that club
     *
     * @return returns the current club at largest club
     */
    public Club largestClub() {
        if (countries.size() > 0) {
            if (countries.get(0).getClubs().size() > 0) {
                //Club largestClub = new Club("dummy", "dummy", 0);
                Club largestClub = countries.get(0).getClubs().get(0);

                for (Country country : countries) {
                    for (Club club : country.getClubs()) {
                        if (club.getMembers() > largestClub.getMembers()) {
                            largestClub = club;

                        }
                    }
                    return largestClub;
                }
            }else{
                 System.out.println("There are no clubs registered ");
            }
        } else {
            return null;
        }return largestClub();
    }

    /**
     * sets a country object to be the first country in the array
     * uses a for each loop to cycle through all country objects in the array
     * tests to see if the number of national players in a country is greater than the previous stored object
     * makes that object the new stored one
     *
     * @return returns the current largest object
     */
    public Country countryWithMostPlayers() {
        if (countries.size() > 0) {
            Country mostPlayers = countries.get(0);
            for (Country country : countries) {
                if (country.getNationalPlayers().size() > mostPlayers.getNationalPlayers().size()) {
                    mostPlayers = country;

                }
            }
            return mostPlayers;

        } else {
            return null;
        }


    }

    /**
     * loads stored data from xml
     *
     * @throws Exception
     */
    @SuppressWarnings("uncheked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("countries.xml"));
        countries = (ArrayList<Country>) is.readObject();
        is.close();
        System.out.println("Loaded from xml");
    }

    /**
     * saves current data to the xml
     *
     * @throws Exception
     */
    public void save() throws Exception {
        XStream xstream = new XStream((new DomDriver()));
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("countries.xml"));
        out.writeObject(countries);
        out.close();
        System.out.println("Saved to xml");
    }


}

