package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.enums.PaperType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Business_card extends BaseModel {
    private String name;
    private String jobTitle;
    private String company_name;
    private String logo;
    private String contactInfo;
    private String size; //3.5 inch by 2 inch. 3.5x2
    private PaperType paperType;

    @Override
    public String toString() {
        return
                "  name         : " + name + " \n " +
                " jobTitle     : " + jobTitle + " \n " +
                " company_name : " + company_name + " \n " +
                " logo         : " + logo + " \n " +
                " contactInfo  : " + contactInfo + " \n " +
                " size         : " + size + " \n " +
                " paperType    : " + paperType;
    }
}
