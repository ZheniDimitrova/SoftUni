function skiTrip(input) {

    let days = Number(input[0] -1);
    let roomtype = input[1];
    let opinion = input[2];

    let price = 0;

    switch(roomtype){

        case "room for one person": price = days * 18; break;

        case "apartment":
            price = days * 25;
            if(days < 10) {
                price -= price * 0.30;
            } else if (days <= 15) {
                price -= price * 0.35;
            } else if(days > 15) {
                price -= price * 0.50;
            };
            break;

        case "president apartment":
            price = days * 35;
            if(days < 10) {
                price -= price * 0.10;
            } else if (days <= 15) {
                price -= price * 0.15;
            } else if(days > 15) {
                price -= price * 0.20;
            };
            break;
    }

    if(opinion === "positive") {
        price += price * 0.25;
    } else {
        price -= price * 0.10;
    }

    console.log(price.toFixed(2));
}

skiTrip(["2", "apartment", "positive"]);