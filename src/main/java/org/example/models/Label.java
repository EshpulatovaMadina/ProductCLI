package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Label extends BaseModel {
    private String productName;
    private String brandName;
    private String description;
    private String size;
    private String shape;
    private String color;
    private String material;

    @Override
    public String toString() {
        return
                "  prodcutName : " + productName + " \n " +
                " brandName   : " + brandName + " \n " +
                " description : " + description + " \n " +
                " size        : " + size + " \n " +
                " shape       : " + shape + " \n " +
                " color       : " + color + " \n " +
                " material    : " + material;
    }
}
