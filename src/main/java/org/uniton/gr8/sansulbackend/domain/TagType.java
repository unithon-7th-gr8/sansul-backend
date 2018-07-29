package org.uniton.gr8.sansulbackend.domain;

public enum TagType {
    LATE(1), NO_DRINK(2), EARLY(3), NO_EAT(4), PASS(5);

    private final int value;

    TagType(int value) {
        this.value = value;
    }

    public static TagType valueOf(int value){
        switch (value){
            case 1: return LATE;
            case 2: return NO_DRINK;
            case 3: return EARLY;
            case 4: return NO_EAT;
            case 5: return PASS;
            default: throw new IllegalStateException(value + "는 TagType이 아닙니다.");
        }
    }

    public int intValue(){
        return this.value;
    }
}
