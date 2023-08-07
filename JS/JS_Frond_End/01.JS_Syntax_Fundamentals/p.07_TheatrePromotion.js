function promotion (dayType, age) {
    let price;
    if(dayType === 'Weekday' && (age >= 0 && age <=18)){
        price = 12;
        console.log(`${price}$`);
    } else if (dayType === 'Weekday' &&  (age > 18 && age <=64)){
        price = 18;
        console.log(`${price}$`)
    } else if (dayType === 'Weekday' &&  (age > 64 && age <=122)){
        price = 12;
        console.log(`${price}$`);
    }  else if(dayType === 'Weekend' && (age >= 0 && age <=18)){
        price = 15;
        console.log(`${price}$`);
    } else if (dayType === 'Weekend' &&  (age > 18 && age <=64)){
        price = 20;
        console.log(`${price}$`)
    } else if (dayType === 'Weekend' &&  (age > 64 && age <=122)){
        price = 15;
        console.log(`${price}$`);
    }  else if(dayType === 'Holiday' && (age >= 0 && age <=18)){
        price = 5;
        console.log(`${price}$`);
    } else if (dayType === 'Holiday' &&  (age > 18 && age <=64)){
        price = 12;
        console.log(`${price}$`)
    } else if (dayType === 'Holiday' && (age > 64 && age <=122)) {
        price = 10;
        console.log(`${price}$`);
    } else {
        console.log('Error!');
    }
}
promotion('Holiday', -12);