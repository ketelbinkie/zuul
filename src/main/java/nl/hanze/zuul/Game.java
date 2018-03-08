package nl.hanze.zuul;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        createPlayer();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, transporterroom;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        transporterroom = new TransporterRoom("in the transporterroom, prepare for magic!", new Room[]{outside, theater, pub, lab, office});

        // create the items
        Book book1 = new Book("Ssst!","Een hele mooie omschrijving",750, 375);
        Book book2 = new Book("BlueJ", "Programmeren in Java met BlueJ", 1575, 664);
        Phone iphone6 = new Phone("iphone6", "super telefoon", 1275, "Dark gray",64);
        Phone iphone6s = new Phone("iphone6s", "super telefoon", 1275, "Dark gray",64);
        Flashlight maglite = new Flashlight("maglite", "super awesome flashlight", 500, 600);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", transporterroom);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        // initialise the room items
        outside.setItem(iphone6.getName(), iphone6);
        outside.setItem(iphone6s.getName(), iphone6s);

        theater.setItem(book1.getName(), book1);
        theater.setItem(book2.getName(), book2);

        pub.setItem(maglite.getName(), maglite);

        currentRoom = outside;  // start game outside
    }

    private void createPlayer(){
        player = new Player("Henk");
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    private void play()
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(player.getName()+", "+player.getBackpack().getDescriptionOfItemInTheBackpack());
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case PICK:
                pickItem(command);
                break;

            case DROP:
                dropItem(command);
                break;
            case SHOW:
                showItem();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            default:
                System.out.println("Make your choice.......");
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void pickItem(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to pick...
            System.out.println("Which item to pick?");
            return;
        }

        String itemName = command.getSecondWord();

        Item itemToPick = currentRoom.getItem(itemName);

        if(itemToPick == null){
            System.out.println("There is no item '"+ itemName +"' in this room");
        }
        else {
            if(itemToPick.getCanBePickedUp()){

                player.getBackpack().addItemToBackPack(itemName,itemToPick);
//                fjallraven.addItemToBackPack(itemName, itemToPick);
                currentRoom.removeItem(itemName);


            }else {
                System.out.println("Item '"+itemToPick.getName()+"' cannot be picked!");
            }
        }
    }

    private void dropItem(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to pick...
            System.out.println("Which item to drop?");
            return;
        }

        String itemName = command.getSecondWord();

//        Item itemToDrop = fjallraven.getItemOfBackPack(itemName);
        Item itemToDrop = player.getBackpack().getItemOfBackPack(itemName);

        if(itemToDrop == null){
            System.out.println("There is no item '"+ itemName +"' in the backpack");
        }
        else {
//                fjallraven.removeItemOutBackPack(itemName);
                player.getBackpack().removeItemOutBackPack(itemName);
                currentRoom.setItem(itemName, itemToDrop);
            }
    }

    private void showItem(){
        System.out.println(player.getBackpack().getDescriptionOfItemInTheBackpack());
//        System.out.println(fjallraven.getDescriptionOfItemInTheBackpack());
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Run the game.
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        new Game().play();
    }
}
