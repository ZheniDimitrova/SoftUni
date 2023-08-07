function evenOddSubstraction (array) {

    let evenSum = 0;
    let oddSum = 0;

    for(let i = 0; i < array.length; i++) {
         let current = parseInt(array[i]);
        if(current % 2 === 0) {
            evenSum += current;
        } else {
            oddSum += current;
        }
    }
    console.log(evenSum - oddSum);
}


evenOddSubstraction([1,2,3,4,5,6]);