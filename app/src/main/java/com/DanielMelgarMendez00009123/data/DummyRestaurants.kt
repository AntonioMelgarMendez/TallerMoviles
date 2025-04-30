package com.DanielMelgarMendez00009123.data

val dummyRestaurants = listOf(
    Restaurant(
        id = 1,
        name = "Burger Bros",
        description = "Las mejores hamburguesas de la ciudad",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/4/47/Hamburger_%28black_bg%29.jpg",
        categories = listOf("🍔 Comida Rápida", "🍔 Hamburguesas"),
        menu = listOf(
            Dish(id = 1, name = "Hamburguesa Clásica", description = "Con queso cheddar y tocino",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/4/4d/Cheeseburger.jpg"),
            Dish(id = 2, name = "Hamburguesa BBQ", description = "Salsa BBQ y aros de cebolla",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5a/Bacon_Cheeseburger.jpg")
        )
    ),
    Restaurant(
        id = 2,
        name = "Taco Loco",
        description = "Auténtica comida mexicana",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/73/Al_Pastor_Tacos.jpg",
        categories = listOf("🌮 Comida Mexicana", "🌯 Burritos"),
        menu = listOf(
            Dish(id = 3, name = "Taco de Pastor", description = "Con piña y cebolla",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/ca/Tacos_de_suadero.jpg"),
            Dish(id = 4, name = "Burrito Grande", description = "De res con frijoles",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Burrito.JPG")
        )
    ),
    // Restaurantes adicionales
    Restaurant(
        id = 7,
        name = "Burger King",
        description = "Whopper y más especialidades",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Burger_King_Whopper_combo_meal.jpg",
        categories = listOf("🍔 Comida Rápida", "🍔 Hamburguesas"),
        menu = listOf(
            Dish(id = 13, name = "Whopper", description = "Hamburguesa con tomate y lechuga",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Burger_King_Whopper_combo_meal.jpg"),
            Dish(id = 14, name = "Cheeseburger", description = "Clásica con queso",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/11/Cheeseburger.png")
        )
    ),
    Restaurant(
        id = 8,
        name = "Taquería El Farolito",
        description = "Tacos estilo Ciudad de México",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Tacos_de_carnitas%2C_carnitas_taqueria.jpg",
        categories = listOf("🌮 Comida Mexicana", "🌯 Burritos"),
        menu = listOf(
            Dish(id = 15, name = "Tacos de Carnitas", description = "Tradicionales de cerdo",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Tacos_de_carnitas%2C_carnitas_taqueria.jpg"),
            Dish(id = 16, name = "Quesadillas", description = "Con queso Oaxaca",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/73/Quesadilla_2.jpg")
        )
    ),
    Restaurant(
        id = 9,
        name = "Domino's Pizza",
        description = "Pizza rápida y deliciosa",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d2/Dominos_pizza_pie.jpg",
        categories = listOf("🍕 Pizza", "🍅 Italiana"),
        menu = listOf(
            Dish(id = 17, name = "Pizza Pepperoni", description = "Extra pepperoni",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/1f/Pizza_pepperoni_%281%29.jpg"),
            Dish(id = 18, name = "Pizza 4 Quesos", description = "Mezcla de quesos selectos",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5c/Four_Cheese_Pizza.JPG")
        )
    ),
    Restaurant(
        id = 10,
        name = "Sushi Express",
        description = "Sushi fresco y rápido",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/e/e7/Sushi_platter.jpg",
        categories = listOf("🍣 Sushi", "🍤 Japonés"),
        menu = listOf(
            Dish(id = 19, name = "Sashimi Variado", description = "Pescado fresco en láminas",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5c/Sashimi_-_Tokyo_-_Japan.jpg"),
            Dish(id = 20, name = "Maki California", description = "Con aguacate y cangrejo",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/0/0a/California_Roll_%281%29.jpg")
        )
    ),
    Restaurant(
        id = 11,
        name = "Pasta Mania",
        description = "Pasta casera italiana",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f5/Pasta_Puttanesca.jpg",
        categories = listOf("🍝 Pasta", "🇮🇹 Italiana"),
        menu = listOf(
            Dish(id = 21, name = "Fettuccine Alfredo", description = "Pasta con salsa cremosa",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/7e/Fettuccine_alfredo.jpg"),
            Dish(id = 22, name = "Ravioli de Ricotta", description = "Rellenos de queso",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/1e/Ravioli_with_ricotta.jpg")
        )
    ),
    Restaurant(
        id = 12,
        name = "Steak House",
        description = "Cortes premium",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8f/Ribeye_steak_10_oz._%2830281639156%29.jpg",
        categories = listOf("🥩 Carne", "🍖 Parrillada"),
        menu = listOf(
            Dish(id = 23, name = "Tomahawk Steak", description = "Corte premium con hueso",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/0/0f/Tomahawk_steak_at_Passion_Meat.jpg"),
            Dish(id = 24, name = "Entraña", description = "Corte jugoso y sabroso",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2a/Skirt_steak_%281%29.jpg")
        )
    ),
    Restaurant(
        id = 13,
        name = "Five Guys",
        description = "Hamburguesas gourmet",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/61/Five_Guys_Cheeseburger_with_Fries.jpg",
        categories = listOf("🍔 Comida Rápida", "🍔 Hamburguesas"),
        menu = listOf(
            Dish(id = 25, name = "Bacon Burger", description = "Doble carne con bacon",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/61/Five_Guys_Cheeseburger_with_Fries.jpg"),
            Dish(id = 26, name = "Patatas Fritas", description = "Estilo Cajún",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/83/Five_Guys_French_Fries.jpg")
        )
    ),
    Restaurant(
        id = 14,
        name = "Pizzeria Napolitana",
        description = "Pizza al estilo de Nápoles",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg",
        categories = listOf("🍕 Pizza", "🍅 Italiana"),
        menu = listOf(
            Dish(id = 27, name = "Pizza Napolitana", description = "Con anchoas y alcaparras",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Pizza_Napoletana.jpg"),
            Dish(id = 28, name = "Calzone", description = "Pizza rellena",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/10/Calzone_fritto.jpg")
        )
    )
)