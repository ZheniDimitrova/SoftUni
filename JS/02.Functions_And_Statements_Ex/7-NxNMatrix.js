function matrixNxN(number) {

    for (let index = 0; index < number; index++) {
        let row = String(number) + " ";
        console.log(row.repeat(number));        
    }
}

matrixNxN(5);