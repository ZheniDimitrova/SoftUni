function lockedProfile() {
    Array.from(document.querySelectorAll("button")).forEach((e) =>
    e.addEventListener("click", onClick));

    function onClick(event) {
        let card = event.target.parentElement;
        let buttonValue = event.target.textContent;
        let isUnlock = card.querySelector("input[value = unlock]").checked;

        if(isUnlock) {

            if(buttonValue === "Show more") {
                card.querySelector("div").style.display = "block";
                event.target.textContent = "Hide it";

            } else {
                card.querySelector("div").style.display = "none";
                event.target.textContent = "Show more";
            }
        }
    }

   
}