async function skinCare(){
    let res=await fetch(`http://localhost:8080/activities`,{
        method:"GET",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify()
    });

    let data=res.json();
    data.then((value)=>{
        console.log(value);
        append(value);
    }).catch(err => {
        console.log(err);
      });
    //append(data);
    
}

skinCare();

let workspace=document.getElementById("workspace");
function append(data){
    workspace.innerHTML = null;
    data.forEach(function(el){
        let div_element=document.createElement("div");
        let img=document.createElement("img");
       //  img.src=el.imageUrl1;
       let activityname=document.createElement("p");
       activityname.innerHTML=el.activityName;
       activityname.setAttribute("class","titleclass")
         let description=document.createElement("p")
        description.innerHTML=el.description;
        description.setAttribute("class","desc");
        let rating=document.createElement("p")
        rating.innerText="Rating: "+el.thrillLevel;
        rating.setAttribute("class","rating")
        let price=document.createElement("p")
        price.innerText="Rs: "+el.charges;
        price.setAttribute("class","price")

        let btn=document.createElement("button")
        btn.innerText="ADD ACTIVITY"
        btn.setAttribute("class","btn-class");
        div_element.append(img,activityname,description,rating,price,btn)
        workspace.append(div_element)
    })
}

let Sort = document.getElementById('men_sort_by');
Sort.onchange = async function (){
    //console.log(Sort.value);
    let res=await fetch(`http://localhost:8080/activities`);
    let data=await res.json()

    if(Sort.value == "asc"){
        data.sort(function(a,b){
            return a.price - b.price
        })
        append(data)
    }
    else if(Sort.value == "dsc"){
        data.sort(function(a,b){
            return b.price - a.price
        })
        append(data)
    }
    else if(Sort.value == "0"){
        append(data)
    }
};

