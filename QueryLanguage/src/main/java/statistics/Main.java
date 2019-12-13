package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder qb = new QueryBuilder();
//        Matcher m = qb.hasAtLeast(5, "goals").hasAtLeast(5, "assists").playsIn("PHI").build();

        Matcher m = qb.or(
            qb.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(8, "goals").build(),

            qb.playsIn("EDM")
                .hasAtLeast(20, "points").build()
        ).build();


        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}