function checkTheSign(n1, n2, n3) {
    let result = n1 * n2 * n3;
    if (result < 0) {
        console.log ("Negative")
    } else {
        console.log("Positive")
    }
}



function checkTheSign (n1, n2, n3) {
    let countNegative = 0;

    if(n1 < 0) {
        countNegative++;
    }
    if(n2 < 0) {
        countNegative++;
    }
    if(n3 < 0) {
        countNegative++;
    }

    if (countNegative % 2 === 0) {
        console.log('Positive')
    } else {
        console.log('Negative')
    }
}
checkTheSign(-1, -2, -3);
checkTheSign(5, -1, 1)
