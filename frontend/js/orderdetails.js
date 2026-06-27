const token =
    localStorage.getItem(
        "token"
    );

const orderId =
    localStorage.getItem(
        "orderId"
    );

async function loadOrderItems() {

    try {

        const response =
            await fetch(

                "https://quickbite-food-delivery-app-xsz4.onrender.com/orderitems/order/"
                + orderId,

                {

                    method: "GET",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        const orderItems =
            await response.json();

        const container =
            document.getElementById(
                "orderItemsContainer"
            );

        container.innerHTML = "";

        orderItems.forEach(item => {

            const total =
                item.quantity
                * item.price;

            container.innerHTML += `

            <div class="order-item">

                <h2>
                    ${item.foodItemName}
                </h2>

                <p>
                    Quantity:
                    ${item.quantity}
                </p>

                <p>
                    Price:
                    ₹${item.price}
                </p>

                <h3>
                    Total:
                    ₹${total}
                </h3>

            </div>
            `;
        });

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
loadOrderItems();
