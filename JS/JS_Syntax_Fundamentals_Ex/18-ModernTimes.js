function findAllWordsWithHashTag(text) {
    let wordsArr = text.split(" ").filter(w => w.startsWith("#") && w.length > 1 && isValid(w));

    for(let word of wordsArr) {
        console.log(word.slice(1));
    }


function isValid(word) {
    let validWord = word.toLowerCase().slice(1);
    let isNeedWord = true;

    for(const symbol of validWord) {
        let currentSymbol = symbol.charCodeAt(0);
        if(!(currentSymbol >= 97 && currentSymbol <= 122)) {
            isNeedWord = false;
            break;
        }
    }
        return isNeedWord;
    }
}

findAllWordsWithHashTag('Nowadays everyone uses # to tag a #special word in #socialMedia');
findAllWordsWithHashTag('The symbol # is known #variously in English-speaking #regions as the #number sign');

