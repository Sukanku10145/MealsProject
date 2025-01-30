package com.example.myapplication

class MealData {

    companion object {
        val meals = listOf<Meal>(
            Meal(
                "52768",
                "Apple Frangipan Tart",
                null,
                "Dessert",
                "British",
                "Preheat the oven to 200C...",
                "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg",
                "Tart,Baking,Fruity",
                "https://www.youtube.com/watch?v=rp8Slv4INLk",
                listOf("digestive biscuits", "butter", "Bramley apples", "butter, softened", "caster sugar", "free-range eggs, beaten", "ground almonds", "almond extract", "flaked almonds"
                ),
                listOf(
                    "175g/6oz", "75g/3oz", "200g/7oz", "75g/3oz", "75g/3oz", "2", "75g/3oz", "1 tsp", "50g/1¾oz"
                ),
                null
            ),
            Meal(
                "52893",
                "Apple & Blackberry Crumble",
                null,
                "Dessert",
                "British",
                "Heat oven to 190C...",
                "https://www.themealdb.com/images/media/meals/xvsurr1511719182.jpg",
                "Pudding",
                "https://www.youtube.com/watch?v=4vhcOwVBDO4",
                listOf(
                    "Plain Flour", "Caster Sugar", "Butter", "Braeburn Apples", "Butter", "Demerara Sugar", "Blackberrys", "Cinnamon", "Ice Cream"
                ),
                listOf(
                    "120g", "60g", "60g", "300g", "30g", "30g", "120g", "¼ teaspoon", "to serve"
                ),
                "https://www.bbcgoodfood.com/recipes/778642/apple-and-blackberry-crumble"
            )
        )
    }
}
