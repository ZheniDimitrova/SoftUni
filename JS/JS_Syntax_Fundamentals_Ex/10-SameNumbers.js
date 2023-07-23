function sameNumbersAndSum(number) {
    const digitsString = number.toString();
    let isTheSame = true;
    let sum = 0;
    //let sum = Number(digitString[0]); Ако използваме този подход вторият цикъл не ни трябва

    for (let index = 1; index < digitsString.length; index++){
        //sum += Number(digitString[index]) Ако използваме този подход вторият цикъл не ни трябва
        if(digitsString[index] !== digitsString[index - 1]){
        isTheSame = false;   
        }      
    }
    
    for (let index = 0; index < digitsString.length; index++) {
        sum += Number(digitsString[index]);
    }

    console.log(isTheSame)
    console.log(sum)
}

sameNumbersAndSum(2222222);


//ВТОРИ ВАРИАНТ СЪС СЕТ

// function sameNumbersAndSum(number) {
//     const digits = Array.from(String(number), Number);                //Може и: number.toString().split("").map(Number)
//     const isTheSame = new Set(digits).size === 1;
//     const sum = digits.reduce(function(total, number){            //<- променливите е прието да се казват accumulator и current
//         return total + number; 
//     }, 0);

// за по-кратко може да се запише и: const sum = digits.reduce((total, number) => total + number, 0);

//     console.log(isTheSame);
//     console.log(sum)
// }

// sameNumbersAndSum(2222222);