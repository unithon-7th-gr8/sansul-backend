package org.uniton.gr8.sansulbackend.vo;

import lombok.NonNull;
import lombok.Value;

import javax.validation.Valid;
import java.util.List;

@Value
public class RawUser {

    @NonNull private String name;
    @NonNull private int roomId;
    @NonNull private List<String> tags;
}
