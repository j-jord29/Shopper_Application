USE autoshopper_db;

SELECT recipes.recipe_name, ingredients.ingredient_name, recipes.amount, units.unit_name
FROM recipes
INNER JOIN ingredients ON recipes.ingredient_id = ingredients.ingredient_id
INNER JOIN units ON recipes.unit_id = units.unit_id








