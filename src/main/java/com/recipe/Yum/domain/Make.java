package com.recipe.Yum.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Make {

    @Id
    @GeneratedValue
    private Long id;

    private int num;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    public Make createMake (int num, String description) {
        Make make = new Make();
        this.setNum(num);
        this.setDescription(description);
        return make;
    }
}
