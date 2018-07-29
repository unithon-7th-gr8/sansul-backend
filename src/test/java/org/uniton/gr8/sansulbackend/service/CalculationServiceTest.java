package org.uniton.gr8.sansulbackend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.uniton.gr8.sansulbackend.dto.Tag;
import org.uniton.gr8.sansulbackend.dto.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceTest {
    private CalculationService calculationService = new CalculationService();

    @Test
    public void testGetDiscountRatio() {
        // given
        int totalPrice = 193000;
        List<User> users = Arrays.asList(
                createUser(0),
                createUser(0),
                createUser(0),
                createUser(0),

                createUser(0.2),
                createUser(0.2),
                createUser(0.2),

                createUser(0.2),
                createUser(0.2),
                createUser(0.2),

                createUser(0.2),
                createUser(0.2),
                createUser(0.2));
        // when
        int result = calculationService.calculateNormalPrice(users, totalPrice);
        // then
        assertEquals(17232, result);
    }

    @Test
    public void test() {
        // given
        User user1 = createUser(0);
        User user2 = createUser(0.1);
        User user3 = createUser(0.2);
        User user4 = createUser(0.3);
        User user5 = createUser(0.4);
        User user6 = createUser(0.5);
        User user7 = createUser(0.6);
        User user8 = createUser(0.7);
        User user9 = createUser(0.8);
        User user10 = createUser(0.9);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        int totalPrice = 5500;

        // when
        int result = calculationService.calculateNormalPrice(users, totalPrice);

        // then
        assertEquals(1000, calculationService.calculateBilledPrice(user1, result));
        assertEquals(900, calculationService.calculateBilledPrice(user2, result));
        assertEquals(800, calculationService.calculateBilledPrice(user3, result));
        assertEquals(700, calculationService.calculateBilledPrice(user4, result));
        assertEquals(600, calculationService.calculateBilledPrice(user5, result));
        assertEquals(500, calculationService.calculateBilledPrice(user6, result));
        assertEquals(400, calculationService.calculateBilledPrice(user7, result));
        assertEquals(300, calculationService.calculateBilledPrice(user8, result));
        assertEquals(199, calculationService.calculateBilledPrice(user9, result));
        assertEquals(99, calculationService.calculateBilledPrice(user10, result));
    }

    private User createUser(double ratio) {
        return User.builder()
                   .tags(Collections.singletonList(createTag(ratio)))
                   .build();
    }

    private Tag createTag(double ratio) {
        Tag tag = new Tag();
        tag.setRatio(ratio);
        return tag;
    }
}
