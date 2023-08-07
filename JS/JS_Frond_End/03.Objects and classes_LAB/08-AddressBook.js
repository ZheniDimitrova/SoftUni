function addressBook(array){
let book = {};

for(let elem of array) {
    let current = elem.split(':');
    let name = current[0];
    let address = current[1];

    book[name] = address;
}
let sortedBook = Object.keys(book).sort();

for(let key of sortedBook) {
    console.log(`${key} -> ${book[key]}`)
}

}

addressBook(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd']);