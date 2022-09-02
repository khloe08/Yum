package com.recipe.Yum.controller;

import com.recipe.Yum.domain.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class RecipeForm {

    private Long id;

    @NotBlank(message="레시피 제목을 입력해주세요")
    private String title;
    private List<Ingredient> ingredient = new ArrayList<>();
    private List<Make> make =new ArrayList<>();
    private Integer calorie;
    private Integer carbon;
    private Integer protein;
    private Integer salt;
    private LocalDateTime time;

    private static ModelMapper modelMapper = new ModelMapper();

    public Recipe createRecipe(){
        return modelMapper.map(this, Recipe.class);
    }

    public static RecipeForm of(Recipe recipe){
        return modelMapper.map(recipe,RecipeForm.class);
    }

}
