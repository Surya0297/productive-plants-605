let submit_btn=document.querySelector("#AdminRegister");

submit_btn.addEventListener(("click"),(event)=>{

    let obj={};

    let all_tags_input=document.querySelectorAll("#mid input");

    for(let i=0;i<all_tags_input.length;i++){
        obj[all_tags_input[i].id]=all_tags_input[i].value;
    }

    RegisterAdmin(obj);


});

async function RegisterAdmin(obj){
    try{
    let user_request=await fetch("http://localhost:8080/admins",{
        method:"POST",
        body:JSON.stringify(obj),
        headers:{
            "Content-Type": "application/json"
        }
    })
     if(user_request.ok){
        alert("Admin has been created");
        window.location.href="adminlogin.html";
     }
}catch(error){
    alert("Bad Request");
}
}