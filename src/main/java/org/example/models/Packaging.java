package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Packaging extends BaseModel {
    private String productName;
    private String brandName;
    private String size;
    private String shape;
    private String color;
    private String material;
    private String graphics;
    private String text;

    @Override
    public String toString() {
        return
                "  productName : " + productName + " \n " +
                " brandName   : " + brandName + " \n " +
                " size        : " + size + " \n " +
                " shape       : " + shape + " \n " +
                " color       : " + color + " \n " +
                " material    : " + material + " \n " +
                " graphics    : " + graphics + " \n " +
                " text        : " + text + " \n ";
    }
}
