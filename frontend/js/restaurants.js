const token =
    localStorage.getItem("token");

if (!token) {

    window.location.href =
        "login.html";
}

let allRestaurants = [];

async function loadRestaurants() {

    try {

        const response =
            await fetch(

                "http://localhost:8080/restaurants",

                {

                    method: "GET",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        const restaurants =
            await response.json();

        allRestaurants = restaurants;

        displayRestaurants(restaurants);

    } catch (error) {

        console.log(error);
    }
}

function displayRestaurants(restaurants) {

    const container =
        document.getElementById(
            "restaurantContainer"
        );

    container.innerHTML = "";

    if (restaurants.length === 0) {

        container.innerHTML = `

            <div class="no-results">

                <h2>
                    No Restaurants Found
                </h2>

                <p>
                    Try searching with another keyword.
                </p>

            </div>
        `;

        return;
    }

    restaurants.forEach(
        restaurant => {

            container.innerHTML += `

            <div class="restaurant-card">

                <h2>
                    ${restaurant.name}
                </h2>

                <p>
                    Cuisine:
                    ${restaurant.cuisineType}
                </p>

                <p>
                    Address:
                    ${restaurant.address}
                </p>

                <p>
                    Phone:
                    ${restaurant.phoneNumber}
                </p>

                <button
                onclick="viewMenu(${restaurant.id})">

                    View Menu

                </button>

            </div>
            `;
        }
    );
}

function searchRestaurants() {

    const searchValue =
        document.getElementById("searchInput")
            .value
            .toLowerCase();

    const filteredRestaurants =
        allRestaurants.filter(
            restaurant =>

                restaurant.name
                    .toLowerCase()
                    .includes(searchValue)

                ||

                restaurant.cuisineType
                    .toLowerCase()
                    .includes(searchValue)
        );

    displayRestaurants(filteredRestaurants);
}

function viewMenu(
        restaurantId) {

    window.location.href =

        "fooditems.html?restaurantId="
        + restaurantId;
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


loadRestaurants();