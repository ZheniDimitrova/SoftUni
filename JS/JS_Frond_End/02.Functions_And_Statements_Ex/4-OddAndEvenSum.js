function oddAndEvenSum(num) {
    let oddSum = 0;
    let evenSum = 0;

    while(num > 0){
        const current = num % 10;
        if (current % 2 == 0) {
            evenSum += current;
        } else {
            oddSum += current;
        }
        num = Math.floor(num / 10);
    }

    console.log (`Odd sum = ${oddSum}, Even sum = ${evenSum}`)

}

oddAndEvenSum(1000435);