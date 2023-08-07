function perfectNumber (number) {

    let sum = 0;

    for (let index = 1; index < number; index++) {
        if (number % index === 0){
            sum += index;
        }        
    }

    return sum === number ? "We have a perfect number!" : "It's not so perfect.";
    
    // if (sum === number) {
    //     console.log('We have a perfect number!')
    // } else {
    //     console.log("It's not so perfect.")
    // }

     
}
 console.log(perfectNumber(1236498));