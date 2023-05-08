// let logo = document.querySelector("#left-section");
// logo.addEventListener("click", () => {
//     window.open("/index.html", "_self");
// })

let adminlogout_btn = document.querySelector("#logoutadmin");

adminlogout_btn.addEventListener("click", (event) => {
    logoutAdmin();
})

async function logoutAdmin() {
    try {
        let sessionId = localStorage.getItem("adminSessionId");
        let logout_request = await fetch(`http://localhost:8080/logout?sessionId=${sessionId}`, {

            method: "DELETE",

            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify()

        });

        if (logout_request.ok) {
            alert("Admin Logged out successfully");
            localStorage.removeItem("adminSessionId");
            window.location.href = "index.html";
        } else {
            alert("Already logged out");
        }
    } catch (err) {
        alert("Bad request");
    }


}

let getActivitiesOfCustomer = document.getElementById("getActivitiesOfCustomer");
let allActivities;

let cont = document.getElementById("displayArea")

getActivitiesOfCustomer.addEventListener("click", async() => {
    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Customer ID:</label>
    <input id="id" type="number" placeholder="Enter customer id">
    <button id=search>Search</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", async() => {

        let id = document.getElementById("id");
        id = id.value;
        let sessionId = localStorage.getItem('adminSessionId');

        let res = await fetch(`http://localhost:8080/customeractivities/${sessionId}/${id}`, {
            method: "GET"
        })
        if (res.ok) {
            allActivities = await res.json();
        }

        renderActicities(allActivities);
    })

})

let activitiesByDate = document.getElementById("activitiesByDate");

activitiesByDate.addEventListener("click", async() => {
    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Customer ID:</label>
    <input id="id" type="number" placeholder="Enter customer id">
    <label>Enter Start Date:</label>
    <input id="sdate" type="date" placeholder="Enter start date">
    <label>Enter end Date:</label>
    <input id="edate" type="date" placeholder="Enter end date">
    <button id=search>Search</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", async() => {

        let id = document.getElementById("id");
        id = id.value;
        let sdate = document.getElementById("sdate");
        sdate = sdate.value;
        let edate = document.getElementById("edate");
        edate = edate.value;
        let sessionId = localStorage.getItem('adminSessionId');

        let res = await fetch(`http://localhost:8080/activities/${sessionId}/${id}/${sdate}/${edate}`, {
            method: "GET"
        })
        if (res.ok) {
            allActivities = await res.json();
        }

        renderActicities(allActivities);
    })

})


let getAllActivities = document.getElementById("getAllActivities");

getAllActivities.addEventListener("click", async() => {
    let res = await fetch(`http://localhost:8080/allActivities`, {
        method: "GET"
    })
    if (res.ok) {
        allActivities = await res.json();
    }

    renderActicities(allActivities);
})

function renderActicities(allActivities) {
    cont.innerHTML = "";



    allActivities.forEach((element) => {

        let divrprice = document.createElement("div");

        let div = document.createElement("div");
        let divinner = document.createElement("div");

        let img1 = document.createElement("img");
        img1.setAttribute("src", element.imageUrl1);

        let img2 = document.createElement("img");
        img2.setAttribute("src", element.imageUrl2);

        let name = document.createElement("h3");
        name.innerText = element.activityName;

        let description = document.createElement("p");
        description.innerText = (element.description);
        description.style.marginTop = 0;
        description.style.padding = 0;

        let p = document.createElement("h4");
        p.innerText = "Thrill Level: " + element.thrillLevel;

        let price = element.charges;
        divrprice.append(`Rs: ${price}`)

        let h = document.createElement("h3")
        h.innerText = "Activity ID:"

        let id = document.createElement("p");
        id.innerText = element.activityId;
        id.setAttribute("id", "activityid");

        divinner.append(h, id, name, description, p);

        divrprice.setAttribute("class", "price");


        div.append(img1, img2, divinner, divrprice);
        div.setAttribute("id", element.activityId);

        cont.append(div);

    });
}



let deleteAdmin = document.getElementById("deleteAdmin");

deleteAdmin.addEventListener("click", async() => {
    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Admin ID:</label>
    <input id="id" type="number" placeholder="Enter admin id">
    <button id=search>Delete</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", () => {

        let id = document.getElementById("id");
        id = id.value;
        let sessionId = localStorage.getItem('adminSessionId');
        getAdmin(sessionId, id);
        deleteAdminData(sessionId, id)
    })
})

async function deleteAdminData(sessionId, id) {


    let x = prompt("Enter Password to Make Chnages");
    if (x == "admin") {
        let res = await fetch(`http://localhost:8080/admins/${sessionId}/${id}`, {
            method: 'DELETE',
            headers: {
                "Content-Type": "application/json"
            }

        })

        if (res.ok) {
            alert("Admin Deleted")
        } else {
            alert("Something went wrong")
        }

    } else {
        alert("Wrong Password");
    }

}

