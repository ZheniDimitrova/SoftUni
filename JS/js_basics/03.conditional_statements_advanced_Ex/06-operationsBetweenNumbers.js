function operatinBetweenNumbers(input) {

    let n1 = Number(input[0]);
    let n2 = Number(input[1]);
    let operator = input[2];
    let result = 0;

    switch(operator) {

        case "+": result = n1 + n2; break;
        case "-": result = n1 - n2; break;
        case "*": result = n1 * n2; break;
        case "/": result = n1 / n2;
            if(n2 === 0) {
                console.log(`Cannot divide ${n1} by zero`);
                return;
            }
            break;
            

        case "%": result = n1 % n2; 
        if(n2 === 0) {
            console.log(`Cannot divide ${n1} by zero`);
            return;
        }
        
        break;
    }
    
    let evenOrOdd = "";
    if(result % 2 === 0) {
        evenOrOdd = "even";
    } else {
        evenOrOdd = "odd";
    }

    if(operator === "+" || operator === "-" || operator === "*") {
        console.log(`${n1} ${operator} ${n2} = ${result} - ${evenOrOdd}`);
    } else if(operator === "/"){
        console.log(`${n1} / ${n2} = ${result.toFixed(2)}`);
    } else if(operator === "%") {
        console.log(`${n1} % ${n2} = ${result}`)
    }
}

operatinBetweenNumbers(["123", "12", "/"]);