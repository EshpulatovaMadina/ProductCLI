package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.enums.PaperType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Poster extends BaseModel{
    private String title;
    private String message;
    private String graphics;
    private String images;
    private String size; //2.5x4
    private PaperType paperType;

    @Override
    public String toString() {
        return
                "  title    : " + title + "  \n" +
                " message  : " + message + "  \n" +
                " graphics : " + graphics + "  \n" +
                " images   : " + images + "  \n" +
                " size     : " + size + "  \n" +
                " paperType : " + paperType;
    }
}
