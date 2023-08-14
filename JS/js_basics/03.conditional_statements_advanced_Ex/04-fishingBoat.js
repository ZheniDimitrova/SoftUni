function fishingBoat(input) {

    let budget = Number(input[0]);
    let season = input[1];
    let fishersCount = Number(input[2]);

    let sum = 0;

    if (season === "Spring") {
        sum = 3000;        

    } else if(season === "Summer" || season === "Autumn") {
        sum = 4200;

    }  else if(season === "Winter") {
        sum = 2600;
    }

    if(fishersCount <= 6) {
        sum -= sum * 0.10;
    } else if (fishersCount > 6 && fishersCount <= 11) {
        sum -= sum * 0.15;
    } else if(fishersCount >= 12) {
        sum -= sum * 0.25;
    }

    if(fishersCount % 2 === 0 && season !== "Autumn") {
        sum -= sum * 0.05;
    }

    if(budget >= sum) {
        console.log(`Yes! You have ${(budget - sum).toFixed(2)} leva left.`);

    } else {
        console.log(`Not enough money! You need ${(sum - budget).toFixed(2)} leva.`);
    }

}

fishingBoat(["2000", "Winter", "13"]);