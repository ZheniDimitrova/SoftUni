function numbersDivisibleBy9 (input) {

    let start = Number(input[0]);
    let end = Number(input[1]);
    let sum = 0;
    let out = "";

    for (let index = start; index <= end; index++) {
        if(index % 9 === 0){
            sum += index;
            out += index + "\n";
        }        
    }
    console.log(`The sum: ${sum}`);
    console.log(out);
}

numbersDivisibleBy9(["100", "200"]);