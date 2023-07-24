function rotateArray(arr, rotateCount) {

    for (let index = 0; index < rotateCount; index++) {
        const firstElem = arr.shift();
        arr.push(firstElem);   
        
    }
        console.log(arr.join(' '));
   
}

rotateArray([51, 47, 32, 61, 21], 2);