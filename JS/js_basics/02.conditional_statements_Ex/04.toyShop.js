function toyShop(input) {

   const puzzlePrice = 2.60;
   const speakDollPrice = 3.00;
   const bearPrice = 4.10;
   const minionPrice = 8.20;
   const truckPrice = 2.00;

    let excursionPrice = Number(input[0]);
    let puzzleCount = Number(input[1]);
    let speakDollsCount = Number(input[2]);
    let bearsCount = Number(input[3]);
    let minionsCount = Number(input[4]);
    let trucksCount = Number(input[5]);

    let totalToysCount = puzzleCount + speakDollsCount + bearsCount + minionsCount + trucksCount;

    let sum = (puzzleCount * puzzlePrice) + (speakDollsCount * speakDollPrice) + (bearsCount * bearPrice) + (minionsCount * minionPrice) + (trucksCount * truckPrice);

    if(totalToysCount >= 50) {
        sum -= sum * 0.25;
    }

     let rent = sum * 0.10;

     let profit = sum - rent;

     if(profit >= excursionPrice) {
        console.log(`Yes! ${(profit - excursionPrice).toFixed(2)} lv left.`);

     } else {
        console.log(`Not enough money! ${(Math.abs(excursionPrice - profit)).toFixed(2)} lv needed.`)
     }


}

toyShop(["320", "8", "2", "5", "5", "1"]);