window.onload=function(){
    function init(){
        return {
            usernameInput: document.getElementById("username_input"),
            passwordInput: document.getElementById("password_input"),
            loginButton: document.getElementById("login_button"),
            registerButton: document.getElementById("register_button")
        }
    }
    let context = init();
    context.loginButton.addEventListener("click", ()=>request(context, "login"));
    context.registerButton.addEventListener("click", ()=>request(context, "register"));
}

function request(context, requestMode){
    if(notNullOrEmpty(context.usernameInput.value) && notNullOrEmpty(context.passwordInput.value)){
        let url = "http://localhost:8081/auth"+ requestMode
        alert(url)
        fetch(url,{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: context.usernameInput.value,
                password: context.passwordInput.value
            })
        }).then(response => {
            if(!response.ok){
                alert("Response is not OK. Please check console.")
                console.log(response);
            }
        }).catch(error => {
            console.error(error);
            alert("Please check console error.")
        })
    } else {
        alert("Username or password cannot be empty.");
    }
}

function notNullOrEmpty(value){
    return (value != null && value != "")
}