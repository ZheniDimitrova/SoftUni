
function largestNum(num1, num2, num3) {
    let largestN = 0;
    if(num1 > num2 && num1 > num3){
        largestN = num1;
    } else if(num2 > num1 && num2 > num3) {
        largestN = num2
    } else {
        largestN = num3;
    }
    console.log(`The largest number is ${largestN}.`);
}