function cookNumbers(number, ...commands) {
    let givenNum = Number(number);

    for (let index = 0; index < commands.length; index++) {
        const command = commands[index];

        switch(command) {

            case "chop":
                givenNum /= 2;
                break;
            case "dice":
                givenNum = Math.sqrt(givenNum);
                break;
            case "spice":
                givenNum += 1;
                break;
            case "bake":
                givenNum *= 3;
                break;
            case "fillet":
                givenNum -= givenNum * 0.20;
                break;
        }

        console.log(givenNum);
        
    }
}

cookNumbers('9', 'dice', 'spice', 'chop', 'bake','fillet');