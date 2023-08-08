function depositCalc(input) {
    let depositSum = Number(input[0]);
    let termDeposit = Number(input[1]);
    let annualPercent = Number(input[2]);

    let finalSum = depositSum + termDeposit * ((depositSum * (annualPercent/100)) / 12);

    console.log(finalSum)
}

depositCalc(["200 ","3 ", "5.7 "]);