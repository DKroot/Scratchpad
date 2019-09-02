package org.houseofsoft.katas;
import java.util.Arrays;

/**
 * 100 doors in a row are all initially closed. You make 100 passes by the doors. The first time through, you visit
 * every door and toggle the door (if the door is closed, you open it; if it is open, you close it). The second time you
 * only visit every 2nd door (door #2, #4, #6, ...). The third time, every 3rd door (door #3, #6, #9, ...), etc, until
 * you only visit the 100th door.
 * 
 * Question: What state are the doors in after the last pass? Which are open, which are closed?
 * 
 * [Source http://rosettacode.org]
 */
public class HundredDoorsHall {
    public static final boolean CLOSED = false;
    public static final boolean OPEN = true;

    public boolean[] doors = new boolean[100];

    public HundredDoorsHall() {
        Arrays.fill(doors, CLOSED);
    }

    public boolean isDoorOpen(int doorNumber) {
        return doors[doorNumber - 1] == OPEN;
    }

    public void pass100Times() {
        for (int pass = 1; pass <= 100; pass++) {
            for (int i = pass; i <= doors.length; i = i + pass) {
                doors[i - 1] = !doors[i - 1];
            }
        }
    }
}
