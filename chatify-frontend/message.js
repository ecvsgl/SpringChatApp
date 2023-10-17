window.onload = function () {
    const authToken = localStorage.getItem("jwt");
    if (!authToken) {
        window.location.href = 'index.html';
        alert("Please login first.");
    }
    function init() {
        return {
            messageDisplay: document.getElementById("msg_display"),
            usernameInput: document.getElementById("username_input"),
            messageInput: document.getElementById("message_input"),
            sendButton: document.getElementById("send_button"),
        }
    }
    let context = init();
    context.sendButton.addEventListener("click", () => sendMessage(context,authToken));
    //Q: Why an error func required there? Else, it returned "undefined promise".
    setInterval(() => getMessages(context,authToken), 2000);
}

async function getMessages(context, authToken) {
    try {
        context.messageDisplay.innerHTML = ""
        const response = await fetch("http://localhost:8081/message", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${authToken}`
            }
        });
        if (response.ok) {
            let rawData = await response.json();
            for (let i = 0; i < rawData.length; i++) {
                context.messageDisplay.innerHTML += rawData[i].username + ": " + rawData[i].message + '<br>'
            }
            context.messageDisplay.scrollTop = context.messageDisplay.scrollHeight - context.messageDisplay.clientHeight
        } else {
            console.error("Response is not OK: ", response.status, response.statusText);
            console.error("Response Headers:", response.headers);
            response.text().then(data => console.error("Response Body:", data));
        }
    } catch (error) {
        console.error("Error occured: " + error);
    }
}

async function sendMessage(context, authToken) {
    if (notNullOrEmpty(context.usernameInput.value) && notNullOrEmpty(context.messageInput.value)) {
        try {
            const response = await fetch("http://localhost:8081/message", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${authToken}`
                },
                body: JSON.stringify({
                    username: context.usernameInput.value,
                    message: context.messageInput.value
                })
            });
            if (!response.ok) {
                console.error("Response is not OK: ", response.status, response.statusText);
            }
        } catch (error) {
            console.error("Error occured: " + error);
        }
        clearAllInputFields(context);
    } else {
        alert("Please enter a username and message to send.");
        location.reload();
    }
}

function notNullOrEmpty(value) {
    return (value != null && value != "")
}

function clearAllInputFields(context) {
    context.messageInput.value = ""
    context.usernameInput.value = ""
}