//customer logout
let logout_btn=document.querySelector("#customerLogout");

logout_btn.addEventListener("click",(event)=>{
    logoutCustomer();
})

async function logoutCustomer(){
try{
    let sessionId=localStorage.getItem("sessionId");
    let logout_request=await fetch(`http://localhost:8080/logout?sessionId=${sessionId}`,{

    method:"DELETE",

    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify()

    });

    if(logout_request.ok){
        alert("Logged out successfully");
        localStorage.removeItem("sessionId");
    }else{
alert("something went wrong");
    }
}catch(err){
    alert("Bad request");
}


}


//admin logout
let adminlogout_btn=document.querySelector("#AdminLogout");

adminlogout_btn.addEventListener("click",(event)=>{
    logoutAdmin();
})

async function logoutAdmin(){
try{
    let sessionId=localStorage.getItem("adminSessionId");
    let logout_request=await fetch(`http://localhost:8080/logout?sessionId=${sessionId}`,{

    method:"DELETE",

    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify()

    });

    if(logout_request.ok){
        alert("Admin Logged out successfully");
        localStorage.removeItem("sessionId");
    }else{
alert("something went wrong");
    }
}catch(err){
    alert("Bad request");
}


}