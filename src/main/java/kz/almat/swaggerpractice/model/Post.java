package kz.almat.swaggerpractice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Almat on 03.06.2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ApiModel(description = "Details about the Post")
public class Post {

    @ApiModelProperty(notes = "The unique ID of the Post")
    private Integer id;

    @ApiModelProperty(notes = "The text content")
    private String text;

}
