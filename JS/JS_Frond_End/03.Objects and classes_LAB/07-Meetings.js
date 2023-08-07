function meetings(arr){
    let data = {};

    for(let elem of arr) {
        let current = elem.split(" ");
        let day = current[0];
        let name = current[1];

        if(data.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`)
        } else {
            data[day] =  name;
            console.log(`Scheduled for ${day}`)
        }
    }

    for(let key in data) {
        console.log(`${key} -> ${data[key]}`)
    }
}

meetings(['Friday Bob',
'Saturday Ted',
'Monday Bill',
'Monday John',
'Wednesday George'])