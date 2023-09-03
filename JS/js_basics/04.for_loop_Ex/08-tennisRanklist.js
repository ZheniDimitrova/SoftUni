function tennisRanklist(input) {

    let tounamentsCount = Number(input.shift());
    let initialPoints = Number(input.shift());
    let points = 0;
    let totalPoints = 0;
    let sumPoints = 0;
    let winnTheTournament = 0;


    for (let index = 0; index < tounamentsCount; index++) {
        let tournamentPart = input[index];

        switch (tournamentPart) {

            case "W": points = 2000; winnTheTournament++; break;
            case "F": points = 1200; break;
            case "SF": points = 720; break;
        }
        
         sumPoints += points;
         
    }
    totalPoints = initialPoints + sumPoints;

    console.log("Final points: " + totalPoints);
    console.log("Average points: " + Math.floor(sumPoints / tounamentsCount));
    console.log((winnTheTournament / tounamentsCount * 100).toFixed(2) + "%");

}

tennisRanklist(["4",

    "750",
    
    "SF",
    
    "W",
    
    "SF",
    
    "W"]);

