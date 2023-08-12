function lunchBreak(input) {

    let serialName = input[0];
    let serialTime = Number(input[1]);
    let lunchBreakTime = Number(input[2]);

    let lunchTime = lunchBreakTime * 0.125;
    let restTime = lunchBreakTime * 0.25;

    let freeTime = lunchBreakTime - lunchTime - restTime;

    if (freeTime >= serialTime) {
        console.log (`You have enough time to watch ${serialName} and left with ${Math.ceil(freeTime - serialTime)} minutes free time.`);

    } else {
        console.log(`You don't have enough time to watch ${serialName}, you need ${Math.ceil(serialTime - freeTime)} more minutes.`)
    }
}

lunchBreak(["Teen Wolf",

"48",

"60"]);