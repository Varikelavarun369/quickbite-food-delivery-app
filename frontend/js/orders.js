const token =
    localStorage.getItem(
        "token"
    );

const userId =
    localStorage.getItem(
        "userId"
    );

if (!token) {

    window.location.href =
        "login.html";
}

async function loadOrders() {

    try {

        const response =
            await fetch(

                "https://quickbite-food-delivery-app-xsz4.onrender.com/orders/user/"
                + userId,

                {

                    method: "GET",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        const orders =
            await response.json();

        const container =
            document.getElementById(
                "ordersContainer"
            );

        container.innerHTML = "";

        if (orders.length === 0) {

            container.innerHTML = `

                <div class="no-orders">

                    <h2>
                        No Orders Yet
                    </h2>

                    <p>
                        Start ordering delicious food from Quick Bite.
                    </p>

                </div>
            `;

            return;
        }

        orders.forEach(order => {

            const statusClass =
                getStatusClass(order.status);

            container.innerHTML += `

            <div class="order-card">

                <div class="order-details">

                    <h2>
                        Order #${order.id}
                    </h2>

                    <div class="status ${statusClass}">

                        ${order.status}

                    </div>

                    <h3>
                        Total:
                        ₹${order.totalAmount}
                    </h3>

                    <button
                    onclick="viewOrderDetails(${order.id})">

                        View Details

                    </button>

                </div>

            </div>
            `;
        });

    } catch (error) {

        console.log(error);
    }
}

function getStatusClass(status) {

    if (status === "PENDING") {

        return "pending";
    }

    if (status === "PREPARING") {

        return "preparing";
    }

    if (status === "OUTFORDELIVERY") {

        return "outfordelivery";
    }

    if (status === "DELIVERED") {

        return "delivered";
    }

    return "pending";
}

function viewOrderDetails(
        orderId) {

    localStorage.setItem(
        "orderId",
        orderId
    );

    window.location.href =
        "orderdetails.html";
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

loadOrders();
