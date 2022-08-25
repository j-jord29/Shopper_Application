package com.shopperapp.ShopperApp.tests;

import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.persistence.repository.IngredientRepo;
import com.shopperapp.ShopperApp.service.IngredientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class IngredientsServiceUnitTest {
    @Autowired
    private IngredientService service;

    @MockBean
    private IngredientRepo repo;

    @Test
    void testCreate() {
        // GIVEN
        final Ingredients TEST_INGREDIENT = new Ingredients();
        final Ingredients TEST_SAVED_INGREDIENT = new Ingredients();

        // WHEN
        Mockito.when(this.repo.save(new Ingredients())).thenReturn(new Ingredients());
        // THEN
        Assertions.assertThat(this.service.addIngredientRequest(new Ingredients())).isEqualTo(new Ingredients());
        // verify
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_INGREDIENT);

    }
}
