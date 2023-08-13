function fruitShop(input) {

    let fruit = input[0];
    let day = input[1];
    let quantity = Number(input[2]);
    let price = 0;

    let isWeekDay = day === "Monday" || day === "Tuesday" || day === "Wednesday" || day === "Thursday" || day === "Friday";
    let isWeekend = day === "Saturday" || day === "Sunday";

    switch(fruit) {

        case "banana": 
        if(isWeekDay) {
            price = quantity * 2.50;
        } else if(isWeekend){
            price = quantity * 2.70;
        }
        break;

        case "apple":
            if(isWeekDay) {
                price = quantity * 1.20;
            } else if(isWeekend){
                price = quantity * 1.25;
            }
            break;

        case "orange":
            if(isWeekDay) {
                price = quantity * 0.85;
            } else if(isWeekend){
                price = quantity * 0.90;
            }
            break;

        case "grapefruit":
            if(isWeekDay) {
                price = quantity * 1.45;
            } else if(isWeekend){
                price = quantity * 1.60;
            }
            break;

        case "kiwi":
            if(isWeekDay) {
                price = quantity * 2.70;
            } else if(isWeekend){
                price = quantity * 3.00;
            }
            break;

        case "pineapple":
            if(isWeekDay) {
                price = quantity * 5.50;
            } else if(isWeekend){
                price = quantity * 5.60;
            }
            break;

        case "grapes":
            if(isWeekDay) {
                price = quantity * 3.85;
            } else if(isWeekend){
                price = quantity * 4.20;
            }
            break;

       
    }
        if((!isWeekDay && !isWeekend) || (fruit !== "banana" && fruit !== "apple" && fruit !== "orange" && fruit !== "grapefruit"
        && fruit !== "kiwi" && fruit !== "pineapple" && fruit !== "grapes")) {
            console.log("error");
        } else {
            console.log(price.toFixed(2));

        }

        

}

fruitShop(["tomato", "Monda", "0.5"]);