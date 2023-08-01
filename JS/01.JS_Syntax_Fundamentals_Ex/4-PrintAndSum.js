function printAndSum (start, end) {
    let sum = 0;
    let out = '';

    for(let i = start; i <= end; i++) {
        out += i + ' ';
        sum += i;
    }
    console.log(out);
    console.log(`Sum: ${sum}`);
}

printAndSum(5, 10);

// function printAndSumArr (start, end) {
//     const numbers = [];
//     let sum = 0;

//     for (let index = start; index <= end; index++) {
//         numbers.push(index);
//         sum += index        
//     }

//     console.log(numbers.join(' '));
//     console.log(`Sum: ${sum}`);
// }

// printAndSumArr(5, 10);