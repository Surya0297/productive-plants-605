let cont = document.getElementById("displayArea")
display();

async function display() {
    let sessionId = localStorage.getItem('sessionId');
    try {
        let res = await fetch(`http://localhost:8080/ticketsofcustomer/${sessionId}/${sessionId}`)
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
}

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
    let div = document.createElement("div");
    let Total = document.createElement("h3");
    Total.innerText = "Total : ";
    let sum = document.createElement("h3");
    total().then((value) => {
        sum.innerText = value
    });
    div.append(Total, sum);
    cont.append(div);
}


async function total() {
    let sessionId = localStorage.getItem('sessionId');
    try {
        let res = await fetch(`http://localhost:8080/calculateBill/${sessionId}/${sessionId}`)
        let data = await res.json();

        if (res.ok) {
            return data;
        } else {
            alert("Tickets does not Exists")
        }
    } catch (error) {
        alert("Something went Wrong")
    }
}