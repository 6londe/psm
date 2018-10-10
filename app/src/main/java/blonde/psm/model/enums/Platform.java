package blonde.psm.model.enums;

public enum Platform {

    VITA(1),
    VR(2),
    PS3(3),
    PS4(4),
    MINI(11),
    ONE(12),
    PSP(13);

    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
