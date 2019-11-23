package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;


    private String[] scores_even={"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
    private String[] scores_advantage ={"Win for player2", "Advantage player2",null, "Advantage player1","Win for player1"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        // if game is tied
        if (player1Score==player2Score){
            return scores_even[player1Score < 4 ? player1Score : 4]; // return value of default "deuce"
        }
        // if game isnt tied and points tally has reached 4
        else if (player1Score>=4 || player2Score>=4)
        {
            // cap results and map them to array
            int delta = player1Score-player2Score;
            delta = Math.min(delta,2);
            delta = Math.max(delta,-2);
            return scores_advantage[delta+2]; // index from 0
        }
        // otherwise game round running as usual and just use lookup tables
        else
        {
            return scores[player1Score]+"-"+scores[player2Score];
        }
    }
}