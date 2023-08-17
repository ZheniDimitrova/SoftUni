function histogram(input){
    let n = input.shift();
    let allNumbers = input.length;

    let lessThan200 = [];
    let between200And399 = [];
    let between400And599 = [];
    let between600And799 = [];
    let greaterOrEqual800 = [];


    for (let index = 0; index < n; index++) {
        const element = input[index];

        if(element < 200) {
            lessThan200.push(element);

        } else if(element < 400) {
            between200And399.push(element);

        } else if(element < 600) {
            between400And599.push(element);

        } else if(element < 800) {
            between600And799.push(element);

        } else if(element >= 800) {
            greaterOrEqual800.push(element);
        }
        
    }

    console.log((lessThan200.length / allNumbers * 100).toFixed(2) + "%");
    console.log((between200And399.length / allNumbers * 100).toFixed(2) + "%");
    console.log((between400And599.length / allNumbers * 100).toFixed(2) + "%");
    console.log((between600And799.length / allNumbers * 100).toFixed(2) + "%");
    console.log((greaterOrEqual800.length / allNumbers * 100).toFixed(2) + "%");
}

histogram(["3",

"1",

"2",

"999"]);