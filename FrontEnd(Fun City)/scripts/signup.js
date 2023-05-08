let submit_btn=document.querySelector("#Register");

submit_btn.addEventListener(("click"),(event)=>{

    let obj={};

    let all_tags_input=document.querySelectorAll("#mid input");

    for(let i=0;i<all_tags_input.length;i++){
        obj[all_tags_input[i].id]=all_tags_input[i].value;
    }

    RegisterUser(obj);


});

async function RegisterUser(obj){
    try{
    let user_request=await fetch("http://localhost:8080/customers",{
        method:"POST",
        body:JSON.stringify(obj),
        headers:{
            "Content-Type": "application/json"
        }
    })
     if(user_request.ok){
        alert("customer has been created");
        window.location.href="login.html";
     }else{
        alert("Something details are wrong");
     }
}catch(error){
    alert("Bad Request");
}
}