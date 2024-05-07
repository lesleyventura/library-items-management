// ----------------------------------------
// Assignment 1
// Part 2 -- Driver
// Written by: Lesley Ventura 40281652
// ----------------------------------------

package driver;

import client.Client;
import items.Book;
import items.Items;
import items.Journal;
import items.Media;

import java.util.Scanner;
/**
 * Library class serves as the driver program for managing all items in the FunReadings Library.
 * It allows employees to add, update, delete, and list items in the library.
 * As well, it manages clients and the leasing and returning of items to and from clients.
 *
 * @author	Lesley Ventura
 * @version 1.0
 */
public class Library {

    // Constants for item and client amounts to keep size of arrays
    private static final int MAX_BOOKS = 100;
    private static final int MAX_JOURNALS = 100;
    private static final int MAX_MEDIAS = 100;
    private static final int MAX_CLIENTS = 100;
    private static final int MAX_ITEMS = 300;

    // Arrays made static to make them a fixed size and accessable throughout the class
    private static Book[] bookArray = new Book[MAX_BOOKS];
    private static Journal[] journalArray = new Journal[MAX_JOURNALS];
    private static Media[] mediaArray = new Media[MAX_MEDIAS];
    private static Client[] clientArray = new Client[MAX_CLIENTS];
    private static Items[] itemArray = new Items[MAX_ITEMS];

