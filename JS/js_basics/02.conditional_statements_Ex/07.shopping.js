function shopping(input) {

    let budget = Number(input[0]);
    let videocardsCount = Number(input[1]);
    let processorCount = Number(input[2]);
    let ramCount = Number(input[3]);
    
    let sumVideoCard = videocardsCount * 250.00;
    let processorPrice = sumVideoCard * 0.35;
    let ramPrice = sumVideoCard * 0.10;

    totalSum = sumVideoCard + (processorCount * processorPrice) + (ramCount * ramPrice);

    if(videocardsCount > processorCount) {
        totalSum -= totalSum * 0.15;
    }

    if (budget >= totalSum) {
        console.log(`You have ${(budget - totalSum).toFixed(2)} leva left!`);

    } else {
        console.log(`Not enough money! You need ${(Math.abs(totalSum - budget)).toFixed(2)} leva more!`);
    }


}

shopping(["920.45",

"3",

"1",

"1"]);