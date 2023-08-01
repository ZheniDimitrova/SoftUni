function sumDigits(number) {
    let sum = 0;
    //let arrDigits = Array.from(String(number));
    const arrDigits = number.toString();

    for (let index = 0; index < arrDigits.length; index++) {
        sum += Number(arrDigits[index]);
        
    }
    console.log(sum);

}

sumDigits(123456);