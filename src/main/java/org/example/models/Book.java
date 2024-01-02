package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.enums.CoverType;
import org.example.models.enums.PaperType;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book extends BaseModel {
    private String title;
    private String author;
    private String publisher;
    private String edition;
    private String format;
    private String isbn;
    private Long numberOfPages;
    private CoverType coverType;
    private PaperType paperType;

    @Override
    public String toString() {
        return
                "  title         : " + title + " \n " +
                " author        : " + author + " \n " +
                " publisher     : " + publisher + " \n " +
                " edition       : " + edition + " \n " +
                " format        : " + format + " \n " +
                " isbn          : " + isbn + " \n " +
                " numberOfPages : " + numberOfPages + " \n " +
                " coverType     : " + coverType + " \n " +
                " paperType     : " + paperType +"\n";
    }
}
