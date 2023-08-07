function validPassword(password) {

    let validLength = true;
    let consistOnlyLetterAndDigits = true;
    let twoDigitsatLeast = true;
    
    
    if(password.length < 6 || password.length > 10) {
        console.log("Password must be between 6 and 10 characters");
        validLength = false;
    }

    
    for (const symbol of password) {
        if (!(symbol >= 0 && symbol <= 9) && !(symbol >= 'a' && symbol <= 'z') && !(symbol >= 'A' && symbol <= 'Z')){
            consistOnlyLetterAndDigits = false;
        }        
    }
        if(!consistOnlyLetterAndDigits) {
            console.log("Password must consist only of letters and digits");
        }
    
    
        let digitcount = 0;
         for(const symbol of password) {
            if(symbol >= 0 && symbol <= 9) {
                digitcount++;
            }
        }

        if(digitcount < 2) {
            twoDigitsatLeast = false
            console.log("Password must have at least 2 digits")
        }
        
    


    if (validLength && consistOnlyLetterAndDigits && twoDigitsatLeast) {
        console.log("Password is valid")
    }

    
}

validPassword('MyPass123');
validPassword('logIn');
validPassword('Pa$s$s');
