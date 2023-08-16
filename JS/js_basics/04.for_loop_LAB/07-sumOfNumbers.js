function sumOfNumbers(input) {

    let numAsStr = input[0] + "";
    let sum = 0;

    for (let index = 0; index < numAsStr.length; index++) {
        let element = Number(numAsStr[index]);
        sum += element;
        
    }
    console.log(`The sum of the digits is:${sum}`);

}

sumOfNumbers(["564891"]);