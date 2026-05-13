const token =
    localStorage.getItem("token");

const role =
    localStorage.getItem("role");

if (!token) {

    window.location.href =
        "login.html";
}

if (role !== "ADMIN") {

    alert(
        "Access Denied"
    );

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