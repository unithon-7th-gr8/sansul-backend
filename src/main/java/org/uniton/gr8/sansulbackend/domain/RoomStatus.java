package org.uniton.gr8.sansulbackend.domain;

import java.util.stream.Stream;

public enum RoomStatus {
    OPEN(1), CLOSED(2), FINISH(3);

    private int value;

    RoomStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoomStatus valueOf(int value) {
        return Stream.of(RoomStatus.values())
                     .filter(status -> status.value == value)
                     .findFirst()
                     .orElseThrow(IllegalStateException::new);
    }
}
