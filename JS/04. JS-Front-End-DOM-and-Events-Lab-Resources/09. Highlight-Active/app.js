function focused() {
    const inputs = Array.from(document.querySelectorAll("input"));

    inputs.forEach(input => {
        input.addEventListener('focus', (ev) => ev.target.parentElement.className = 'focused');
        input.addEventListener('blur', (ev) => ev.target.parentElement.className = "");
    })
}