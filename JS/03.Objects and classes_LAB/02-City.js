
function city(object) {
    
    for(let property in object) {
        console.log(`${property} -> ${object[property]}`)
    }
}

city({name: "Plovdiv",
area: 389,
population: 1162358,
country: "Bulgaria",
postCode: "4000"})