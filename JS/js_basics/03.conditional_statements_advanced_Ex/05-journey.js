function journey(input) {

    let budget = Number(input[0]);
    let season = input[1];

    let destination = "";
    let spentMoney = 0;
    let place = "";

    if(budget <= 100) {
        destination = "Bulgaria";
        if(season === "summer") {
            spentMoney = budget * 0.30;
            place = "Camp";
        } else {
            spentMoney = budget * 0.70;
            place = "Hotel"
        }

    } else if(budget <= 1000) {
        destination = "Balkans";
        if(season === "summer") {
            spentMoney = budget * 0.40;
            place = "Camp";
        } else {
            spentMoney = budget * 0.80;
            place = "Hotel"
        }

    } else {
        destination = "Europe";
        spentMoney = budget * 0.90;
        place = "Hotel"

    }

    console.log(`Somewhere in ${destination}`);
    console.log(`${place} - ${spentMoney.toFixed(2)}`);
}

journey(["1500", "summer"]);