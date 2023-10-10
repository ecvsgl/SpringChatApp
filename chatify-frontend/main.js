window.onload=function(){
    function init(){
        return {
            messageDisplay: document.getElementById("msg_display"),
            usernameInput: document.getElementById("username_input"),
            messageInput: document.getElementById("message_input"),
            sendButton: document.getElementById("send_button"),
        }
    }

    let context = init();
    context.sendButton.addEventListener("click", sendMessage);
    const messageInterval = setInterval(getMessages,2000);

    async function getMessages(){
        context.messageDisplay.innerHTML = ""
        let rawData = []
        await fetch("http://localhost:8081/message",{
            method: "GET"
        }).then(response => response.json())
        .then(data => rawData = data)
        for(let i = 0; i<rawData.length; i++){
            context.messageDisplay.innerHTML += rawData[i].username + ": " + rawData[i].message + '<br>'
        }
        context.messageDisplay.scrollTop = context.messageDisplay.scrollHeight - context.messageDisplay.clientHeight
    }

    function sendMessage(){
        if(notNullOrEmpty(context.usernameInput.value) && notNullOrEmpty(context.messageInput.value)){
            fetch("http://localhost:8081/message", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username: context.usernameInput.value,
                    message: context.messageInput.value
                })
            }).then(response=> {
                if(!response.ok){
                    alert("Response is not OK.")
                }
            }).catch(error => {
                console.error(error);
                alert("Please check console error.")
            })
            clearAllInputFields();
        } else {
            alert("Please enter a username and message to send.");
            location.reload();
        }
    }
    
    function notNullOrEmpty(value){
        if (value != null && value != ""){
            return true
        } else {
            return false
        }
    }
    function clearAllInputFields(){
        context.messageInput.value = ""
        context.usernameInput.value = ""
    }

}