package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.enums.PaperType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brochure extends BaseModel {
    private String title;
    private String description;
    private String targetAudience;
    private String size;
    private PaperType paperType;
    private String graphics;
    private String images;

    @Override
    public String toString() {
        return
                "  title          : " + title + " \n " +
                " description    : " + description + " \n " +
                " targetAudience : " + targetAudience + " \n " +
                " size           : " + size + " \n " +
                " paperType      : " + paperType + " \n " +
                " graphics       : " + graphics + " \n " +
                " images         : " + images;
    }
}
