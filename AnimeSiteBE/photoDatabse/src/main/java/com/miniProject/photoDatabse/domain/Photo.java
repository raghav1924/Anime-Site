package com.miniProject.photoDatabse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "photos")
public class Photo {
    @Id
    private String id;
    private String animeName,type,lang,releaseData,genre,director,rating,descp;
    @Lob
    private byte[] image;
}
