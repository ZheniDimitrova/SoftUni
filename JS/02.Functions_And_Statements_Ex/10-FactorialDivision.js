function calculatefactoriel (num1, num2){
 let fact1 = 1;
 let fact2 = 1;

 for (let index = 1; index <= num1 ; index++) {
    fact1 *= index;    
 }

 for (let index = 1; index <= num2 ; index++) {
    fact2 *= index;    
 }
 console.log((fact1 / fact2).toFixed(2));
}

calculatefactoriel(5, 2);
calculatefactoriel(6, 2);