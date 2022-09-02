package com.recipe.Yum.repository;


import com.recipe.Yum.domain.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {

    private final EntityManager em;

    public void save(Recipe recipe){
        if(recipe.getId() == null){
            em.persist(recipe);
        }else{
            em.merge(recipe);
        }
    }

    public Recipe findOne(Long id){

        return em.find(Recipe.class,id);
    }

    public List<Recipe> findAll(){
        List<Recipe> recipe = em.createQuery("select r from Recipe r", Recipe.class)
                .getResultList();
        return recipe;
    }

}
