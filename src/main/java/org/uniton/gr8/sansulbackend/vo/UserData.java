package org.uniton.gr8.sansulbackend.vo;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class UserData {

    private int userId;
    private String name;
    private List<String> tags;
}
