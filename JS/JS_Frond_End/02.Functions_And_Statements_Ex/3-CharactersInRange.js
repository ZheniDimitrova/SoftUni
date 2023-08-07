function printCharactersBetween (start, end) {
    let first = Math.min(start.charCodeAt(0), end.charCodeAt(0));
    let second = Math.max(start.charCodeAt(0), end.charCodeAt());
    let out = "";

    for (let index = first + 1; index < second; index++) {
        const symbol = String.fromCharCode(index);
        out += symbol + " ";        
    }
    console.log(out);

}


printCharactersBetween("C","#");