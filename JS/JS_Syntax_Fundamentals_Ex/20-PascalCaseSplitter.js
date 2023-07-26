function splitThePascalCaseText(text) {
    let resultText = "";

    for(const symbol of text) {
        let currentSymbol = symbol.charCodeAt(0);

        if ((currentSymbol >= 65 && currentSymbol <= 90) && (resultText.length > 0)) {
            resultText += ", "
        }

        resultText += symbol;
    }
    console.log(resultText);
}

splitThePascalCaseText('SplitMeIfYouCanHaHaYouCantOrYouCan');