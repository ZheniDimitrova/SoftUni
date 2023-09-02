function salary(input) {

    const facebook = 150;
    const instagram = 100;
    const reddit = 50;

    let openTabs = input.shift();
    let salary = input.shift();

    for (let index = 0; index < openTabs; index++) {
        let tab = input[index];

        switch(tab) {
            case "Facebook": salary -= facebook; break;
            case "Instagram": salary -= instagram; break;
            case "Reddit": salary -= reddit; break;
        }

        if (salary <= 0) {
            console.log("You have lost your salary.");
            return;
        }
        
    }

    console.log(salary);

}

salary(["3", "500", "Facebook", "Stackoverflow.com", "softuni.bg"]);