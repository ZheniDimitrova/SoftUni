function palindromeIntegers (array) {

    for(const currentElement of array) {
        let reverseElement = String(currentElement).split("").reverse().join("");

        if (reverseElement == currentElement) {
            console.log("true");
        } else {
            console.log("false");
        }
    }
}

palindromeIntegers([123,323,421,121]);
palindromeIntegers([32,2,232,1010]);