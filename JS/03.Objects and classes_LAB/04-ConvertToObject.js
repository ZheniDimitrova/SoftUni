function converToObject(jsonInput){
    let object = JSON.parse(jsonInput);

    for(const prop in object) {
        console.log(`${prop}: ${object[prop]}`)
    }
}

converToObject('{"name": "George", "age": 40, "town": "Sofia"}');