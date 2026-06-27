const token =
    localStorage.getItem("token");

if (!token) {

    window.location.href =
        "login.html";
}

let allFoodItems = [];

async function loadFoodItems() {

    try {

        const params =
            new URLSearchParams(
                window.location.search
            );

        const restaurantId =
            params.get(
                "restaurantId"
            );

        let apiUrl =
            "https://quickbite-food-delivery-app-xsz4.onrender.com/fooditems";

        if (restaurantId) {

            apiUrl =
                "https://quickbite-food-delivery-app-xsz4.onrender.com/fooditems/restaurant/"
                + restaurantId;
        }

        const response =
            await fetch(

                apiUrl,

                {

                    method: "GET",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        const foodItems =
            await response.json();

        allFoodItems = foodItems;

        displayFoodItems(foodItems);

    } catch (error) {

        console.log(error);
    }
}

function displayFoodItems(foodItems) {

    const container =
        document.getElementById(
            "foodContainer"
        );

    container.innerHTML = "";

    if (foodItems.length === 0) {

        container.innerHTML = `

            <div class="no-results">

                <h2>
                    No Food Items Found
                </h2>

                <p>
                    Try searching with another keyword.
                </p>

            </div>
        `;

        return;
    }

    foodItems.forEach(
        foodItem => {

            container.innerHTML += `

            <div class="food-card">

                <h2>
                    ${foodItem.name}
                </h2>

                <p>
                    ${foodItem.description}
                </p>

                <h3>
                    ₹${foodItem.price}
                </h3>

                <p>
                    Availability:
                    ${foodItem.available
                        ? "Available"
                        : "Not Available"}
                </p>

                <button
                onclick="addToCart(${foodItem.id})">

                    Add To Cart

                </button>

            </div>
            `;
        }
    );
}

function searchFoodItems() {

    const searchValue =
        document.getElementById("searchInput")
            .value
            .toLowerCase();

    const filteredFoodItems =
        allFoodItems.filter(
            foodItem =>

                foodItem.name
                    .toLowerCase()
                    .includes(searchValue)

                ||

                foodItem.description
                    .toLowerCase()
                    .includes(searchValue)
        );

    displayFoodItems(filteredFoodItems);
}

async function addToCart(
        foodItemId) {

    const cartId =
        localStorage.getItem(
            "cartId"
        );

    const cartItemData = {

        cartId: cartId,

        foodItemId: foodItemId,

        quantity: 1
    };

    try {

        const response =
            await fetch(

                "https://quickbite-food-delivery-app-xsz4.onrender.com/cartitems",

                {

                    method: "POST",

                    headers: {

                        "Content-Type":
                            "application/json",

                        "Authorization":
                            "Bearer " + token
                    },

                    body: JSON.stringify(
                        cartItemData
                    )
                }
            );

        if (response.ok) {

            alert(
                "Item added to cart"
            );

        } else {

            alert(
                "Failed to add item"
            );
        }

    } catch (error) {

        console.log(error);
    }
}
/* LOGOUT */

const logoutBtn =
    document.getElementById(
        "logoutBtn"
    );

if (logoutBtn) {

    logoutBtn.addEventListener(

        "click",

        function () {

            localStorage.clear();

            window.location.href =
                "login.html";
        }
    );
}
loadFoodItems();
