const token =
    localStorage.getItem(
        "token"
    );

if (!token) {

    window.location.href =
        "login.html";
}

async function loadOrders() {

    try {

        const response =
            await fetch(

                "https://quickbite-food-delivery-app-xsz4.onrender.com/orders",

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
                        No Orders Available
                    </h2>

                    <p>
                        Customer orders will appear here.
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

                <div class="order-top">

                    <h2>
                        Order #${order.id}
                    </h2>

                    <div class="status ${statusClass}">

                        ${order.status}

                    </div>

                </div>

                <p>
                    Customer:
                    ${order.userName}
                </p>

                <h3>
                    ₹${order.totalAmount}
                </h3>

                <div class="action-section">

                    <select
                    onchange="updateStatus(${order.id}, this.value)">

                        <option value="">
                            Update Status
                        </option>

                        <option value="PREPARING">
                            PREPARING
                        </option>

                        <option value="OUT_FOR_DELIVERY">
                            OUT FOR DELIVERY
                        </option>

                        <option value="DELIVERED">
                            DELIVERED
                        </option>

                    </select>

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

    if (status === "OUT_FOR_DELIVERY") {

        return "outfordelivery";
    }

    if (status === "DELIVERED") {

        return "delivered";
    }

    return "pending";
}

async function updateStatus(
        orderId,
        status) {

    if (!status) {

        return;
    }

    try {

        const response =
            await fetch(

                `https://quickbite-food-delivery-app-xsz4.onrender.com/orders/${orderId}/status?status=${status}`,

                {

                    method: "PUT",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        if (response.ok) {

            showMessage(
                "Order status updated"
            );

            loadOrders();

        } else {

            showMessage(
                "Failed to update status"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

/* TOAST MESSAGE */

function showMessage(message) {

    const toast =
        document.createElement("div");

    toast.className =
        "toast-message";

    toast.innerText =
        message;

    document.body.appendChild(toast);

    setTimeout(() => {

        toast.remove();

    }, 3000);
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