    /**
     * Driver welcomes the user and offers user choice of hardcoded scenario,
     * 	access the menu, or exit the program.
     * In the case of invalid input, user will be prompted to try again.
     *
     * @param args the command line arguments passed to the program (not used)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice;
        boolean valid = true;

        System.out.println("Written by Lesley Ventura 40281652\n");
        System.out.println("Welcome to the FunReadings Library!");

        while(valid) {
            System.out.print("Would you like to\n"+
                    "1. Run a predefined scenario\n"+
                    "2. Access the menu\n"+
                    "3. Exit program.\n"+
                    "\nChoice: ");

            choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    predefinedScenario();
                    proceed(scan);
                    break;
                case 2:
                    runMenu();
                    break;
                case 3:
                    System.out.println("\nThank you for using this program.");
                    valid = false;
                    break;
                default:
                    System.out.println("Not a valid choice. Please try again.");
            }

        }
        scan.close();
    }

    /**
     * Runs a predefined scenario of manipulation of items in the library.
     * 	Initialises arrays of items, books, journals, media, and clients with sample data
     * 	and prints information of each.	Prints comparisons between items and clients,
     * 	and identifies biggest book in array. Demonstates copying of media array.
     */
    public static void predefinedScenario() {

        // Initialises book array with Book objects
        bookArray[0] = new Book ("1984", "George Orwell", 1949, 328);
        bookArray[1] = new Book ("1984", "George Orwell", 1949, 328);
        bookArray[2] = new Book ("To Kill a Mockingbird", "Harper Lee", 1960, 281);

        // Prints out book array information
        System.out.println("-----\nBooks\n-----");
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] != null) {
                System.out.println(((Book)bookArray[i]).toString()+"\n");
            }
        }

        // Initialises journal arry with Journal objects
        journalArray[0] = new Journal("Journal of Neuroscience", "Elena Rodriguez", 2023, 37);
        journalArray[1] = new Journal("Science", "John Doe", 2002, 357);
        journalArray[2] = new Journal("Nature", "Jane Doe", 2015, 30);

        // Prints out journal array information
        System.out.println("--------\nJournals\n--------");
        for (int i = 0; i < journalArray.length; i++) {
            if (journalArray[i] != null) {
                System.out.println(((Journal)journalArray[i]).toString()+"\n");
            }
        }

        // Initialises media array with Media objects
        mediaArray[0] = new Media("Serial", "Sarah Koenig", 2014, "Podcast");
        mediaArray[1] = new Media("The Shining", "Stanley Kubrick", 1980, "Film");
        mediaArray[2] = new Media("Elle", "Lagardère Group", 2023, "Magazine");

        // Prints out media array information
        System.out.println("-----\nMedia\n-----");
        for (int i = 0; i < mediaArray.length; i++) {
            if (mediaArray[i] != null) {
                System.out.println(((Media)mediaArray[i]).toString()+"\n");
            }
        }

        // Initialises client array with Client objects
        clientArray[0] = new Client("Rachel Kim", "514000000", "rachel.kime@email.com");
        clientArray[1] = new Client("Cody Quinn", "4381234567", "cquinn@email.com");
        clientArray[2] = new Client("Eve Fischer", "1234567890", "evefischer00@email.com");

        // Prints out client array information
        System.out.println("-------\nClients\n-------");
        for (int i = 0; i < clientArray.length; i++) {
            if (clientArray[i] != null) {
                System.out.println(((Client)clientArray[i]).toString()+"\n");
            }
        }

        // Stores all items in item array
        itemArray[0] = bookArray[0];
        itemArray[1] = bookArray[1];
        itemArray[2] = bookArray[2];
        itemArray[3] = journalArray[0];
        itemArray[4] = journalArray[1];
        itemArray[5] = journalArray[2];
        itemArray[6] = mediaArray[0];
        itemArray[7] = mediaArray[1];
        itemArray[8] = mediaArray[2];

        // Compares objects using equals() method
        System.out.println("-----------\nComparison:\n-----------\n");
        if (mediaArray[1].equals(bookArray[0])) {
            System.out.println(mediaArray[1].getID() + " and " + bookArray[0].getID() + " are similar.");
        } else {
            System.out.println(mediaArray[1].getID() + " and " + bookArray[0].getID() + " are different.");
        }
        if (journalArray[0].equals(journalArray[2])) {
            System.out.println(journalArray[0].getID() + " and " + journalArray[2].getID() + " are similar.");
        } else {
            System.out.println(journalArray[0].getID() + " and " + journalArray[2].getID() + " are different.");
        }
        if (bookArray[0].equals(bookArray[1])) {
            System.out.println(bookArray[0].getID() + " and " + bookArray[1].getID() + " are similar.");
        } else {
            System.out.println(bookArray[0].getID() + " and " + bookArray[1].getID() + " are different.");
        }

        // Finds and prints biggest book using getBiggestBook() method
        Book biggestBook = getBiggestBook(bookArray);
        if (biggestBook != null)
            System.out.println("\n--------------------\nThe biggest book is:\n--------------------\n"+biggestBook.toString());
        else
            System.out.print("There are no books");

        // Copies items from media array
        copyBooks(mediaArray);

    }

    /**
     * Runs user defined program. Presents a menu to user, allowing them to choose from
     * 	different item and client manipulation options.
     */
    public static void runMenu() {
        Scanner scan = new Scanner(System.in);
        boolean valid = true;
        String answer = "";

        while (valid) {
            System.out.print("What would you like to do?"+
                    "\n1. Add an Item."+
                    "\n2. Delete an Item."+
                    "\n3. Edit Item Information."+
                    "\n4. List All Items in Specific Category."+
                    "\n5. List All Items in Library."+
                    "\n6. Add a Client."+
                    "\n7. Edit Client Information."+
                    "\n8. Delete a Client."+
                    "\n9. Lease an Item to a Client."+
                    "\n10. Return an Item from a Client."+
                    "\n11. Show All Leased Items by a Client."+
                    "\n12. Show All Leased Items."+
                    "\n13. Display the Biggest Book."+
                    "\n14. Make a Copy of Item Array."+
                    "\n15. Exit Program.\n"+
                    "\nChoice: ");
            int choice = scan.nextInt();
            scan.nextLine();


            switch (choice) {
                case 1:
                    addItem(itemArray, scan);
                    proceed(scan);
                    break;
                case 2:
                    removeItem(itemArray, scan);
                    proceed(scan);
                    break;
                case 3:
                    updateItem(itemArray, scan);
                    proceed(scan);
                    break;
                case 4:
                    listItems(itemArray, scan);
                    proceed(scan);
                    break;
                case 5:
                    listAllItems(itemArray);
                    proceed(scan);
                    break;
                case 6:
                    addClient(clientArray, scan);
                    proceed(scan);
                    break;
                case 7:
                    editClient(clientArray, scan);
                    proceed(scan);
                    break;
                case 8:
                    deleteClient(clientArray, scan);
                    proceed(scan);
                    break;
                case 9:
                    leaseToClient(clientArray, itemArray, scan);
                    proceed(scan);
                    break;
                case 10:
                    returnFromClient(clientArray, itemArray, scan);
                    proceed(scan);
                    break;
                case 11:
                    System.out.print("Enter the ID of the client: ");
                    String clientID = scan.nextLine();
                    showLeasedByClient(clientArray, scan, clientID);
                    proceed(scan);
                    break;
                case 12:
                    showAllLeased(clientArray);
                    proceed(scan);
                    break;
                case 13:
                    Book biggestBook = getBiggestBook(bookArray);
                    if (biggestBook != null)
                        System.out.println("\nThe biggest book is:\n"+biggestBook.toString());
                    else
                        System.out.print("There are no books");
                    proceed(scan);
                    break;
                case 14:
                    System.out.print("Which item category do you want to make a copy of? (Books/Journals/Media) ");
                    answer = scan.nextLine().toLowerCase();

                    char type = answer.charAt(0);
                    Items[] copiedArray = null;

                    switch (type) {
                        case 'b':
                            copiedArray = copyBooks(bookArray);
                            break;
                        case 'j':
                            copiedArray = copyBooks(journalArray);
                            break;
                        case 'm':
                            copiedArray = copyBooks(mediaArray);
                            break;
                        default:
                            System.out.println("Wrong input. Not a valid category.");
                    }
                    proceed(scan);
                    break;
                case 15:
                    System.out.println("\nThank you for using this program.");
                    valid = false;
                default:
                    System.out.println("\nNot a valid choice. Please Try again.");
            }
        }

        System.out.println("Thank you for using this program!");
    }

    /**
     * Prompts user if they want to continue/return to the menu
     * after completing a task and handles response.
     *
     * @param scan	a Scanner object used for user input
     */
    public static void proceed(Scanner scan) {
        String answer = "";
        boolean valid = true;

        while (valid) {
            System.out.print("\nWould you like to perform another task? (Y/N) ");
            answer = scan.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                System.out.println();
                return;
            } else if (answer.equalsIgnoreCase("n")) {
                valid = false;
                System.out.println("Thank you for using this program.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    /**
     * Gets the biggest book in book array by comparing number of pages in array.
     *
     * @param array	an array of Book objects
     * @return		the Book object with the largest number of pages, or null if
     * 				array is null.
     */
    public static Book getBiggestBook(Book[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Book biggestBook = array[0];

        for (int i = 1; i< array.length; i++) {
            if (array[i] != null && ((Book)array[i]).getNumberOfPages() > biggestBook.getNumberOfPages()) {
                biggestBook = array[i];
            }
        }

        return biggestBook;
    }

    /**
     * Copies non null items in original array and stores them in copy array.
     * Prints the original Array and newly copied array.
     *
     * @param originalArray	the array containing items to be copied
     * @return				the array where items will be copied to
     */
    public static Items[] copyBooks(Items[] originalArray) {
        if (originalArray == null) {
            return null;
        }

        Items[] copiedItems = new Items[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != null) {
                if (originalArray[i] instanceof Book) {
                    Book original = (Book) originalArray[i];
                    copiedItems[i] = new Book(original.getName(), original.getAuthor(), original.getYear(), original.getNumberOfPages());
                } else if (originalArray[i] instanceof Journal) {
                    Journal original = (Journal) originalArray[i];
                    copiedItems[i] = new Journal(original.getName(), original.getAuthor(), original.getYear(), original.getVolumeNumber());
                } else if (originalArray[i] instanceof Media) {
                    Media original = (Media) originalArray[i];
                    copiedItems[i] = new Media(original.getName(), original.getAuthor(), original.getYear(), original.getType());
                }
            }
        }

        System.out.println("\n---------------\nOriginal Array:\n---------------");
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != null) {
                System.out.println(originalArray[i].toString()+"\n");
            }
        }

        System.out.println("-------------\nCopied Array:\n-------------");
        for (int i = 0; i < copiedItems.length; i++) {
            if (copiedItems[i] != null) {
                System.out.println(copiedItems[i].toString()+"\n");
            }
        }

        return copiedItems;
    }

    /**
     * Adds items into Items array. Prompts user for category of item and number of items.
     * Handles user input for general information of item, and specific information,
     * depending if item is a book, journal, or media.
     *
     * @param array	the Items array in which the items will be stored
     * @param scan	a Scanner object used for user input
     */
    public static void addItem(Items[] array, Scanner scan) {
        boolean valid = false;

        while (!valid) {
            System.out.print("Which Item Category Would You Like to Add to Your Library? (Book/Journal/Media): ");
            String type = scan.nextLine();

            if (type.equalsIgnoreCase("book") || type.equalsIgnoreCase("journal") || type.equalsIgnoreCase("media")) {
                System.out.print("How many would you like to add? ");
                int amount = scan.nextInt();
                scan.nextLine();

                int count = 0;

                while (count < amount) {
                    System.out.print("\nEnter the Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter the Author: ");
                    String author = scan.nextLine();
                    System.out.print("Enter the Year of Publication: ");
                    int year = scan.nextInt();

                    scan.nextLine();

                    // If the category is book, prompts for number of pages
                    if (type.equalsIgnoreCase("book")) {
                        int pages;
                        System.out.print("Enter the Number of Pages: ");
                        pages = scan.nextInt();
                        scan.nextLine();

                        for (int i = 0; i < array.length; i++) {
                            if (array[i] == null) {
                                array[i] = new Book(title, author, year, pages);
                                bookArray[i] = (Book) array[i];
                                System.out.println("\nBook Information:\n"+((Book)array[i]).toString());
                                break;
                            }
                        }

                        // If the category is journal, prompts for volume number
                    } else if (type.equalsIgnoreCase("journal")) {
                        int volume;

                        System.out.print("Enter the Volume Number: ");
                        volume = scan.nextInt();
                        scan.nextLine();

                        for (int i = 0; i < array.length; i++) {
                            if (array[i] == null) {
                                array[i] = new Journal(title, author, year, volume);
                                journalArray[i] = (Journal) array[i];
                                System.out.println("\nJournal Information:\n"+((Journal)array[i]).toString());
                                break;
                            }
                        }

                        // If category is media, prompts for type of media
                    } else if (type.equalsIgnoreCase("media")) {
                        System.out.print("Enter the Type of Media: ");
                        String mediaType = scan.nextLine();

                        for (int i = 0; i < array.length; i++) {
                            if (array[i] == null) {
                                array[i] = new Media(title, author, year, mediaType);
                                mediaArray[i] = (Media) array[i];
                                System.out.println("\nMedia Information:\n"+((Media)array[i]).toString());
                                break;
                            }
                        }
                        break;
                    }
                    count++;
                }
                valid = true;

                // If user input does not match the categories, program will re-prompt user
            } else {
                System.out.println("Error: Invalid Item Category. Please enter 'book', 'journal', or 'media'.\n");
            }
        }
    }

    /**
     * Removes items from Items array and from their respective array (book, journal, media).
     * Takes user input and determines category of item through ID.
     *
     * @param array	the Items array in which items will be removed from
     * @param scan	a Scanner object used for user input
     */
    public static void removeItem(Items[] array, Scanner scan) {
        System.out.print("Enter the ID of the item you would like to remove: ");
        String id = scan.nextLine().toUpperCase();

        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getID().equalsIgnoreCase(id)) {
                for (int j = i; j < array.length-1; j++) {

                    // Moves up items to fill up gaps from removed item
                    array[j] = array[j+1];

                    if (array[j] instanceof Book) {
                        bookArray[j] = bookArray[j+1];
                    } else if (array[j] instanceof Journal) {
                        journalArray[j] = journalArray[j+1];
                    } else if (array[j] instanceof Media) {
                        mediaArray[j] = mediaArray[j+1];
                    }
                }

                // Makes last item in array null
                array[array.length-1] = null;

                if (array[array.length-1] instanceof Book) {
                    bookArray[bookArray.length-1] = null;
                } else if (array[array.length-1] instanceof Journal) {
                    journalArray[journalArray.length-1] = null;
                } else if (array[array.length-1] instanceof Media) {
                    mediaArray[mediaArray.length-1] = null;
                }
                found = true;
                System.out.println(id+" has been removed from the library.");
                break;
            }
        }
        if (!found)
            System.out.println(id + " has not been found.");
    }

    /**
     * Updates item in Items array. Handles user input and determines category
     * of item by ID of item. Prompts user for which information to update and
     * displays newly updated information of item.
     *
     * @param array	the Items array in which items information will be updated
     * @param scan	a Scanner object used for user input
     */
    public static void updateItem(Items[] array, Scanner scan) {
        System.out.print("Enter the ID of the item you would like update: ");
        String id = scan.nextLine().toLowerCase();
        boolean valid = false;

        while (!valid) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null && array[i].getID().equalsIgnoreCase(id)) {

                    // Displays original information of item
                    System.out.println("\n"+array[i].toString());

                    System.out.print("Which information would you like to change? ");
                    String choice = scan.nextLine().toLowerCase();

                    // Depending on choice, call setX() to update information of item
                    switch (choice) {
                        case "title":
                            System.out.print("Enter a new title: ");
                            String newTitle = scan.nextLine();
                            array[i].setName(newTitle);
                            break;
                        case "author":
                            System.out.print("Enter a new author: ");
                            String newAuthor = scan.nextLine();
                            array[i].setAuthor(newAuthor);
                            break;
                        case "year":
                            System.out.print("Enter a new year of publication: ");
                            int newYear = scan.nextInt();
                            array[i].setYear(newYear);
                            break;
                        case "number of pages":
                            if (array[i] instanceof Book) {
                                System.out.println("Enter a new number of pages: ");
                                int newPages = scan.nextInt();
                                ((Book)array[i]).setNumberOfPages(newPages);
                            } else {
                                System.out.println("This is not a book. Cannot update number of pages.");
                            }
                            break;
                        case "volume number":
                            if (array[i] instanceof Journal) {
                                System.out.println("Enter a new volume number: ");
                                int newVolume = scan.nextInt();
                                ((Journal)array[i]).setVolumeNumber(newVolume);
                            } else {
                                System.out.println("This is not a journal. Cannot update volume number.");
                            }
                            break;
                        case "type":
                            if (array[i] instanceof Media) {
                                System.out.println("Enter a new type: ");
                                String newType = scan.nextLine();
                                ((Media)array[i]).setType(newType);
                            } else {
                                System.out.println("This is not a media. Cannot update type.");
                            }
                            break;
                    }

                    // Displays updated information
                    System.out.print("Updated Information: \n");
                    System.out.println(array[i].toString());

                    valid = true;
                    return;
                }
            }
            System.out.println(id + " not found.");
            break;
        }
    }

    /**
     * Lists items of a specifiic category in Items array. Prompts user for their choice
     * of category, handles user input, and displays chosen array.
     *
     * @param array	the Items array in which items will be checked for specific category
     * @param scan	a Scanner object used for user input
     */
    public static void listItems(Items[] array, Scanner scan) {
        System.out.print("Which category of items would you like to list? (Book/Journal/Media) ");
        String choice = scan.nextLine().toLowerCase();
        boolean valid = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                switch (choice) {
                    case "book":
                        if (array[i] instanceof Book) {
                            System.out.println("\n"+((Book)array[i]).toString());
                        }
                        break;
                    case "journal":
                        if (array[i] instanceof Journal) {
                            System.out.println("\n"+((Journal)array[i]).toString());
                        }
                        break;
                    case "media":
                        if (array[i] instanceof Media) {
                            System.out.println("\n"+((Media)array[i]).toString());
                        }
                        break;
                }
                valid = true;
                return;
            }
        }
        if (!valid)
            System.out.println(choice+" is not a valid item category.");
    }

    /**
     * List all items in Items array.
     *
     * @param array the Items array in which item information will be printed from
     */
    public static void listAllItems(Items[] array) {
        boolean valid = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if(!valid) {
                    System.out.print("All items: \n");
                    valid = true;
                }
                System.out.println("\n"+ array[i].toString());
            }
        }
        if (!valid)
            System.out.println("There are no items in the library.");

    }

    /**
     * Adds client into Clients array. Prompts user for amount of clients
     * to add and information for each client.
     *
     * @param array	the Client array in which clients will be stored in
     * @param scan	a Scanner object used for user input
     */
    public static void addClient(Client[] array, Scanner scan) {

        System.out.print("How many clients would you like to add? ");
        int amount = scan.nextInt();
        scan.nextLine();

        int count = 0;

        // Repeats until desired number of clients are entered
        while (count < amount) {
            System.out.print("\nEnter the name of the client: ");
            String name = scan.nextLine();
            System.out.print("Enter the phone number: ");
            String phoneNumber = scan.nextLine();
            System.out.print("Enter the email address: ");
            String email = scan.nextLine();

            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = new Client(name, phoneNumber, email);
                    System.out.println("\nClient Information: \n"+array[i].toString());
                    break;
                }
            }
            count++;
        }
    }

    /**
     * Edits client information in Client array. Prompts user and handles user
     * input for which information to update. Displays newly update information of client.
     *
     * @param array	the Client array in which clients information will be edited
     * @param scan	a Scanner object used for user input
     */
    public static void editClient(Client[] array, Scanner scan) {
        boolean valid = false;
        System.out.print("Enter the ID of the client you would like edit: ");
        String id = scan.nextLine();

        while (!valid) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null && array[i].getID().equalsIgnoreCase(id)) {

                    // Display original information of client
                    System.out.println("\n"+array[i].toString());

                    // Depending on choice, call setX() to update information of item
                    System.out.print("\nWhich information would you like to change? ");
                    String choice = scan.nextLine();

                    if (choice.equalsIgnoreCase("name")) {
                        System.out.print("Enter a new name: ");
                        String newName = scan.nextLine();
                        ((Client)array[i]).setName(newName);
                    }
                    else if (choice.equalsIgnoreCase("phone number")) {
                        System.out.print("Enter a new phone number: ");
                        String newPhoneNumber = scan.nextLine();
                        ((Client)array[i]).setPhoneNumber(newPhoneNumber);
                    }
                    else if (choice.equalsIgnoreCase("email address")) {
                        System.out.print("Enter a new email address: ");
                        String newEmail = scan.nextLine();
                        ((Client)array[i]).setEmail(newEmail);
                    }

                    // Displays updated information
                    System.out.print("The updated information:\n");
                    System.out.println(((Client)array[i]).toString());

                    valid = true;
                    return;
                }
            }
            System.out.println(id + " not found.");
            break;
        }

    }

    /**
     * Deletes client from Client array. Handles user input to determine
     * which client to remove.
     *
     * @param array	the Client array in which clients will be deleted from
     * @param scan	a Scanner object used for user input
     */
    public static void deleteClient(Client[] array, Scanner scan) {
        System.out.print("Enter the ID of the client you would like to remove: ");
        String id = scan.nextLine();

        boolean found = false;


        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && ((Client)array[i]).getID().equalsIgnoreCase(id)) {

                array[i] = null;
                found = true;
                System.out.println("Client "+id+" has been deleted.");
                break;
            }
        }
        if (!found)
            System.out.println("Client "+id + " has not been found.");
    }

    /**
     * Leases items from Items array to clients in Client array. Prompts user for ID
     * of item and client to lease to and handles information through leaseItem(Items) from Client class.
     *
     * @param clients	the Client array in which items will be leased to
     * @param items		the Items array in which items will be leased from
     * @param scan		a Scanner object used for user input
     */
    public static void leaseToClient(Client[] clients, Items[] items, Scanner scan) {
        boolean validItem = false;
        boolean validClient = false;

        System.out.print("Enter the ID of the item to be leased: ");
        String itemID = scan.nextLine();
        System.out.print("Enter the ID of the client that is leasing the item: ");
        String clientID = scan.nextLine();

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getID().equalsIgnoreCase(itemID)) {
                validItem = true;
                for (int j = 0; j< clients.length; j++) {
                    if (clients[j] != null && clients[j].getID().equalsIgnoreCase(clientID)) {
                        validClient = true;
                        clients[j].leaseItem(items[i]);
                        System.out.println(itemID+" was leased to "+clientID);
                        return;
                    }
                }
                break;
            }
        }
        if (!validItem)
            System.out.println("Item "+itemID+" not found.");

        if (!validClient)
            System.out.println("Client "+clientID+" not found.");

    }

    /**
     * Returns items from clients in Client array, such that it gets removed from
     * leasedItems array. Prompts user for ID of client and item and handles
     * information through returnItems(Item) from Client class.
     *
     * @param clients	the Client array in which item will be returned from
     * @param items		the Items array in which item ID will be checked for availability in array
     * @param scan		a Scanner object used for user input
     */
    public static void returnFromClient(Client[] clients, Items[] items, Scanner scan) {
        boolean validItem = false;
        boolean validClient = false;

        System.out.print("Enter the ID of the client: ");
        String clientID = scan.nextLine();

        showLeasedByClient(clients, scan, clientID);

        System.out.print("Enter the ID of the item to be returned: ");
        String itemID = scan.nextLine();

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getID().equalsIgnoreCase(itemID)) {
                validItem = true;
                for (int j = 0; j< clients.length; j++) {
                    if (clients[j] != null && clients[j].getID().equalsIgnoreCase(clientID)) {
                        validClient = true;
                        clients[j].returnItem(items[i]);
                        return;
                    }
                }
                break;
            }
        }
        if (!validItem)
            System.out.println(itemID+" not found.");
        if (!validClient)
            System.out.println("Client "+clientID+" not found.");

    }

    /**
     * Shows leased items by specific client in Client array. Evaluates clientID
     * entered by user and checks if leasedItems array of client has items.
     * Displays all leased items.
     *
     * @param clients	the Client array in which clients will be checked using clientID
     * @param scan		a Scanner object used for user input
     * @param clientID	a String for client ID
     */
    public static void showLeasedByClient(Client[] clients, Scanner scan, String clientID) {
        boolean valid = false;

        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getID().equalsIgnoreCase(clientID)) {
                valid = true;
                clients[i].showLeased();

                // If user has no leased items
                if (clients[i].getLeasedItems().length == 0) {
                    System.out.println(clientID+" does not have any leased items.");
                }
                break;
            }
        }
        if (!valid)
            System.out.println(clientID+" not found.");
    }

    /**
     * Shows total leased items by all clients in Client array.
     *
     * @param clients	the Client array in which information for leased items will be printed
     * 					from using getLeasedItems() method
     */
    public static void showAllLeased(Client[] clients) {
        boolean valid = false;


        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getLeasedItems() != null && clients[i].getLeasedItems().length >0) {
                if(!valid) {
                    System.out.println("\nAll Leased Items: ");
                    valid = true;
                }
                clients[i].showLeased();
            }
        }
        if (!valid)
            System.out.println("There are no items leased at the moment.");
    }
}
