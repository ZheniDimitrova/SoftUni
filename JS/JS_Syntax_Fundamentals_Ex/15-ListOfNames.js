function sortNamesAlphabetically(arr) {
    arr.sort((n1, n2) => n1.localeCompare(n2));

    for (let index = 0; index < arr.length; index++) {
        let num = index + 1;
        let name = arr[index];

        console.log(`${num}.${name}`);
    }
  
} 

sortNamesAlphabetically(["John", "Bob", "Christina", "Ema"])