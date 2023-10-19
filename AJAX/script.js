function checkUsernameAvailability() {
    const usernameInput = document.getElementById("username");
    const availabilitySpan = document.getElementById("availability");
    const registerbox = document.getElementById("username");

    const username = usernameInput.value;

    if (username.length < 3) {
        availabilitySpan.innerText = "";
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "check_username.php", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {  
                const response = (xhr.responseText);
                console.log(response);

                if (response === "available") {
                    availabilitySpan.innerText = "Available";
                    availabilitySpan.style.color = "green";
                    registerbox.style.color = "green";
                } else {        
                    availabilitySpan.innerText = "Not Available";
                    availabilitySpan.style.color = "red";
                    registerbox.style.color = "red";
                }
           
    };
    
    if (username === "") {
        availabilitySpan.innerText = "";
    }

    xhr.send("username=" + username);
}
