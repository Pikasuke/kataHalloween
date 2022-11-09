package fr.arolla;

import java.util.Arrays;

public class Halloween {

    public String trickOrTreat(int nbChildren, String[][] candyBag) {
        if (candyBag.length < nbChildren) {
            return "Trick or treat!";
        }
        for (String[] packet : candyBag){
           if (candyCounter(packet) < 2 || Arrays.asList(packet).contains("bomb") ||
                   candyCounter(candyBag[0]) != candyCounter(packet)) {
               return "Trick or treat!";
            }
        }
        return "Thank you, strange uncle!";
    }

    private static long candyCounter(String[] packet) {
        return Arrays.stream(packet).filter(c -> c.equals("candy")).count();
    }

}
