function checkTheWordContains(word, text) {
    let newTextArr = text.toLowerCase().split(" ");

    for(let part of newTextArr) {
        if(part === word.toLowerCase()){
            console.log(part);
            return;
        }
        // if(newTextArr.includes(word.toLowerCase())){ 
        //     console.log(part);
        //     return;
        // } - дава 60/100
    }
    console.log(`${word} not found!`)
}


checkTheWordContains('javascript', 'JavaScript is the best programming language');

checkTheWordContains('python','JavaScript is the best programming language')