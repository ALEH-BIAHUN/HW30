package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Case {
    @SerializedName("title")
    private String caseTitle;
    private String description;
    transient private String addingInfo;
}
