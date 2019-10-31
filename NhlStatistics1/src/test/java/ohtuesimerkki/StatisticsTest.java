package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void existingPlayerIsFound(){
        Player p = stats.search("Semenko");
        assertEquals(p.getName(),"Semenko");
    }

    @Test
    public void nonExistingPlayerReturnsNull(){
        Player p = stats.search("SSemenko");
        assertEquals(p,null);
    }

    @Test
    public void getTeamMembers(){
        List<Player> roster = stats.team("EDM");
        assertEquals(roster.size(), 3);
    }

    @Test
    public void getTopScorers(){
        List<Player> scorers = stats.topScorers(2);
        assertEquals(scorers.size(), 2);
    }

}