let updateAdmin = document.getElementById("updateAdmin");
updateAdmin.addEventListener("click", () => {

    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Admin ID:</label>
    <input id="id" type="number" placeholder="Enter admin id">
    <button id=search>Update</button>
    </div>
    `
    let btn = document.getElementById("search");
    btn.addEventListener("click", async() => {

        let id = document.getElementById("id");
        id = id.value;
        let sessionId = localStorage.getItem('adminSessionId');

        try {
            let res = await fetch(`http://localhost:8080/admins/${sessionId}/${id}`)
            let data = await res.json();
            let out = [];
            out.push(data);


            if (res.ok) {
                alert("FOUND")
                console.log(out);
                updateAdminData(out);
            } else {
                alert("ADMIN DOES NOT EXIST")
            }
        } catch (error) {
            alert("No Admin")
        }



    })
})


function updateAdminData(admin) {


    console.log(admin);
    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Admin Id:</label>
    <input id="id" type="text" value="${admin[0].admin_id}">
    <label>Update Email:</label>
    <input id="email" type="text" value="${admin[0].email}">
    <label>Update User Name:</label>
    <input id="username" type="text" value="${admin[0].username}">
    <label>Update Mobile Number:</label>
    <input id="mobileNumber" type="text" value="${admin[0].mobileNumber}">
    <label>Update Password:</label>
    <input id="password" type="text" value="${admin[0].password}">
    <button id=updatebtn>UPDATE</button>
    </div>
    `

    let updatebtn = document.getElementById("updatebtn");
    updatebtn.addEventListener("click", async() => {
        console.log("2");
        let obj = {
            "email": document.getElementById("email").value,
            "username": document.getElementById("username").value,
            "mobileNumber": document.getElementById("mobileNumber").value,
            "password": document.getElementById("password").value,
        }

        let x = prompt("Enter Password to Make Chnages");
        if (x == "admin") {
            let id = document.getElementById("id");
            id = id.value;
            let sessionId = localStorage.getItem('adminSessionId');
            let res = await fetch(`http://localhost:8080/admins/${sessionId}/${id}`, {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(obj)

            })

            if (res.ok) {
                alert("Admin Updated")
            } else {
                alert("Something went wrong")
            }

        } else {
            alert("Wrong Password");
        }
    })



}

let addNewAdmin = document.getElementById("addNewAdmin");
addNewAdmin.addEventListener("click", () => {
    let obj = {};
    cont.innerHTML = `
    <div id="addnewadmin">
    <label>Enter Email:</label>
    <input id="email"type="text" placeholder="Email" >
    <label>Enter Username:</label>
    <input id="username"type="text" placeholder="Username" >
    <label>Enter Mobile Number:</label>
    <input  id="mobileNumber"type="text" placeholder="Mobile Number">
    <label>Enter Password:</label>
    <input  id="password"type="text" placeholder="Password">
    <button id="add">ADD</button>
    </div>
    `

    let addbtn = document.getElementById("add");
    addbtn.addEventListener("click", () => {
        console.log("ADD");
        let allinputs = document.querySelectorAll("#cont input");
        for (let input of allinputs) {
            let key = input.id;
            obj[key] = input.value;
        }
        addNewAdmin1(obj);
        // console.log(obj);

    })



})

async function addNewAdmin1(obj) {


    let x = prompt("Enter Password to Make Chnages");
    if (x == "admin") {

        let res = await fetch("http://localhost:8080/admins", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(obj)
        })
        if (res.ok) {
            alert("Admin Successfully added")
        } else {
            alert("Something went Wrong");
        }
    } else {
        alert("Wrong Password");
    }
}

let getAdminById = document.getElementById("getAdminById");

getAdminById.addEventListener("click", () => {


    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Admin ID:</label>
    <input id="id" type="number" placeholder="Enter admin id">
    <button id=search>Search</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", () => {

        let id = document.getElementById("id");
        id = id.value;
        let sessionId = localStorage.getItem('adminSessionId');
        getAdmin(sessionId, id);
    })

})

async function getAdmin(sessionId, id) {
    try {
        let res = await fetch(`http://localhost:8080/admins/${sessionId}/${id}`)
        let data = await res.json();
        let out = [];
        out.push(data);


        if (res.ok) {
            alert("FOUND")
            console.log(out);
            renderAdmin(out);
        } else {
            alert("ADMIN DOES NOT EXIST")
        }
    } catch (error) {
        alert("No Admin")
    }

}

function renderAdmin(admins) {

    cont.innerHTML = "";



    let table = document.createElement("table");

    table.id = 'allDataTable';
    table.innerHTML = `
    <thead id="head">
        <tr>
        <th></th>
        <th ></th>
        <th >All Admin List</th>
        <th ></th>
        <th ></th>
        </tr>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>User Name</th>
            <th>Mobile Number</th>
            <th>Password</th>
        </tr>
    </thead>
    <tbody id="bodyOfTable">
    </tbody>
    `;


    cont.append(table);
    admins.forEach((element) => {

        let tableBody = document.getElementById("bodyOfTable");

        let row = document.createElement("tr");

        let adminId = document.createElement("td");
        adminId.innerHTML = element.admin_id;

        let email = document.createElement("td");
        email.innerText = element.email;

        let userName = document.createElement("td");
        userName.innerText = element.username;

        let mobileNumber = document.createElement("td");
        mobileNumber.innerText = element.mobileNumber;

        let password = document.createElement("td");
        password.innerText = element.password;


        row.append(adminId, email, userName, mobileNumber, password);

        tableBody.appendChild(row);


    });



}


