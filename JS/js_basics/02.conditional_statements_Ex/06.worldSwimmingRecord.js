function swimmingRecord (input) {

    let worldRecord = Number(input[0]);
    let distance = Number(input[1]);
    let timeForOneMeter = Number(input[2]);

    let time = distance * timeForOneMeter;
    let delay = Math.floor((distance / 15)) * 12.5;
    let totalTime = time + delay;

    if (totalTime >= worldRecord) {
        console.log(`No, he failed! He was ${(totalTime - worldRecord).toFixed(2)} seconds slower.`);

    } else {
        console.log(`Yes, he succeeded! The new world record is ${totalTime.toFixed(2)} seconds.`)
    }
}

swimmingRecord(["10464",

"1500",

"20"]);