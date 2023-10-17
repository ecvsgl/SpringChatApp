window.onload = function () {
    function init() {
        return {
            usernameInput: document.getElementById("username_input"),
            passwordInput: document.getElementById("password_input"),
            loginButton: document.getElementById("login_button"),
            registerButton: document.getElementById("register_button")
        }
    }
    let context = init();
    context.loginButton.addEventListener("click", () => httpRequest(context, "login"));
    context.registerButton.addEventListener("click", () => httpRequest(context, "register"));
}

async function httpRequest(context, requestMode) {
    if (notNullOrEmpty(context.usernameInput.value) && notNullOrEmpty(context.passwordInput.value)) {
        try {
            let url = "http://localhost:8081/auth/" + requestMode;
            const response = await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username: context.usernameInput.value,
                    password: context.passwordInput.value
                })
            });
            const responseText = await response.text();
            switch (response.status) {
                case 400:
                    alert("Please try a different Username.");
                    break;
                case 401:
                    alert("Invalid Username or Password.");
                    break;
                case 200:
                    switch (requestMode) {
                        case "login":
                            localStorage.setItem("jwt", responseText);
                            window.location.href = 'message.html';
                            break;
                        case "register":
                            alert(responseText);
                            break;
                    }
            }
        } catch (error) {
            console.error("Error occured: " + error);
        }
    } else {
        alert("Username or password cannot be empty.");
    }
}

function notNullOrEmpty(value) {
    return (value != null && value != "")
}