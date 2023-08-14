function onTimeForExam(input) {

    let examHour = Number(input[0]);
    let examMinutes = Number(input[1]);
    let studentHour = Number(input[2]);
    let studentMinutes = Number(input[3]);

    let examTime = examHour * 60 + examMinutes;
    let studentTime = studentHour * 60 + studentMinutes;

    if (studentTime < examTime && (examTime - studentTime > 30))  {
        console.log("Early");

        let diff = examTime - studentTime;
        let h = parseInt(diff / 60);
        let m = diff % 60;

        if(h === 0) {
            console.log(`${m} minutes before the start`)
        } else {
            if(m < 10) {
            console.log(`${h}:0${m} hours before the start`);
             } else {
            console.log(`${h}:${m} hours before the start`);
            }
        }

    } else if (studentTime < examTime) {
        console.log("On time");

        let diff = examTime - studentTime;
        let m = diff % 60;

        console.log(`${m} minutes before the start`);

    } else if (examTime === studentTime) {

        console.log("On time");

    } else {
        console.log("Late")

        let diff = studentTime - examTime;
        let h = parseInt(diff / 60);
        let m = diff % 60;

        if(h === 0) {
            console.log(`${m} minutes after the start`)
        } else {
            if(m < 10) {
            console.log(`${h}:0${m} hours after the start`);
            } else {
            console.log(`${h}:${m} hours after the start`);
            }
     }

    }
        
}

onTimeForExam(["11", "30", "12", "29"]);