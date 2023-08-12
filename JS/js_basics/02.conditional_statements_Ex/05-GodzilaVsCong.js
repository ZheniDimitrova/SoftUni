function godzilaVsKong(input) {

    let budget = Number(input[0]);
    let peopleCount = Number(input[1]);
    let clothesPerPerson = Number(input[2]);
    let decor = budget * 0.10;

    let peopleSum = peopleCount * clothesPerPerson;
    if(peopleCount > 150) {
        peopleSum -= peopleSum * 0.10;
    }

    let totalSum = peopleSum + decor;

    if(totalSum <= budget) {
        console.log("Action!");
        console.log(`Wingard starts filming with ${(Math.abs(totalSum - budget)).toFixed(2)} leva left.`);

    } else {
        console.log("Not enough money!");
        console.log(`Wingard needs ${(Math.abs(budget - totalSum)).toFixed(2)} leva more.`)
    }


}

godzilaVsKong(["9587.88",

"222",

"55.68"]);