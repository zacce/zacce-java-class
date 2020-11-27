package sakkesoft.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        package sakkesoft.com;

        LinkedList<String> songs = new LinkedList<String>();
        addInOrder(songs, "Carry on the wayward son");


        Song song = new Song("Carry on the wayward son", 5.45);

    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newSong) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newSong);
            if (comparison == 0) {
                // equal , do not add
                System.out.println(newSong + " is already included in catalog");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newSong);
                return true;
            } else if (comparison < 0) {
                // move on next city

            }
        }
        stringListIterator.add(newSong);
        return true;

    }

    private static void play(LinkedList songs) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = false;
        ListIterator<String> listIterator = songs.listIterator();

        if (songs.isEmpty()) {
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday Vacation Over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the catalog");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the catalog");
                        goingForward = true;
                    }
                case 3:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - print menu options");

    }

}
