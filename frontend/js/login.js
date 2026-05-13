document
    .getElementById("loginForm")

    .addEventListener(
        "submit",

        async function (event) {

            event.preventDefault();

            const email =
                document
                    .getElementById("email")
                    .value;

            const password =
                document
                    .getElementById("password")
                    .value;

            const loginData = {

                email: email,

                password: password
            };

            try {

                const response =
                    await fetch(

                        "http://localhost:8080/auth/login",

                        {

                            method: "POST",

                            headers: {
                                "Content-Type":
                                    "application/json"
                            },

                            body: JSON.stringify(
                                loginData
                            )
                        }
                    );

                const data =
                    await response.json();

                if (response.ok) {

                    localStorage.setItem(
                        "token",
                        data.token
                    );

                    localStorage.setItem(
                        "userId",
                        data.userId
                    );

                    localStorage.setItem(
                        "role",
                        data.role
                    );

                    try {

                        const cartResponse =
                            await fetch(

                                "http://localhost:8080/carts/user/"
                                + data.userId,

                                {

                                    method: "GET",

                                    headers: {

                                        "Authorization":
                                            "Bearer "
                                            + data.token
                                    }
                                }
                            );

                        if (cartResponse.ok) {

                            const cartData =
                                await cartResponse.json();

                            localStorage.setItem(
                                "cartId",
                                cartData.id
                            );

                        } else {

                            const newCartResponse =
                                await fetch(

                                    "http://localhost:8080/carts",

                                    {

                                        method: "POST",

                                        headers: {

                                            "Content-Type":
                                                "application/json",

                                            "Authorization":
                                                "Bearer "
                                                + data.token
                                        },

                                        body: JSON.stringify({

                                            userId:
                                                data.userId
                                        })
                                    }
                                );

                            const newCartData =
                                await newCartResponse.json();

                            localStorage.setItem(
                                "cartId",
                                newCartData.id
                            );
                        }

                    } catch (error) {

                        console.log(
                            "Cart creation error",
                            error
                        );
                    }

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Login Successful";

                    if (data.role === "ADMIN") {

                        window.location.href =
                            "admin-dashboard.html";

                    } else {

                        window.location.href =
                            "dashboard.html";
                    }

                } else {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Invalid Credentials";
                }

            } catch (error) {

                document
                    .getElementById("message")
                    .innerHTML =
                    "Error connecting to server";
            }
        }
    );

