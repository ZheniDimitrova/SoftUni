function cinema(input) {

    let kind = input[0];
    let rows = Number(input[1]);
    let columns = Number(input[2]);
    let allPlaces = rows * columns;
    
    let premiere = 12.00;
    let normal = 7.50;
    let discount = 5.00;

    let income = 0;

    switch(kind) {
        case "Premiere": income = allPlaces * premiere; break;
        case "Normal": income = allPlaces * normal; break;
        case "Discount": income = allPlaces * discount; break;
    }

    console.log(`${income.toFixed(2)} leva`);
}

cinema(["Discount", "12", "30"]);