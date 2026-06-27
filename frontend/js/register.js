document
    .getElementById("registerForm")

    .addEventListener(
        "submit",

        async function (event) {

            event.preventDefault();

            const name =
                document
                    .getElementById("name")
                    .value;

            const email =
                document
                    .getElementById("email")
                    .value;

            const password =
                document
                    .getElementById("password")
                    .value;

            const userData = {

                name: name,

                email: email,

                password: password,

                role: "CUSTOMER"
            };

            try {

                const response =
                    await fetch(

                        "https://quickbite-food-delivery-app-xsz4.onrender.com/users",

                        {

                            method: "POST",

                            headers: {
                                "Content-Type":
                                    "application/json"
                            },

                            body: JSON.stringify(
                                userData
                            )
                        }
                    );

                if (response.ok) {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Registration Successful";

                    window.location.href =
                        "login.html";

                } else {

                    document
                        .getElementById("message")
                        .innerHTML =
                        "Registration Failed";
                }

            } catch (error) {

                document
                    .getElementById("message")
                    .innerHTML =
                    "Error connecting to server";
            }
        }
    );


