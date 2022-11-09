package fr.arolla;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyClassTest {
    String [] packet;
    String [] packetOneCandy;
    String [] packetThreeCandy;
    String [] packetBomb;
    String [][] candyBag;
    Halloween halloween;

    @BeforeEach
    public void setup() {
        packet = new String[]{"candy", "candy"};
        packetOneCandy = new String[]{"candy"};
        packetThreeCandy = new String[]{"candy", "candy", "candy"};
        packetBomb = new String[]{"candy", "bomb", "candy"};
        candyBag = new String[][]{packet};
        halloween = new Halloween();
    }

    @Test
    public void oneChildHaveOnePacket() {
        String message = halloween.trickOrTreat(1,candyBag);
        Assertions.assertEquals("Thank you, strange uncle!", message);
    }

    @Test
    public void TwoChildrenHaveTwoPackets() {
        String message = halloween.trickOrTreat(2,candyBag);
        Assertions.assertEquals("Trick or treat!", message);
    }

    @Test
    public void eachChildrenHaveAtleastOnePacket() {
        String message = halloween.trickOrTreat(4,new String[][]{packet, packet, packet, packet});
        Assertions.assertEquals("Thank you, strange uncle!", message);
    }

    @Test
    public void eachPacketContainsTwoCandies() {
        String message = halloween.trickOrTreat(3,new String[][]{packet, packet, packetOneCandy});
        Assertions.assertEquals("Trick or treat!", message);
    }

    @Test
    public void aBombInPacketShouldReturnTrickOrTreat() {
        String message = halloween.trickOrTreat(2,new String[][]{packet, packetBomb});
        Assertions.assertEquals("Trick or treat!", message);
    }

    @Test
    public void eachChildGetSameAmountOfCandy() {
        String message = halloween.trickOrTreat(2,new String[][]{packet, packetThreeCandy});
        Assertions.assertEquals("Trick or treat!", message);
    }


}
