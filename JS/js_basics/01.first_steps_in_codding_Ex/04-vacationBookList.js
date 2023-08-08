function vacationBookList(input) {

    let bookPages = Number(input[0]);
    let pagesPerhour = Number(input[1]);
    let days = Number(input[2]);

    let everyDayReading = (bookPages / pagesPerhour) / days;
    console.log(everyDayReading);
}

vacationBookList(["212 ",

"20 ",

"2 "]);