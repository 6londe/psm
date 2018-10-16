package blonde.psm.model.enums;

public enum Platform {

    VITA(0),
    MINI(1),
    ONE(2),
    PSP(3),
    VR(4),
    PS3(5),
    PS4(6);


    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
