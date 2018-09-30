package blonde.psm.enums;

import blonde.psm.R;

public enum Platform {

    // MINI(11), ONE(12), PSP(13),
    VITA(1), VR(2), PS3(3), PS4(4);

    private final int value;

    Platform(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getRawId() {
        switch(this) {
            case VITA:
                return R.raw.vita;
            case VR:
                return R.raw.vr;
            case PS3:
                return R.raw.ps3;
            case PS4:
                return R.raw.ps4;
            default:
                return -1;
        }
    }
}
