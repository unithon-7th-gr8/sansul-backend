package org.uniton.gr8.sansulbackend.domain;

public enum TagType {
    LATE(0);

    private final int value;

    TagType(int value) {
        this.value = value;
    }

    public static TagType valueOf(int value){
        switch (value){
            case 0: return LATE;
            default: throw new IllegalStateException(value + "는 TagType이 아닙니다.");
        }
    }

    public int intValue(){
        return this.value;
    }
}
