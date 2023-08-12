function timePlus15Minutes(input) {

    let hour = Number(input[0]);
    let minutes = Number(input[1]);

    if(hour === 0) {
        hour = 24;
    }
    let totalMinutes = hour * 60 + minutes + 15;

    let newHour = parseInt(totalMinutes / 60);
    let newMinutes = totalMinutes % 60;

    if(newHour >= 24) {
        newHour = newHour % 24;
    }

    if(newMinutes < 10) {
        console.log(`${newHour}:0${newMinutes}`);
    } else {
        console.log(`${newHour}:${newMinutes}`);
    }

}

timePlus15Minutes(["0", "48"]);