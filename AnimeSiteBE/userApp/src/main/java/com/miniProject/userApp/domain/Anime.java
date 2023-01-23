package com.miniProject.userApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anime {
    private String animeName;
//    private byte[] image;
}
