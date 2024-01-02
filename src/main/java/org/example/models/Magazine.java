package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.enums.CoverType;
import org.example.models.enums.PaperType;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Magazine extends BaseModel {
    private String title;
    private String publisher;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM.dd.yyyy")
    private LocalDate issueDate;
    private String format;
    private Long numberOfPages;
    private CoverType coverType;

    private PaperType paperType;

    @Override
    public String toString() {
        return
                "  title         : " + title + " \n " +
                " publisher     : " + publisher + " \n " +
                " issueDate     : " + issueDate + " \n " +
                " format        : " + format + " \n " +
                " numberOfPages : " + numberOfPages + " \n " +
                " coverType     : " + coverType + " \n " +
                " paperType     : " + paperType;
    }
}
