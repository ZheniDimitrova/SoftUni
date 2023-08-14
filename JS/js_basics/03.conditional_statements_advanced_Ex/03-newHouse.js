function newHouse(input) {
    let rosePrice = 5;
    let dahliaPrice = 3.80;
    let tulipPrice = 2.80;
    let narcissPrice = 3;
    let gladiolPrice = 2.50;

    let flowerType = input[0];
    let count = Number(input[1]);
    let budget = Number(input[2]);

    let totalPrice = 0;

    if(flowerType === "Roses") {
        totalPrice = count * rosePrice;
        if(count > 80) {
            totalPrice -= totalPrice * 0.10;
        };

    } else if(flowerType === "Dahlias"){
        totalPrice = count * dahliaPrice;
        if(count > 90) {
            totalPrice -= totalPrice * 0.15;
        };

    } else if(flowerType === "Tulips") {
        totalPrice = count * tulipPrice;
        if(count > 80) {
            totalPrice -= totalPrice * 0.15;
        };

    } else if(flowerType === "Narcissus") {
        totalPrice = count * narcissPrice;
        if(count < 120) {
            totalPrice += totalPrice * 0.15;
        };

    } else if(flowerType === "Gladiolus") {
        totalPrice = count * gladiolPrice;
        if(count < 80) {
            totalPrice += totalPrice * 0.20;
        };
    }

    if(totalPrice <= budget) {
        console.log(`Hey, you have a great garden with ${count} ${flowerType} and ${(budget - totalPrice).toFixed(2)} leva left.`)
    } else {
        console.log(`Not enough money, you need ${(totalPrice - budget).toFixed(2)} leva more.`);
    }
}

newHouse(["Narcissus", "119", "360"]);