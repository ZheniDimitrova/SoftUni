function stringOccurrences(text, word) {
    let array = text.split(' ');
    let count = 0;
    for(i = 0; i < array.length; i++) {
        if(word === array[i]) {
            count++;
        }
    }
    console.log(count);
}

stringOccurrences('This is a word and it also is a sentence',
'is');