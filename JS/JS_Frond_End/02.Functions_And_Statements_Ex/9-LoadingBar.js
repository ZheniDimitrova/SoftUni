function printLoadingBar (percent) {
    //let load = "";
    // for (let index = 1; index < 100; index += 10) {
    //     if (index < percent) {
    //         load += "%";
    //     } else {
    //         load += ".";
    //     }        
    // }

    const percentageNum = percent / 10;
    let load = "%".repeat(percentageNum) + ".".repeat(10 - percentageNum);

    if (percent === 100) {
        console.log("100% Complete!")
        console.log(`[${load}]`)
    } else {
        console.log(`${percent}% [${load}]`);
        console.log("Still loading...")
    }
}

printLoadingBar(50);