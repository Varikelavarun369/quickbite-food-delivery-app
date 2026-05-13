const token =
    localStorage.getItem(
        "token"
    );

const cartId =
    localStorage.getItem(
        "cartId"
    );

if (!token) {

    window.location.href =
        "login.html";
}

async function loadCartItems() {

    try {

        const response =
            await fetch(

                "http://localhost:8080/cartitems/cart/"
                + cartId,

                {

                    method: "GET",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        const cartItems =
            await response.json();

        const container =
            document.getElementById(
                "cartContainer"
            );

        container.innerHTML = "";

        let total = 0;

        if (cartItems.length === 0) {

            container.innerHTML = `

                <div class="empty-cart">

                    <h2>
                        Your Cart is Empty
                    </h2>

                    <p>
                        Add delicious food items to continue ordering.
                    </p>

                </div>
            `;

            document
                .getElementById(
                    "cartTotal"
                )
                .innerHTML = "Total: ₹0";

            return;
        }

        cartItems.forEach(
            item => {

                const itemTotal =

                    item.quantity
                    * item.foodItemPrice;

                total += itemTotal;

                container.innerHTML += `

                <div class="cart-item">

                    <div class="cart-details">

                        <h2>
                            ${item.foodItemName}
                        </h2>

                        <div class="quantity-controls">

                            <button
                            onclick="updateQuantity(
                                ${item.id},
                                ${item.foodItemId},
                                ${item.quantity - 1}
                            )">

                                -

                            </button>

                            <span>
                                ${item.quantity}
                            </span>

                            <button
                            onclick="updateQuantity(
                                ${item.id},
                                ${item.foodItemId},
                                ${item.quantity + 1}
                            )">

                                +

                            </button>

                        </div>

                        <h3>
                            ₹${itemTotal}
                        </h3>

                        <div class="cart-buttons">

                            <button
                            class="remove-btn"
                            onclick="removeCartItem(${item.id})">

                                Remove

                            </button>

                        </div>

                    </div>

                </div>
                `;
            }
        );

        document
            .getElementById(
                "cartTotal"
            )

            .innerHTML =

            "Total: ₹" + total;

    } catch (error) {

        console.log(error);
    }
}

async function updateQuantity(
        cartItemId,
        foodItemId,
        newQuantity) {

    if (newQuantity <= 0) {

        return;
    }

    const requestData = {

        quantity: newQuantity,

        cartId: Number(cartId),

        foodItemId: foodItemId
    };

    try {

        const response =
            await fetch(

                "http://localhost:8080/cartitems/"
                + cartItemId,

                {

                    method: "PUT",

                    headers: {

                        "Content-Type":
                            "application/json",

                        "Authorization":
                            "Bearer " + token
                    },

                    body: JSON.stringify(
                        requestData
                    )
                }
            );

        if (response.ok) {

            loadCartItems();

        } else {

            showMessage(
                "Failed to update quantity"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

async function removeCartItem(
        cartItemId) {

    try {

        const response =
            await fetch(

                "http://localhost:8080/cartitems/"
                + cartItemId,

                {

                    method: "DELETE",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        if (response.ok) {

            showMessage(
                "Item removed from cart"
            );

            loadCartItems();

        } else {

            showMessage(
                "Failed to remove item"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

async function placeOrder() {

    try {

        const response =
            await fetch(

                "http://localhost:8080/orders/place/"
                + cartId,

                {

                    method: "POST",

                    headers: {

                        "Authorization":
                            "Bearer " + token
                    }
                }
            );

        if (response.ok) {

            showMessage(
                "Order placed successfully"
            );

            setTimeout(() => {

                window.location.href =
                    "orders.html";

            }, 1200);

        } else {

            showMessage(
                "Failed to place order"
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

loadCartItems();