package kz.almat.swaggerpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Almat on 03.06.2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Integer id;
    private String text;

}
