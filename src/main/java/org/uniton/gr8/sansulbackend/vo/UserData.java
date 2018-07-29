package org.uniton.gr8.sansulbackend.vo;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class UserData {

    private int userId;
    private String name;
    private int billedPrice;
    private boolean isPaid;
    private int roomId;
    private List<String> tags;
}
