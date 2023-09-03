function trekkingMania(input) {

    let groupsCount = Number(input.shift());
    
    let sumAllPeople = 0;
    let sumMusala = 0;
    let sumMonblan = 0;
    let sumKilimandjaro = 0;
    let sumK2 = 0;
    let sumEverest = 0;

    for (let index = 0; index < groupsCount; index++) {
        let numberOfPeople = Number(input[index]);

        sumAllPeople += numberOfPeople;

        if (numberOfPeople <= 5) {
            sumMusala += numberOfPeople;

        } else if (numberOfPeople <= 12) {
            sumMonblan += numberOfPeople;

        } else if (numberOfPeople <= 25) {
            sumKilimandjaro += numberOfPeople;

        } else if (numberOfPeople <= 40) {
            sumK2 += numberOfPeople;

        } else if (numberOfPeople >= 41) {
            sumEverest += numberOfPeople;
        }

    }

    console.log ((sumMusala / sumAllPeople * 100).toFixed(2) + "%");
    console.log ((sumMonblan / sumAllPeople * 100).toFixed(2) + "%");
    console.log ((sumKilimandjaro / sumAllPeople * 100).toFixed(2) + "%");
    console.log ((sumK2 / sumAllPeople * 100).toFixed(2) + "%");
    console.log ((sumEverest / sumAllPeople * 100).toFixed(2) + "%");


}
trekkingMania(["5",

    "25",
    
    "41",
    
    "31",
    
    "250",
    
    "6"]);