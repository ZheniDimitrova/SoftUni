function vacationCost(countPeople, groupType, day) {

    let price = 0;
    
    switch(groupType) {

        case "Students": 
            if(day ==='Friday'){
                price = 8.45 * countPeople;
            } else if (day === 'Saturday') {
                price = 9.80 * countPeople;
            } else if (day === 'Sunday') {
                price = 10.46 * countPeople;
            }

            if(countPeople >= 30) {
                price -= price * 0.15;
            }
            break;       
               

        case "Business":
            
            if(countPeople >= 100) {
                countPeople -= 10;
            }

            if(day ==='Friday'){
                price = 10.90 * countPeople;
            } else if (day === 'Saturday') {
                price = 15.60 * countPeople;
            } else if (day === 'Sunday') {
                price = 16.00 * countPeople;
            }
            
            break;
        
            

        case "Regular": 
            if(day ==='Friday'){
                price = 15.00 * countPeople;
            } else if (day === 'Saturday') {
                price = 20.00 * countPeople;
            } else if (day === 'Sunday') {
                price = 22.50 * countPeople;
            }

            if(countPeople >= 10 && countPeople <= 20) {
                price -= price * 0.05;
            }
            break;
        }
        
        console.log(`Total price: ${price.toFixed(2)}`);
        
    }


vacationCost(40,'Regular','Saturday');
