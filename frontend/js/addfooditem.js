const token =
    localStorage.getItem("token");

const role =
    localStorage.getItem("role");

if (!token) {

    window.location.href =
        "login.html";
}

if (role !== "ADMIN") {

    alert("Access Denied");

    window.location.href =
        "dashboard.html";
}

document
    .getElementById("logoutBtn")

    .addEventListener(
        "click",

        function () {

            localStorage.clear();

            window.location.href =
                "login.html";
        }
    );

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

        const restaurantSelect =
            document
                .getElementById("restaurant");

        restaurants.forEach(
            restaurant => {

                restaurantSelect.innerHTML += `

                <option value="${restaurant.id}">

                    ${restaurant.name}

                </option>
                `;
            }
        );

    } catch (error) {

        console.log(error);
    }
}

loadRestaurants();

document
    .getElementById("foodItemForm")

    .addEventListener(
        "submit",

        async function (event) {

            event.preventDefault();

            const name =
                document
                    .getElementById("name")
                    .value;

            const price =
                document
                    .getElementById("price")
                    .value;

            const description =
                document
                    .getElementById("description")
                    .value;

            const restaurantId =
                document
                    .getElementById("restaurant")
                    .value;

            const available =
                document
                    .getElementById("available")
                    .value;

            const foodItemData = {

                name: name,

                price: price,

                description: description,

                available:
                    available === "true",

                restaurantId: restaurantId
            };

            try {

                const response =
                    await fetch(

                        "http://localhost:8080/fooditems",

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token
                            },

                            body: JSON.stringify(
                                foodItemData
                            )
                        }
                    );

                if (response.ok) {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Food Item Added Successfully";

                    document
                        .getElementById("foodItemForm")
                        .reset();

                } else {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Failed To Add Food Item";
                }

            } catch (error) {

                document
                    .getElementById("message")
                    .innerHTML =
                    "Error Connecting To Server";
            }
        }
    );

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