function convertToJson(firstName, lastName, hairColor) {

    let person = {
        name: firstName,
        lastName: lastName,
        hairColor: hairColor
    };

    let result = JSON.stringify(person);
    console.log(result);
}

convertToJson('George', 'Jones', 'Brown')