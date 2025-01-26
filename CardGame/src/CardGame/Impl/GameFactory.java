package CardGame.Impl;

import CardGame.Api.*;
import java.util.*;

public class GameFactory {
    private static final List<String> BELOTE_CARDS = Arrays.asList(
            "7", "8", "9", "10", "J", "Q", "K", "A"
    );
    private static final List<String> SANTASE_CARDS = Arrays.asList(
            "9", "10", "J", "Q", "K", "A"
    );

    public static Game createGame(String gameName, List<Card> initialCards) {
        Deck deck;
        ArrayList<Operation> operations = new ArrayList<>();

        switch (gameName) {
            case "War":
                if (!areWarCardsValid(initialCards)) {
                    throw new IllegalArgumentException("ERROR: Not enough cards for War");
                }
                deck = DeckFactory.createWarDeck(initialCards);
                break;
            case "Belote":
                if (!areBeloteCardsValid(initialCards)) {
                    throw new IllegalArgumentException("ERROR: Not enough cards for Belote");
                }
                deck = DeckFactory.createBeloteDeck(initialCards);
                break;
            case "Santase":
                if (!areSantaseCardsValid(initialCards)) {
                    throw new IllegalArgumentException("ERROR: Not enough cards for Santase");
                }
                deck = DeckFactory.createSantaseDeck(initialCards);
                break;
            case "quit":
                return null;
            default:
                throw new IllegalArgumentException("ERROR: Unknown game");
        }

        GameImpl game = new GameImpl(deck);
        game.addOperation(new Size(game));
        game.addOperation(new DrawTopCard(game));
        game.addOperation(new DrawBottomCard(game));
        game.addOperation(new TopCard(game));
        game.addOperation(new BottomCard(game));
        game.addOperation(new Shuffle(game));
        game.addOperation(new Sort(game));
        game.addOperation(new Deal(game));

        return game;
    }


    ///Tezi implementacii sa po-tupiq case kogato se preglejda celiqt
    ///podaden list ot karti a ne samo purvite 24, 32 ili 52.
    ///poneje razbrah che trqbvalo da se proverqvat samo purvite 24, 32 ili 52
    ///gi ostavih zakomentirano.
    ///napisah versii na metodite, koito proverqvat samo purvite
//    private static boolean areBeloteCardsValid(List<Card> cards) {
//        Map<String, Set<String>> cardMap = new HashMap<>();
//
//        cards.stream()
//                .filter(card -> BELOTE_CARDS.contains(card.getRank().getValue()))
//                .forEach(card -> {
//                    cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
//                    cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
//                });
//
//        for (String rank : BELOTE_CARDS) {
//            if (!cardMap.containsKey(rank) || cardMap.get(rank).size() != 4) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static boolean areSantaseCardsValid(List<Card> cards) {
//        Map<String, Set<String>> cardMap = new HashMap<>();
//
//        cards.stream()
//                .filter(card -> SANTASE_CARDS.contains(card.getRank().getValue()))
//                .forEach(card -> {
//                    cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
//                    cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
//                });
//
//        for (String rank : SANTASE_CARDS) {
//            if (!cardMap.containsKey(rank) || cardMap.get(rank).size() != 4) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static boolean areWarCardsValid(List<Card> cards) {
//        Map<String, Set<String>> cardMap = new HashMap<>();
//
//        cards.forEach(card -> {
//            cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
//            cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
//        });
//
//        for (Rank rank : Rank.values()) {
//            if (!cardMap.containsKey(rank.getValue()) || cardMap.get(rank.getValue()).size() != 4) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    private static boolean areBeloteCardsValid(List<Card> cards) {
        if (cards.size() < 32) {
            return false;
        }

        Map<String, Set<String>> cardMap = new HashMap<>();
        cards.subList(0, 32).stream()
                .filter(card -> BELOTE_CARDS.contains(card.getRank().getValue()))
                .forEach(card -> {
                    cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
                    cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
                });

        for (String rank : BELOTE_CARDS) {
            if (!cardMap.containsKey(rank) || cardMap.get(rank).size() != 4) {
                return false;
            }
        }

        return true;
    }

    private static boolean areSantaseCardsValid(List<Card> cards) {
        if (cards.size() < 24) {
            return false;
        }

        Map<String, Set<String>> cardMap = new HashMap<>();
        cards.subList(0, 24).stream()
                .filter(card -> SANTASE_CARDS.contains(card.getRank().getValue()))
                .forEach(card -> {
                    cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
                    cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
                });

        for (String rank : SANTASE_CARDS) {
            if (!cardMap.containsKey(rank) || cardMap.get(rank).size() != 4) {
                return false;
            }
        }

        return true;
    }

    private static boolean areWarCardsValid(List<Card> cards) {
        if (cards.size() < 52) {
            return false;
        }

        Map<String, Set<String>> cardMap = new HashMap<>();
        cards.subList(0, 52).forEach(card -> {
            cardMap.putIfAbsent(card.getRank().getValue(), new HashSet<>());
            cardMap.get(card.getRank().getValue()).add(card.getSuit().name());
        });

        for (Rank rank : Rank.values()) {
            if (!cardMap.containsKey(rank.getValue()) || cardMap.get(rank.getValue()).size() != 4) {
                return false;
            }
        }

        return true;
    }
}