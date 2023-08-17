function cleverLily(input) {

    let yearsLily = Number(input[0]);
    let washingMashinePrice = Number(input[1]);
    let toyPrice = Number(input[2]);

    let toysCount = 0;
    let currentSum = 0;
    let totalSum = 0;
    let brother = 0;
    

    for (let years = 1; years <= yearsLily; years++) {
        let current = years;

        if(current % 2 === 0) {
            brother++;
            
            if(current === 2){
                currentSum = 10;
            } else{
                currentSum += 10;
            }
            totalSum += currentSum;

        } else{
            toysCount++;

        }
        
    }
    let totalToysPrice = toysCount * toyPrice;
    let finalSum = (totalSum + totalToysPrice) - brother;

    if(finalSum >= washingMashinePrice) {
        console.log("Yes! " + (finalSum - washingMashinePrice).toFixed(2));
    } else {
        console.log("No! " + (washingMashinePrice - finalSum).toFixed(2));
    }


}

cleverLily(["10",

"170.00",

"6"]);