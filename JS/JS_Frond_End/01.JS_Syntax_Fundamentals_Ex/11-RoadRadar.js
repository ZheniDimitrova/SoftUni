function checkSpeeding(speed, area) {

    const speedLimitsAreas = {
        motorway: 130,
        interstate: 90,
        city: 50,
        residential: 20,
    };          

    const currentSpeedLimit = speedLimitsAreas[area];
    const speedOverLimit = speed - currentSpeedLimit;

    if(speedOverLimit <= 0) {
        console.log(`Driving ${speed} km/h in a ${currentSpeedLimit} zone`)
        return;
    };

    // let speedingMessage;

    // if(speedOverLimit <= 20) {
    //     speedingMessage = "speeding"
    // } else if (speedOverLimit <= 40) {
    //     speedingMessage = "excessive speeding"
    // } else {
    //     speedingMessage = "reckless driving"
    // }

    // решение с тернарен оператор:
    const speedingMessage = speedOverLimit <= 20 ? "speeding" : speedOverLimit <= 40 ? "excessive speeding" : "reckless driving";

    console.log(`The speed is ${speedOverLimit} km/h faster than the allowed speed of ${currentSpeedLimit} - ${speedingMessage}`);
    
}

    checkSpeeding(40, 'city' );
    checkSpeeding(21, 'residential');
    checkSpeeding(120, 'interstate');
    checkSpeeding(200, 'motorway');
