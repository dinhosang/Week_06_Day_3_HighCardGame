public class Card {


    private Suit suit;
    private Rank rank;


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }


    public String getRankString() {
        String rankStringUpperCase;
        int rankStringLength;
        String rankStringCapitalised;

        rankStringUpperCase = this.rank.toString();
        rankStringLength = rankStringUpperCase.length();
        rankStringCapitalised = rankStringUpperCase.substring(0,1) + rankStringUpperCase.substring(1, rankStringLength).toLowerCase();
        return rankStringCapitalised;
    }

    public String getSuitString() {
        String suitStringUpperCase;
        int suitStringLength;
        String suitStringCapitalised;

        suitStringUpperCase = this.suit.toString();
        suitStringLength = suitStringUpperCase.length();
        suitStringCapitalised = suitStringUpperCase.substring(0,1) + suitStringUpperCase.substring(1, suitStringLength).toLowerCase();
        return suitStringCapitalised;
    }
}

