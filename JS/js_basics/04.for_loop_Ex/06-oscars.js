function oscars(input) {

     let actorName = input.shift();
     let academyPoints = input.shift();
     let juryNumber = input.shift();
     let points = 0;
     let totalPoints = 0;
     let sumPoints = 0;
     let juryNameLength = 0;
     

     for (let index = 0; index < input.length; index++) {
            let juryName = input[index];

            if (index % 2 === 0) {
            juryNameLength = Number(juryName.length);

            } else {
                points = Number(input[index]);
                sumPoints += (juryNameLength * points) / 2;
                totalPoints = Number(academyPoints) + sumPoints;

                if (totalPoints >= 1250.5) {

                 console.log(`Congratulations, ${actorName} got a nominee for leading role with ${totalPoints.toFixed(1)}!`)
                 return;
            }

        }
        
    }
            
     
            console.log(`Sorry, ${actorName} you need ${(1250.5 - totalPoints).toFixed(1)} more!`);

}

oscars(["Sandra Bullock", "340", "5", "Robert De Niro", "50", "Julia Roberts", "40.5", "Daniel Day-Lewis", "39.4", "Nicolas Cage", "29.9", "Stoyanka Mutafova", "33"]);