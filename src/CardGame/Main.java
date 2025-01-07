package CardGame;

import CardGame.Api.*;
import CardGame.Impl.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static Game game = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Card> initialCards = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String[] cardStrings = scanner.nextLine().split(" ");
            for (String cardString : cardStrings) {
                initialCards.add(parseCard(cardString));
            }
        }

        while (true) {
            System.out.println("Enter game type (War, Belote, Santase):");
            String gameName = scanner.nextLine().trim();
            try {
                game = GameFactory.createGame(gameName, initialCards);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (game == null) {
                break;
            }

            while (true) {
                System.out.println("Enter operation (deal, draw_top_card, draw_bottom_card, top_card, bottom_card, shuffle, sort, quit):");
                String operation = scanner.nextLine().trim();
                if (operation.equals("quit")) {
                    break;
                }
                try {
                    game.processOperation(operation);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static Card parseCard(String cardString) {
        if (cardString.length() < 2 || cardString.length() > 3) {
            throw new IllegalArgumentException("Invalid card format: " + cardString);
        }

        Rank rank;
        Suit suit = parseSuit(cardString.charAt(0));

        if (cardString.length() == 3) {
            if (cardString.substring(1).equals("10")) {
                rank = Rank.TEN;
            } else {
                throw new IllegalArgumentException("Invalid rank: " + cardString.substring(1));
            }
        } else {
            rank = parseRank(cardString.charAt(1));
        }

        return new CardImpl(rank, suit);
    }

    private static Suit parseSuit(char suitChar) {
        switch (suitChar) {
            case 'S':
                return Suit.SPADES;
            case 'H':
                return Suit.HEARTS;
            case 'D':
                return Suit.DIAMONDS;
            case 'C':
                return Suit.CLUBS;
            default:
                throw new IllegalArgumentException("Invalid suit character: " + suitChar);
        }
    }

    private static Rank parseRank(char rankChar) {
        switch (rankChar) {
            case '2':
                return Rank.TWO;
            case '3':
                return Rank.THREE;
            case '4':
                return Rank.FOUR;
            case '5':
                return Rank.FIVE;
            case '6':
                return Rank.SIX;
            case '7':
                return Rank.SEVEN;
            case '8':
                return Rank.EIGHT;
            case '9':
                return Rank.NINE;
            case '1':
                return Rank.TEN;
            case 'J':
                return Rank.JACK;
            case 'Q':
                return Rank.QUEEN;
            case 'K':
                return Rank.KING;
            case 'A':
                return Rank.ACE;
            default:
                throw new IllegalArgumentException("Invalid rank: " + rankChar);
        }
    }
}