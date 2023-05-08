let slideIndex = 0;
showSlides();

function showSlides() {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) { slideIndex = 1 }
    slides[slideIndex - 1].style.display = "block";
    setTimeout(showSlides, 3000); // Change image every 2 seconds
}
//customer logout
let logout_btn = document.querySelector("#logoutbtn");

logout_btn.addEventListener("click", (event) => {
    logoutCustomer();
})

async function logoutCustomer() {
    try {
        let sessionId = localStorage.getItem("sessionId");
        let logout_request = await fetch(`http://localhost:8080/logout?sessionId=${sessionId}`, {

            method: "DELETE",

            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify()

        });

        if (logout_request.ok) {
            alert("Logged out successfully");
            localStorage.removeItem("sessionId");
        } else {
            alert("something went wrong");
        }
    } catch (err) {
        alert("Bad request");
    }


}


let loginBtn = document.getElementById("loginbtn");
loginBtn.addEventListener("click", (event) => {
    window.location.href = "signup.html";
});