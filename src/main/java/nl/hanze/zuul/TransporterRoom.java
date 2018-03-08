package nl.hanze.zuul;

import java.util.Random;

public class TransporterRoom extends Room {

    private Room[] rooms;
    private Random random;

    /**
     * Constructor for objects of class TransporterRoom
     */

    public TransporterRoom(String description, Room[] rooms) {
        super(description);
        setExit("surpriseroom", this);
        this.rooms = rooms;
        random = new Random();
    }

    /**
     * Overrided - Exit from TransporterRoom.
     * param  direction Ignored
     */
    public Room getExit(String direction) {

        return rooms[random.nextInt(rooms.length)];
    }
}
