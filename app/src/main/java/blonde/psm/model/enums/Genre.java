package blonde.psm.model.enums;

public enum Genre {

    ACTION(0),
    ADVENTURE(1),
    ARCADE(2),
    BOARDGAME(3),
    CASUAL(4),
    FAMILY(5),
    FIGHTING(6),
    HORROR(7),
    MUSIC(8),
    PARTY(9),
    PUZZLE(10),
    RACING(11),
    RPG(12),
    SHOOTER(13),
    SIMULATION(14),
    SIMULATOR(15),
    SPORTS(16),
    STRATEGY(17),
    UNIQUE(18);

    private final int value;

    Genre(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
