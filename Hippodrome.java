package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    Hippodrome (List <Horse> horses){
        this.horses = horses;
    }

    public List getHorses(){
        return horses;
    }

    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int max = Integer.MIN_VALUE;
        Horse tempHorse = null;
        for (Horse horse : horses) {
            if (max < horse.getDistance()) {
                max = (int) horse.getDistance();
                tempHorse = horse;
            }
        }
        return tempHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List <Horse> horses = new ArrayList<>();
        horses.add(new Horse ("Sivka", 3, 0));
        horses.add(new Horse ("Burca", 3, 0));
        horses.add(new Horse ("Kaurka", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
