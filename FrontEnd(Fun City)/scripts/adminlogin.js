document.querySelector("span").addEventListener("click", wake);
let state = false;

function wake() {
    if (state) {
        document.querySelector(".i6").setAttribute("type", "password");
        state = false;
    } else {
        document.querySelector(".i6").setAttribute("type", "text");
        state = true;
    }
}

let submit_btn = document.querySelector("#SignIn");

submit_btn.addEventListener("click", (event) => {

    let obj = {};
    let all_input_tags = document.querySelectorAll("#mid input");
    for (let i = 0; i < all_input_tags.length - 1; i++) {
        obj[all_input_tags[i].id] = all_input_tags[i].value;
        obj["role"] = "admin";
    }
    LoginAdmin(obj);

})

async function LoginAdmin(obj) {

    try {
        let user_request = await fetch("http://localhost:8080/login", {
            method: "POST",
            body: JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
        })

        if (user_request.ok) {
            alert("Admin Logged In successfully");
            let token = user_request.json();

            token.then((value) => {
                localStorage.setItem("adminSessionId", value.sessionId);
                window.location.href = "admin.html";
            }).catch(err => {
                alert("Wrong Credentials");
            });

        } else {
            alert("Already Logged In");
        }


    } catch (error) {
        alert("Bad Request");
    }
}