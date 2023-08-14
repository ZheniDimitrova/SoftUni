function hotelRoomPrice(input) {

    let month = input[0];
    let nightsCount = Number(input[1]);

    let studioPrice = 0;
    let apartmentPrice = 0;

    if(month === "May" || month === "October") {
        studioPrice = nightsCount * 50;
        apartmentPrice = nightsCount * 65;
        if(nightsCount > 7 && nightsCount <= 14) {
            studioPrice -= studioPrice * 0.05;
        } 
        
        if(nightsCount > 14) {
            studioPrice -= studioPrice * 0.30;
        }

    } else if(month === "June" || month === "September") {
        studioPrice = nightsCount * 75.20;
        apartmentPrice = nightsCount * 68.70;
         if(nightsCount > 14) {
            studioPrice -= studioPrice * 0.20;
        }
            
    } else if(month === "July" || month === "August") {
        studioPrice = nightsCount * 76;
        apartmentPrice = nightsCount * 77;
    }

    if(nightsCount > 14) {
        apartmentPrice -= apartmentPrice * 0.10;
    }

    console.log(`Apartment: ${apartmentPrice.toFixed(2)} lv.`);
    console.log(`Studio: ${studioPrice.toFixed(2)} lv.`);

}

hotelRoomPrice(["August", "20"]);