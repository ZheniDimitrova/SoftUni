// --1--

// function calculate(num1, num2, operator) {
//     if (operator === "multiply") {
//         return num1 * num2;
//     }

//     if (operator === "divide") {
//         return num1 / num2;
//     }

//     if (operator === "add") {
//         return num1 + num2;
//     }

//     if (operator === "subtract") {
//         return num1 - num2;
//     }
// }


//   --2--
// const multiply = (x, y) => x * y;
// const divide = (x, y) => x / y;
// const add = (x, y) => x + y;
// const subtract = (x, y) => x - y;

// function calculate(num1, num2, operator) {
//     if (operator === "multiply") {
//         return multiply(num1, num2);
//     }

//     if (operator === "divide") {
//         return divide(num1, num2);
//     }
//     if (operator === "add") {
//         return add(num1, num2);
//     }
//     if (operator === "subtract") {
//         return subtract(num1, num2);
//     }
//     
// }

//   --3--

const calculator = {
     multiply: (x, y) => x * y,
     divide: (x, y) => x / y,
     add: (x, y) => x + y,
     subtract: (x, y) => x - y,
}

// function calculate(num1, num2, operator) {
//     return calculator[operator](num1, num2);
// }
 const calculate = (num1, num2, operator) => calculator[operator](num1, num2);

    const result = calculate(5,3, "add");
    console.log(result);