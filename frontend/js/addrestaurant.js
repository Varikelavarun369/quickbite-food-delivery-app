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

document
    .getElementById("restaurantForm")

    .addEventListener(
        "submit",

        async function (event) {

            event.preventDefault();

            const name =
                document
                    .getElementById("name")
                    .value;

            const address =
                document
                    .getElementById("address")
                    .value;

            const cuisineType =
                document
                    .getElementById("cuisineType")
                    .value;

            const phoneNumber =
                document
                    .getElementById("phoneNumber")
                    .value;

            const restaurantData = {

                name: name,

                address: address,

                cuisineType: cuisineType,

                phoneNumber: phoneNumber
            };

            try {

                const response =
                    await fetch(

                        "https://quickbite-food-delivery-app-xsz4.onrender.com/restaurants",

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token
                            },

                            body: JSON.stringify(
                                restaurantData
                            )
                        }
                    );

                if (response.ok) {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Restaurant Added Successfully";

                    document
                        .getElementById("restaurantForm")
                        .reset();

                } else {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Failed To Add Restaurant";
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
