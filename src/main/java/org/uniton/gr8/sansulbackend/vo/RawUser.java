package org.uniton.gr8.sansulbackend.vo;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class RawUser {

    private String name;
    private int roomId;
    private List<String> tags;
}
