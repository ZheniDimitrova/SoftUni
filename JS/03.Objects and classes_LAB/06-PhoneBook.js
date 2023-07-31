function phoneBook(arr) {
    let data = {};

    for(let elem of arr) {
        let info = elem.split(" ");
        let name = info[0];
        let phone = info[1];

        data[name] = phone;
    }

    for(let key in data){
        console.log(`${key} -> ${data[key]}`);
    }
}

phoneBook(['Tim 0834212554',
'Peter 0877547887',
'Bill 0896543112',
'Tim 0876566344'])