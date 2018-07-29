package org.uniton.gr8.sansulbackend.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomStatusTest {
    @Test
    public void testStatusFactoryMethod() {
        // given

        // when

        // then
        assertEquals(RoomStatus.OPEN, RoomStatus.valueOf(1));
        assertEquals(RoomStatus.CLOSED, RoomStatus.valueOf(2));
    }
}