let viewAllCustomer = document.getElementById("viewAllCustomer");
viewAllCustomer.addEventListener("click", async() => {
    try {
        let res = await fetch("http://localhost:8080/customers")
        let data = await res.json();

        if (res.ok) {
            console.log(data);
            renderConstumer(data);
        } else {
            alert("Customer does not Exists")
        }
    } catch (error) {
        alert("Something went Wrong")
    }
})

function renderConstumer(customers) {

    cont.innerHTML = "";

    customers.forEach((element) => {


        let div = document.createElement("div");
        let divinner = document.createElement("div");

        let img1 = document.createElement("img");
        img1.setAttribute("src", "images/RidesImages/UserIcon.jpg");


        let name = document.createElement("h3");
        name.innerText = "Name: " + element.customerName;

        let p1 = document.createElement("p");
        p1.innerText = "Email: " + element.email;

        let p2 = document.createElement("p");
        p2.innerText = "UserName: " + element.username;

        let p3 = document.createElement("h3");
        p3.innerText = "Mobile Number: " + element.mobileNumber;

        let p4 = document.createElement("p");
        p4.innerText = "Address: " + element.address;


        let p5 = document.createElement("p");
        p5.innerText = "Date of birth: " + element.dateOfBirth;


        divinner.append(name, p1, p2, p3, p4, p5);




        div.append(img1, divinner);

        cont.append(div);

    });
}

let viewCustomerById = document.getElementById("viewCustomerById");

viewCustomerById.addEventListener("click", () => {


    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Customer ID:</label>
    <input id="id" type="number" placeholder="Enter Customer id">
    <button id=search>Search</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", () => {
        let id = document.getElementById("id");
        id = id.value;
        getCustomer(id);
    })

})

async function getCustomer(id) {
    try {
        let res = await fetch(`http://localhost:8080/customers/${id}`)
        let data = await res.json();
        let out = [];
        out.push(data);
        if (res.ok) {
            alert("FOUND")
            console.log(data);
            renderConstumer(out);
        } else {
            alert("Customer DOES NOT EXIST")
        }
    } catch (error) {
        alert("Something went Wrong")
    }

}

let viewAllTickets = document.getElementById("viewAllTickets");
viewAllTickets.addEventListener("click", async() => {

    let sessionId = localStorage.getItem('adminSessionId');
    try {
        let res = await fetch(`http://localhost:8080/tickets?sessionId=${sessionId}`)
        let data = await res.json();

        if (res.ok) {
            console.log(data);
            renderTickets(data);
        } else {
            alert("Tickets does not Exists")
        }
    } catch (error) {
        alert("Something went Wrong")
    }
})

function renderTickets(tickets) {
    cont.innerHTML = "";

    tickets.forEach((element) => {

        let divrprice = document.createElement("div");
        let div = document.createElement("div");
        let divinner = document.createElement("div");

        let img1 = document.createElement("img");
        img1.setAttribute("src", "images/RidesImages/ticket.png");

        let name = document.createElement("h3");
        name.innerText = "Ticket Id: " + element.ticketId;

        let description = document.createElement("p");
        description.innerText = (element.dateTime);
        description.style.marginTop = 0;
        description.style.padding = 0;

        let price = element.total;
        divrprice.append(`Rs: ${price}`)

        let h = document.createElement("h3")
        h.innerText = "Activity ID:" + element.activityId;

        let h1 = document.createElement("h3")
        h1.innerText = "Customer ID:" + element.customerId;


        divinner.append(name, h, h1, description);

        divrprice.setAttribute("class", "price");


        div.append(img1, divinner, divrprice);
        div.setAttribute("id", element.activityId);

        cont.append(div);

    });
}

let viewTicketById = document.getElementById("viewTicketById");
viewTicketById.addEventListener("click", () => {
    cont.innerHTML = "";

    cont.innerHTML = `
    <div id=searchbyid>
    <label>Enter Ticket ID:</label>
    <input id="id" type="number" placeholder="Enter ticket id">
    <button id=search>Search</button>
    </div>
    `

    let btn = document.getElementById("search");
    btn.addEventListener("click", async() => {

        let id = document.getElementById("id");
        id = id.value;
        let sessionId = localStorage.getItem('adminSessionId');
        try {
            let res = await fetch(`http://localhost:8080/gettickets/${id}?sessionId=${sessionId}`)
            let data = await res.json();
            let out = [];
            out.push(data);
            if (res.ok) {
                // console.log(data);
                renderTickets(out);
            } else {
                alert("Tickets does not Exists")
            }
        } catch (error) {
            alert("Something went Wrong")
        }
    })

})