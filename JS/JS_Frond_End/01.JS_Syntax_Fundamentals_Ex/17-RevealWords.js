function findWordLengthAndReplace(words, string) {

    let wordArray = words.split(", ");

    for(let word of wordArray) {
        let missedWord = "*".repeat(word.length);
        string = string.replace(missedWord, word);
    }
    console.log(string);
}

//findWordLengthAndReplace('great','softuni is ***** place for learning new programming languages');
findWordLengthAndReplace('great, learning','softuni is ***** place for ******** new programming languages');