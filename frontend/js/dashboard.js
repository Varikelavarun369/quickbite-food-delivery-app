const token =
    localStorage.getItem("token");

if (!token) {

    window.location.href =
        "login.html";
}

document
    .getElementById("logoutBtn")

    .addEventListener(
        "click",

        function () {

            localStorage.removeItem(
                "token"
            );

            window.location.href =
                "login.html";
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